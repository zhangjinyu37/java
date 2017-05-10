//�����
public class Node {
  
	Object element; //������
	Node next;  //ָ����
	
	//ͷ���Ĺ��췽��
	public Node(Node nextval)
	{
		this.next = nextval;
	}
	
	//��ͷ���Ĺ��췽��
	public Node(Object obj,Node nextval)
	{
	   this.element = obj;
	   this.next = nextval;
	}
	
	//��õ�ǰ���ĺ�̽��
	public Node getNext()
	{
		return this.next;
	}
	
	//��õ�ǰ���������ֵ
	public Object getElement()
	{
		return this.element;
	}
	
	//���õ�ǰ����ָ����
	public void setNext(Node nextval)
	{
		this.next = nextval;
	}
	
	//���õ�ǰ����������
	public void setElement(Object obj)
	{
		this.element = obj;
	}
	
	public String toString()
	{
	   return this.element.toString();	
	}
}
