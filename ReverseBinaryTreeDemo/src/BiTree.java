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
	
	//��ӡ������
	public static void printBiTree(BiTreeNode root,int level)
	{
		if(root!=null)
		{
			printBiTree(root.getRightChild(),level+1);
			
			if(level!=0)
			{
				//���6*��level-1�����ո�
				for(int i=0;i<6*(level-1);i++)
				{
					System.out.print(" ");
				}
				System.out.print("-----");
			}
			System.out.println(root.getData());
		
		    printBiTree(root.getLeftChild(),level+1);
		}
	}
	
	//��ö������Ľ��
	public static BiTreeNode getTreeNode(Object data,BiTreeNode left,BiTreeNode right)
	{
		BiTreeNode node = new BiTreeNode(data,left,right);
		return node;
	}
	
	//����ָ��Ԫ��
	public static BiTreeNode search(BiTreeNode root,Object obj)
	{
		BiTreeNode node=null;
		if(root==null)
		{
			return null;
		}
		if(root.getData().equals(obj))
		{
			return root;
		}
		if(root.getLeftChild()!=null)
		{
			node = search(root.getLeftChild(),obj);
		}
		if(root.getRightChild()!=null)
		{
			node = search(root.getRightChild(),obj);
		}
		
		return node;
	}
	
	//��ת���������㷨
	public static void reverse(BiTreeNode root)
	{
		BiTreeNode tempNode;
		tempNode = root.getLeftChild();
		root.setLeftChild(root.getRightChild());
		root.setRightChild(tempNode);
		
		if(root.getLeftChild()!=null)
		{
			reverse(root.getLeftChild());
		}
		
		if(root.getRightChild()!=null)
		{
			reverse(root.getRightChild());
		}
	}
	
}
