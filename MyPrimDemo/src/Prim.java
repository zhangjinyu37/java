//特里姆算法类
public class Prim {
  public final static int MAXWEIGHT = 9999;
  
  //特里姆算法
  public static void prim(MyAdjGraphic g,MinSpanTree[] closeVertex) throws Exception
  {
	  int n = g.getNumOfVertice(); //获得结点数量
	  int[] lowCost = new int[n];
	  int k=0; 
	  int minCost;  
	  
	  //初始化closeVertex数组
	  for(int i=0;i<n;i++)
	  {
		  lowCost[i] = g.getWeightOfEdges(0, i);
	  }
	  
	  MinSpanTree temp = new MinSpanTree();
	  temp.vertex = g.getValueOfVertice(0);	
	  closeVertex[0] = temp;
	  lowCost[0] = - 2;//标记为已访问
	  
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
			lowCost[k] = -2; //标记为已访问
			
			for(int j = 1; j < n; j ++)
			{
				if(g.getWeightOfEdges(k, j)>0) //说明有边存在
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
