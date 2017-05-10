import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;


public class Kruskal {
	 private int[][] table;
	 private HashSet<Integer> vertices;// ��ſ�³˹�����㷨���Ѿ��漰���Ķ�������
	 private ArrayList<Edge> resultEdges;
	 private ArrayList<Edge> initEdges;
	 private int numberOfVertice;
	 
	 public Kruskal(int[][] table)
	 {
		   vertices = new HashSet<Integer>();
	       resultEdges = new ArrayList<Edge>();
	       initEdges = new ArrayList<Edge>();
	       this.numberOfVertice = table.length;
	       this.table = table;
	       createEdges();
	 }
	 
	 /** ��³˹�����㷨 */
	 public void kruskal() 
	 {
	       int timer = 1;   
	       sortInitEdges(initEdges);
	       //���while���֮�󻹲����һ����
	       while (timer<=this.numberOfVertice-1){// ��С�������ı������ڶ�����-1  
	           Edge curEdge = initEdges.get(0);
	           //�ж��Ƿ񹹳ɻ�
	           if(vertices.contains(curEdge.getLeftV()) && vertices.contains(curEdge.getRightV())){//���ɻ�
	              initEdges.remove(0);
	              timer++;
	           }
	           else{//�����ɻ�
	               resultEdges.add(curEdge);
	               vertices.add(curEdge.getLeftV());
	               vertices.add(curEdge.getRightV());
	               initEdges.remove(0);
	               timer++;
	           }     
	       }
	       resultEdges.add(findTheLastEdgeInVfromResultEdges());//�Զ��ҳ����һ����
	    }
	    
	    /** �ҵ����һ���ߣ�����߿�Խ������ͨ���� */
	    public Edge findTheLastEdgeInVfromResultEdges(){
	       //��ʱresultEdges����������1������2�����б�
	       ArrayList<Integer> setA = new ArrayList<Integer>();//�������1�Ķ���
	       ArrayList<Integer> setB = new ArrayList<Integer>();//�������2�Ķ���
	       ArrayList<Edge> tempEdges = new ArrayList<Edge>();//��ʱ���������乹�ܱ�
	       
	       setA.add(resultEdges.get(0).getLeftV());//����1��ʼ��
	       setA.add(resultEdges.get(0).getRightV());//����1��ʼ��
	       for(int i=0;i<resultEdges.size();i++){//����ǰ������������б�
	           Edge edge = resultEdges.get(i);//��õ�ǰ�����ıߵ�����
	           if(setA.contains(edge.getLeftV()) || setA.contains(edge.getRightV())){
	              setA.add(resultEdges.get(i).getLeftV());//�����ǰ�ߵ����������κ�һ��������setA
	               setA.add(resultEdges.get(i).getRightV());//�������������setA
	           }
	           else{
	              setB.add(resultEdges.get(i).getLeftV());//������뵽setB
	               setB.add(resultEdges.get(i).getRightV());
	           }
	       }
	       for(int i=0;i<setA.size();i++)//����table����ʱ�ıߣ���Щ�߿�ԽsetA setB��
	           for(int j=0;j<setB.size();j++)
	              if(table[setA.get(i)][setB.get(j)] > 0)
	                  tempEdges.add(new Edge(setA.get(i),table[setA.get(i)][setB.get(j)],setB.get(j)));
	       Collections.sort(tempEdges);//����Ȩֵ�ǵݼ�����
	       return tempEdges.get(0);//����ȫְ��С�ıߵ�����
	    }
	    
	    /** ��ӡ�ߵļ��� */
	    public void printEdge(ArrayList<Edge> edges){
		Iterator <Edge> it = edges.iterator();
	       while(it.hasNext()){
	           Edge edge = it.next();
	           System.out.println(edge);
	       }
	    }
	    /** �Ա߸���Ȩֵ�ǵݼ����� */
	    public void sortInitEdges(ArrayList<Edge> edges) {
	       Collections.sort(edges);
	    }
	 
	    /** �������б� */
	    public void createEdges() {
	       for (int i = 0; i < table.length; i++) {
	           for (int j = i; j < table[i].length; j++)
	              if (table[i][j] > 0)
	                  initEdges.add(new Edge(i, table[i][j], j));
	       }
	    }
	 
	    
	    /** ��ӡͼ��Ϣ */
	    public void printtable() {
	       System.out.println("");
	       System.out.println("ͼ����Ϣ:");
	       for (int i = 0; i < table.length; i++) {
	           for (int j = 0; j < table.length; j++) {
	              System.out.printf("%3d", table[i][j]);
	           }
	           System.out.print("\n");
	       }
	    }
	    
	    public void showResult()
	    {
	    	System.out.println("��С�����������б���ɣ�");
		    System.out.println("����    Ȩֵ     ����");
		    printEdge(resultEdges);
		    printtable();
	    }
}
