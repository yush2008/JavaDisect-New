package threadlivelock;

import java.util.LinkedList;
import java.util.Queue;

public class ProducerConsumer {

    /**
     * @param args
     */
    public static void main(String[] args) {

        QueueManager mgr = new QueueManager(5);

        for (int i = 0; i < 500; i++) {
            Producer prod = new Producer(mgr);
            prod.setName("Prod" + i);
            prod.start();

            //if(i>5){
            Consumer con = new Consumer(mgr);
            con.setName("Con" + i);
            con.start();
            //}
        }
    }

}

class QueueManager {

    int size;
    boolean isEmpty = true;
    Object lock = new Object();
    Queue<Thread> tQue = new LinkedList<Thread>();
    Queue<Object> bucket = new LinkedList<Object>();

    QueueManager(int size) {
        this.size = size;
    }

    public boolean produce() {
        boolean isProduced = false;
        synchronized (lock) {
            while (bucket.size() >= size) {
                try {
                    System.out
                            .println(Thread.currentThread().getName()
                                    + " BucketSize:"
                                    + bucket.size()
                                    + ".  Bucket filled. Waiting for the bucket item to be used.");
                    lock.wait();
                } catch (InterruptedException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }
            Object item = Math.round(Math.random() * 10000);
            bucket.add(item);
            isEmpty = false;
            System.out.println(Thread.currentThread().getName() + " Added to Bucket:" + item + "  Bucket Size:" + bucket.size());
            if (!isEmpty) {
                System.out.println(Thread.currentThread().getName() + " Notifying all blocking thread ");
                lock.notifyAll();
            }

            isProduced = true;
        }

        return isProduced;
    }

    public boolean consume() throws InterruptedException {
        boolean isCosumed = false;
        synchronized (lock) {

            while (bucket.size() < 1 || isEmpty) {
                try {
                    System.out.println(Thread.currentThread().getName()
                            + ". Bucket size:" + bucket.size()
                            + ". Waiting for the bucket to fill.");
                    tQue.offer(Thread.currentThread());
                    lock.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

            Thread t = null;
            if (tQue.size() > 0) {
                t = tQue.peek();
                if (!t.getName().equals(Thread.currentThread().getName())) {
                    System.out.println("MissMatch Que thread:" + t.getName()
                            + " Current Thread:"
                            + Thread.currentThread().getName());
                    lock.wait();
                } else {
                    System.out.println("Matched. Que thread:" + tQue.poll().getName() + " Current Thread:" + Thread.currentThread().getName());

                }
            }


            if (bucket.size() == 1)
                isEmpty = true;
            Object item = bucket.remove();
            System.out.println(Thread.currentThread().getName() + ".  Consumed Item:" + item);
            if (isEmpty) {
                System.out.println(Thread.currentThread().getName() + " Notifying all blocking thread ");
                lock.notifyAll();
            }

            isCosumed = true;
        }

        return isCosumed;
    }
}

class Consumer extends Thread {

    private QueueManager mgr;

    Consumer(QueueManager mgr) {
        this.mgr = mgr;
    }

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + ".  RUN: ");
        try {
            this.mgr.consume();
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}

class Producer extends Thread {

    private QueueManager mgr;

    Producer(QueueManager mgr) {
        this.mgr = mgr;
    }

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + ".  RUN: ");
        this.mgr.produce();
    }
}