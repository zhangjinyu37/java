
public class GcbNumber {
    
	//求最大公约数的递归算法。
	public static int gcb(int bigNum,int smallNum)
	{
		if(bigNum<0||smallNum<0)
		{
			return -1; //表示没有找到最大公约数。
		}
		if(smallNum==0)
		{
			return bigNum;
		}
		if(bigNum < smallNum)
		{
			return gcb(smallNum,bigNum);
		}
		else
		{
		   return gcb(smallNum,bigNum%smallNum);	
		}
	}
	
	
	public static void main(String[] args)
	{
		 int smallNum = 30;
		 int bigNum = 25;
		 int result = GcbNumber.gcb(bigNum, smallNum);
		 if(result!=-1)
		 {
			 System.out.println(bigNum+"和"+smallNum+"的最大公约数是："+result);
		 }
		
	}
}
