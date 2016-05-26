package InheritanceComposition;

/**
 * Created with IntelliJ IDEA.
 * User: pratyush
 * Date: 28/10/13
 * Time: 3:03 PM
 * To change this template use File | Settings | File Templates.
 */
public class R1 {

    public static void main( String[] args ) {
        Foo x = new Beta();
        Foo b = (Delta)x;
    }

}

interface Foo {}
class Alpha implements Foo {}
class Beta extends Alpha {}
class Delta extends Beta {

}