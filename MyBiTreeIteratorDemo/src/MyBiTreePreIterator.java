import java.util.Stack;


//�������α�ǰ�������
public class MyBiTreePreIterator extends MyBiTreeIterator{
   
	Stack<MyBiTreeNode> stack = new Stack<MyBiTreeNode>();
     
	
	MyBiTreePreIterator()
	{
		
	}
	MyBiTreePreIterator(MyBiTreeNode root)
	{
	   super(root);	
	}
	
	@Override
	public void next() {
		// TODO Auto-generated method stub
		if(this.isComplete)
		{
			System.out.println("�Ѿ���������������β��");
			return ;
		}
		if(this.curr.getRightChild()!=null)
		{
			stack.push(this.curr.getRightChild());
		}
		if(this.curr.getLeftChild()!=null)
		{
			stack.push(this.curr.getLeftChild());
		}
		
		if(!stack.empty())
		{
			this.curr = stack.pop();
		}
		else
		{
			this.isComplete = true;
		}
		
	}
	
	@Override
	public void reset() {
		// TODO Auto-generated method stub
		if(this.root==null)
		{
			this.isComplete = true;
		}
		else
		{
			this.isComplete = false;
		}
		if(this.root==null)
		{
			return ;
		}
		
		this.curr = this.root;
	}
	
	
}
