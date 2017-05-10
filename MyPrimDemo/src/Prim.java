//����ķ�㷨��
public class Prim {
  public final static int MAXWEIGHT = 9999;
  
  //����ķ�㷨
  public static void prim(MyAdjGraphic g,MinSpanTree[] closeVertex) throws Exception
  {
	  int n = g.getNumOfVertice(); //��ý������
	  int[] lowCost = new int[n];
	  int k=0; 
	  int minCost;  
	  
	  //��ʼ��closeVertex����
	  for(int i=0;i<n;i++)
	  {
		  lowCost[i] = g.getWeightOfEdges(0, i);
	  }
	  
	  MinSpanTree temp = new MinSpanTree();
	  temp.vertex = g.getValueOfVertice(0);	
	  closeVertex[0] = temp;
	  lowCost[0] = - 2;//���Ϊ�ѷ���
	  
	  for(int i = 1; i < n; i ++)
		{
			minCost = MAXWEIGHT;
			for(int j = 1; j < n; j ++)
			{
				if(lowCost[j] < minCost && lowCost[j] > 0)
				{
					minCost = lowCost[j];
					k = j;
				}
			}
			MinSpanTree curr = new MinSpanTree();
			curr.vertex = g.getValueOfVertice(k);
			curr.weight = minCost;
			closeVertex[i] = curr;
			lowCost[k] = -2; //���Ϊ�ѷ���
			
			for(int j = 1; j < n; j ++)
			{
				if(g.getWeightOfEdges(k, j)>0) //˵���бߴ���
				{
					if(lowCost[j]==-1)
					{
						lowCost[j] = g.getWeightOfEdges(k, j);
					}
					else
					{
						if(g.getWeightOfEdges(k, j)< lowCost[j]&& lowCost[j]!=-2)
						{
						  lowCost[j] = g.getWeightOfEdges(k, j);
						}	
					}
			    }
			}
	    }	
  }
}
