//哈夫曼编码类
public class Code {

	int[] bit;  //编码数组
	int start;  //编码的开始下标
	int weight; //权值
	
	Code(int n)
	{
		bit = new int[n];
		start = n-1;
	}
}
