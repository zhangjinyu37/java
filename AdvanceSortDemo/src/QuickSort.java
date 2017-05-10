import java.util.Arrays;
//���������㷨
public class QuickSort {
	public static void quickSort(int arr[], int low, int high) 
	{
        if(low < high) 
        {
            //���յ�һ���������з֡���߷�С�ڡ�0���������ұ߷Ŵ���[0]����
           int mid = partition(arr, low, high);
            //�Թؼ�����ߵ����ݽ��з���
           quickSort(arr, low, mid - 1);
            //�Թؼ����ұߵ����ݽ��з���
           quickSort(arr, mid + 1, high);
        }
    }
	public static int partition(int array[], int low, int high) {
        // ������������i��j������ʼ��ʱ��i��=0��j��=N-1��
        // �Ե�һ������Ԫ����Ϊ�ؼ����ݣ���ֵ��pivotKey����pivotKey��=array[0]��
        int pivotKey = array[low];
        int i= low, j = high;
        if(low < high) 
        {
           while (i < j) 
           {
               // ��J��ʼ��ǰ���������ɺ�ʼ��ǰ������J��=J-1�����ҵ���һ��С��X��ֵ�����߽�����
               while (i < j && array[j] >= pivotKey) 
               {
                   j--;
               }
               if (i < j) 
               {
                   array[i] = array[j];
                   i++;
               }
               // ��I��ʼ�������������ǰ��ʼ���������I��=I+1�����ҵ���һ������X��ֵ�����߽�����
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
            //��ӡÿ�η�����Ľ��
            System.out.println("ÿ������:" + Arrays.toString(array));
            //�������������ʱ������i���أ������´�ִ��ʱ����ǰ������β���꣬�����������ͷ����
        }
        return i;
    }
 	public static void main(String[] args)
	{
        int[] list={49,38,65,97,76,13,27,49};  
        System.out.println("����ǰ:" +Arrays.toString(list));
        quickSort(list, 0, list.length - 1);
        System.out.println("�����:" + Arrays.toString(list));
	}
}
