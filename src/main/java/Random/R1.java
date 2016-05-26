package Random;

import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.*;
import java.util.List;

public class R1 {

	/**
	 * @param args
	 */
    public static void main(String[] args) {

        /*Computer c = new Computer();
        c.storeIt(c);
*/
        String s = "-";
        int x = 343;
        Long L343 = 343L;

        if( x == L343 )
            s += ".e1 ";

        if(L343.equals(x))
            s += ".e2 ";
        Short s1 = (short)((new Short((short)343)) / (new Short((short)49)));

        if(s1 == 7)
            s += "=s ";

        if(s1 < new Integer(7+1))
            s += "fly ";

        System.out.println(s);
    }
}


class Keyboard { }
class Computer implements Serializable {
    private Keyboard k = new Keyboard();

    void storeIt(Computer c) {
        try {
            ObjectOutputStream os = new ObjectOutputStream(new FileOutputStream("myFile"));
            os.writeObject(c);
            os.close();
            System.out.println("done");
        } catch (Exception x) {System.out.println("exc"); }
    }
}