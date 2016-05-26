package collections;

import java.util.*;

/**
 * Created with IntelliJ IDEA.
 * User: pratyush
 * Date: 26/10/13
 * Time: 11:16 PM
 * To change this template use File | Settings | File Templates.
 */
public class R1 {

    public static void update(List oldLst){
        oldLst.add(new String("Hero"));
    }

    public static void main(String[] args) {

        List<Employee> empLst = new ArrayList<Employee>();
        empLst.add(new Employee(34,"Ram","223"));
        empLst.add(new Employee(34,"Ram","123"));
        empLst.add(new Employee(34,"Aam","123"));
        empLst.add(new Employee(34,"aam","123"));


        legacy(empLst);
        System.out.println(empLst);
        for(Iterator itr = empLst.iterator(); itr.hasNext();){
            System.out.println(itr.next());
        }




        List<Integer> intLst = new ArrayList<Integer>();
        for ( Iterator<Integer> iter = intLst.iterator(); iter.hasNext(); ) {
                  int x= iter.next();
        }
        List<Long> lstA = new ArrayList<Long>();
        lstA.add(12l);
        update(lstA);
        System.out.println(lstA);

        Set empSet = new TreeSet();
        //empSet.add(new Employee(1, "Tumbo", "223"));
        empSet.add(1);
        empSet.add("1");

        //Boxing
        Set<Long> longSet = new HashSet<Long>();
        longSet.add(123l);

        Integer[] ax = new Integer[10];
        ax[3]=123;
        ax[6]=666 ;

        System.out.println(ax[0]);
        System.out.println(1 * -1);

        Vector<Employee> empVect = new Vector<Employee>();
        empVect.add(new Employee(34,"Ram","223"));
        empVect.add(new Employee(34,"Ram","123"));
        empVect.add(new Employee(34,"Aam","123"));
        empVect.add(new Employee(34,"aam","123"));



        Employee[] empArr = new Employee[4];
        empArr = (Employee[])empLst.toArray(empArr);
        empArr[0]= new Employee(1,"Sudesh","223");
        empArr[1]= new Employee(2,"Krishna","223");
        empArr[2]= new Employee(3,"Billo","223");

        List<Employee> empLLst = Arrays.asList(empArr);
        empLLst.set(0, new Employee(1, "Tumbo", "223"));
        empLLst.set(1, new Employee(1, "Bumbo", "223"));
        empLLst.set(2, new Employee(1, "Achumbo", "223"));

        System.out.println(empLst);

        System.out.println(empArr);

        /*Enumeration en = empVect.elements();
        while(en.hasMoreElements()){
            en.nextElement();
        }

        Iterator it = empLst.iterator();

*/

        Collections.sort(empLst, new Comparator<Employee>() {
            @Override
            public int compare(Employee o1, Employee o2) {
                int state;
                if (o1.age.compareTo(o2.age) == 0)
                    if (o1.name.toLowerCase().compareTo(o2.name.toLowerCase()) == 0)
                        state = o1.id.compareTo(o2.id);

                    else
                        state = o1.name.toLowerCase().compareTo(o2.name.toLowerCase());
                else
                    state = o1.age.compareTo(o2.age);

                return state;  //To change body of implemented methods use File | Settings | File Templates.
            }
        });


        Map<String, String> ht = new HashMap<String, String>();
        //ht.put("1","one");
        ht.put(null, null);

        HashSet<String> set = new HashSet<String>();
        //
        set.add(null);
        set.add("one");
        set.add("two");
        set.add("three");
        set.add("four");
        set.add("five");
        set.add("six");


        List<String> listA = new ArrayList<String>();
        ArrayList<String> list = new ArrayList<String>();

        list.add(0, "zero");
        list.add(1, "one");
        list.add(2, "two");
        list.add(3, "three");

        listA.add(0, "ten");
        listA.add(1, "twenty");

        list.addAll(1, listA);
        System.out.println(list);

        Collections.synchronizedList(list);
        Collections.sort(list);
        list.clone();



    }

    public static void legacy(List list){

        list.add(new Integer(12));
        list.add(new String ("Hello"));
        list.add(new Float(12.21));

    }
}


class Employee {
    Integer age;
    String name;
    String id;

    Employee(Integer age, String name, String id){
        this.age = age;
        this.name = name;
        this.id = id;
    }


}