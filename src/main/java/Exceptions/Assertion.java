package Exceptions;

/**
 * Created with IntelliJ IDEA.
 * User: pratyush
 * Date: 26/10/13
 * Time: 12:07 AM
 * To change this template use File | Settings | File Templates.
 */
public class Assertion {

    public static void wow(){

    }

    public static void main(String[] args) {

        Float pi = new Float(3.14f);
        if (pi > new Integer(3)) {
            System.out.print("pi is bigger than 3. ");
        }
        else {
            System.out.print("pi is not bigger than 3. ");
        }



        int dx;
        boolean assertsOn = false;
        assert (assertsOn) : dx=12;
        if(assertsOn) {
            System.out.println("assert is on");
        }



        try{
        int x=10;
        assert (x>1);
        System.out.println("After Assert");

        }catch (Error e){
            e.printStackTrace();
        }
    }
}
