package StaticFactoryTest;

import java.util.HashSet;
import java.util.Set;

public class StatClass {

	public static void statShow(){
		System.out.println("Super static");
	}
	
	
	
	public static void main(String[] str){
        Static1 as = new Static1();




        Set<String> set = new HashSet<String>();
		set.add("Hello");
		set.add(null);
		set.add("Hello");
		set.add(null);
		
		for(String s : set){
			System.out.println(s);
		}
		
		System.out.println(set.contains("Ola"));
		
	}
}
class SubClass2 extends StatClass
{
public static void show()
{
System.out.println("SubClass");	
}
public static void statShow(){
	System.out.println("Sub static");
}

}



class Static1{

    static {
        System.out.println("Static Block Execution");
    }

    {
        System.out.println("Instance block execution");
    }

    Static1(){

        System.out.println("Constructor Execution");
    }
}