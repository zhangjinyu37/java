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
			   System.out.println("左右括号匹配次序不正确！");
			   return ;
		   }
		   else if(arr[i].equals("]")&& !stack.isEmpty()&& stack.getTop().equals("["))
		   {
			   stack.pop();
		   }
		   else if(arr[i].equals("]")&& !stack.isEmpty()&& !stack.getTop().equals("["))
		   {
			   System.out.println("左右括号匹配次序不正确！");
			   return ;
		   }
		   else if(arr[i].equals("}")&& !stack.isEmpty()&& stack.getTop().equals("{"))
		   {
			   stack.pop();
		   }
		   else if(arr[i].equals("}")&& !stack.isEmpty()&& !stack.getTop().equals("{"))
		   {
			   System.out.println("左右括号匹配次序不正确！");
			   return ;
		   }
		   else if(arr[i].equals(")")||arr[i].equals("]")||arr[i].equals("}")&& stack.isEmpty())
		   {
               System.out.println("右括号多于左括号！");
               return ;
		   }
   
		}
		if(!stack.isEmpty())
		{
			System.out.println("左括号多于右括号！");
		}
		else
		{
			System.out.println("括号匹配正确！");
		}
	}
	
	public static void expCaculate(LinkStack stack) throws Exception
	{
		char ch; //扫描每次输入的字符。
		int x1,x2,b=0; //x1,x2:两个操作数 ，b字符的ASCII码
		System.out.println("输入后缀表达式并以#符号结束:");
		while((ch =(char)(b=System.in.read()))!='#')
		{
			//如果是数字，说明是操作数则压入堆栈
			if(Character.isDigit(ch))
			{
				stack.push(new Integer(Character.toString(ch)));
			}
			//如果不是数字，说明是运算符
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
						   throw new Exception("分母不能为零！");
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
		System.out.println("后缀表达式计算结果是："+stack.getTop());
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
    	   System.out.println("请输入第"+(i+1)+"个整数：");
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
