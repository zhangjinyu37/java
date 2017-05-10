import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

//�ڽӾ�����
public class MyAdjGraphic {

	static final int maxWeight=-1; //����������֮��û�бߣ�ȨֵΪ-1��
	ArrayList vertices = new ArrayList();//��Ž��ļ���
	int[][] edges; //�ڽӾ���Ķ�ά����
	int numOfEdges; //�ߵ�����
	
	public MyAdjGraphic(int n)
	{
	    edges = new int[n][n];
		for(int i=0;i<n;i++)
	    {
	    	for(int j=0;j<n;j++)
	    	{
	    		if(i==j) //�Խ����ϵ�Ԫ��
	    		{
	    		   edges[i][j]=0;	
	    		}
	    		else
	    		{
	    		   edges[i][j]=maxWeight;
	    		}
	    	}
	    }
	    numOfEdges = 0;
	}
	
	//���رߵ�����
	public int getNumOfEdges()
	{
		return this.numOfEdges;
	}
	
	//���ؽ�������
	public int getNumOfVertice()
	{
		return this.vertices.size();
	}
	
	//���ؽ���ֵ
	public Object getValueOfVertice(int index)
	{
	    return this.vertices.get(index);	
	}
	
	//���ĳ���ߵ�Ȩֵ
	public int getWeightOfEdges(int v1,int v2) throws Exception
	{
	   if((v1 < 0 || v1 >= vertices.size())||(v2 < 0||v2 >= vertices.size()))
	   {
		   throw new Exception("v1����v2����Խ�����");
	   }
	   return this.edges[v1][v2];
	   
	}
	
	//������
	public void insertVertice(Object obj)
	{
		this.vertices.add(obj);
	}
	
	//�����Ȩֵ�ı�
	public void insertEdges(int v1,int v2,int weight) throws Exception
	{
		if((v1 < 0 || v1 >= vertices.size())||(v2 < 0||v2 >= vertices.size()))
		{
		  throw new Exception("v1����v2����Խ�����");
		}
		
		this.edges[v1][v2]=weight;
		this.numOfEdges++;
	}
	
	//ɾ��ĳ����
	public void deleteEdges(int v1,int v2) throws Exception
	{
	    if((v1 < 0 || v1 >= vertices.size())||(v2 < 0||v2 >= vertices.size()))
		{
		  throw new Exception("v1����v2����Խ�����");
		}
	    if( v1==v2 || this.edges[v1][v2]==maxWeight)	
	    {
	    	throw new Exception("�߲����ڣ�");
	    }
	    
	    this.edges[v1][v2]=maxWeight;
	    this.numOfEdges--;   
	}
	
	//��ӡ�ڽӾ���
	public void print()
	{
		for(int i=0;i<this.edges.length;i++ )
		{
			for(int j=0;j<this.edges[i].length;j++)
			{
			    System.out.print(edges[i][j]+" ");	
			}
			System.out.println();
		}
	}
	
	//ȡ��һ���ڽӽ��
	public int getFirstNeighbor(int v) throws Exception
    {
		if((v < 0 || v >= vertices.size()))
		{
		  throw new Exception("v����Խ�����");
		}
		for(int col=0;col<this.vertices.size();col++)
		{
		   if( this.edges[v][col] > 0)
		   {
			  return col;  
		   }
		}
		return -1;
    }
	///ȡ��һ���ڽӽ��
	public int getNextNeighbor(int v1,int v2) throws Exception
	{
		if((v1 < 0 || v1 >= vertices.size())||(v2 < 0||v2 >= vertices.size()))
		{
		  throw new Exception("v1����v2����Խ�����");
		}
		for(int col=v2+1;col<this.vertices.size();col++)
		{
			if(this.edges[v1][col] > 0)
			{
				return col;
			}
		}
		return -1;
	}
	
	//��ͨͼ��������ȱ����㷨
	public void deptFirstSearch(Visit v) throws Exception
	{
	    boolean[] visited = new boolean[this.vertices.size()];
	    for(int i=0;i<visited.length;i++)
	    {
	    	visited[i] = false;
	    }
	    
	    for(int i=0;i<visited.length;i++)
	    {
	    	if(!visited[i])
	    	{
	    		deptFirstSearch(i,visited,v); 	
	    	}
	    }
	}
	
	//��ͨͼ��������ȱ����㷨����ʵ���㷨
	private void deptFirstSearch(int v, boolean[] visited, Visit vs) throws Exception{
	//��ͨͼ��vΪ��ʼ�����š����ʲ���Ϊvs��������ȱ���
	//����visited�������Ӧ����Ƿ��ѷ��ʹ���0��ʾδ���ʣ�1��ʾ�ѷ���
		vs.print(this.getValueOfVertice(v)); //���ʸý��
		visited[v] = true; 	//���ѷ��ʱ��
		int w = getFirstNeighbor(v);//ȡ��һ���ڽӽ��
		while(w != -1)
	    {//���ڽӽ�����ʱѭ��
		  if(!visited[w])//���û�з��ʹ�
		  {
		    deptFirstSearch(w, visited,vs); //��wΪ��ʼ���ݹ����
	      }
		  w = getNextNeighbor(v, w);//ȡ��һ���ڽӽ��
		}
	}
    
	//������ȱ����㷨������ʵ���㷨
	private void broadFirstSearch(int v, boolean[] visited, Visit vs) throws Exception{
        //����visited�������Ӧ����Ƿ��ѷ��ʹ���0��ʾδ���ʣ�1��ʾ�ѷ���
		int u, w;
		Queue queue = new LinkedList();//����˳�����queue
		vs.print(this.getValueOfVertice(v));//���ʽ��v
		visited[v] = true; //���ѷ��ʱ��
		queue.add(new Integer(v)); //���v�����
		while(! queue.isEmpty())
        {//���зǿ�ʱѭ��
		   u = ((Integer)queue.remove()).intValue();//������
		   w = getFirstNeighbor(u);//ȡ���u�ĵ�һ���ڽӽ��
		   while(w != - 1)
           {  //���ڽӽ�����ʱѭ��
		      if(! visited[w])
              { //���ý��û�з��ʹ�
		          vs.print(this.getValueOfVertice(w));//���ʽ��w
		          visited[w] = true;//���ѷ��ʱ��
		          queue.add(new Integer(w)); 	//���w�����
		      }//ȡ���u���ڽӽ��w����һ���ڽӽ��
		      w = getNextNeighbor(u, w);
		  }
		}
	}
	
	//������ȱ����㷨�ĵ����㷨
	public void broadFirstSearch(Visit v) throws Exception
	{
		 boolean[] visited = new boolean[this.vertices.size()];
		 for(int i=0;i<visited.length;i++)
		 {
		   	visited[i] = false;
		 }
		 for(int i=0;i<visited.length;i++)
		 {
		   	if(!visited[i])
		   	{
		   		broadFirstSearch(i,visited,v); 	
		   	}
		 }
	}

    
}
