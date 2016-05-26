package NumberFormatting;

/**
 * Created with IntelliJ IDEA.
 * User: pratyush
 * Date: 1/11/13
 * Time: 10:08 PM
 * To change this template use File | Settings | File Templates.
 */
public class R1 {

    public static void main(String[] args) {


        int i = 10;
        i=0xff;
        long l=0xfffffL;



        char c = (char)1231231231;

        float a = 100.3434501f;
        a += a+12.312;

        int b = (int)a;
        short srt = 19009;
        srt = (short)(srt+ 123);
        //4294967296

        System.out.println(b);

    }
}


class Alien {
     private String lock = "lock";

    static {

    }

    String invade(short ships) {

        this.notifyAll();
      /*  this.wait();
        Thread.sleep(123);
        new Thread().join();*/

        return "a few";

    }
    String invade(short... ships) { return "many"; }
}
class Defender {
    int ouch;
    Integer in = new Integer(12);
    Float Flt = new Float(12);
    float ft = 12.23f;
    Long Lng = new Long(123);
    float[] ftArr = new float[2];

    void go(int oucha) {
        if(ft==Lng){

        }


        oucha++;
        for(int ouch = 3; ouch < 6; ouch++)
                    ;
        System.out.print(" " + ouch);
    }

    public static void main(String [] args) {

        int x;
        //x++;

        //System.out.println(new Alien().invade(7));
    }
}



class Bird {
    {
        System.out.print("b1 ");
    }
    public Bird() { System.out.print("b2 "); }
}
abstract class Raptor extends Bird {
    private static String str ="Hello";
    static {
        System.out.print("r1 "+str.length());
    }
    public Raptor() { System.out.print("r2 "); }

    { System.out.print("r3 "); }

    static public  void main(){};

    static {
        System.out.print("r4 ");
    }
}
class Hawk extends Raptor{
    public static void main(String[] args) {
        System.out.print("pre ");
        new Hawk();
        System.out.println("hawk ");
    }
}



 enum Title {

    MR("Mr."), MRS("Mrs."), MS("Ms.");

    private final String title;
    private Title(String t) { title = t; }
    public String format(String last, String first) {
        final int x;
        x=10;
        return title + " " + first + " " + last;
    }

     public static void main(String[] args) {
         System.out.println(Title.MR.format("Doe", "John"));
     }
 }