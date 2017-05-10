//ѭ��˳�����
public class CircleSequenceQueue implements Queue{
    
	static final int defaultSize = 10; //Ĭ�϶��еĳ���
	int front;  //��ͷ
	int rear;   //��β
	int count;  //ͳ��Ԫ�ظ����ļ�����
	int maxSize; //�ӵ���󳤶�
	Object[] queue;  //����
	
	public CircleSequenceQueue()
	{
		init(defaultSize);
	}
	
	public CircleSequenceQueue(int size)
	{
	    init(size);	
	}
	
	public void init(int size)
	{
		maxSize = size;
		front=rear=0;
		count=0;
		queue = new Object[size];
	}
	
	@Override
	public void append(Object obj) throws Exception {
		// TODO Auto-generated method stub
		if(count>0&&front==rear)
		{
			throw new Exception("����������");
		}
		queue[rear]=obj;
		rear=(rear+1)%maxSize;
		count++;
	}

	@Override
	public Object delete() throws Exception {
		// TODO Auto-generated method stub
		if(isEmpty())
		{
			throw new Exception("����Ϊ�գ�");
		}
		Object obj = queue[front];
		front = (front+1)%maxSize;
		count--;
		return obj;
	}

	@Override
	public Object getFront() throws Exception {
		// TODO Auto-generated method stub
		if(!isEmpty())
		{
		   return queue[front];	
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
