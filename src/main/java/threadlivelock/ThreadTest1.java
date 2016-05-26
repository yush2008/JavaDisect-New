package threadlivelock;

/**
 * Created with IntelliJ IDEA.
 * User: pratyush
 * Date: 6/2/14
 * Time: 8:11 AM
 * To change this template use File | Settings | File Templates.
 */
public class ThreadTest1 {

    public static void main(String[] args) {

        new Thread(new NumberDisplayer(5)).start();
        new Thread(new NumberDisplayer(5)).start();

    }
}

class NumberDisplayer implements Runnable{

    int number;
    NumberDisplayer(int value){
        number =  value;
    }

    @Override
    public void run() {

    }
}