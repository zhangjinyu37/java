//优先级队列
public class PrioritySequenceQueue implements Queue {
    
	static final int defaultSize = 10; //默认队列长度
	int front ; //队头
	int rear;  //队尾
	int count;  //计数器
	int maxSize; //队列最大长度
	Element[] queue; //队列
	
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
		//如果队列已满
		if(count>=maxSize)
		{
			throw new Exception("队列已满！");
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
			throw new Exception("队列为空！");
		}
		//默认第一个元素为优先级最高的。
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
		
		//找的优先级别最高的元素后，把该元素后面的元素向前移动。
		for(int i=minIndex+1;i<count;i++)
		{
			queue[i-1]=queue[i]; //移动元素
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
			throw new Exception("队列为空！");
		}
		//默认第一个元素为优先级最高的。
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
