package p2;

import p1.Super;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created with IntelliJ IDEA.
 * User: pratyush
 * Date: 30/10/13
 * Time: 10:39 PM
 * To change this template use File | Settings | File Templates.
 */
public class Sub extends Super {

    public void defShow(){
        System.out.println("Sub Default Show");
    }

    public void protShow(){
        System.out.println("Sub protected show");
    }

    protected static void proStatic(){
        System.out.println("Sub pro static");
    }

    public void takeList(List<? extends StringBuffer> list) {
        Object o = list;
        list = new ArrayList<StringBuffer>();
    }

    public static void main(String[] args) {
        Set<Object> set = new HashSet<Object>();
        set.add("A");
        set.add(new String("A"));
        set.add(new String("A"));

        if(new String("A") == new String("A") )
            System.out.println("true");

        String A1 = new String("A");
        String A2 = new String("A");

        if(A1 == A2)
            System.out.println("true");

        if(A1.hashCode() == A2.hashCode())
            System.out.println("true");

        System.out.println(set.size());

        Sub su1 = new Sub();
        su1.proStatic();

    }

}
