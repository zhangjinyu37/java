//用户自定义的Vector类
public class MyVector implements Collection{
    
	private Object[] data; //集合对象数组
	private int count;  //集合大小
	private final static int defaultSize=10;
	
	public MyVector()
	{
	   init(defaultSize);	
		
	}
	
	public MyVector(int size)
	{
		init(size);
	}
	
	public void init(int size)
	{
		data = new Object[size];
		count=0;
	}
	
	//动态扩充内存
	private void ensureCapacity(int minCapacity)
	{
		int oldCapacity = data.length;
		if(minCapacity>oldCapacity)
		{
			Object[] oldData = data;
			int newCapacity = oldCapacity*2;
			if(newCapacity<minCapacity)
			{
				newCapacity = minCapacity;
			}
			data = new Object[newCapacity];
			System.arraycopy(oldData, 0, data, 0, count);
		}
	}
	
	
	@Override
	public void add(int index, Object element) throws Exception {
		// TODO Auto-generated method stub
		if(index>=count+1)
		{
			throw new ArrayIndexOutOfBoundsException(index);
		}
		ensureCapacity(count+1);
		System.arraycopy(data, index, data, index+1, count-index);
		data[index]=element;
		count++;
	}

	@Override
	public void add(Object element) throws Exception {
		// TODO Auto-generated method stub
		add(count);
	}

	@Override
	public boolean contain(Object element) throws Exception {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Object get(int index) throws Exception {
		// TODO Auto-generated method stub
		if(index>=count||index<0)
		{
		  throw new ArrayIndexOutOfBoundsException(index);
		}
		return data[index];
	}

	@Override
	public void remove(int index) throws Exception {
		// TODO Auto-generated method stub
		if(index>=count||index<0)
		{
		  throw new ArrayIndexOutOfBoundsException(index);
		}
		int j=count-index-1;
		if(j>0)
		{
			System.arraycopy(data, index+1, data, index, j);
		}
		count--;
		data[count]=null;
	}

	private int indexOf(Object element)
	{
		if(element==null)
		{
			for(int i=0;i<count;i++)
			{
				if(data[i]==null)
					return i;
			}
		}
		else
		{
			for(int i=0;i<count;i++)
			{
				if(data[i].equals(element))
					return i;
			}
		}
		return -1;
	}
	
	@Override
	public void remove(Object element) throws Exception {
		// TODO Auto-generated method stub
		int index = indexOf(element);
		if(index>=0)
		{
			remove(index);
		}
	}

	@Override
	public void set(int index, Object element) throws Exception {
		// TODO Auto-generated method stub
		if(index>=count||index<0)
		{
		  throw new ArrayIndexOutOfBoundsException(index);
		}
		data[index]=element;
	}

	@Override
	public int size() {
		// TODO Auto-generated method stub
		return count;
	}

	
}
