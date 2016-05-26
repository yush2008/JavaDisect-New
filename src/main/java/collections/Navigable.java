package collections;

import java.util.*;

/**
 * Created with IntelliJ IDEA.
 * User: pratyush
 * Date: 27/10/13
 * Time: 7:40 PM
 * To change this template use File | Settings | File Templates.
 */
public class Navigable {

    public static void main(String[] args) {

        String[] lstA= new String[2];
        String[] lstB= new String[2];

        lstA[0]="one";
        lstA[1]="two";

        lstB[0]="one";
        lstB[1]="two";


        System.out.println(Arrays.equals(lstA,lstB));


        TreeMap<String, String> nvgMap = new TreeMap<String,String>();
        nvgMap.put("2","two");
        nvgMap.put("4","four");
        nvgMap.put("9","nine");
        nvgMap.put("8","eight");
        nvgMap.put("3","three");
        nvgMap.put("1","one");
        nvgMap.higherKey("5");
        nvgMap.headMap("8");

      /*  SortedMap<String,String> srtedMap = nvgMap.subMap("2", "6");
        srtedMap.put("2","five");
        srtedMap.put("21","twentyone");

        nvgMap.put("22","twenytwo");*/

        SortedMap<String,String> tailMap = nvgMap.tailMap("3");
        //tailMap.put("5","five-ten");

        nvgMap.put("32","twenytwo");


        System.out.println("world");



    }
}


