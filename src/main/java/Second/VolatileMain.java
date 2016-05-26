package Second;

public class VolatileMain {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		MRunnable mr1 = new MRunnable();
		MRunnable mr2 = new MRunnable();
		MRunnable mr3 = new MRunnable();
		
		Thread t1 = new Thread(mr1);
		Thread t2 = new Thread(mr2);
		Thread t3 = new Thread(mr3);
		

	     t1.start();
	     t2.start();
	     t3.start();
	     System.out.println("Done");
	}

}

class MSingleton implements Runnable
{

	private MSingleton _inst ;
	
	@Override
	public void run() {

		
		
		
	}
	
	

}

class MRunnable implements Runnable
{

	private volatile Integer count = 0;
	private volatile int primCount = 0;
	
	@Override
	public void run() {

		synchronized (count) {
			
		
		
		for(int i=0; i<5; i++)
		{
			count++;
		}
		System.out.println("Count:"+count);
		}
	}
	


}