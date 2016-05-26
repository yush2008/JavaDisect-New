package algos;

import java.util.*;

public class CommonArrayElement {

	public static void main(String args[])
	{
		
		/*Integer a[] = {1,1,1,2,2,2,3,4,5,6,7};
		Integer b[] = {1,1,1,2,2,2,8,9,};;*/
		
		Integer a[] = {7,2,4,3,1,5,6};
		Integer b[] = {1,4,3,6,5,2};
		
		List<Integer> lstA = new ArrayList<Integer>(Arrays.asList(a));
		List<Integer> lstB = new ArrayList<Integer>(Arrays.asList(b));
		
		lstA.addAll(lstB);
		//Collections.sort(lstA);  //nlogn  Sorting is not needed actually
		
		int x=0;
		for(int i=0; i<lstA.size(); i++)
		{
			x^= lstA.get(i);
		}
		
		System.out.println(x);
		
		Set setA = new HashSet(lstA);
		Set setB = new HashSet(lstB);
		
		List<Integer> lstCombo1 = new ArrayList<Integer>(setA);
		List<Integer> lstCombo2 = new ArrayList<Integer>(setB);
		
		lstCombo1.addAll(lstCombo2); 
		//int x=0;
		for(int i=0; i< lstCombo1.size(); i++)
		{
			x^=lstA.get(i);
			
		}
		
		/*Set<Integer> setA = new HashSet<Integer>();
		Set<Integer> setB = new HashSet<Integer>();
		
		for(int i=0; i<a.length; i++)
		{
		    setA.add(a[i]);	
		}
		for(int i=0; i<b.length; i++)
		{
		    setB.add(b[i]);	
		}
        */		
		
	}
}
