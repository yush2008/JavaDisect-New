package NumberFormatting;

/**
 * Created with IntelliJ IDEA.
 * User: pratyush
 * Date: 2/11/13
 * Time: 5:56 PM
 * To change this template use File | Settings | File Templates.
 */
public class Pass2 {

    public void main(String [] args) {
        int x = 6;
        Pass2 p = new Pass2();
        p.doStuff(x);
        System.out.print(" main x = " + x);
    }
    void doStuff(int x) {
        System.out.print(" doStuff x = " + x++);
    }
}

