//��̬��������
public class DynamicArray {
    
	final static int defaultSize=10;
	Object[] arr; //��������
	int maxSize; //�������󳤶�
	
	//Ĭ�ϵĹ��췽��
	public DynamicArray()
	{
	   init(defaultSize);	
	}
	
	//ָ���������鳤�ȵĹ��췽��
	public DynamicArray(int size)throws Exception
	{
		if(size<=0)
		{
			throw new Exception("���鳤�Ȳ����쳣��");
		}
		init(size);
	}
	
	//�������ж������飬�������������µĶ�������
	public DynamicArray(DynamicArray a)
	{
	   arr = new Object[a.maxSize];
	   for(int i=0;i<a.maxSize;i++)
	   {
		   arr[i]=a.arr[i];
	   }
	   maxSize = a.maxSize;
	}
	
	
    public void init(int size)
    {
       arr = new Object[size];
       maxSize = size;
    }
    
    //������������Ĵ�С
	public void reSize(int size)throws Exception
	{
		//��������Ĵ�С<=0,�Ƿ���
		if(size<=0)
		{
			throw new Exception("���鳤�Ȳ����쳣��");
		}
		//��������Ĵ�С��ԭ����ͬ����û��Ҫ������ֱ�ӷ��ء�
		if(size==maxSize)
			return ;
		//����һ���µĶ�������
		Object[] newArray = new Object[size];
		//�ж��µ����Ĵ�С����ԭ���󣬻��Ǳ�ԭ��С
		int n=(size > maxSize)? maxSize:size;
		
		for(int i=0;i<n;i++)
		{
		   newArray[i]=arr[i];	
		}
		arr = newArray;
		maxSize = size;
	}
}
