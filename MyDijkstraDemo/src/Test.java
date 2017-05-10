
public class Test {
	static final int maxVertices = 100;
	
	public static void main(String[] args) {
		MyAdjGraphic g = new MyAdjGraphic(maxVertices);
	    
		Object[] vertices = {new Character('A'),new Character('B'),new Character('C'),
				new Character('D'),new Character('E'),new Character('F')};
		
		Weight[] weight = {new Weight(0,2,5),new Weight(0,3,30),new Weight(1,0,2),
				new Weight(1,4,8),new Weight(2,1,15),new Weight(2,5,7),new Weight(4,3,4),
				new Weight(5,3,10),new Weight(5,4,18)};
	
	    int n = 6;
	    int e = 9;
	    
	    try
	    {
	    	Weight.createAdjGraphic(g, vertices, n, weight, e);
	    	int[] distance = new int[n];
	    	int[] path = new int[n];
	    	Dijkstra.dijkstra(g, 0, distance, path);
	    	
	    	System.out.println("�Ӷ���A���������������̾���Ϊ��");
			for(int i = 1; i < n; i ++)
			{
				System.out.println("������" + g.getValueOfVertice(i) + "����̾���Ϊ��" + distance[i]);
			}	
			System.out.println("�Ӷ���A�������������ǰһ����ֱ�Ϊ��");
			for(int i = 0; i < n; i ++)
			{
				if(path[i] != -1)
				{
					System.out.println("������" + g.getValueOfVertice(i) + "��ǰһ����Ϊ��" + g.getValueOfVertice(path[i]));
		        }
			}
	    }
	    catch(Exception ex)
	    {
	    	ex.printStackTrace();
	    }
	}

}
