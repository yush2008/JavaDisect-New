package threadlivelock;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.*;

/**
 * Created with IntelliJ IDEA.
 * User: pratyush
 * Date: 31/10/13
 * Time: 9:46 PM
 * To change this template use File | Settings | File Templates.
 */
abstract class superHero implements Comparable {
}

public class RJ1 {
    private String str;

    public RJ1(String str) {
        this.str = str;
    }

    @Override
    public String toString() {
        return str;
    }

    @Override
    public int hashCode() {
        return this.str.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof RJ1) {
            RJ1 ht = (RJ1) obj;
            return this.str.equals(ht.str);
        }
        return false;
    }

    public static void main(String args[]) {

        int x=10;
        System.out.println("Check:"+ x);



        Vehicle v = new Car();
        Bike b = (Bike) v;

        v.printSound();
        b.printSound();


        RJ1 h1 = new RJ1("1");
        RJ1 h2 = new RJ1("1");
        String s1 = new String("1");
        String s2 = new String("2");

        List ls = new ArrayList();
        ls.add(h1);
        ls.add(s1);
        Collections.sort(ls);

        Object arr[] = new Object[2];
        arr[0] = h1;
        arr[1] = s1;
        Arrays.sort(arr);


        HashSet<Object> hs = new HashSet<Object>();
        hs.add(h1);
        hs.add(h2);
        hs.add(s1);
        hs.add(s2);

        System.out.print(hs.size());
    }
}

class Vehicle {
    public void printSound() {
        System.out.print("vehicle");
    }
}

class Car extends Vehicle {
    public void printSound() {
        System.out.print("car");
    }
}

class Bike extends Vehicle {
    public void printSound() {
        System.out.print("bike");
    }
}

class TrickyNum<X extends Number> {

    private X x;

    public TrickyNum(X x) {
        this.x = x;
    }

    private double getDouble() {
        return x.doubleValue();
    }

    public static void main(String args[]) {
        /*Integer in = new Integer(12);
        System.out.println(in.doubleValue());
*/
        TrickyNum<Integer> a = new TrickyNum<Integer>(new Integer(1));
        System.out.print(a.getDouble());
    }
}


class Empty {
}

class Extended extends Empty {
}

class TryMe {
    public static void doStuff1(List<Empty> list) {
        // some codetest
    }

    public static void doStuff2(List list) {
        // some codetest
    }

    public static void doStuff3(List<? extends Empty> list) {
        // some codetest
    }

    public static void main(String args[]) {
        List<Empty> list1 = new LinkedList<Empty>();
        List<Extended> list2 = new LinkedList<Extended>();

        doStuff1(list1);
        doStuff2(list2);
        doStuff2(list1);
        doStuff3(list1);
        doStuff3(list2);
        // doStuff1(list2);

        // more codetest here
    }
}

class HashTest {

    private String str;

    public HashTest(String str) {
        this.str = str;
    }

    public static void main(String args[]) {
        HashTest h1 = new HashTest("1");
        HashTest h2 = new HashTest("1");
        String s1 = new String("2");
        String s2 = new String("2");

        HashSet<Object> hs = new HashSet<Object>();
        hs.add(h1);
        hs.add(h2);
        hs.add(s1);
        hs.add(s2);

        System.out.print(hs.size());
    }
}

interface  SynchronizedInterf{

     void show();
}

class Con implements SynchronizedInterf{

    @Override
    public synchronized void show() {
        //To change body of implemented methods use File | Settings | File Templates.
    }
}


abstract class A{

}

class B{

}

class Hotel {

    public static void book(short a) {
        System.out.print("short ");
    }

    public static void book(Short a) {
        System.out.print("SHORT ");
    }

    public static void book(Long a) {
        System.out.print("LONG ");
    }

    public synchronized   void shoe(){};

    public void add(float f){
        int i = (int)f;
    }

    private static String str;
    public static void main(String[] args) {
        System.out.println(str);

        Thread.yield();


       List l = new LinkedList<String>();
        LinkedList<String> lnk = new LinkedList();

        File file = new File("abc.txt");
        file.isDirectory();
        file.delete();
        file.list();
        file.canRead();


        int i = 10;
        while (++i <= 10) {
            i++;
        }
        System.out.print(i);

        short shortRoom = 1;
        int intRoom = 2;

        book(shortRoom);
        //book(intRoom);
    }
}


class Creature {
    private int legCount;
    protected int wingCount;

    public Creature(int legCount) {
        this.legCount = this.legCount;
        this.wingCount = 0;
    }

    public String toString() {
        return "legs=" + this.legCount + " wings=" + wingCount;
    }
}

class Animal extends Creature {
    public Animal(int legCount) {
       super(legCount);
        this.wingCount = 0;
    }

}


class Hotela  {
    public int roomNr = 100;
    private Integer in = new Integer(roomNr);
    public static void astaticVoid(){}
}
class Hotelb  extends Hotela{
    public static void changer(){
        astaticVoid();
    }

}