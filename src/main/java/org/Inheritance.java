package org;

/**
 * Created with IntelliJ IDEA.
 * User: pratyush
 * Date: 17/10/13
 * Time: 4:41 PM
 * To change this template use File | Settings | File Templates.
 */
public class Inheritance {
}



interface DeclareStuff {
    public static final int EASY = 3;

    void doStuff(int t);
}

class AbsStuff{

    public static void doAbsStuff(int t){};
}

class TestDeclare extends  AbsStuff implements DeclareStuff {

    public static void main(String[] args) {
        int x = 5;
        new TestDeclare().doStuff(++x);
    }

    public void doStuff(int s) {
        s += EASY + ++s;
        System.out.println("s " + s);
    }

    public static void doAbsStuff(int t) {
        //To change body of implemented methods use File | Settings | File Templates.
    }
}