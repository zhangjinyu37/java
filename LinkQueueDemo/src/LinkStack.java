
public class LinkStack implements Stack {
    
	Node head;  //ջ��ָ��
	int size;  //���ĸ���
	
	public LinkStack()
	{
		head = null;
		size = 0;
	}
	
	@Override
	public Object getTop() throws Exception {
		// TODO Auto-generated method stub
		return head.getElement();
	}

	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return head==null;
	}

	@Override
	public Object pop() throws Exception {
		// TODO Auto-generated method stub
		if(isEmpty())
		{
			throw new Exception("ջΪ�գ�");
		}
		Object obj = head.getElement();
		head = head.getNext();
		size--;
		return obj;
		
	}

	@Override
	public void push(Object obj) throws Exception {
		// TODO Auto-generated method stub
		head = new Node(obj,head);
		size++;
	}

}
