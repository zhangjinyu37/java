//Hash�㷨

public class MyHashTable {
    //��ϣ������
	private HashItem[] hashtable;
	//��ϣ��ĳ���
	private int hashTableSize;
	//��ǰԪ�صĸ���
	private int currentSize;
	
	
	public MyHashTable(int len)
	{
		hashtable = new HashItem[len];
		this.hashTableSize = len;
		this.currentSize = 0;
	}
	
	
	//�����㷨
	public int find(int x)
	{
		int i= x % hashTableSize;
		int j=i;
		
		if(this.hashtable[j]==null)
		{
		   this.hashtable[j]=new HashItem(0);	
		}
		//�����λ����Ԫ�أ����Ҳ�����x
		while(this.hashtable[j].getInfo()==1&&this.hashtable[j].getData()!=x)
		{
			j = (j+1)%hashTableSize;
			
			//˵��hash������
			if(j==i)
			{
			  	return -hashTableSize;
			}
		}
		//˵��Ԫ�ش���
		if(this.hashtable[j].getInfo()==1)
		{
		   return j;	
		}
		else //˵���ҵ�Ԫ�ز���
		{
		   return -j;
		}
	}
	
	//�ж�Ԫ���Ƿ��ڹ�ϣ���д���
	public boolean isIn(int x)
	{
	   int i = find(x);
	   
	   if(i>=0)
	   {
		   return true;
	   }
	   else
	   {
		   return false;	   
       }
	}
	
	//�����㷨
	public boolean insert(int x) throws Exception
	{
	 	int i=find(x);
	    
	 	if(i>=0)
	    {
	       System.out.println("��Ԫ���Ѵ��ڣ�");
	 	   return false;	
	    }
	 	else
	 	{
	 	   if(i!=-hashTableSize)
	 	   {
	 		   this.hashtable[-i]=new HashItem(1,x);
	 		   this.currentSize++;
	 		   return true;
	 	   }
	 	   else
	 	   {
	 		   throw new Exception("��ϣ���������޷����룡");
	 	   }
	 	}
	}
	
	//ɾ���㷨
	public boolean delete(int x)
	{
		int i = find(x);
		if(i>=0)
		{
			this.hashtable[i].setInfo(0);
			this.currentSize--;
		    return true;
		}
		else
		{
			System.out.println("Ҫɾ����Ԫ�ز����ڣ�");
			return false;
		}
	}
	
	//��ȡָ��λ�õ�Ԫ��ֵ
	public int getValue(int index)
	{
		return this.hashtable[index].getData();
	}
}
