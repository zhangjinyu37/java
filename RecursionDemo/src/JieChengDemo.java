import java.util.Scanner;


public class JieChengDemo {
    
	public static long jieCheng(int num)
	{
		if(num==1)
		{
			return 1;
		}
		else
		{
			return num*jieCheng(num-1); //�ݹ����
		}
	}
	
	
	
	public static void main(String[] args) {
	    
		int num;
		long result;
		Scanner in = new Scanner(System.in);
		System.out.println("������һ����������");
		num = in.nextInt();
		result = JieChengDemo.jieCheng(num);
		System.out.println(num+"�Ľ׳��ǣ�"+result);
		
	}

}
