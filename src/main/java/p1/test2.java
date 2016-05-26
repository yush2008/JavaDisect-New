package p1;

import java.util.*;

import p2.Subtest;

public class test2 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

	
		Integer x=10;
		Integer y=10;
		
		Vector v = new Vector<Integer>();
		v.add(x);
		v.add(y);
		
		List<Integer> llist = new LinkedList<Integer>();
		llist.add(y);
		llist.add(x);
		
		
		List<Integer> list = new ArrayList<Integer>();
		list.add(x);
		list.add(y);
		
		
		if(v.equals(llist))
			System.out.println("Yes");
		else
			System.out.println("Not");

		List<String> lnkd = new LinkedList<String>();
		lnkd.add(1, "a");
		
		
		
		List<String> arr = new ArrayList<String>();
		arr.add(0, "a");
		arr.add(1, "b");
		arr.add(2, "c");
		arr.add("d");
		arr.add("e");
		arr.add(2, "rt");
		
		//arr.add(15, "fiv");


	}

}
class Pri
{
public int px=0;	
}



