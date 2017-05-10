//�Գƾ�����
public class SynmeMatrix {
  
	double [] a;//����Ԫ��
	int n; //����Ľ���;
	int m; //һά����ĸ���
	
	public SynmeMatrix(int n)
	{
		//��Ҫ���ֵ�Ԫ�ظ�����m=n*(n-1)/2 ;
		m = n*(n+1)/2 ;
		a = new double[m];
		this.n = n;
	}
	//ͨ��һ����ά��������ʼ��
	public void evaluate(double[][] b)
	{
	  	int k=0;
	  	for(int i=0;i<n;i++)
	  	{
	  		for(int j=0;j<n;j++)
	  		{
	  		   if(i>=j)	
	  		   {
	  		      //System.out.println("a["+k+"]="+b[i][j]);
	  			  a[k++]=b[i][j]; //ֻ����������Ԫ��
	  		   }
	  		}
	  	}
		
	}
	
	//ͨ��һ��һά��������ʼ������ô���һά������ǶԳƾ���Ԫ�صĸ���
	public void evaluate(double[] b)
	{
		for(int k=0;k<m;k++)
		{
			a[k]= b[k];
		}
	}
	
	//�Գƾ������
	public SynmeMatrix add(SynmeMatrix b)
	{
	   SynmeMatrix t = new SynmeMatrix(n);
	   int k;
	   for(int i=1;i<=n;i++)
	   {
		   for(int j=1;j<=n;j++)
		   {
			   if(i>=j)
			   {
				   k= i*(i-1)/2+j-1;
			   }
			   else
			   {
				   k= j*(j-1)/2+i-1;
			   }
			   t.a[k] = a[k]+b.a[k];
		   }
	   }
	   return t;
	}
	
	//��ӡ�Գƾ���
	public void print()
	{
		   int k;
		   for(int i=1;i<=n;i++)
		   {
			   for(int j=1;j<=n;j++)
			   {
				   if(i>=j)
				   {
					   k= i*(i-1)/2+j-1;
				   }
				   else
				   {
					   k= j*(j-1)/2+i-1;
				   }
				   System.out.print(" "+a[k]);
			   }
			   System.out.println();
		   }
	}
}
