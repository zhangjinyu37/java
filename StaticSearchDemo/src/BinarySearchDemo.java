import java.util.Arrays;

//���ֲ����㷨
public class BinarySearchDemo {

	/* arr:��ʾҪ���ҵ�����
	 * low:���ҵ��½�
	 * high:���ҵ��Ͻ�
	 * des:Ҫ���ҵ�Ԫ��
	 * */
	
	public static boolean binarySearch(int[] arr,int low,int high,int des)
	{
		int mid = (low+high)/2;
		
		if(low > high)
		{
			return false;
		}
		
		if(des==arr[mid])
		{
			return true;
		}
		else if(des<arr[mid])
		{
		   return binarySearch(arr,low,(mid-1),des);	
		}
		else
		{
		   return binarySearch(arr,(mid+1),high,des);
		}
		
	}
	
	
	public static void main(String[] args) {
	  
		int[] arr = {45,12,32,7,5,11,22,65,18,73,95,18};
		int des = 13;
		Arrays.sort(arr);
		
	    if(BinarySearchDemo.binarySearch(arr, 0, arr.length-1, des))
	    {
	    	System.out.println("���ҳɹ���");
	    }
	    else
	    {
	    	System.out.println("����ʧ�ܣ�");
	    }
	}

}
