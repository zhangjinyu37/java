
public class BubbleSort {
    
	//ð�������㷨��ͨ��flag�����ж������Ƿ���ǰ������
	public static void BubbleSort(int arr[])
	{
		int n = arr.length;
		int i,j,temp,flag;
		flag = 1;//flag:1��ʾ����û�н�����0��ʾ�����Ѿ�����
		for(i=1;i<n&&flag==1;i++)
		{
		  for(j=0;j<n-i;j++)
		  {
			  flag = 0;//����Ժ��ѭ�����ı�flag��ֵ��˵��û�з�������Ԫ�صĽ���
			  //Ҳ����˵����������Ѿ��ź����ˡ����оͿ�����ǰ�˳�ѭ����
			  if(arr[j]>arr[j+1])
			  {
				  flag = 1;
				  temp = arr[j];
				  arr[j]=arr[j+1];
				  arr[j+1]=temp;
			  }
			  
		  }
		}
		
	}
	
   public static void main(String[] args)
   {
	   int arr[]={34,67,32,19,8,20,17,44,67,80,42,57,38};
	   BubbleSort.BubbleSort(arr);
	   System.out.println("-----������------");
	   for(int i=0;i<arr.length;i++)
	   {
		   System.out.print(arr[i]+" ");
	   }
	   
   }

}
