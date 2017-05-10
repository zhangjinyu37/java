
public class Test {

	
	public static void main(String[] args)throws Exception {
		
		MySet set1 = new MySet();
		set1.add(new Integer(0));
		set1.add(new Integer(1));
		set1.add(new Integer(2));
		
		MySet set2 = new MySet();
		set2.add(new Integer(0));
		set2.add(new Integer(1));
		set2.add(new Integer(2));
		//set2.add(new Integer(3));
		//set2.add(new Integer(4));
		
		System.out.println(set1.size());
		set1.add(new Integer(2));//不能添加重复元素
		System.out.println(set1.size());
		set1.add(null);//不能添加空对象
		System.out.println(set1.size());
		
		System.out.println(set2.include(set1));
		System.out.println(set1.include(set2));
		System.out.println(set1.equals(set2));
	}

}
