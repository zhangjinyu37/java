//˳��ջ
public class SequenceStack implements Stack {
    
	Object[] stack; //��������
	final int defaultSize =10; //Ĭ����󳤶�
	int top; //ջ��λ��
	int maxSize; //��󳤶�
	
    public SequenceStack()
    {
       init(defaultSize);	
    }
    
    public SequenceStack(int size)
    {
    	init(size);
    }
    
	public void init(int size)
	{
		this.maxSize = size;
		top =0;
		stack = new Object[size];
	}
    
	@Override
	public Object getTop() throws Exception {
		// TODO Auto-generated method stub
		if(isEmpty())
		{
			throw new Exception("��ջΪ�գ�");
		}
		
		
		return stack[top-1];
	}

	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return top==0;
	}

	@Override
	public Object pop() throws Exception {
		// TODO Auto-generated method stub
		if(isEmpty())
		{
			throw new Exception("��ջΪ�գ�");
		}
		top--;
		
		return stack[top];
	}

	@Override
	public void push(Object obj) throws Exception {
		// TODO Auto-generated method stub
		//�����ж�ջ�Ƿ�����
		if(top == maxSize)
		{
			throw new Exception("��ջ������");
		}
		stack[top]=obj;
		top++;
	}

	
}
