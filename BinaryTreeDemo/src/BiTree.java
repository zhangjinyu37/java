//��������
public class BiTree {

	private BiTreeNode  root;//���ڵ�
	
	
	
	BiTree()
	{
		this.root = null;
	}
	
	BiTree(Object data,BiTree left,BiTree right)
	{
		BiTreeNode l,r;
		if(left==null)
		{
			l = null;
		}
		else
		{
		   l=left.root; 
		}
		
		if(right==null)
		{
			r = null;
		}
		else
		{
			r = right.root;
		}
		
		this.root = new BiTreeNode(data,l,r);
	}
	
}
