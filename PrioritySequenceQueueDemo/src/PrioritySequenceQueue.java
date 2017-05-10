//���ȼ�����
public class PrioritySequenceQueue implements Queue {
    
	static final int defaultSize = 10; //Ĭ�϶��г���
	int front ; //��ͷ
	int rear;  //��β
	int count;  //������
	int maxSize; //������󳤶�
	Element[] queue; //����
	
	public PrioritySequenceQueue()
	{
		init(defaultSize);
	}
	
	public PrioritySequenceQueue(int size)
	{
		init(size);
	}
	
	public void init(int size)
	{
		maxSize = size;
		front= rear = 0;
		count=0;
		queue = new Element[size];
	}
	
	@Override
	public void append(Object obj) throws Exception {
		// TODO Auto-generated method stub
		//�����������
		if(count>=maxSize)
		{
			throw new Exception("����������");
		}
		queue[rear]=(Element)obj;
		rear++;
		count++;
	}

	@Override
	public Object delete() throws Exception {
		// TODO Auto-generated method stub
		if(isEmpty())
		{
			throw new Exception("����Ϊ�գ�");
		}
		//Ĭ�ϵ�һ��Ԫ��Ϊ���ȼ���ߵġ�
		Element min = queue[0];
		int minIndex = 0;
		for(int i=0;i<count;i++)
		{
			if(queue[i].getPriority()<min.getPriority())
			{
				min = queue[i];
				minIndex = i;
			}
		}
		
		//�ҵ����ȼ�����ߵ�Ԫ�غ󣬰Ѹ�Ԫ�غ����Ԫ����ǰ�ƶ���
		for(int i=minIndex+1;i<count;i++)
		{
			queue[i-1]=queue[i]; //�ƶ�Ԫ��
		}
		rear--;
		count--;
		return min;
	}

	@Override
	public Object getFront() throws Exception {
		// TODO Auto-generated method stub
		if(isEmpty())
		{
			throw new Exception("����Ϊ�գ�");
		}
		//Ĭ�ϵ�һ��Ԫ��Ϊ���ȼ���ߵġ�
		Element min = queue[0];
		int minIndex = 0;
		for(int i=0;i<count;i++)
		{
			if(queue[i].getPriority()<min.getPriority())
			{
				min = queue[i];
				minIndex = i;
			}
		}
		return min;
	}

	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return count==0;
	}

}
