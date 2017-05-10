import java.util.Random;


public class MyMatrix {
   
	int[][] matrix ;//��������
	Random random =new Random() ;//���������
	
	//Ĭ�ϵĹ��췽��������3*3�ľ���
	public MyMatrix()
	{
		matrix = new int[3][3];
		//��ʼ����
		for(int i=0;i<matrix.length;i++)
		{
			for(int j=0;j<matrix[i].length;j++)
			{
				matrix[i][j]=random.nextInt(100);
			}
		}
	}
	
	//���ɷ���Ĺ��췽��
	public MyMatrix(int n)
	{
	    matrix = new int[n][n];
	    //��ʼ����
		for(int i=0;i<matrix.length;i++)
		{
			for(int j=0;j<matrix[i].length;j++)
			{
				matrix[i][j]=random.nextInt(100);
			}
		}
	}
	
	//����һ��m*n�ľ���
	public MyMatrix(int m,int n)
	{
		matrix = new int[m][n];
		//��ʼ����
		for(int i=0;i<matrix.length;i++)
		{
			for(int j=0;j<matrix[i].length;j++)
			{
				matrix[i][j]=random.nextInt(100);
			}
		}
	}
	
	//������֪��ά���飬���ɾ���
	public MyMatrix(int[][] matrix)
	{
		this.matrix = matrix;
	}
	
	//���ؾ�������
	public int[][] getMatrix()
	{
		return this.matrix;
	}
	
	//��ӡ����
	public void print()
	{
		for(int i=0;i<matrix.length;i++)
		{
			for(int j=0;j<matrix[i].length;j++)
			{
				System.out.print(matrix[i][j]+" ");
			}
			System.out.println();
		} 	
	}
	
	//ת�þ���
	public MyMatrix transport()
	{
	    //�б���
		int m = matrix[0].length;
		//�б���
		int n = matrix.length;
		
		MyMatrix transMatrix = new MyMatrix(m,n);
		//��ʼ��
		for(int i=0;i<transMatrix.matrix.length;i++)
		{
			for(int j=0;j<transMatrix.matrix[i].length;j++)
			{
				transMatrix.matrix[i][j] = matrix[j][i];
			}
		}
		return transMatrix;
	}
	
	//�жϾ����Ƿ��������Ǿ���
	public boolean isUpTriangle()
	{
	   for(int i=1;i<matrix.length;i++)
	   {
		   for(int j=0;j<i;j++)
		   {
			   if(matrix[i][j]!=0)
			   {
				   return false;
			   }
		   }
	   }
	   return true;
	}
	
	//�ж��Ƿ��������Ǿ���
    public boolean isDownTriangle()
    {
    	for(int i=0;i<matrix.length;i++)
    	{
    		for(int j=matrix[i].length-1;j>i;j--)
    		{
    		   if(matrix[i][j]!=0)
  			   {
  				   return false;
  			   }
    		}
    	}
    	return true;
    }
    
    //�ж��Ƿ��ǶԳƾ���
    public boolean isSynmetry()
    {
       for(int i=1;i<matrix.length;i++)
  	   {
  		  for(int j=0;j<matrix[i].length;j++)
  		  {
  			  if(matrix[i][j]!=matrix[j][i])
  			  {
  				  return false;
  			  }
  		  }
  	   }
  	   return true;
    }
    
    //�������
    public void add(MyMatrix b)
    {
       int m = b.matrix.length;
       int n = b.matrix[0].length;
       if(m!=matrix.length||n!=matrix[0].length)
       {
    	   System.out.println("�������Ͳ���ͬ���޷���ӣ�");
       }
       else
       {
    	   for(int i=0;i<matrix.length;i++)
   		   {
   			 for(int j=0;j<matrix[i].length;j++)
   			 {
   				matrix[i][j]+=b.matrix[i][j];
   			 }
   			 
   		   } 	 
       }
    }
}
