
//�������㷨
public class HeapSort {
	
	  public static void createHeap(int[] a, int n, int h) 
	  {
		int i, j, flag;
		int temp;

		i = h; // iΪҪ���ѵĶ�����������±�
		j = 2 * i + 1; // jΪi�������ӽ����±�
		temp = a[i];
		flag = 0;

		// �����Һ�����ֵ�ϴ����ظ�����ɸѡ
		while (j < n && flag != 1) {
			// Ѱ�����Һ��ӽ���еĽϴ���,jΪ���±�
			if (j < n - 1 && a[j] < a[j + 1])
				j++;

			if (temp > a[j]) // a[i]>a[j]
				flag = 1; // ��ǽ���ɸѡ����
			else { // �����a[j]����
				a[i] = a[j];
				i = j;
				j = 2 * i + 1;
			}
		}
		a[i] = temp; // �������a[i]��������a[j]
	}

	public static void initCreateHeap(int[] a) {
		int n = a.length;
		for (int i = (n - 1) / 2; i >= 0; i--)
			createHeap(a, n, i);
	}

	public static void heapSort(int[] a) {
		int temp;
		int n = a.length;

		initCreateHeap(a); // ��ʼ����������

		for (int i = n - 1; i > 0; i--) { // ��ǰ���Ѹ���ÿ�εݼ�1
			// �ѶѶ�a[0]Ԫ�غ͵�ǰ���ѵ����һ��Ԫ�ؽ���
			temp = a[0];
			a[0] = a[i];
			a[i] = temp;
			createHeap(a, i, 0); // �����������������
		}
	}

	public static void main(String[] args) {
		int[] test = { 10, 50, 32, 5, 76, 9, 40, 88 };
		int n = test.length;
		heapSort(test);
		for (int i = 0; i < n; i++)
			System.out.print(test[i] + "  ");
	}
}