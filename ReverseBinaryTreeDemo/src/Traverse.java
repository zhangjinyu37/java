import java.util.LinkedList;
import java.util.Queue;


public class Traverse {
   
	//ǰ�����--�ݹ��㷨
	public static void preOrder(BiTreeNode root,Visit visit)
	{
		if(root!=null)
		{
			visit.print(root.getData());
			preOrder(root.getLeftChild(),visit);
			preOrder(root.getRightChild(),visit);
		}
	}
	
	//�������--�ݹ��㷨
	public static void inOrder(BiTreeNode root,Visit visit)
	{
		if(root!=null)
		{
			inOrder(root.getLeftChild(),visit);
			visit.print(root.getData());
			inOrder(root.getRightChild(),visit);
		}
	}
	
	//�������--�ݹ��㷨
	public static void postOrder(BiTreeNode root,Visit visit)
	{
		if(root!=null)
		{
			postOrder(root.getLeftChild(),visit);
			postOrder(root.getRightChild(),visit);
			visit.print(root.getData());
		}
		
	}
	
	//��α���
	public static void levOrder(BiTreeNode root,Visit visit)
	{
	   Queue<BiTreeNode> queue = new LinkedList<BiTreeNode>();
	   
	   if(root==null)
	   {
		   return ;
	   }
	   BiTreeNode curr;
	   queue.add(root);
	   
	   while(!queue.isEmpty())
	   {
		   curr = queue.remove();
		   visit.print(curr.getData());
		   if(curr.getLeftChild()!=null)
		   {
			  queue.add(curr.getLeftChild());   
		   }
		   if(curr.getRightChild()!=null)
		   {
			  queue.add(curr.getRightChild());   
		   }
	   }
	   
	}
}
