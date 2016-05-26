package threadlivelock;

import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class ExecutorServiceMain {

	/**
	 * @param args
	 * @throws InterruptedException 
	 */
	public static void main(String[] args) throws InterruptedException {

		/*Object lock = new Object();
        MyObj obj = new MyObj(lock);
        Thread a = new Thread(new RunableA(obj));
        a.start();
        Thread b = new Thread(new RunableB(obj));
		b.start();*/
		
		ExecutorService executor = Executors.newScheduledThreadPool(3);
		
		
		CountDownLatch latch = new CountDownLatch(3);
		MCountDwnLatch mc = new MCountDwnLatch(latch);
		mc.name = "mc";
		MCountDwnLatch mc1 = new MCountDwnLatch(latch);
        mc1.name = "mc1";
		MCountDwnLatch mc2 = new MCountDwnLatch(latch);
        mc2.name = "mc2";

		MCountDwnLatch mc3 = new MCountDwnLatch(latch);
        mc3.name = "mc3";
		
		Thread t = null;
		
		//for(int i=0; i<3; i++)
		{
			//t = new Thread(mc);
			//t.start();
			//executor.execute(mc);
			executor.submit(mc);
			executor.submit(mc1);
			executor.submit(mc2);
			//executor.shutdown();
		}
	//	executor.shutdown();
		//executor.submit(mc3);
		//List<Runnable> waitlist  = executor.shutdownNow();
		//executor.awaitTermination(5000,TimeUnit.MILLISECONDS);
		try {
			latch.await();
			System.out.println("Await finished for Latch");
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
}
class MyObj
 {

	Object lock;
	MyObj(Object lock)
	{
		this.lock = lock;
	}
	
	public void read() {

		synchronized (lock) {
			System.out.println("1");
			System.out.println("2");
			System.out.println("3");

		}

	}

	public void write() {

		synchronized (lock) {
			System.out.println("1");
			System.out.println("2");
			System.out.println("3");

		}

	}

}
class RunableA implements Runnable
{
	private MyObj obj ;
	
	RunableA(MyObj obj)
	{
		this.obj = obj;
	}
	
	@Override
	public void run() {
		obj.read();
	}
	
}

class RunableB implements Runnable
{
	private MyObj obj ;
	
	RunableB(MyObj obj)
	{
		this.obj = obj;
	}
	
	@Override
	public void run() {
		obj.write();
	}
	
}