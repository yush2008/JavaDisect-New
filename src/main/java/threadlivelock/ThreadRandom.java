package threadlivelock;

/**
 * Created with IntelliJ IDEA.
 * User: pratyush
 * Date: 31/10/13
 * Time: 12:27 PM
 * To change this template use File | Settings | File Templates.
 */
public class ThreadRandom {

    public static synchronized  void main(String[] args) {
       new Thread(new MoRa()).start();


        Thread t = new Thread();
        t.start();

        try {
            t.join();
        } catch (InterruptedException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        }

        System.out.print("X");
        System.out.print("Y");

        ThreadRandom tr = new ThreadRandom();
        tr.syncChek();


        for(int i=0; i<5; i++)
            System.out.println(i);

        for(int i=0; i<5; ++i)
            System.out.println(i);


        args = new String[2];
        args[0] = "wow";
        arrIncr(args);
        System.out.println(args.toString());
    }

    private void syncChek() {

        try {
            this.notifyAll();
            //Thread.sleep(13123);
        } catch (Exception e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        }


    }

    private static void arrIncr(String[] args) {
        args[1]="wew";
    }
}


class MoRa implements Runnable{

    @Override
    public void run() {
        System.out.println("Ola");
    }
}
class Resource{


}