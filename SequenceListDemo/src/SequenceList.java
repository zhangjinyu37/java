
public class SequenceList implements List{
    
	//Ĭ�ϵ�˳������󳤶�
	final int defaultSize =10;
	//��󳤶�
	int maxSize;
	//��ǰ����
	int size;
	//��������
	Object[] listArray;
	
	
	public SequenceList()
	{
		init(defaultSize);
	}
	
	public SequenceList(int size)
	{
		init(size);
	}
	
	//˳���ĳ�ʼ������
	private void init(int size)
	{
		maxSize = size;
		this.size = 0;
		listArray = new Object[size];
	}
	
	@Override
	public void delete(int index) throws Exception {
		// TODO Auto-generated method stub
		if(isEmpty())
		{
			throw new Exception("˳���Ϊ�գ��޷�ɾ����");
		}
		if(index<0||index>size-1)
		{
			throw new Exception("��������");
		}
		//�ƶ�Ԫ��
		for(int j=index;j<size-1;j++)
		{
			listArray[j]=listArray[j+1];
		}
		size--;
	}

	@Override
	public Object get(int index) throws Exception {
		// TODO Auto-generated method stub
		if(index<0||index>=size)
		{
			throw new Exception("��������");
		}
		return listArray[index];
	}

	@Override
	public void insert(int index, Object obj) throws Exception {
		// TODO Auto-generated method stub
		//���Ա�����
		if(size==maxSize)
		{
			throw new Exception("˳����������޷����룡");
		}
		//����λ�ñ���Ƿ�Ϸ�
		if(index<0||index>size)
		{
		   throw new Exception("��������");
		}
		//�ƶ�Ԫ��
		for(int j=size;j>index;j--)
		{
			listArray[j]=listArray[j-1];
		}
		
		listArray[index]=obj;
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
		return size;
	}

}
