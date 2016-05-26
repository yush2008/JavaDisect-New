package algos;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedHashSet;
import java.util.Set;

/**
 * Created by pratyush on 17/2/15.
 */
public class Solution1 {

    public static void main(String args[] ) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = br.readLine();
        if(line.length()!=7){
            System.out.println("Please provide a 7 digit number");
            return;
        }


        Set uniqueChar = new LinkedHashSet<Character>();
        for(int i=0; i<line.length();i++){
            if(uniqueChar.contains(line.charAt(i))){
                System.out.println("The number should be 7 digit number(with each digit being distinct and 0-9).");
                return;
            }else
                uniqueChar.add(line.charAt(i));
        }

        int a,b,c,d,e,f,g;
        a = Integer.parseInt(String.valueOf(line.charAt(0)));
        b = Integer.parseInt(String.valueOf(line.charAt(1)));
        c = Integer.parseInt(String.valueOf(line.charAt(2)));
        d = Integer.parseInt(String.valueOf(line.charAt(3)));
        e = Integer.parseInt(String.valueOf(line.charAt(4)));
        f = Integer.parseInt(String.valueOf(line.charAt(5)));
        g = Integer.parseInt(String.valueOf(line.charAt(6)));

        if(a*b*c == c*d*e && c*d*e == e*f*g)
            System.out.println(d);
        else
            System.out.println(a+"*"+b+"*"+c+"="+a*b*c+"   "+c+"*"+d+"*"+e+"="+c*d*e+"    "+e+"*"+f+"*"+g+"="+e*f*g +"\nNot a desired 7 digit number");

    }

}
