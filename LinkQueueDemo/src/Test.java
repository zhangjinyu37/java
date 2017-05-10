
public class Test {

	/**
	 * @param args
	 */
	
	public static boolean isHuiWen(String str)throws Exception
	{
		int n = str.length();
		LinkStack stack = new LinkStack();//������ջ
		LinkQueue queue = new LinkQueue();//��������
		for(int i=0;i<n;i++)
		{
			stack.push(str.subSequence(i, i+1)); //���ַ���ÿ���ַ�ѹ����ջ
			queue.append(str.subSequence(i, i+1));//���ַ���ÿ���ַ�ѹ�����
		}
		while(!queue.isEmpty()&&!stack.isEmpty())
		{
		   if(!queue.delete().equals(stack.pop()))
		   {
			  return false;   
		   }
		}
		
		return true;
	}
	
	public static void main(String[] args)throws Exception {
		// TODO Auto-generated method stub
		/*
		LinkQueue queue = new LinkQueue();
		queue.append("a");
		queue.append("b");
		queue.append("c");
		queue.append("d");
		queue.append("e");
		queue.append("f");
		
		queue.delete();
		queue.delete();
		
		queue.append("g");
		
		
		while(!queue.isEmpty())
		{
			System.out.println(queue.delete());
		}*/
		
		String str1= "ABCDCBA" ;
		String str2 = "ABCDECAB" ;
		
		try
		{
		   if(Test.isHuiWen(str2))
		   {
			   System.out.println(str2+":�ǻ��ģ�");
		   }
		   else
		   {
			   System.out.println(str2+":���ǻ��ģ�");
		   }
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
		}
	}

}
