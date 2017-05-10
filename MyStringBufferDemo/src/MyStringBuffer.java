//用户自定义的MyStringBuffer类
public class MyStringBuffer {
	private char[] value; //字符数组
	private int count; //字符串的长度
	
	//从源串指定下标开始拷贝指定长度的字符串到目标串指定为下标开始
	//char[] src:源串
	//int srcPos：源串的开始下标
	//char[] dst:目标串
	//int dstPos:目标串开始下标
	//int length：拷贝长度
	public static void arrayCopy(char[] src,int srcPos,char[] dst,int dstPos,int length)
	{   
		//如果源串起始下标+拷贝长度>源串长度或者目标串起始下标+拷贝长度>目标串长度
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
	   value=newValue; //让value指向新创建的newValue数组。
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
