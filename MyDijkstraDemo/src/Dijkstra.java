
public class Dijkstra {
  
	static final int maxWeight = 9999;
	
	public static void dijkstra(MyAdjGraphic g,int v0,int[] distance,int[] path)
	throws Exception
	{
		int n = g.getNumOfVertice();//�������
		int[] s = new int[n]; //��ʾ����Ƿ��ѱ����ʵ�����
		int minDis; //ÿ���ҵ������·��
		int u=0; //��һ�����·����Ӧ�Ľ����±�
		
		for(int i=0;i<n;i++)
		{
			distance[i] = g.getWeightOfEdges(v0, i);
		    s[i] = 0; //δ����
		    if(i!=v0&&distance[i]<maxWeight)
		    {
		        path[i]= v0;	
		    }
		    else
		    {
		    	path[i]=-1;
		    }
		}
		s[0]=1; //���Ϊ�ѷ���
		for(int i=1;i<n;i++)
		{
			minDis = maxWeight;
			for(int j=0;j<n;j++)
			{
			    if(distance[j]!=-1) //˵���бߴ���
			    {
			    	//���δ���ʣ�����С�ڵ�ǰ��С·��
			    	if(s[j]==0&&distance[j]<minDis)
			    	{
			    		u = j;
			    		minDis = distance[j];
			    	}
			    }
			}
			
            if(minDis==maxWeight)
            {
            	return ;
            }
            s[u]=1;//���Ϊ�ѷ���
            for(int j=0;j<n;j++)
            {
            	if(g.getWeightOfEdges(u, j)!=-1) //�бߴ���
            	{
            		if(distance[j]==-1) //δ���ʹ�
            		{
            			if(s[j]==0&&g.getWeightOfEdges(u, j)<maxWeight)
            			{
            				distance[j] = distance[u]+g.getWeightOfEdges(u, j);
            				path[j]=u;
            			}
            		}
            		else
            		{
            			if(s[j]==0&&g.getWeightOfEdges(u, j)<maxWeight && distance[u]+g.getWeightOfEdges(u, j)<distance[j])
            			{
            				distance[j] = distance[u]+g.getWeightOfEdges(u, j);
            				path[j]=u;
            			}
            		}
            	}
            	
            }
		   	
		}
		
	}
}
