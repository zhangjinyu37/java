import java.util.LinkedList;
import java.util.Queue;

///二叉树游标层次遍历类
public class MyBiTreeLevIterator extends MyBiTreeIterator {
   
	Queue<MyBiTreeNode> queue = new LinkedList<MyBiTreeNode>();
	
	MyBiTreeLevIterator()
	{
		
	}
	
	MyBiTreeLevIterator(MyBiTreeNode root)
	{
	  super(root);	
	}

	@Override
	public void next() {
		// TODO Auto-generated method stub
		if(this.isComplete)
		{
			System.out.println("已经遍历到二叉树结尾！");
			return ;
		}
		if(!queue.isEmpty())
		{
			this.curr = queue.remove();
			if(this.curr.getLeftChild()!=null)
			{
				queue.add(this.curr.getLeftChild());
			}
			if(this.curr.getRightChild()!=null)
			{
				queue.add(this.curr.getRightChild());
			}
		}
		else
		{
			this.isComplete = true;
		}
	}

	@Override
	public void reset() {
		// TODO Auto-generated method stub
		if (this.root == null) {
			this.isComplete = true;
		} else {
			this.isComplete = false;

		}
		if (this.root == null) {
			return;
		}
		this.curr = root;
		if(this.curr.getLeftChild()!=null)
		{
			queue.add(this.curr.getLeftChild());
		}
		if(this.curr.getRightChild()!=null)
		{
			queue.add(this.curr.getRightChild());
		}
	}
	
	
}
