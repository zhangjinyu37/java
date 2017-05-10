import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

//邻接矩阵类
public class MyAdjGraphic {

	static final int maxWeight=-1; //如果两个结点之间没有边，权值为-1；
	ArrayList vertices = new ArrayList();//存放结点的集合
	int[][] edges; //邻接矩阵的二维数组
	int numOfEdges; //边的数量
	
	public MyAdjGraphic(int n)
	{
	    edges = new int[n][n];
		for(int i=0;i<n;i++)
	    {
	    	for(int j=0;j<n;j++)
	    	{
	    		if(i==j) //对角线上的元素
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
	
	//返回边的数量
	public int getNumOfEdges()
	{
		return this.numOfEdges;
	}
	
	//返回结点的数量
	public int getNumOfVertice()
	{
		return this.vertices.size();
	}
	
	//返回结点的值
	public Object getValueOfVertice(int index)
	{
	    return this.vertices.get(index);	
	}
	
	//获得某条边的权值
	public int getWeightOfEdges(int v1,int v2) throws Exception
	{
	   if((v1 < 0 || v1 >= vertices.size())||(v2 < 0||v2 >= vertices.size()))
	   {
		   throw new Exception("v1或者v2参数越界错误！");
	   }
	   return this.edges[v1][v2];
	   
	}
	
	//插入结点
	public void insertVertice(Object obj)
	{
		this.vertices.add(obj);
	}
	
	//插入带权值的边
	public void insertEdges(int v1,int v2,int weight) throws Exception
	{
		if((v1 < 0 || v1 >= vertices.size())||(v2 < 0||v2 >= vertices.size()))
		{
		  throw new Exception("v1或者v2参数越界错误！");
		}
		
		this.edges[v1][v2]=weight;
		this.numOfEdges++;
	}
	
	//删除某条边
	public void deleteEdges(int v1,int v2) throws Exception
	{
	    if((v1 < 0 || v1 >= vertices.size())||(v2 < 0||v2 >= vertices.size()))
		{
		  throw new Exception("v1或者v2参数越界错误！");
		}
	    if( v1==v2 || this.edges[v1][v2]==maxWeight)	
	    {
	    	throw new Exception("边不存在！");
	    }
	    
	    this.edges[v1][v2]=maxWeight;
	    this.numOfEdges--;   
	}
	
	//打印邻接矩阵
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
	
	//取第一个邻接结点
	public int getFirstNeighbor(int v) throws Exception
    {
		if((v < 0 || v >= vertices.size()))
		{
		  throw new Exception("v参数越界错误！");
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
	///取下一个邻接结点
	public int getNextNeighbor(int v1,int v2) throws Exception
	{
		if((v1 < 0 || v1 >= vertices.size())||(v2 < 0||v2 >= vertices.size()))
		{
		  throw new Exception("v1或者v2参数越界错误！");
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
	
	//连通图的深度优先遍历算法
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
	
	//连通图的深度优先遍历算法真正实现算法
	private void deptFirstSearch(int v, boolean[] visited, Visit vs) throws Exception{
	//连通图以v为初始结点序号、访问操作为vs的深度优先遍历
	//数组visited标记了相应结点是否已访问过，0表示未访问，1表示已访问
		vs.print(this.getValueOfVertice(v)); //访问该结点
		visited[v] = true; 	//置已访问标记
		int w = getFirstNeighbor(v);//取第一个邻接结点
		while(w != -1)
	    {//当邻接结点存在时循环
		  if(!visited[w])//如果没有访问过
		  {
		    deptFirstSearch(w, visited,vs); //以w为初始结点递归遍历
	      }
		  w = getNextNeighbor(v, w);//取下一个邻接结点
		}
	}
    
	//广度优先遍历算法真正的实现算法
	private void broadFirstSearch(int v, boolean[] visited, Visit vs) throws Exception{
        //数组visited标记了相应结点是否已访问过，0表示未访问，1表示已访问
		int u, w;
		Queue queue = new LinkedList();//创建顺序队列queue
		vs.print(this.getValueOfVertice(v));//访问结点v
		visited[v] = true; //置已访问标记
		queue.add(new Integer(v)); //结点v入队列
		while(! queue.isEmpty())
        {//队列非空时循环
		   u = ((Integer)queue.remove()).intValue();//出队列
		   w = getFirstNeighbor(u);//取结点u的第一个邻接结点
		   while(w != - 1)
           {  //当邻接结点存在时循环
		      if(! visited[w])
              { //若该结点没有访问过
		          vs.print(this.getValueOfVertice(w));//访问结点w
		          visited[w] = true;//置已访问标记
		          queue.add(new Integer(w)); 	//结点w入队列
		      }//取结点u的邻接结点w的下一个邻接结点
		      w = getNextNeighbor(u, w);
		  }
		}
	}
	
	//广度优先遍历算法的调用算法
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
