
public class MyMaze {
    
	private static int startPosI;//入口的i下标
    private static int startPosJ;//入口的j下标
    private static int endPosI;//出口的i下标
    private static int endPosJ;//出口的j下标
    
    //设置迷宫入口的坐标
    public void setStart(int startPosI,int startPosJ)
    {
       MyMaze.startPosI = startPosI;
       MyMaze.startPosJ = startPosJ;
    }
	
    //设置迷宫出口的坐标
    public void setEnd(int endPosI,int endPosJ)
    {
       MyMaze.endPosI = endPosI;
       MyMaze.endPosJ = endPosJ;
    }
	
    //迷宫搜索通路的算法
    /*  cell:迷宫地图
     *  i: 入口的i坐标
     *  j: 入口的j坐标
     **/
    public static void visited(int[][] cell,int i,int j)
    {
    	cell[i][j]=1;
    	
    	if(i==endPosI&&j==endPosJ) //找到了出口
    	{
    		System.out.println("找到一条通路：");
    		for(int m=0;m<cell.length;m++)
    		{
    			for(int n=0;n<cell[0].length;n++)
    			{
    			    if(cell[m][n]==2)
    			    {
    			    	System.out.print("2");
    			    }
    			    else if(cell[m][n]==1)
    			    {
    			        System.out.print("*");	
    			    }
    			    else
    			    {
    			    	System.out.print(" ");
    			    }
    			}
    			System.out.println();
    		}
    	}
    	//向左边寻找通路
    	if(cell[i][j-1]==0)
    	{
    		visited(cell,i,j-1);
    	}
    	//向右边寻找通路
    	if(cell[i][j+1]==0)
    	{
    	   visited(cell,i,j+1);
    	}
    	//向上寻找通路
    	if(cell[i-1][j]==0)
    	{
    	   visited(cell,i-1,j);
    	}
    	//向下寻找通路
    	if(cell[i+1][j]==0)
    	{
    		visited(cell,i+1,j);
    	}
    	cell[i][j]=0;
    }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub
       
		//初始化一个迷宫地图
		int[][] maze={
				{2,2,2,2,2,2,2,2,2},
				{2,0,0,0,0,0,0,0,2}, 
				{2,0,2,2,0,2,2,0,2}, 
				{2,0,2,0,0,2,0,0,2},
				{2,0,2,0,2,0,2,0,2}, 
				{2,0,0,0,0,0,2,0,2}, 
				{2,2,0,2,2,0,2,2,2}, 
				{2,0,0,0,0,0,0,0,2}, 
				{2,2,2,2,2,2,2,2,2}
		};
		
		MyMaze cell = new MyMaze();
		cell.setStart(1, 1);//设置迷宫的入口坐标
		cell.setEnd(7, 7);//设置迷宫的出口坐标
		cell.visited(maze, 1, 1);
	}

}
