package threadlivelock;

import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

/**
 * Created with IntelliJ IDEA.
 * User: pratyush
 * Date: 2/11/13
 * Time: 10:41 PM
 * To change this template use File | Settings | File Templates.
 */
public class CustomConnectionPool {

    public static void main(String[] args) {
        TickectPool tp = new TickectPool(3);

        for (int i = 0; i < 10; i++) {
            new Thread(new PoolManager(tp), "T" + i).start();
        }

    }

}


class PoolManager implements Runnable {
    public TickectPool pool;

    PoolManager(TickectPool tp) {
        this.pool = tp;
    }

    @Override
    public void run() {
        pool.getConnection();

        try {
            Thread.sleep(300);
        } catch (InterruptedException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        }

        pool.releaseConnection();
    }
}


class TickectPool {

    public final int initialPoolSize;
    public int poolSize;
    public boolean isAvailable;
    public Set<String> threadName = new LinkedHashSet<String>();
    public Queue<String> queue = new LinkedList<String>();


    TickectPool(int poolSize) {

        if (poolSize > 0)
            this.isAvailable = true;
        this.poolSize = poolSize;
        this.initialPoolSize = poolSize;

    }


    public void releaseConnection() {
        synchronized (this) {
            if(threadName.contains(Thread.currentThread().getName())){
                System.out.println("Thread: "+Thread.currentThread().getName()+" Releasing. Poolsize: "+ ++poolSize);
                threadName.remove(Thread.currentThread().getName());
                this.notifyAll();
                isAvailable = true;
            }
        }
    }

    public void getConnection() {
        boolean isBlockRelease = false;
        synchronized (this) {

            //Add each thread to a Set
            String threadName = Thread.currentThread().getName();
            this.threadName.add(threadName);
            if (!queue.contains(threadName))
                queue.offer(threadName);

            while (!isAvailable) {
                try {
                    System.out.println("Thread waiting: " + threadName + " PoolSize: " + poolSize);
                    this.wait();
                    isBlockRelease = true;

                    while (!threadName.equals(queue.peek())) {
                        try {
                            this.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
                        }
                    }

                } catch (InterruptedException e) {
                    e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
                }

            }

            if (poolSize < 2)
                isAvailable = false;

            System.out.println("Thread: " + threadName + "  acquired one connection. PoolSize: " + --poolSize);

            queue.remove(threadName);

        }

    }


}