import java.util.Vector;


public class MyLotto {

	
	public static void main(String[] args) {
		
		Vector<Integer> v = new Vector<Integer>();
		
		//��ʼ���������
		for(int i=1;i<=33;i++)
		{
			v.add(i);
		}
		
		//���������������
		for(int i=0;i<6;i++)
		{
			int len = v.size();
			int random = (int)(Math.random()*100)%len; 
			System.out.println("��"+(i+1)+"����������ǣ�"+v.get(random));
		    v.remove(random);//ɾ��Ԫ��
		}
		
		//�����ȡ����
		int num = (int)(Math.random()*100)%16;
		System.out.println("��������ǣ�"+(num+1));
		
		
	}

}
