
public class GcbNumber {
    
	//�����Լ���ĵݹ��㷨��
	public static int gcb(int bigNum,int smallNum)
	{
		if(bigNum<0||smallNum<0)
		{
			return -1; //��ʾû���ҵ����Լ����
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
			 System.out.println(bigNum+"��"+smallNum+"�����Լ���ǣ�"+result);
		 }
		
	}
}
