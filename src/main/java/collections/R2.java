package collections;

import java.util.Comparator;
import java.util.Map;
import java.util.SortedMap;
import java.util.TreeMap;

/**
 * Created with IntelliJ IDEA.
 * User: pratyush
 * Date: 28/10/13
 * Time: 12:28 AM
 * To change this template use File | Settings | File Templates.
 */
public class R2 {

    private class InPrivate {

    }

    public class InProtected {

    }

    public class InPublic {

    }

    class InDefault {

    }

    public void main() {
        InDefault ind = new InDefault();
        InPrivate inP = new InPrivate();
    }

    public static void main(String[] args) {

        Student st = new Student(10) {

            synchronized void show() {

                System.out.println("Anonymous Student show.");
            }
        };


        Map<Student, String> mp = new TreeMap<Student, String>(new Comparator<Student>() {
            @Override
            public int compare(Student o1, Student o2) {
                return 0;  //To change body of implemented methods use File | Settings | File Templates.
            }
        });
        mp.put(new Student(12), "");


        TreeMap<String, String> myMap = new TreeMap<String, String>();
        myMap.put("a", "apple");
        myMap.put("d", "date");
        myMap.put("f", "fig");
        myMap.put("p", "pear");
        System.out.println("1st after mango: " +
// sop 1
                myMap.higherKey("f"));
        System.out.println("1st after mango: " +
// sop 2
                myMap.ceilingKey("f"));
        System.out.println("1st after mango: " +
// sop 3
                myMap.floorKey("f"));
        SortedMap<String, String> sub = new TreeMap<String, String>();
        sub = myMap.tailMap("f");
        System.out.println("1st after mango: " +
//sop4
                sub.firstKey());

    }


}


class Student {
    String name = "Default";
    Integer age = 0;

    Student(int age) {
        this.age = age;
    }

    public void display() {
        System.out.println("Student Display");
    }

}

class Outer {

    static class A {
        void process() throws Exception { throw new Exception(); }
    }
    static class B extends A {
        void process() { System.out.println("B"); }
    }
    public static void main(String[] args) {
        String s = "-";
        Integer x = 343;
        long L343 = 343L;
        if(x.equals(L343)) s += ".e1 ";
        if(x.equals(343)) s += ".e2 ";
        Short s1 = (short)((new Short((short)343)) / (new Short((short)49)));
        if(s1 == 7)
            s += "=s ";
        if(s1 < new Integer(7+1)) s += "fly ";
        System.out.println(s);
    }
}

