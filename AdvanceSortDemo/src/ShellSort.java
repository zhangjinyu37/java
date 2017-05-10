/**
 * ϣ����������ѡ�񲽳�Ϊ��15,7,3,1 ����ѡ�񲽳���ʽΪ��2^k-1,2^(k-1)-1,����,15,7,3,1
 * (2^4-1,2^3-1,2^2-1,2^1-1) ע�����������Ǵ�С�����š�
 */
public class ShellSort {
 
    /**
     * �����㷨��ʵ�֣���������ָ����Ԫ�ؽ�������
     *
     * @param array
     *            �����������
     * @param from
     *            �����￪ʼ����
     * @param end
     *            �ŵ�����
     * @param c
     *            �Ƚ���
     */
    public void sort(Integer[] array, int from, int end) {
        // ��ʼ������ʵ��Ϊÿ�ֵķ�����
        int step = initialStep(end - from + 1);
 
        // ��һ��ѭ���Ƕ������ִν���ѭ����(step + 1) / 2 - 1 Ϊ��һ�ֲ���ֵ
        for (; step >= 1; step = (step + 1) / 2 - 1) {
            // ��ÿ�����ÿ���������ѭ��
            for (int groupIndex = 0; groupIndex < step; groupIndex++) {
 
                // ��ÿ�����ֱ�Ӳ�������
                insertSort(array, groupIndex, step, end);
            }
        }
    }
 
    /**
     * ֱ�Ӳ�������ʵ��
     *
     * @param array
     *            ����������
     * @param groupIndex
     *            ��ÿ�ֵ���һ���������
     * @param step
     *            ����
     * @param end
     *            ��������Ҫ���ĸ�Ԫ��ֹ
     * @param c
     *            �Ƚ���
     */
    public void insertSort(Integer[] array, int groupIndex, int step, int end) {
        int startIndex = groupIndex;// �����￪ʼ����
        int endIndex = startIndex;// �ŵ�����
        /*
         * �ŵ�������Ҫ����õ����ӿ�ʼ����Ԫ�ؿ�ʼ����step�������������Ԫ���Ƿ������鷶Χ�ڣ�
         * ��������鷶Χ�ڣ������ѭ����ֱ�������������鷶Χ
         */
        while ((endIndex + step) <= end) {
            endIndex += step;
        }
 
        // iΪÿС����ĵڶ���Ԫ�ؿ�ʼ
        for (int i = groupIndex + step; i <= end; i += step) {
            for (int j = groupIndex; j < i; j += step) {
                Integer insertedElem = array[i];
                // ��������������һ��Ԫ�ؿ�ʼ���ҵ�һ�����ڴ������Ԫ��
                if ((array[j].compareTo(insertedElem)) >= 0) {
                    // �ҵ������󣬴Ӳ���㿪ʼ�������Ԫ�غ���һλ
                    move(array, j, i - step, step);
                    array[j] = insertedElem;
                    break;
                }
            }
        }
    }
 
    /**
     * �������鳤�����ʼ����
     *
     * ����ѡ�񲽳��Ĺ�ʽΪ��2^k-1,2^(k-1)-1,...,15,7,3,1 ������2^k ��һ��Ϊ�ò������У�k Ϊ�����ִ�
     *
     * ��ʼ������step = 2^k-1 ��ʼ����Լ��������step < len - 1 ��ʼ������ֵҪС�����鳤�Ȼ�Ҫ��һ��ֵ����
     * Ϊ��һ�ַ���ʱ������Ҫ��Ϊһ�飬�������鱾��ĳ��Ⱦ�С�ڵ���4��
     *
     * ������������ϵ�Կ��Ե�֪��2^k - 1 < len - 1 ��ϵʽ������kΪ�ִΣ������ 2^k �� ��ʽ ת���� step ���ʽ����
     * 2^k-1 ��ʹ�� (step + 1)*2-1 �滻����Ϊ step+1 �൱�ڵ�k-1 �ֵĲ����������� step+1 �����ϳ��� 2
     * ���൱�� 2^k �ˣ��������������鳤�ȵĹ�ϵ����ʽΪ (step + 1)*2 - 1 < len -1
     *
     * @param len
     *            ���鳤��
     * @return
     */
    public static int initialStep(int len) {
        /*
         * ��ʼֵ����Ϊ������ʽ�е���С����������С�����Ƶ������ʼ����ֵ�����������¹�ʽ����:
         * 1,3,7,15,...,2^(k-1)-1,2^k-1
         * ������鳤��С�ڵ���4ʱ������Ϊ1��������С�ڵ���4�����鲻�÷��飬��ʱֱ���˻�Ϊֱ�Ӳ�������
         */
        int step = 1;
 
        // ��̽��һ�������Ƿ�������������������������򲽳���Ϊ��һ����
        while ((step + 1) * 2 - 1 < len - 1) {
            step = (step + 1) * 2 - 1;
        }
 
        System.out.println("��ʼ���� : " + step);
        return step;
    }
 
    /**
     * ��ָ���Ĳ���������Ԫ�غ��ƣ�����ָ��ÿ��Ԫ�ؼ�ļ��
     *
     * @param array
     *            ����������
     * @param startIndex
     *            �����￪ʼ��
     * @param endIndex
     *            ���ĸ�Ԫ��ֹ
     * @param step
     *            ����
     */
    protected final void move(Integer[] array, int startIndex, int endIndex,
            int step) {
        for (int i = endIndex; i >= startIndex; i -= step) {
            array[i + step] = array[i];
        }
    }
 
    /**
     * ����
     *
     * @param args
     */
    public static void main(String[] args) {
        Integer[] intgArr = { 65, 34, 25, 87, 12, 38, 56, 46, 14, 77, 92, 23 };
        ShellSort shellSort = new ShellSort();
        shellSort.sort(intgArr, 0, intgArr.length - 1);
        for (Integer intObj : intgArr) {
            System.out.print(intObj + " ");
        }
    }
}
