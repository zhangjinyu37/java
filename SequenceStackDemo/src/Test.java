import java.util.Scanner;


public class Test {

	/**
	 * @param args
	 */
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
       SequenceStack stack = new SequenceStack(10);
       
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
		
	}

}
