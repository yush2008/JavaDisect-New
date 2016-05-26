package org;

/**
 * Created with IntelliJ IDEA.
 * User: pratyush
 * Date: 18/10/13
 * Time: 6:31 PM
 * To change this template use File | Settings | File Templates.
 */
public class Random {

    void testDefault() {

    }

    protected void test() {
        System.out.println("Test");
    }

    Bar myBar = new Bar();

    void changeIt(Bar myBar) {
        myBar.barNum = 99;
        System.out.println("myBar.barNum in changeIt is " + myBar.barNum);
        myBar = new Bar();
        myBar.barNum = 420;
        System.out.println("myBar.barNum in changeIt is now " + myBar.barNum);
    }

    public static void main1(String[] args) {
        Random f = new Random();
        System.out.println("f.myBar.barNum is " + f.myBar.barNum);
        f.changeIt(f.myBar);
        System.out.println("f.myBar.barNum after changeIt is " + f.myBar.barNum);
    }

    public static void wob(Short... i) {
        System.out.println("I");
    }

    public static void woba(long... i) {
        System.out.println("i");
    }

    class RInner {

    }

    public static void main(String... args) {


        int mask = 0;
        int count = 0;
        if (((5 < 7) || (++count < 10)) & mask++ > 10)
            mask = mask + 1;
//        if ((6 > 8) ^ false)
//            mask = mask + 10;
//        if (!(mask > 1) && ++count > 1)
//            mask = mask + 100;
        System.out.println(mask + " " + count);







     /*   float f1 = 2.3f;
        float[][] f2 = {{42.0f}, {1.7f, 2.3f}, {2.6f, 2.7f}};
        float[] f3 = {2.7f};
        Long x = 42L;
        if(f1 == f2[1][1])
         System.out.println("true");

        String as="100";



        A aaa = new A(2);
        A aa = new B();
        if(aa instanceof Object)
            System.out.println("Object");
        if(aa instanceof A)
            System.out.println("A");
        if(aa instanceof B)
            System.out.println("B");
        if(aa instanceof Object)
            System.out.println("Object");

        B bb = (B)aa;
        bb.onlyOnB();

        if(bb == aaa)
           System.out.println(Suits.NOTRUMP.getValue(3));

        System.out.println(Suits.SPADES + " " + Suits.SPADES.points);
        System.out.println(Suits.values());

        Fizz.main2();


        int[][] a = {{1, 2,}, {3, 4}};
        int[] b = (int[]) a[1];
        Object o1 = a;
        int[][] a2 = (int[][]) o1;
        int[] b2 = (int[]) o1;
        System.out.println(b[1]);


        short i = 10;
        Random r = new Random();
        r.wob(i);

        r.testDefault();
        r.temp.test();
*/

        // A a = new A(1);
        System.out.println("====================");
        B b = new B();

    }

    public Object clone() {
        return null;
    }


    public enum Suits {
        CLUBS(20), DIAMONDS(20), HEARTS(30), SPADES(30),
        NOTRUMP(40) {
            public int getValue(int bid) {
                return ((bid - 1) * 30) + 40;
            }
        };

        Suits(int points) {
            this.points = points;
        }

        public int points;

        public int getValue(int bid) {
            return points * bid;
        }
    }
}


class Fizz {
    int x = 5;

    public static void main2() {
        final Fizz f1 = new Fizz();
        Fizz f2 = new Fizz();
        Fizz f3 = FizzSwitch(f1, f2);
        System.out.println((f1 == f3) + " " + (f1.x == f3.x));
    }

    static Fizz FizzSwitch(Fizz x, Fizz y) {
        final Fizz z = y;
        z.x = 6;
        return z;
    }
}


class Bar {
    int barNum = 28;

}

class A {


    A(int x) {
        System.out.println("No arg ctr A");
    }

    static {
        int[] arr = new int[3];
        arr[2] = 2;
        System.out.println("1Static A");
    }

    static {
        System.out.println("2Static A");
    }

    {
        int[] arr = new int[3];
        System.out.println("1Instance A");
    }

    {
        System.out.println("2Instance A");
    }

    public static void zone() {
        System.out.println("static A Zone");
    }

    public void onlyOnA() {
        System.out.println("Only on A");
    }
}

class B extends A {
    B() {
        super(3);
        System.out.println("No arg ctr B");
    }

    B(int x) {
        super(2);
        System.out.println("Arg ctr A");
    }

    static {
        System.out.println("1Static B");
    }

    static {
        System.out.println("2Static B");
    }

    {
        System.out.println("1Instance B");
    }

    {
        System.out.println("2Instance B");
    }

    public static void zone() {
        System.out.println("static B Zone");
    }

    public void onlyOnB() {
        System.out.println("Only on B");
    }
}