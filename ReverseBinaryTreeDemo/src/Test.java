
public class Test {
   
	public static BiTreeNode makeTree()
	{
		BiTreeNode b,c,d,e,f,g;
		g = BiTree.getTreeNode(new Character('G'), null, null);
		d = BiTree.getTreeNode(new Character('D'), null, g);
		b = BiTree.getTreeNode(new Character('B'), d, null);
		e = BiTree.getTreeNode(new Character('E'), null, null);
		f = BiTree.getTreeNode(new Character('F'), null, null);
	    c = BiTree.getTreeNode(new Character('C'), e, f);
	    return BiTree.getTreeNode(new Character('A'), b, c);
	}
	
	public static void main(String[] args) {
		
		BiTreeNode root;
		BiTreeNode temp;
		
		Visit visit = new Visit();
		
		root = Test.makeTree();
		System.out.println("������Ϊ��");
		BiTree.printBiTree(root, 0);
		System.out.println();
		
		System.out.println("ǰ������������ǣ�");
		Traverse.preOrder(root, visit);
		System.out.println();
	    
		System.out.println("��������������ǣ�");
		Traverse.inOrder(root, visit);
		System.out.println();
		
		System.out.println("��������������ǣ�");
		Traverse.postOrder(root, visit);
		System.out.println();
		
		System.out.println("��α����������ǣ�");
		Traverse.levOrder(root, visit);
		System.out.println();
		
	    temp = BiTree.search(root, new Character('T'));
	    if(temp!=null)
	    {
	    	System.out.println(temp.getData());
	    }
	    else
	    {
	    	System.out.println("û���ҵ�ָ��Ԫ�أ�");
	    }
	    
	    //��ת������
	    BiTree.reverse(root);
	    System.out.println("��ת������Ϊ��");
	    BiTree.printBiTree(root, 0);
	}

}
