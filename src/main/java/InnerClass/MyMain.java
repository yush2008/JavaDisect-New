package InnerClass;

import java.util.*;

//import InnerClass.SuperAPI.SuperAPIInnerPro;
//import InnerClass.SuperAPI.SuperAPIInnerPub;

public class MyMain {

	private static final String A = "A";

	public static void main(String[] args) {

		int arr[] = {8, 3, 2, 2, 1};
		
		for(int i = 0; i < arr.length; i++)
		  {
		    if(arr[Math.abs(arr[i])] > 0)
		      arr[Math.abs(arr[i])] = -arr[Math.abs(arr[i])];
		    else
		      System.out.println(Math.abs(arr[i]));
		  }    
		
		
		System.out.println(arr[10]);
		
		
		//SuperAPI sup = new SuperAPI();
		SuperApiSub sub = new SuperApiSub();
		sub.show();
		
		//SuperAPIInnerPub supinrpub = sup.new SuperAPIInnerPub ();
		//SuperAPIInnerPro supinrpro = sup.new SuperAPIInnerPro ();
	
		
	List<String> strLst = new ArrayList<String>();
	strLst.add(A);
	strLst.add(A);
	strLst.add(A);
	
	System.out.println(strLst.toString());
	}

}
