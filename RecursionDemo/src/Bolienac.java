
public class Bolienac {
  
	//获得波列那契数列第N项的值
	public static int getNums(int n)
	{
        if(n==1||n==2)
        {
        	return 1;
        }
        else
        {
        	return getNums(n-1)+getNums(n-2);
        }
	}
	
	
	public static void main(String[] args)
	{
		//1,1,2,3,5,8,13
		int n=7;
		int result=0;
		for(int i=n;i>=1;i--)
		{
			result+=Bolienac.getNums(i);
		}
		System.out.println("波列那契数列的前"+n+"项之和是："+result);
	}
	
}
