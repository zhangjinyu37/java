//��ʽ����

public class LinkQueue implements Queue {
    
	Node front; //��ͷ
	Node rear;  //��β
	int count; //������
	
	public LinkQueue()
	{
		init();
	}
	
    public void init()
    {
    	front=rear=null;
    	count=0;
    }
	
	@Override
	public void append(Object obj) throws Exception {
		// TODO Auto-generated method stub
		Node node = new Node(obj,null);
		
		//�����ǰ���в�Ϊ�ա�
		if(rear!=null)
		{
			rear.next = node; //��β���ָ���½��
		}
		
		rear = node; //���ö�β���Ϊ�½��
		
		//˵��Ҫ����Ľ���Ƕ��еĵ�һ�����
		if(front==null)
		{
		  front = node;	
		}
		count++;
	}

	@Override
	public Object delete() throws Exception {
		// TODO Auto-generated method stub
		if(isEmpty())
		{
			new Exception("�����ѿգ�");
		}
		Node node = front;
		front = front.next;
		count--;
		return node.getElement();
	}

	@Override
	public Object getFront() throws Exception {
		// TODO Auto-generated method stub
		if(!isEmpty())
		{
			return front.getElement();
		}
		else
		{
			return null;	
		}
	}

	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return count==0;
	}

}
