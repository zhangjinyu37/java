//����������
public class DoubleCycleLinkList implements List {

	Node head; //ͷָ��
	Node current;//��ǰ������
	int size;//������
	
	//��ʼ��һ��������
	public DoubleCycleLinkList()
	{
		//��ʼ��ͷ��㣬��ͷָ��ָ��ͷ��㡣�����õ�ǰ���������ͷ��㡣
		this.head = current = new Node(null);
		this.size =0;//����������ʼ����Ϊ�㡣
		this.head.next = head;
		this.head.prior = head;
	}
    
	//��λ������ʵ�ֵ�ǰ���������ǰһ����㣬Ҳ�����õ�ǰ������λ��Ҫ��������ǰһ����㡣
	public void index(int index) throws Exception
	{
		if(index <-1 || index > size -1)
		{
		  throw new Exception("��������");	
		}
		//˵����ͷ���֮�������
		if(index==-1)
			return;
		current = head.next;
		int j=0;//ѭ������
		while(current != head&&j<index)
		{
			current = current.next;
			j++;
		}
		
	}	
	
	@Override
	public void delete(int index) throws Exception {
		// TODO Auto-generated method stub
		//�ж������Ƿ�Ϊ��
		if(isEmpty())
		{
			throw new Exception("����Ϊ�գ��޷�ɾ����");
		}
		if(index <0 ||index >size)
		{
			throw new Exception("��������");
		}
		index(index-1);//��λ��Ҫ��������ǰһ��������
		current.setNext(current.next.next);
		current.next.setPrior(current);
		size--;
	}

	@Override
	public Object get(int index) throws Exception {
		// TODO Auto-generated method stub
		if(index <-1 || index >size-1)
		{
			throw new Exception("�����Ƿ���");
		}
		index(index);
		
		return current.getElement();
	}

	@Override
	public void insert(int index, Object obj) throws Exception {
		// TODO Auto-generated method stub
		if(index <0 ||index >size)
		{
			throw new Exception("��������");
		}
		index(index-1);//��λ��Ҫ��������ǰһ��������
		current.setNext(new Node(obj,current.next));
		current.next.setPrior(current);
		current.next.next.setPrior(current.next);
		
		size++;
	}

	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return size==0;
	}

	@Override
	public int size() {
		// TODO Auto-generated method stub
		return this.size;
	}
	
	
}
