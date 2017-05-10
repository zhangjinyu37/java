import java.util.Scanner;


public class Test {

	public static String[] expToStringArray(String exp)
	{
		int n = exp.length();
		String[] arr = new String[n];
		for(int i=0;i<arr.length;i++)
		{
			arr[i]= exp.substring(i, i+1);
		}
		return arr;
	}
	
	
	public static void signCheck(String exp)throws Exception
	{
		SequenceStack stack = new SequenceStack();
		String[] arr = Test.expToStringArray(exp);
		for(int i=0;i<arr.length;i++)
		{
		   if(arr[i].equals("(")||arr[i].equals("[")||arr[i].equals("{"))
		   {
			   stack.push(arr[i]);
		   }
		   
		   else if(arr[i].equals(")")&& !stack.isEmpty()&& stack.getTop().equals("("))
		   {
			   stack.pop();
		   }
		   else if(arr[i].equals(")")&& !stack.isEmpty()&& !stack.getTop().equals("("))
		   {
			   System.out.println("��������ƥ�������ȷ��");
			   return ;
		   }
		   else if(arr[i].equals("]")&& !stack.isEmpty()&& stack.getTop().equals("["))
		   {
			   stack.pop();
		   }
		   else if(arr[i].equals("]")&& !stack.isEmpty()&& !stack.getTop().equals("["))
		   {
			   System.out.println("��������ƥ�������ȷ��");
			   return ;
		   }
		   else if(arr[i].equals("}")&& !stack.isEmpty()&& stack.getTop().equals("{"))
		   {
			   stack.pop();
		   }
		   else if(arr[i].equals("}")&& !stack.isEmpty()&& !stack.getTop().equals("{"))
		   {
			   System.out.println("��������ƥ�������ȷ��");
			   return ;
		   }
		   else if(arr[i].equals(")")||arr[i].equals("]")||arr[i].equals("}")&& stack.isEmpty())
		   {
               System.out.println("�����Ŷ��������ţ�");
               return ;
		   }
   
		}
		if(!stack.isEmpty())
		{
			System.out.println("�����Ŷ��������ţ�");
		}
		else
		{
			System.out.println("����ƥ����ȷ��");
		}
	}
	
	public static void expCaculate(LinkStack stack) throws Exception
	{
		char ch; //ɨ��ÿ��������ַ���
		int x1,x2,b=0; //x1,x2:���������� ��b�ַ���ASCII��
		System.out.println("�����׺���ʽ����#���Ž���:");
		while((ch =(char)(b=System.in.read()))!='#')
		{
			//��������֣�˵���ǲ�������ѹ���ջ
			if(Character.isDigit(ch))
			{
				stack.push(new Integer(Character.toString(ch)));
			}
			//����������֣�˵���������
			else
			{
			    x2 = ((Integer)stack.pop()).intValue();
			    x1 = ((Integer)stack.pop()).intValue();
				switch(ch)
				{
				   case '+':
					   x1+=x2;
					   break;
				   case '-':
					   x1-=x2;
					   break;
				   case '*':
					   x1*=x2;
					   break;
				   case '/':
					   if(x2==0)
					   {
						   throw new Exception("��ĸ����Ϊ�㣡");
					   }
					   else
					   {
						   x1/=x2;
					   }
					   break;
				}
				stack.push(new Integer(x1));
			}
		}
		System.out.println("��׺���ʽ�������ǣ�"+stack.getTop());
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
      
	   //SequenceStack stack = new SequenceStack(10);
	   /*
	   LinkStack stack = new LinkStack();
       Scanner in = new Scanner(System.in);
       int temp;
       for(int i=0;i<10;i++)
       {
    	   System.out.println("�������"+(i+1)+"��������");
    	   temp = in.nextInt();
    	   stack.push(temp);
       }
       
       while(!stack.isEmpty())
       {
    	   System.out.println(stack.pop());
       }
	   */
		
		//String str = "([(a+b)-(c*e)]+{a+b}";
		//Test.signCheck(str);
		//(2+3)*(3-1)/2=5   23+31-*2/
		LinkStack stack = new LinkStack();
		Test.expCaculate(stack);
	}

}
