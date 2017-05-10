
//��Ʊ����
public class WindowQueue {
  
  //��Ʊ�Ķ���	
  int maxSize =10;
  CircleSequenceQueue queue = new CircleSequenceQueue(maxSize);
  int num=0; //ͳ����Ʊ��������һ�������100��Ʊ��
  boolean isAlive = true; //�ж��Ƿ������Ʊ��
  
  //�Ŷ���Ʊ
  public synchronized void producer() throws Exception
  {
	if(queue.count < maxSize)
	{
		queue.append(num++); //�ȴ���Ʊ��������1
		System.out.println("��"+num+"���ͻ��Ŷӵȴ���Ʊ��");
		this.notifyAll();//������Ʊ���߳�
	}
	else
	{
		try
		{
			System.out.println("��������...��ȴ���");
			this.wait();//������ʱ���Ŷ���Ʊ�̵߳ȴ���
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
		}
	}
  }
  
  //��Ʊ
  public synchronized void consumer() throws Exception
  {
	if(queue.count > 0)
	{
		Object obj = queue.delete();
		int temp = Integer.parseInt(obj.toString());
		System.out.println("��"+(temp+1)+"���ͻ���Ʊ�뿪���У�");
		//�����ǰ����Ϊ�գ���������Ʊ���������ڵ���100��˵����Ʊ����
		if(queue.isEmpty()&&this.num>=100)
		{
			this.isAlive = false;
		}
		this.notifyAll(); //�����Ŷ���Ʊ���̡߳�
	}
	else
	{
		try
		{
			System.out.println("�����ѿ�...��ȴ���");
			this.wait();//���п�ʱ����Ʊ�̵߳ȴ���
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
		}
	}
  }
}
