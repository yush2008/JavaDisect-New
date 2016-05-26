package StringWraperEquals;

public class Stringmain {

	public static void main(String[] args) {

        String s = "Hello";
        String s1 = s;
        System.out.println(s+"   "+s1);
        s1="world";
        System.out.println(s+"   "+s1);


        StringBuilder sb = new StringBuilder("Hello");
        StringBuilder sb1 = sb;
        System.out.println(sb+"   "+sb1);
        sb1=new StringBuilder("world");
        System.out.println(sb+"   "+sb1);



/*		String a = "hello";  // a points to "hello" in the string pool.
		String b = "hello";  // b points to same "hello" in the string pool.
							 //  == operator returns true if both the ref points to same memo loc.		
		if(a==b)
			System.out.println("a==b is true");
		else
			System.out.println("a==b is false");
		
		if(a!=b)
			System.out.println("a!=b is true");
		else
			System.out.println("a!=b is false");
		
		if(a.equals(b))                   // is true as the internal contents of the String/Wrapper/primitive class is same
			System.out.println("a.equals(b) is true");
		else
			System.out.println("a.equals(b) is false");
*/	
	//=================================================================
	
/*		String a1 = "hello";              // a points to "hello" in the string pool.
		String b1 = new String("hello");  // b points to new String("hello") in the string pool.
		
		if(a1==b1)                        //  == operator returns false  both the ref points to diff memo loc.  
			System.out.println("a1==b1 is true");
		else
			System.out.println("a1==b1 is false");
		
		if(a1!=b1)
			System.out.println("a1!=b1 is true");
		else
			System.out.println("a1!=b1 is false");
		
		if(a1.equals(b1))               // is true if the internal contents of the String/Wrapper/primitive class is same
			System.out.println("a1.equals(b1) is true");
		else
			System.out.println("a1.equals(b1) is false");
*/
		
//============================================================		
	
	
		String a11 = new String("hello");
		String b11 = new String("hello");
		
		if(a11==b11)
			System.out.println("a1==b1 is true");
		else
			System.out.println("a1==b1 is false");
		
		if(a11!=b11)
			System.out.println("a1!=b1 is true");
		else
			System.out.println("a1!=b1 is false");
		
		if(a11.equals(b11))
			System.out.println("a1.equals(b1) is true");
		else
			System.out.println("a1.equals(b1) is false");


		//==============================================================
		
		
		StringBuffer a111 = new StringBuffer("hello");   // a points to "hello" in the string pool.
		StringBuffer b111 = new StringBuffer("hello");  // b points to new String("hello") in the string pool.
		
		if(a111==b111)                        //  == operator returns false  both the ref points to diff memo loc.  
			System.out.println("a1==b1 is true");
		else
			System.out.println("a1==b1 is false");
		
		if(a111!=b111)
			System.out.println("a1!=b1 is true");
		else
			System.out.println("a1!=b1 is false");
		
		if(a111.equals(b111))                     // is false as a1 and b1 are Objects of (Class/userdefined class). 
			                                  //Asper defaults impli, it compare the reference a1 with b1, which are different.
		{
			System.out.println("a1.equals(b1) is true");
		}else
			System.out.println("a1.equals(b1) is false");

		
	//=======================================================================================
		
/*

		
		//Integer a1 = 127 ;
		//Integer a1 = new Integer(127) ;
		Integer a1 = new Integer("127") ;  // a1 points to Integer val of "127"
		Integer b1 = 129 ;  			  // b1 points to Integer val of 127
		
		if(a1==b1)                        //  == operator returns true as both the ref points to same memo loc.  
			System.out.println("a1==b1 is true");
		else
			System.out.println("a1==b1 is false");
		
		if(a1!=b1)
			System.out.println("a1!=b1 is true");
		else
			System.out.println("a1!=b1 is false");
		
		if(a1.equals(b1))                     // id true as both objects are Wrapper class objects and equals compares  
			                                  // only values for String/primitive and wrapper objects
		{
			System.out.println("a1.equals(b1) is true");
		}else
			System.out.println("a1.equals(b1) is false");

*/

//==========================================================
		
		//Integer a1 = 129 ;
		Integer aaa1 =   127 ;
		//Integer b1 = new Integer("12") ;  // a1 points to Integer val of "127" 
        Integer bbb1 = 128  ;  			  // b1 points to Integer val of 127
		
		if(aaa1==bbb1)
			System.out.println("a1==b1 is true");
		else
			System.out.println("a1==b1 is false");
		
		if(aaa1!=bbb1)
			System.out.println("a1!=b1 is true");
		else
			System.out.println("a1!=b1 is false");
		
		if(aaa1.equals(bbb1))                     // id true as both objects are Wrapper class objects and equals compares
			                                  // only values for String/primitive and wrapper objects
		{
			System.out.println("a1.equals(b1) is true");
		}else
			System.out.println("a1.equals(b1) is false");
	
		/*
		 *  Important Note
		 * 
		 *   a1==b1 is true when a1=127; and b1=127 
		 * but
		 *   a1==b1 is false when a1=128; and b1=128
		 *  
		 *  Reason
		 *  
		 *  The "==" operator always returns true for  
		 *   following wrapper objects when their primitive values are the same
		 *   
		 *   1.  always for Boolean, Byte
		 *   2.  Character from \u0000 to \u007f     (7f is 127 in decimal)
		 *   3.  Short and Integer from -128 to 127   //reason to save memory
		 *     
		 * */
		
	
//===================================================================================
		
		
		Float a1 =  new Float(129.12) ;
		//Float a1 = new Integer(127) ;
		//Float b1 = new Integer("127") ;  // a1 points to Floatval of "127" 
		Float b1 = new Float(129.12) ;  			  // b1 points to Integer val of 127
		
		if(a1==b1)                          
			System.out.println("a1==b1 is true");
		else
			System.out.println("a1==b1 is false");
		
		if(a1!=b1)
			System.out.println("a1!=b1 is true");
		else
			System.out.println("a1!=b1 is false");
		
		if(a1.equals(b1))                     // id true as both objects are Wrapper class objects and equals compares  
			                                  // only values for String/primitive and wrapper objects
		{
			System.out.println("a1.equals(b1) is true");
		}else
			System.out.println("a1.equals(b1) is false");
		

	}


}
