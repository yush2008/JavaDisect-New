package threadlivelock;

import java.util.Collections;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.ThreadPoolExecutor;

public class ThreadMain {


    /**
     * @param args
     * @throws InterruptedException
     */
    public static void main(String[] args) {
/*
        MyCallable mc1 = new MyCallable(12);
		MyCallable mc2 = new MyCallable(21);
		MyCallable mc3 = new MyCallable(13);

		ExecutorService exec = new ScheduledThreadPoolExecutor(3);
		Future f1 = exec.submit(mc1);
		Future f2 = exec.submit(mc2);
		Future f3 = exec.submit(mc3);
		try{
		f1.get();
		f2.get();
		f3.get();
		}catch(Exception e)
		{
			
		}*/


        StaticChk s1 = new StaticChk();
        Runnable1 r1 = new Runnable1(s1);
        Runnable2 r2 = new Runnable2(s1);
        Thread tt1 = new Thread(r1);
        System.out.println(tt1.getState().name());
        tt1.start();
        System.out.println(tt1.getState().name());
        System.out.println(tt1.getState().name());
        System.out.println(tt1.getState().name());
        System.out.println(tt1.getState().name());
        System.out.println(tt1.getState().name());


        Thread tt2 = new Thread(r2);
        tt2.start();

        ThreadB tb1 = new ThreadB();
        tb1.start();


       /* synchronized (tb1) {

            try {
                tb1.wait();
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }*/


        StaticChk o1 = new StaticChk();
        StaticChk o2 = new StaticChk();
        StaticChk o3 = new StaticChk();

        /*MyIRunnable mr1 = new MyIRunnable(10, "A");
        MyIRunnable mr2 = new MyIRunnable(10, "A");*/
        MyIRunnable mr2 = new MyIRunnable(o1);
        MyIRunnable mr3 = new MyIRunnable(o1);


        Thread t1 = new Thread(mr3);
        Thread t2 = new Thread(mr2);
        /*Thread t3 = new Thread(mr1);
        Thread t4 = new Thread(mr1);*/

        t1.start();
        t2.start();
		/*t3.start();
		t4.start();*/
        //t1.stop();
        System.out.println("End");


    }

}

class ThreadB extends Thread {

    public Integer count = 0;
    public String lockStr = "lock";

    @Override
    public void run() {
        synchronized (this) {

            for (int i = 0; i < 10; i++) {
                count++;
            }

            //this.notify();
            lockStr.notify();
        }
    }

}

class MyCallable implements Callable<Integer> {
    private Integer x = 0;

    public MyCallable(int i) {

        this.x = i;
    }

    @Override
    public Integer call() throws Exception {

        return x;
    }


}


class MyIRunnable implements Runnable {

    private Integer num;
    private String str;


    public Integer getNum() {
        return num;
    }


    public void setNum(Integer num) {
        this.num = num;
    }


    public String getStr() {
        return str;
    }


    public void setStr(String str) {
        this.str = str;
    }


    public MyIRunnable(Integer num, String str) {
        super();
        this.num = num;
        this.str = str;
    }

    public MyIRunnable(StaticChk obj) {
       this.obj = obj;
    }


    private StaticChk obj = null;

    @Override
    public void run() {

        this.showInstance();

        synchronized (this.getClass()) {
            for (int i = 0; i < 10; i++) {
                this.num += i;
            }

            try {
                Thread.sleep(1234);
            } catch (InterruptedException e) {
                e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
            }

            System.out.println(Thread.currentThread().getName() + ":" + this.num);

        }
    }

    public static void showStatic() {
        System.out.println("Static Show");
    }

    public void showInstance() {
        //synchronized (MyRunnable.class) {
        synchronized (this) {
            System.out.println("Instance Show");
        }

    }

}


class StaticChk {

    static {

        int x = 10;
        String str = "Name";
    }

    public static synchronized void showStc() {
        System.out.println("Static Show");
    }

    public synchronized void show() {
        System.out.println("Instance Show");
    }

    public synchronized void notShow() {
        System.out.println("Instance Not Show");
    }

}

class Runnable1 implements Runnable {

    private StaticChk obj = null;

    Runnable1(StaticChk obj) {
        this.obj = obj;
    }

    @Override
    public void run() {

        Thread current = Thread.currentThread();
        current.stop();

        obj.show();

    }

    public static void test() {
        final int x = 10;
    }


}

class Runnable2 implements Runnable {

    private StaticChk obj = null;

    Runnable2(StaticChk obj) {
        this.obj = obj;
    }

    @Override
    public void run() {

        obj.notShow();

    }


}