
public class Test {

	public static void main(String[] args) {
		
		int n=5; //5�����
		int e=5; //5����
		
		MyAdjGraphic g = new MyAdjGraphic(n);
		Object[] vertices = new Object[]{new Character('A'),new Character('B'),new Character('C'),new Character('D'),new Character('E')};
	    Weight[] weights = new Weight[]{new Weight(0,1,10),new Weight(0,4,20),new Weight(2,1,40),new Weight(1,3,30),new Weight(3,2,50)};
	    try
	    {
	       Weight.createAdjGraphic(g, vertices, n, weights, e);
	       System.out.println("--------���ٽӾ�������---------");
	       g.print();
	       System.out.println("���ĸ�����"+g.getNumOfVertice());
	       System.out.println("�ߵĸ�����"+g.getNumOfEdges());
	       /*
	       g.deleteEdges(0, 4);
	       System.out.println("--------ɾ��֮��---------");
	       g.print();
	       System.out.println("���ĸ�����"+g.getNumOfVertice());
	       System.out.println("�ߵĸ�����"+g.getNumOfEdges());
	       */
	       Visit v = new Visit();
	       System.out.println("\n������ȱ������У�");
	       g.deptFirstSearch(v);
	       System.out.println("\n������ȱ������У�");
	       g.broadFirstSearch(v);
	       
	    }
	    catch(Exception ex)
	    {
	    	
	    }
	}

}
