package threadlivelock;

import java.util.concurrent.*;

public class ThreadWait {

    /**
     * Different ways to make a Thread wait for another thread to complete.
     *
     * @param args
     */

    public static void main(String[] args) {
       /* Thread t = new Thread(new MRunnable());
        t.start();
        try{
            t.interrupt();
        }catch (Exception e){
            e.printStackTrace();
        }*/

        final ExecutorService executor = Executors.newSingleThreadExecutor();
        final Future future = executor.submit(new MRunnable());
        executor.shutdown(); // This does not cancel the already-scheduled task.
        try {
            future.get(5, TimeUnit.SECONDS);
        }
        catch (InterruptedException ie) { /* Handle the interruption. Or ignore it. */ }
        catch (ExecutionException ee) { /* Handle the error. Or ignore it. */ }
        catch (TimeoutException te) { /* Handle the timeout. Or ignore it. */ }

        if (!executor.isTerminated())
            executor.shutdownNow(); // If you want to stop the codetest that hasn't finished.


    }

    public static void main1(String[] args) {
        try {


            final CountDownLatch latch = new CountDownLatch(1);
            MCountDwnLatch mc1 = new MCountDwnLatch(latch);
            MCountDwnLatch mc2 = new MCountDwnLatch(latch);
            MCountDwnLatch mc3 = new MCountDwnLatch(latch);
            MCountDwnLatch mc4 = new MCountDwnLatch(latch);
            MCountDwnLatch mc5 = new MCountDwnLatch(latch);

            Thread t1 = new Thread(mc1);
            t1.start();
            t1 = null;
            //t1.join();

            Thread t2 = new Thread(mc1);
            t2.start();
            latch.await();
            //t2.join();

            Thread t3 = new Thread(mc1);
            t3.start();
            //t3.join();

            Thread t4 = new Thread(mc1);
            t4.start();
            //t4.join();

            Thread t5 = new Thread(mc1);
            t5.start();
            //t5.join();


            latch.await();
            System.out.println("Latch completed waiting.");
        } catch (InterruptedException e1) {
            // TODO Auto-generated catch block
            e1.printStackTrace();
        }


        MRunnable mr1 = new MRunnable();

        Thread t11 = new Thread(mr1);
        t11.start();

        Thread t12 = new Thread(mr1);
        t12.start();


        //  Call join() on the same thread.


        try {
            t11.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

		
		
		  /*
           * Make the current running thread wait on the thread obj t1.
           * and notify t1 at the end of it run()
           *    		
           */
        synchronized (t11) {

            System.out.println(" Wait on t1");
            try {
                t11.wait();
                System.out.println("Release on t1");
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }


    }

}

class MCountDwnLatch implements Runnable {

    public Integer count = 0;
    public String lockStr = "lock";
    public final CountDownLatch latch;
    public String name = null;
    public boolean stop = false;

    MCountDwnLatch(final CountDownLatch latch) {
        this.latch = latch;
    }


    @Override
    public void run() {
        synchronized (this) {
            if (!Thread.currentThread().isInterrupted() && !stop) {
                for (int i = 0; i < 10; i++) {
                    count++;
                }

                latch.countDown();
                System.out.println("Latch count down. count:" + count + " Name:" + name);
            }
        }
    }

}

class MRunnable implements Runnable {

    public Integer count = 0;
    public String lockStr = "lock";

    @Override
    public void run() {
        synchronized (this) {

            for (int i = 0; i < 100000000; i++) {
                boolean status = Thread.currentThread().isInterrupted();
                System.out.println("Count: " + count + "  Status: " + status);
                if (status) break;
                count++;
            }

            this.notify();
            System.out.println("Notified on this.");
        }
    }

}