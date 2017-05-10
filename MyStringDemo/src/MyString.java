//�û��Զ����MyString��
public class MyString {

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
	
	//���췽��1������һ�����ַ���
	public MyString()
	{
		value=new char[0];
		count=0;
	}
	//���췽��2��ʵ�ִ�һ���ַ���������ȡ���µ��ַ�����
	//char[] value:���е��ַ����顣
	//int offset����ʼ�±�
	//int count�������ĸ���
	public MyString(char[] value,int offset,int count)
	{
		//�ж���ʼλ���Ƿ�<0
		if(offset<0)
		{
		   throw new StringIndexOutOfBoundsException(offset);  	
		}
		//�ж�count�Ƿ�<0
		if(count<0)
		{
		   throw new StringIndexOutOfBoundsException(count);
		}
		//�ж���ʼλ��+count�Ƿ����value�ַ����ĳ���
		
		if(offset+count>value.length)
		{
		   throw new StringIndexOutOfBoundsException(offset+count);
		}
		this.value = new char[count];
		this.count = count;
		arrayCopy(value,offset,this.value,0,count);
		
	}
	
	//���췽��3���������е��ַ����飬�����µ��ַ���
	public MyString(char[] value)
	{
		this.count = value.length;
		this.value = new char[count];
		arrayCopy(value,0,this.value,0,count);
	}
	
	//���췽��4��ʹ��JDK�����String�࣬�����µ��ַ���
	public MyString(String str)
	{
	  char[] chararray = str.toCharArray();
	  value = chararray;
	  count = chararray.length;
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
	
	public int length()
	{
		return count;
	}
	
	
	public char charAt(int index)
	{
	   if(index<0||index>=count)
	   {
		   throw new StringIndexOutOfBoundsException(index); 
	   }
	   return value[index];
	}
	
	//�Ƚ������ַ����Ĵ�С
	//�����ǰ�ַ������ڱȽ��ַ���������һ��������
	//�����ǰ�ַ������ڱȽ��ַ���������0
	//�����ǰ�ַ���С�ڱȽ��ַ��������ظ�����
	
	public int compareTo(MyString anotherStr)
	{
		int len1= this.count;
		int len2 = anotherStr.length();
		int n = Math.min(len1, len2);
		char[] v1 = value;
		char[] v2 = anotherStr.value;
	    int i=0;
	    while(i<n)
	    {
	      char c1 =v1[i];
	      char c2 =v2[i];
	      if(c1!=c2)
	      {
	    	  return c1-c2;
	      }
	      i++;
	    }
	    
	    return len1-len2;
	}
	
	//���Ӵ�1,������ʼ�±�
	public MyString substring(int beginIndex,int endIndex)
	{
		if(beginIndex<0)
		{
		   throw new StringIndexOutOfBoundsException(beginIndex);	
		}
		if(endIndex>count)
		{
		   throw new StringIndexOutOfBoundsException(endIndex);
		}
		if(beginIndex>endIndex)
		{
		   throw new StringIndexOutOfBoundsException(endIndex-beginIndex);
		}
		
		return (beginIndex==0&&endIndex==count)?this:new MyString(value,beginIndex,endIndex-beginIndex);
		
	}
	
	//���Ӵ�2��������ʼ�±꣬���ַ���ĩβ
	public MyString substring(int beginIndex)
	{
	    return substring(beginIndex,count);	
	}
	
	public char[] toCharArray()
	{
	   char[] buff = new char[count];
	   arrayCopy(value,0,buff,0,count);
	   return buff;
	}
	
	//�ַ���������
	public MyString concat(MyString str)
	{
	   int otherLen = str.length();
	   char[] strarray = str.toCharArray();
	   if(otherLen==0)
	   {
		  return this;   
	   }
	   char[] buff = new char[count+otherLen];
	   arrayCopy(value,0,buff,0,count);
	   arrayCopy(strarray,0,buff,count,otherLen);
	   return new MyString(buff);
	}
	
	//�����Ӵ�
	public MyString insert(MyString str,int pos)
	{
		if(pos<0||pos>count)
		{
		   throw new StringIndexOutOfBoundsException(pos);	
		}
		if(pos!=0)
		{
		  //��ò����֮ǰ���Ӵ� 
		  MyString str1 =this.substring(0, pos);
		  //��ò����֮����Ӵ�
		  MyString str2 = this.substring(pos);
		  MyString res1 = str1.concat(str);
		  MyString res2 = res1.concat(str2);
		  return res2;
		}
		else
		{
		  return str.concat(this);	
		}
	}
	
	//ɾ���Ӵ�
	public MyString delete(int beginIndex,int endIndex)
	{
		if(beginIndex<0)
		{
		    throw new StringIndexOutOfBoundsException(beginIndex);	
		}
		if(endIndex>count)
		{
			throw new StringIndexOutOfBoundsException(endIndex);
		}
		if(beginIndex>endIndex)
		{
			throw new StringIndexOutOfBoundsException(endIndex-beginIndex);
		}
		//ɾ�������ַ���
		if(beginIndex==0&&endIndex==count)
		{
			return new MyString();
		}
		else
		{
			//���ɾ����ǰ���Ӵ�
			MyString str1 = this.substring(0,beginIndex);
			//���ɾ���Ӵ�����Ӵ�
			MyString str2 = this.substring(endIndex);
			return str1.concat(str2);
		}
		
	}
}
