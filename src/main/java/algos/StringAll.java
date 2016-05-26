package algos;



import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: pratyush
 * Date: 3/1/14
 * Time: 11:33 AM
 * To change this template use File | Settings | File Templates.
 */
public class StringAll {

    public static void main(String[] args) {
        String str="H ellyBellyGellybean proxywareagletrom";
        String pat = "ellyllyygellybean";
                   // "abeglny"






        String str12 = "Hello world";
        assert (str != null);
        int[] charArr = new int[256];
        char maxOccuredChar = str.charAt(0);
        int maxOccurCharVal = 1;
        for(int i=0; i< str.length(); i++){
            char charAt = str.charAt(i);
            int occurance = charArr[charAt];

            charArr[charAt] = ++occurance;
            if( occurance > maxOccurCharVal){
                maxOccuredChar = charAt;
                maxOccurCharVal = charArr[charAt];
            }

        }

        System.out.println("maxOccuredChar:"+maxOccuredChar+" occurance:"+maxOccurCharVal);



        /*x = x.replaceAll("l",new String());
        System.out.println(x);*/
    }
}
