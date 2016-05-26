package org;

/**
 * Created with IntelliJ IDEA.
 * User: pratyush
 * Date: 20/10/13
 * Time: 11:39 PM
 * To change this template use File | Settings | File Templates.
 */
public class Barn extends Building {
    public static void main(String[] args) {
        Building build1 = new Building();
        Barn barn1 = new Barn();
        Barn barn2 = (Barn) build1;
        Object obj1 = (Object) build1;
        //String str1 = (String) build1;
        Building build2 = (Building) barn1;
    }
}

class Building { }