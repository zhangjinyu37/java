//KMP�㷨
public class KMP {

	//���ݸ�����ģʽ������next[j]���㷨
	public static int[] getNext(String sub)
	{
		int j=1,k=0;
		int[] next = new int[sub.length()];
		next[0]=-1;
		next[1]=0;
		
		while(j<sub.length()-1)
		{
			if(sub.charAt(j)==sub.charAt(k))
			{
				next[j+1]=k+1;
				j++;
				k++;
			}
			else if(k==0)
			{
				next[j+1]=0;
				j++;
			}
			else
			{
				k=next[k];
			}
		}
		return next;
	}
	
	//���ݸ����������Ӵ�������KMP�㷨
	public static int kmp(String src,String sub)
	{
		//������ģʽ��sub��next[j]
		int[] next = getNext(sub);
		
		//i:�������α�
		//j:�Ӵ����α�
		int i=0,j=0,index=-1;
		while(i<src.length()&&j<sub.length())
		{
			if(src.charAt(i)==sub.charAt(j))
			{
				i++;
				j++;
			}
			else if(j==0)
			{
				i++;
			}
			else
			{
				j=next[j]; //���һ���
			}
				
		}
		if(j==sub.length())
		{
			index = i-sub.length();
		}
		return index;
	}
}
