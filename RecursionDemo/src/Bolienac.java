
public class Bolienac {
  
	//��ò����������е�N���ֵ
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
		System.out.println("�����������е�ǰ"+n+"��֮���ǣ�"+result);
	}
	
}
