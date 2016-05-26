package threadlivelock;

import java.util.concurrent.Callable;

public class TheadComm {

    /**
     * @param args
     * @throws InterruptedException
     */
    public static void main(String[] args) {

        ConnectionL con = new ConnectionL();
        Thread t1 = new Thread(new TheadGetConnection(con), "T-1");
        Thread t2 = new Thread(new TheadGetConnection(con), "T-2");
        Thread t3 = new Thread(new TheadGetConnection(con), "T-3");
        //new Thread(new TheadSetConnection(con),"T-S").start();

        t1.start();

        t2.start();
        t3.start();
        try {
            t1.wait();
            t1.join();
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }


        try {
            ClassLoader.getSystemClassLoader().loadClass("algos.ForNameTest");
            Class<ForNameTest> obj = (Class<ForNameTest>) Class.forName("algos.ForNameTest");


        } catch (ClassNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }


        Thread o1 = new Thread(new InteruptTest());
        Thread o2 = new Thread(new InteruptTest());
        Thread o3 = new Thread(new InteruptTest());
        Thread o4 = new Thread(new InteruptTest());

        o1.start();
        o2.start();
        o3.start();
        o4.start();


        Thread.interrupted();

        //System.exit(0);


        System.out.println("Hello");
        //ExecutorService es = new ScheduledThreadPoolExecutor(6);
    }

}


class ForNameTest {
    private int x = 10;

    ForNameTest(int x) {
        this.x = x;
    }
}


class InteruptTest implements Runnable {

    @Override
    public void run() {
        try {
            Thread.sleep(50000);
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }


}

class ConnectionL {

    int connection = 1;
    boolean isConnAvailable = true;
    Object lock = new Object();
    Object lock1 = new Object();

    public void doDBWork() {

        this.getConnection();

        //Perform DB Task

        this.setConnection();

    }


    public void getConnection() {
        synchronized (lock) {
            while (!isConnAvailable) {
                try {
                    lock.wait();
                } catch (InterruptedException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }

            if (connection > 1)
                System.out.println(Thread.currentThread() + "Get: conn:" + connection--);
            else {
                if (connection == 1)
                    System.out.println(Thread.currentThread() + "Get: conn:" + connection--);
                isConnAvailable = false;
            }

        }
    }

    public void setConnection() {
        synchronized (lock) {

            if (!isConnAvailable) {
                if (connection < 3)
                    System.out.println(Thread.currentThread() + "Set: conn:" + ++connection);

                isConnAvailable = true;
                lock.notify();
            }

        }
    }


    public void suspenResumeCheck() {

        synchronized (lock) {

            Thread.currentThread().destroy();
            Thread.currentThread().suspend();
            Thread.currentThread().resume();

        }

    }

}

class TheadGetConnection implements Runnable {
    ConnectionL connection = null;// new ConnectionL();

    TheadGetConnection(ConnectionL connection) {
        this.connection = connection;
    }

    @Override
    public void run() {
        //for(int i=0; i<10 ; i++)
        {
            connection.doDBWork();
            //connection.suspenResumeCheck();
        }

    }

}


class TheadCalable implements Callable<Boolean> {
    ConnectionL connection = new ConnectionL();

    TheadCalable(ConnectionL connection) {
        this.connection = connection;
    }

    @Override
    public Boolean call() throws Exception {
        // TODO Auto-generated method stub
        return true;
    }


}



class TheadSetConnection implements Runnable
{
ConnectionL connection = new ConnectionL();
	
   TheadSetConnection (ConnectionL connection)
	{
		this.connection = connection;
	}
	
	@Override
	public void run() {
	for(int i=0; i<3 ; i++)
		{
			connection.setConnection();	
		}
		
	}
	
}

interface InterState {

    void show();

}

