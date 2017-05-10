
public class MyMaze {
    
	private static int startPosI;//��ڵ�i�±�
    private static int startPosJ;//��ڵ�j�±�
    private static int endPosI;//���ڵ�i�±�
    private static int endPosJ;//���ڵ�j�±�
    
    //�����Թ���ڵ�����
    public void setStart(int startPosI,int startPosJ)
    {
       MyMaze.startPosI = startPosI;
       MyMaze.startPosJ = startPosJ;
    }
	
    //�����Թ����ڵ�����
    public void setEnd(int endPosI,int endPosJ)
    {
       MyMaze.endPosI = endPosI;
       MyMaze.endPosJ = endPosJ;
    }
	
    //�Թ�����ͨ·���㷨
    /*  cell:�Թ���ͼ
     *  i: ��ڵ�i����
     *  j: ��ڵ�j����
     **/
    public static void visited(int[][] cell,int i,int j)
    {
    	cell[i][j]=1;
    	
    	if(i==endPosI&&j==endPosJ) //�ҵ��˳���
    	{
    		System.out.println("�ҵ�һ��ͨ·��");
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
    	//�����Ѱ��ͨ·
    	if(cell[i][j-1]==0)
    	{
    		visited(cell,i,j-1);
    	}
    	//���ұ�Ѱ��ͨ·
    	if(cell[i][j+1]==0)
    	{
    	   visited(cell,i,j+1);
    	}
    	//����Ѱ��ͨ·
    	if(cell[i-1][j]==0)
    	{
    	   visited(cell,i-1,j);
    	}
    	//����Ѱ��ͨ·
    	if(cell[i+1][j]==0)
    	{
    		visited(cell,i+1,j);
    	}
    	cell[i][j]=0;
    }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub
       
		//��ʼ��һ���Թ���ͼ
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
		cell.setStart(1, 1);//�����Թ����������
		cell.setEnd(7, 7);//�����Թ��ĳ�������
		cell.visited(maze, 1, 1);
	}

}
