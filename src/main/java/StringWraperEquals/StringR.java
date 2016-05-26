package StringWraperEquals;

import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: pratyush
 * Date: 27/10/13
 * Time: 11:08 PM
 * To change this template use File | Settings | File Templates.
 */
public class StringR {

    static int value = 100;

    public static void main(String[] args) {

        go(value);
        System.out.println(value);

        StringBuffer sbuf = new StringBuffer("one");

        String s1 = "one" ;//new String("one");
        String s2 =  "one"; // new String("one");

        if(s1 ==s2)
            System.out.println("==");

        if(s1.equals(sbuf))
            System.out.println("equals");


        StringBuilder sb = new StringBuilder();
        List<List<String>> lstLst = new ArrayList<List<String>>();

    }

    private static void go(int value) {
        tigo(++value);
    }

    private static void tigo(int value) {
         StringR.value = value;

    }
}
