
public class Test {

	/**
	 * @param args
	 */
	public static void main(String[] args)throws Exception {
		// TODO Auto-generated method stub
		/*
		CircleSequenceQueue queue = new CircleSequenceQueue();
		queue.append("a");
		queue.append("b");
		queue.append("c");
		queue.append("d");
		queue.append("e");
		queue.append("f");
		
		queue.delete();
		queue.delete();
		
		queue.append("g");
		
		
		while(!queue.isEmpty())
		{
			System.out.println(queue.delete());
		}*/
		
		WindowQueue queue = new WindowQueue();
		
		Producer p = new Producer(queue);//ע��һ��Ҫ��ͬһ�����ڶ���
		Consumer c = new Consumer(queue);
		
		//�Ŷ���Ʊ�߳�
		Thread pThread = new Thread(p);
		//��Ʊ�߳�
		Thread cThread = new Thread(c);
		
		pThread.start(); //��ʼ�Ŷ���Ʊ
		cThread.start();  //��ʼ��Ʊ
	}

}
