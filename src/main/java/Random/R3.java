package Random;

/**
 * Created with IntelliJ IDEA.
 * User: pratyush
 * Date: 26/10/13
 * Time: 9:50 PM
 * To change this template use File | Settings | File Templates.
 */
public class R3 {
    public static void main(String[] args) {

        A a = new A();
        B b = new B();
        b.same((B) a);

        //a.same(new B());

    }
}


class A{

   /* public boolean same(A a){
        System.out.println("A");
        return true;
    }*/
}

class B extends A{

    public boolean same(B b){
        System.out.println("B");
        return true;
    }
}