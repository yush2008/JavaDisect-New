package threadlivelock;

import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class LiveLockSolMain {

	public static void main(String[] args) {

		PCManager mg = new PCManager(new Object());
		
		/*Thread tC = new Thread(new CRunnable(mg));
		Thread tP = new Thread(new PRunnable(mg));
		tC.start();
		tP.start();*/
		
		Thread t1 = new Thread(new CRunnable(mg));
		t1.setName("one");
		Thread t2 = new Thread(new CRunnable(mg));
		t2.setName("two");
		Thread t3 = new Thread(new CRunnable(mg));
		t3.setName("three");
		Thread t4 = new Thread(new CRunnable(mg));
		t4.setName("four");
		t1.start();
		t2.start();
		t3.start();
		t4.start();
		
		
		Thread t5 = new Thread(new PRunnable(mg));
		t4.setName("Interrupter");
		t5.start();
	}

}

class Product {
	private int quantity;
	private boolean isTimeOut = false;
	private ReentrantLock lock = null;

	Product(ReentrantLock lock) {
		this.lock = lock;
		this.quantity = 0;
		this.isTimeOut = false;
	}

	public void produce() {
		lock.lock();
		try {
			this.quantity++;
			System.out.println("Produce:" + this.quantity);

			lock.notifyAll();
		} finally {
			lock.unlock();
		}
	}

	public void consumer() {
		lock.lock();
		try {
			while (isTimeOut == false && this.quantity < 1) {
				lock.wait();
			}
			if (this.quantity > 0) {
				this.quantity--;
				System.out.println("Consume:" + this.quantity);
			} else
				System.out.println("Producer has not produce any product yet.");

		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			lock.unlock();
		}
	}
}

class PCManager {

	private Object lock = new Object();
	private int count = 3;
	private boolean isInterupted = false;

	PCManager(Object lock) {
		this.lock = lock;
	}
	public void produce() {
		if (count == 1) {
			count++;
		}
	}

	public void interrupt() {
		synchronized (lock) {
			if (count <= 1) {
				isInterupted = true;
				System.out.println("Interrupting Thread"+Thread.currentThread().getName());
				Thread.currentThread();
				Thread.interrupted();
			}
		}
	}

	public void consume() {

		synchronized (lock) {

			nonSync1();
			
			if (count > 0){
				System.out.println("Thread:"+Thread.currentThread().getName() +"count:"+count--);
			} else{
				try {
					System.out.println("WAIT() Thread"+Thread.currentThread().getName());
					lock.wait();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
	}
	public synchronized void nonSync1(){
		
		System.out.println("Non Synchronised.");
		System.out.println("Non Synchronised.");
		System.out.println("Non Synchronised.");
	}
}

class PRunnable implements Runnable{
	private PCManager mg = null;
	PRunnable(PCManager mg ){
		this.mg = mg;
	}
	@Override
	public void run() {
		mg.interrupt();
		//mg.nonSync1();
	}
}
class CRunnable implements Runnable
{
    private PCManager mg = null;
	CRunnable(PCManager mg ){
		this.mg = mg;
	}
	@Override
	public void run() {
		mg.consume();
	}
}