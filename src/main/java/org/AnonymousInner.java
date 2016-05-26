package org;

/**
 * Created with IntelliJ IDEA.
 * User: pratyush
 * Date: 18/10/13
 * Time: 2:58 PM
 * To change this template use File | Settings | File Templates.
 */
public class AnonymousInner {


    public static void dataCollector(Collector collector){

        System.out.println(collector.collect());

        final class MethodInner{

        }
    }

    public static void main(String[] args) {

        dataCollector(new Collector(3){

            protected int x=10;

            @Override
            public String collect() {
                return "From Anonymous inner class";
            }
        });
    }

    class Inner{

    }

}

class Collector{
    Collector(int x){

    }
    Collector(float f){

    }
    String collect(){
        return null;
    }
}
