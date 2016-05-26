package NumberFormatting;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created with IntelliJ IDEA.
 * User: pratyush
 * Date: 4/11/13
 * Time: 10:04 AM
 * To change this template use File | Settings | File Templates.
 */
public class Widening {

   /* static void wide_vararg(long... x) {
        System.out.println("long...");
    }*/

    static void wide_vararg(int... x) {
        System.out.println("int...");
    }

    static void wide_vararg(Integer x, Integer y) {
        System.out.println("Integer...");
    }

    public static void main(String[] args) {

        Pattern pattern = Pattern.compile(",\\[\\{");

        String strRecord = "20130902:WWBAG200,[{\"SUBNET\":\"172.25.64.13\",\"RBS_CATEGORY\":\"ATM\",\"SITE_CLASS\":\"Rural\",\"RBS_ID\":\"34014\",\"RBS_NAME\":\"WW014\",\"RBS_RNC_BSC_NAME\":\"706RNC20\",\"EQUIPMENT_VENDOR\":\"Ericsson\",\"STATUS\":\"OnAir\"},{\"SUBNET\":\"172.25.64.13\",\"RBS_CATEGORY\":\"ATM\",\"SITE_CLASS\":\"Town 3k - 1.5k\",\"RBS_ID\":\"34060\",\"RBS_NAME\":\"WW060\",\"RBS_RNC_BSC_NAME\":\"706RNC20\",\"EQUIPMENT_VENDOR\":\"Ericsson\",\"STATUS\":\"OnAir\"},{\"SUBNET\":\"172.25.64.13\",\"RBS_CATEGORY\":\"ATM\",\"SITE_CLASS\":\"Town 1.5k - 1k\",\"RBS_ID\":\"34044\",\"RBS_NAME\":\"WW044\",\"RBS_RNC_BSC_NAME\":\"706RNC20\",\"EQUIPMENT_VENDOR\":\"Ericsson\",\"STATUS\":\"OnAir\"}]\n";
        Matcher matcher = pattern.matcher(strRecord);
        boolean found = false;

        while(matcher.find()){
            found = (!found)? true: false;

        }


    }
}


