
public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        
		MyThreadBiTree tree = new MyInThreadBiTree();
		tree.initMyBiTree();
		tree.createMyThreadBiTree();
		System.out.println("中序遍历序列是：");
		tree.traversal();
	
	}

}
