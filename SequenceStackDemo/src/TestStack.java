
public class TestStack {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
      String s1 = "china";
      String s2 = "china";
      //������new�ؼ������Ķ��󣬶����ڶ��ڴ��з���ռ䡣
      String s3 = new String("china");
      
      //����new�����Ķ��󣬾����ǲ�ͬ����������
      String s4 = new String("china");
      
      System.out.println(s1==s2);
      System.out.println(s1==s3);
      System.out.println(s3==s4);
      System.out.println(s3.equals(s4));
      
      System.out.println("\n-----------------\n");
      /*String�����⣬��д�Ӹ���̳й�����hashCode������ʹ������
       *�ַ������������ȣ���ôhashCodeҲ��ȡ�
       **/
      System.out.println(s3.hashCode());
      System.out.println(s4.hashCode());
      
      System.out.println("\n-----------------\n");
      System.out.println(System.identityHashCode(s3));
      System.out.println(System.identityHashCode(s4));
	  
      System.out.println("\n-----------------\n");
      System.out.println(s1.hashCode());
      System.out.println(s2.hashCode());
      
      System.out.println("\n-----------------\n");
      System.out.println(System.identityHashCode(s1));
      System.out.println(System.identityHashCode(s2));
	
	}

}
