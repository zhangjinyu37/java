
//�����ߵ�Ȩֵ��
public class Weight {
   
	int row;  //������
	int col;  //������
	int weight; //Ȩֵ
	
	Weight(int row,int col,int weight)
	{
		this.row = row;
		this.col = col;
		this.weight = weight;
	}
	
	public static void createAdjGraphic(MyAdjGraphic g, Object[] vertices, int n,Weight[] weight,int e)
	throws Exception
	{
	   //��ʼ�����
	   for(int i=0;i<n;i++)
	   {
		   g.insertVertice(vertices[i]);
	   }
	   //��ʼ�����еı�
	   for(int i=0;i<e;i++)
	   {
		   g.insertEdges(weight[i].row, weight[i].col, weight[i].weight);
	   }
	}
}
