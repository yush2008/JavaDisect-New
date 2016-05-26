package StringWraperEquals;

/**
 * Created with IntelliJ IDEA.
 * User: pratyush
 * Date: 28/10/13
 * Time: 2:13 PM
 * To change this template use File | Settings | File Templates.
 */
public class Formating {

    public static void main(String[] args) {

        double x = 123.456;

        System.out.printf("%5.0f",x);

        double fl = -123.45,dl = -123.45;
        System.out.printf("%2$(11f",fl,dl);

        /*int i1 = -123;
        int i2 = 12345;
        System.out.printf(">%1$(7d< \n", i1);
        System.out.printf(">%0,7d< \n", i2);
        System.out.format(">%+-7d< \n", i2);
        System.out.printf(">%2$b + %1$5d< \n", i1, false);*/



        //System.out.printf("%1$-010.2f%n",x);



    }
}



