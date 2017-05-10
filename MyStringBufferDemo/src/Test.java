
public class Test {

	public static void main(String[] args) {
	   
		MyStringBuffer sb1 = new MyStringBuffer("I love ");
		MyStringBuffer sb2 = new MyStringBuffer("china");
		
		
		System.out.println(sb1.hashCode());
		System.out.println(sb2.hashCode());
		System.out.println(sb2);
		sb2.concat(sb1);
		System.out.println(sb2.hashCode());
		System.out.println(sb2);
	}

}
