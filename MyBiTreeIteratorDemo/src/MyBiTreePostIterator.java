import java.util.Stack;

///二叉树游标后序遍历类
public class MyBiTreePostIterator extends MyBiTreeIterator{
  
	Stack<MyBiTreeNode> stack = new Stack<MyBiTreeNode>();
	Stack<MyBiTreeNode> temp = new Stack<MyBiTreeNode>();

	MyBiTreePostIterator()
	{
		
	}
	MyBiTreePostIterator(MyBiTreeNode root)
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
		if(!temp.isEmpty())
		{
			this.curr = temp.pop();
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
		
		while (this.curr != null || stack.size() > 0)
		{    
            while (this.curr != null) {    
                temp.push(this.curr);
                //System.out.println(this.curr.getData());
                stack.push(this.curr);    
                curr = this.curr.getRightChild();    
            }    
            if (stack.size() > 0) {    
                this.curr = stack.pop();    
                this.curr = this.curr.getLeftChild();    
            }    
        }   
		this.curr = temp.pop();
	}
	
	
	
	
}
