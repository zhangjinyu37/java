import java.util.Scanner;


//���÷ǵݹ��㷨��ʵ�ֽ׳ˡ�ʹ��ѭ��
public class JieCheng2Demo {

	public static long jieCheng2(int num)
	{
		long result =1;
		for(int i=num;i>=1;i--)
		{
			result*=i;
		}
		return result;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
       
		int num;
		long result;
		Scanner in = new Scanner(System.in);
		System.out.println("������һ����������");
		num = in.nextInt();
		result = JieCheng2Demo.jieCheng2(num);
		System.out.println(num+"�Ľ׳��ǣ�"+result);
	}

}
