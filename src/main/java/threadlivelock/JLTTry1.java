package threadlivelock;

/**
 * Created with IntelliJ IDEA.
 * User: pratyush
 * Date: 29/1/14
 * Time: 3:35 PM
 * To change this template use File | Settings | File Templates.
 */
public class JLTTry1 {

    public static void main(String[] args) {
        ResoucreIn rin = new ResoucreIn();


        Thread t1 = new Thread(new Runn1(rin));
        t1.start();

        Thread t2 = new Thread(new Runn2(rin));
        t2.start();
    }


}


class ResoucreIn{


    public void show(){

        System.out.println("Show 1");
        System.out.println("Show 2");
        System.out.println("Show 3");
        System.out.println("Show 4");
    }

    public synchronized void showSync(){

        System.out.println("Show 1");
        System.out.println("Show 2");
        System.out.println("Show 3");
        System.out.println("Show 4");
    }

}


class Runn1 implements Runnable{
    private ResoucreIn rin;
    Runn1(ResoucreIn rin){
        this.rin = rin;
    }

    @Override
    public void run() {
        rin.show();
    }

}

class Runn2 implements Runnable{
    private ResoucreIn rin;
    Runn2(ResoucreIn rin){
        this.rin = rin;
    }

    @Override
    public void run() {
        rin.showSync();
    }

}

