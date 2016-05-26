package org;

/**
 * Created with IntelliJ IDEA.
 * User: pratyush
 * Date: 17/10/13
 * Time: 3:15 PM
 * To change this template use File | Settings | File Templates.
 */
public class GarbageCollection {

   /* int x;

    GarbageCollection(){
        System.out.println("Constructor Block");
    }

    {
        System.out.println("Non statis block"+x);
    }

    static {
        System.out.println("Satic Block");
    }

    public static void main(String[] args) {

        GarbageCollection gb =  new GarbageCollection();
    }*/


    static class InnerMain1{

        public static void main(String[] args) {

            System.out.println("Inner Main 1");
        }
    }

    public static class InnerMain2{

        public static void main(String[] args) {

            System.out.println("Inner Main 2");
        }
    }

}

