package algos;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by pratyush on 18/2/15.
 */
public class Solution {

    public static void main(String args[] ) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line;
        int n = 0,m=0;
        int ls=0,le=0;
        int count = 0;
        Map<Integer,Integer> overlapCount = new HashMap<Integer,Integer>();
        while( (line = br.readLine()) != null) {
            if(count==0){
                n = Integer.parseInt(String.valueOf(line.charAt(0)));
                m = n+Integer.parseInt(String.valueOf(line.charAt(1)));
            }else if(count<=n){
                ls = Integer.parseInt(String.valueOf(line.charAt(0)));
                le = Integer.parseInt(String.valueOf(line.charAt(1)));

                for(Integer key : overlapCount.keySet()){
                    if(ls<=key && key<=le){
                        overlapCount.put(key,overlapCount.get(key)+1);
                    }
                }

                if(!overlapCount.containsKey(ls))
                    overlapCount.put(ls,1);
                /*else
                    overlapCount.put(ls,overlapCount.get(ls)+1);
*/
                if(!overlapCount.containsKey(le))
                    overlapCount.put(le,1);
  /*              else
                    overlapCount.put(le,overlapCount.get(le)+1);
  */

            }else if(count>n && count <= m){
                int point = Integer.parseInt(String.valueOf(line.charAt(0)));
                if(overlapCount.containsKey(point))
                    System.out.println(overlapCount.get(point));
                else
                    System.out.println("0");
            }
           count++;
        }



    }
}

