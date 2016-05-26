package collections;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.*;

/**
 * Created with IntelliJ IDEA.
 * User: pratyush
 * Date: 28/10/13
 * Time: 12:55 AM
 * To change this template use File | Settings | File Templates.
 */
public class GenericCollection {

    enum Example { APPLE ,ONE, TWO, THREE }

    public static void main(String[] args) {

        Set<Example> ss = new LinkedHashSet<Example>();
        ss.add(Example.APPLE);
        ss.add(Example.THREE);
        ss.add(Example.TWO);
        ss.add(Example.ONE);



        Map<Example,String>  map = new HashMap<Example, String>();
        map.put(Example.ONE,"ONE");
        map.put(Example.TWO,"TWO");

        /*Map<Example,String>  mapEnum = new EnumMap<Example, String>();
        mapEnum.put(Example.ONE,"ONE");
        mapEnum.put(Example.TWO,"TWO");
*/


        Business b = new Business();
        Hotel i = new Inn();
        b = i;

        Set<? super Hotel> buSet = new TreeSet<Business>();
        buSet.add(new Inn());
        buSet.add(new Hotel());

        /*List<? super Inn> bnsLst = new ArrayList<Business>();
        bnsLst.add(new Hotel());
        bnsLst.add(new Inn());
        bnsLst.add(new TBusiness());
*/
        List<Inn> innList = new ArrayList<Inn>();
  //      bnsLst.addAll(innList);
        methodGeneric(innList);

    }

    public static void methodLegacy(List<Business> businessList){
        System.out.println(businessList);
    }

    public static void methodGeneric(List<? super Inn> businessList){
        businessList.add(new Inn());

        System.out.println(businessList);
    }
}




class Business implements Comparable{
    @Override
    public int compareTo(Object o) {
        return 0;  //To change body of implemented methods use File | Settings | File Templates.
    }
}
class TBusiness extends Business { }
class Hotel extends Business { }
class Inn extends Hotel { }
class Travel<A extends Business> {
    List<Hotel> go() {
        return new Vector<Hotel>();
    }
}


class GenericComparato1r<Business> implements Comparator<Business>{

    @Override
    public int compare(Business o1, Business o2) {
        return 0;  //To change body of implemented methods use File | Settings | File Templates.
    }
}


class GenericComparator<T> implements Comparator<T>{

    String methodName = null;

    GenericComparator(String methodName){
        methodName    = methodName;

    }
    @Override
    public int compare(T o1, T o2) {
        try {
            Comparable c1 = getComparable(o1);
        } catch (Exception e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        }
        return 0;  //To change body of implemented methods use File | Settings | File Templates.
    }

    private Comparable getComparable(T o1) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {

        if(!(o1 instanceof Comparable)){
           Method m =   o1.getClass().getMethod("methodName",new Class[]{});
           Object obj = m.invoke(o1,new Class[]{});
           return (Comparable) obj;

        }else{
          return  (Comparable)o1;
        }

    }
}