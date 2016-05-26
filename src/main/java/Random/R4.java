package Random;

/**
 * Created with IntelliJ IDEA.
 * User: pratyush
 * Date: 1/11/13
 * Time: 10:40 AM
 * To change this template use File | Settings | File Templates.
 */
class R4 {

    protected class ABC{
        String pro = "Hello";

    }

    public void grew(){
        ABC a =new ABC();
    }

}


class SubR4 extends R4{


    public static void main(String[] args) {
        R4 r4 = new R4();
        ABC abc = r4.new ABC();
    }


}

interface IN{
    public abstract void show();
}
