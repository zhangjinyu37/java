import java.util.Stack;


public class Test {

	/**
	 * @param args
	 */
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
        /*       
		Stack<Character> s = new Stack<Character>();
		char ch;
		//�ӿ���̨�����ַ���ֱ��#���Ž���
		System.out.println("�������ַ�����#������");
		while((ch=(char)(System.in.read()))!='#')
		{
		  	s.push(ch);
		}
		//������ջ
		while(!s.isEmpty())
		{
			System.out.println(s.pop());
		}
		*/
		String str = "3+(2-5)*6/3";  //325-6*3/+
		System.out.println(StringToArithmetic.infixToSuffix(str));
		System.out.println(StringToArithmetic.stringToArithmetic(str));
	}

}
