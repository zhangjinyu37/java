
public class Test {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
      char[] c1={'c','h','i','n','a'};
      char[] c2={'I','l','o','v','e',' ','c','h','i','n','a'};
      //���췽��1
      MyString str1= new MyString();
      
      //���췽��3
      MyString str2 = new MyString(c1);
      
      //���췽��2
      MyString str3 = new MyString(c2,1,5);
      
      //���췽��4
      MyString str4 = new MyString("Hello ");
      
      MyString str5 = new MyString("China");
      
      
      
      System.out.println(str1);
      System.out.println(str2);
      System.out.println(str3);
      System.out.println(str4);
      
      System.out.println(str4.length());
      System.out.println(str3.charAt(2));
      
      System.out.println(str5);
      System.out.println(str5.hashCode());
      str5 =str5.concat(str4);
      System.out.println(str5);
      System.out.println(str5.hashCode());
	}

}
