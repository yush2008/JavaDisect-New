package Exceptions;

import java.util.*;

import General.Parent1;

public class AccessModifier2 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		Set<Integer> intSet = new LinkedHashSet<Integer>();
		intSet.add(1);
		intSet.add(1);
		intSet.add(2);
		intSet.add(3);
        
		List<Integer> intlst = new LinkedList<Integer>();
		intlst.add(1);
		intlst.add(1);
		intlst.add(2);
		intlst.add(3);
		
		intlst.get(0);       
		
	}

}
interface Inter
{
public void show();	
}
abstract class Abst1 implements Inter
{
	public abstract void showAb();
}
abstract class Abst2 extends Abst1
{}