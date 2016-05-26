package Random;

/**
 * Created with IntelliJ IDEA.
 * User: pratyush
 * Date: 26/10/13
 * Time: 12:52 AM
 * To change this template use File | Settings | File Templates.
 */
public class R2 {

    static int i;
    static Integer j;
    static int x = 7;
    public static void main(String[] args) {


        StringBuffer sbuff = new StringBuffer("String");
        StringBuilder sbuild = new StringBuilder("String");

        if(sbuff.toString()==sbuild.toString())
            System.out.println("");


        Employee e1= new Employee("Sudesh");
        wow(e1);
        System.out.println(e1.name);


        System.out.println(7/0);

        System.out.println("i="+i+"  j="+j);


        String s = "";
        for(int y = 0; y < 3; y++) {
            x++;
            switch(x) {
                case 8: s += "8 ";
                case 9: s += "9 ";
                case 10: { s+= "10 "; break; }
                default: s += "d ";
                case 13: s+= "13 ";
            }
        }
        System.out.println(s);
    }
    static { x++; }


    static void wow(Employee e1){
        e1.name = "billo";
        e1 = new Employee("Krishan");
    }

}


class Employee{
    String name;
    Employee(String name){
        this.name = name;
    }
}