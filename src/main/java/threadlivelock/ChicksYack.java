package threadlivelock;

/**
 * Created with IntelliJ IDEA.
 * User: pratyush
 * Date: 31/10/13
 * Time: 2:00 PM
 * To change this template use File | Settings | File Templates.
 */
public class ChicksYack implements  Runnable {
    static Chicks c;

    public static void main(String[] args) {
        new ChicksYack().go();
    }

    void go() {
        c = new Chicks();
        new Thread(new ChicksYack()).start();
        new Thread(new ChicksYack()).start();
    }

    public void run() {
        c.yack(Thread.currentThread().getId());

    }
}

class Chicks {
    synchronized void yack(long id) {
        Integer intg = 10;

        synchronized (intg){

        }

        for (int x = 1; x < 3; x++) {
            System.out.print(id + " ");
            Thread.yield();
        }
    }

}