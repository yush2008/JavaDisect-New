package p1;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import p2.Subtest;


public class Polytest {

    Polytest() {
        System.out.println("Defaulu package private Ctor is called");
    }

    protected void show() {
        System.out.println("Parent");
    }

    void showDefault() {
        System.out.println("Default Show");
    }

}

class MainTest {
    public static void main(String args[]) {
        Polytest pt = new Polytest();
        Subtest st = new Subtest();

        //st.show();


        try {
            //pst.show();
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }


    }

}
