import java.util.Arrays;
//快速排序算法
public class QuickSort {
	public static void quickSort(int arr[], int low, int high) 
	{
        if(low < high) 
        {
            //按照第一个数进行切分。左边放小于【0】的数，右边放大于[0]的数
           int mid = partition(arr, low, high);
            //对关键字左边的数据进行分区
           quickSort(arr, low, mid - 1);
            //对关键字右边的数据进行分区
           quickSort(arr, mid + 1, high);
        }
    }
	public static int partition(int array[], int low, int high) {
        // 设置两个变量i、j，排序开始的时候i：=0，j：=N-1；
        // 以第一个数组元素作为关键数据，赋值给pivotKey，即pivotKey：=array[0]；
        int pivotKey = array[low];
        int i= low, j = high;
        if(low < high) 
        {
           while (i < j) 
           {
               // 从J开始向前搜索，即由后开始向前搜索（J：=J-1），找到第一个小于X的值，两者交换；
               while (i < j && array[j] >= pivotKey) 
               {
                   j--;
               }
               if (i < j) 
               {
                   array[i] = array[j];
                   i++;
               }
               // 从I开始向后搜索，即由前开始向后搜索（I：=I+1），找到第一个大于X的值，两者交换；
               while (i < j && array[i] <= pivotKey) 
               {
                   i++;
               }
               if (i < j) 
               {
                   array[j] = array[i];
                   j--;
               }
            }
            array[i] = pivotKey;
            //打印每次分区后的结果
            System.out.println("每次排序:" + Arrays.toString(array));
            //将这个分区结束时的坐标i返回，用于下次执行时当做前分区的尾坐标，当做后分区的头坐标
        }
        return i;
    }
 	public static void main(String[] args)
	{
        int[] list={49,38,65,97,76,13,27,49};  
        System.out.println("排序前:" +Arrays.toString(list));
        quickSort(list, 0, list.length - 1);
        System.out.println("排序后:" + Arrays.toString(list));
	}
}
