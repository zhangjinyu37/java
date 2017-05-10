//�û��Զ����MySet��
public class MySet {

	private MyVector value = new MyVector();
	
	//��Ӷ���
	public void add(Object obj)throws Exception
	{
		//��������ӿն���
		if(obj==null)
		{
			return ;
		}
		//����Set�಻��������ظ���Ԫ�أ������Ȳ��Ҹö����Ƿ��Ѿ����ڡ�
		if(value.indexOf(obj)<0)
		{
			value.add(obj);
		}
		else
		{
			return;
		}
	}
	
	//ɾ������
	public void remove(Object obj)throws Exception
	{
		value.remove(obj);
	}
	
	//�Ƿ����һ������
	public boolean contain(Object obj)throws Exception
	{
		return value.contain(obj);
	}
	
	public int size()
	{
		return value.size();
	}
	
	public Object get(int index)throws Exception
	{
		return value.get(index);
	}
	
	//�Ƿ������һ�����϶���.
    public boolean include(Object obj)throws Exception
    {
    	if( obj instanceof MySet)
    	{
    		MySet set = (MySet)obj;
    		int count=0;
    		while(count<set.size())
    		{
    			Object temp = set.get(count);
    			count++;
    			if(!contain(temp))
    				return false;
    		}
    		return true;
    	}
    	else
    	{
    		return false;
    	}
    }
    
    //�ж����������Ƿ����
    public boolean equals(Object obj) 
    {
    	if(obj instanceof MySet)
    	{
    	   MySet set = (MySet)obj;
    	   try
    	   {
	    	   if(include(set)&&set.include(this))
	    	   {
	    		   return true;
	    	   }
	    	   else
	    		   return false;
    	   }
    	   catch(Exception ex)
    	   {
    		   ex.printStackTrace();
    		   return false;
    	   }
    	}
    	else
    	{
    		return false;
    	}
    }
   
    //�жϼ����Ƿ�Ϊ��
    public boolean isEmpty()
    {
    	return value.size()>0;
    }
	
    
    
}
