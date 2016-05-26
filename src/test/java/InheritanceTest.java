
/**
 * Created with IntelliJ IDEA.
 * User: pratyush
 * Date: 2/12/13
 * Time: 2:19 PM
 * To change this template use File | Settings | File Templates.
 */
public class InheritanceTest {
    public static void main(String[] args) {

        Parent p = new Parent();
        Child c = new Child();
        c.show();
    }
}

class  Parent{
    int p=10;
    static void pShow(){
        System.out.println("pShow");
    }
    static void show(){
        System.out.println("parent");
    }
}
class Child extends Parent{
    int q=20;
    static void cShow(){
        System.out.println("cShow");
    }
    static void show(){
        System.out.println("child");
    }
}