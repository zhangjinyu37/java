//�����
public class Node {
  
	Object element; //������
	Node next;  //���ָ����
	Node prior; //ǰ��ָ����
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
	
	//��õ�ǰ����ǰ�����
	public Node getPrior()
	{
		return this.prior;
	}
	//��õ�ǰ���������ֵ
	public Object getElement()
	{
		return this.element;
	}
	
	//���õ�ǰ���ĺ��ָ����
	public void setNext(Node nextval)
	{
		this.next = nextval;
	}
	
	//���õ�ǰ����ǰ��ָ����
	public void setPrior(Node priorval)
	{
		this.prior = priorval;
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
