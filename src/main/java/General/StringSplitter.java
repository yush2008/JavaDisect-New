package General;

/**
 * Created with IntelliJ IDEA.
 * User: pratyush
 * Date: 4/8/14
 * Time: 2:10 PM
 * To change this template use File | Settings | File Templates.
 */
public class StringSplitter {

    public static void main(String[] args) {
        String str = "AREA_KEY+NODE_LOOPBACK_IP+History+UPDATE_DATE";
        String strs[] = str.split( "\\+");
        System.out.println(str.length());


    }
}
