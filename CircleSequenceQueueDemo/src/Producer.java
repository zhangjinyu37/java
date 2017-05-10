
//ÂòÆ±Õß
public class Producer implements Runnable {
   
	WindowQueue queue ;
	public Producer(WindowQueue queue)
	{
		this.queue = queue;
	}
	@Override
	public void run() {
		// TODO Auto-generated method stub
		while(queue.num<100)
		{
			try
			{
			   queue.producer();
			}
			catch(Exception ex)
			{
				ex.printStackTrace();
			}
		}
	}
	
}
