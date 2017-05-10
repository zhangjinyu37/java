//�û��Զ����MyStringBuffer��
public class MyStringBuffer {
	private char[] value; //�ַ�����
	private int count; //�ַ����ĳ���
	
	//��Դ��ָ���±꿪ʼ����ָ�����ȵ��ַ�����Ŀ�괮ָ��Ϊ�±꿪ʼ
	//char[] src:Դ��
	//int srcPos��Դ���Ŀ�ʼ�±�
	//char[] dst:Ŀ�괮
	//int dstPos:Ŀ�괮��ʼ�±�
	//int length����������
	public static void arrayCopy(char[] src,int srcPos,char[] dst,int dstPos,int length)
	{   
		//���Դ����ʼ�±�+��������>Դ�����Ȼ���Ŀ�괮��ʼ�±�+��������>Ŀ�괮����
		if(srcPos+length>src.length||dstPos+length>dst.length)
		{
			throw new StringIndexOutOfBoundsException(length);
		}
		for(int i=0;i<length;i++)
		{
			dst[dstPos++]=src[srcPos++];
		}
	}
	
	private void expandCapacity(int newCapacity)
	{
	   char newValue[] = new char[newCapacity];
	   arrayCopy(value,0,newValue,0,count);
	   value=newValue; //��valueָ���´�����newValue���顣
	   //count=newCapacity;
	}
	
    public MyStringBuffer(String str)
    {
    	char[] chararray = str.toCharArray();
    	value=chararray;
    	count=chararray.length;
    }
    
    public MyStringBuffer concat(MyStringBuffer str)
    {
    	int otherLen = str.length();
    	if(otherLen==0)
    	{
    		return this;
    	}
    	this.expandCapacity(count+otherLen);
    	System.out.println("src.lenght="+str.length());
    	System.out.println("des.lenght="+this.length());
    	arrayCopy(str.toCharArray(),0,this.toCharArray(),this.length(),str.length());
        count+=otherLen;
        return this;
    }
    
    public int length()
    {
    	return count;
    }
    
    @Override
	public String toString() {
		// TODO Auto-generated method stub
		String str="";
		for(int i=0;i<count;i++)
		{
			str+=value[i];
		}
		return str;
	}
    
    public char[] toCharArray()
	{
	   
	   return value;
	}
	
}
