
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
		
		Producer p = new Producer(queue);//注意一定要传同一个窗口对象
		Consumer c = new Consumer(queue);
		
		//排队买票线程
		Thread pThread = new Thread(p);
		//卖票线程
		Thread cThread = new Thread(c);
		
		pThread.start(); //开始排队买票
		cThread.start();  //开始卖票
	}

}
