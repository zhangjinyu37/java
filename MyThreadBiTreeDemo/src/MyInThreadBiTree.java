//中序线索二叉树类
public class MyInThreadBiTree extends MyThreadBiTree {
  
	public MyInThreadBiTree()
	{
		super();
	}

	@Override
	public void initMyBiTree() {
		// TODO Auto-generated method stub
		super.initMyBiTree();
	}
    
	@Override
	public void createMyThreadBiTree() {
		
	    create(head,null);	
	}
	
	//中序线索化二叉树
	private MyBiTreeNode create(MyBiTreeNode curNode,MyBiTreeNode preNode)
	{
		if (curNode != null) 
		{
			MyBiTreeNode tempNode = create(curNode.getLeftNode(), preNode);

			if ((!curNode.getLeftFlag()) && (curNode.getLeftNode() == null)) 
			{
				curNode.setLeftFlag(true);
				curNode.setLeftNode(preNode);
			} // end of if

			preNode = tempNode;

			if ((preNode != null) && (preNode.getRightNode() == null)) 
			{
				preNode.setRightFlag(true);
				preNode.setRightNode(curNode);
			} // end of if

			preNode = curNode;
			preNode = create(curNode.getRightNode(), preNode);
			return preNode;
		} // end of if

		return preNode;
	}
	
	//中序线索遍历算法
	@Override
	public void traversal() {
		MyBiTreeNode walker = this.head;

		if (this.head != null) {
			while (!walker.getLeftFlag())
				walker = walker.getLeftNode();

			System.out.print(walker.getData() + " ");

			while (walker.getRightNode() != null) {
				if (walker.getRightFlag())
					walker = walker.getRightNode();
				else {
					walker = walker.getRightNode();
					while ((walker.getLeftNode() != null)
							&& (!walker.getLeftFlag()))
						walker = walker.getLeftNode();
				} // end of else

				System.out.print(walker.getData() + " ");
			} // end of while
		} // end of if
	}
	
	
}
