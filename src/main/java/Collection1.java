import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;


public class Collection1 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		try{
		System.out.println("Try");
		System.exit(0);
		}
		catch(Exception e)
		{
			System.out.println("Catch");
		}
		finally
		{
			System.out.println("finally");
		}
		
		List<Integer> intLst = new ArrayList<Integer>();
		intLst.add(0);
		intLst.add(1);
		intLst.add(0);
		intLst.add(1);
		intLst.add(0);
		intLst.add(1);
		intLst.add(0);
		intLst.add(1);
		intLst.add(0);
		
		Collections.sort(intLst);
		
		for(Iterator i = intLst.iterator();i.hasNext();)
			System.out.println(i.next());
		
		
		
		List<Employee> empLst = new LinkedList<Employee>();
		empLst.add(new Employee(57));
		empLst.add(new Employee(23));
		empLst.add(new Employee(45));
		empLst.add(new Employee(78));
		
		Collections.sort(empLst, new Comparator<Employee>() {

			@Override
			public int compare(Employee o1, Employee o2) {
				return o1.getAge().compareTo(o2.getAge());
			}
			
			
		});
		
		
	}
	
	
	
	
	private static String getCredit(String responce) {
		
		return responce.split("#")[0];

	}
	
	

}

class Employee //implements Comparable<Employee>
{
  Integer age;	
  
  public Integer getAge() {
	return age;
}

public void setAge(Integer age) {
	this.age = age;
}

Employee(Integer age)
  {
	  this.age = age;
  }


public int compareTo(Employee arg0) {

	
	return this.getAge().compareTo(arg0.getAge());
}
}
