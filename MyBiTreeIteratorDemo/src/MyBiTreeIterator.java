
public class MyBiTreeIterator {
   
	MyBiTreeNode root; //���ڵ�
	MyBiTreeNode curr;// ��ǰ��㣻
	boolean isComplete;  //�ж��Ƿ��������
	
	MyBiTreeIterator()
	{
		
	}
	
	MyBiTreeIterator(MyBiTreeNode root)
	{
		this.root = root;
	}
	
	public void reset()
	{
		
	}
	
	public void next()
	{
	  	
	}
	
	public boolean endOfBiTree()
	{
	  return isComplete;	
	}
	
	public Object getData()
	{
		return this.curr.getData();
	}
	
	
	
}
