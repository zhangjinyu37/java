import java.util.Scanner;


//������������
public class MyThreadBiTree {
   
	protected MyBiTreeNode head;
	protected final static String ENDFLAG = "null"; 
	
	public MyThreadBiTree()
	{
		this.head = null;
	}
	
	//��ʼ���������ĸ��ڵ�
	public void initMyBiTree()
	{
		String item;
		Scanner in = new Scanner(System.in);
		System.out.println("�������������������㣨����null��ʾ�ý��Ϊ�գ���");
	    item = in.next();
	    if(!item.equalsIgnoreCase(ENDFLAG))
	    {
	      head = new MyBiTreeNode(item);
	      init(head);
	    }
	}
	
	//��ʼ��������
	private void init(MyBiTreeNode head)
	{
	   String item;
	   Scanner in = new Scanner(System.in);
	   System.out.println("������"+head.getData()+"�������ӽ�㣺");
	   item = in.next();
	   if(!item.equalsIgnoreCase(ENDFLAG))
	   {
		  head.setLeftNode(new MyBiTreeNode(item));
		  init(head.getLeftNode()); //�ݹ�
	   }
	   System.out.println("������"+head.getData()+"�����Һ��ӽ�㣺");
	   item = in.next();
	   if(!item.equalsIgnoreCase(ENDFLAG))
	   {
		  head.setRightNode(new MyBiTreeNode(item));
		  init(head.getRightNode()); //�ݹ�
	   }
	}
	
	//��������������
	public void createMyThreadBiTree()
	{
		
	}
	
	//���������㷨
	public void traversal()
	{
		
	}
	
    	
}
