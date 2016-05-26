package p2;


import java.io.File;
import java.io.Serializable;

import p1.Polytest;

public class Subtest implements Cloneable
{
	public int x=10;


    public Object clone()
	{
		try 
		{
			return super.clone();
		} catch (CloneNotSupportedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
		
		
	}
	
	
	protected void show()throws ArithmeticException{
		
		System.out.println("Child");
	
	}	
	
	void testFile()
	{
		File f = new File("Faslse.txt");
		f.canExecute();
		f.delete();
		f.getAbsolutePath();
		//FileInputStream fis = new FileInputStream(f);
	}
	
}

class CloneTest implements Cloneable
{
	
}
class SerializableTest implements Serializable
{
	
}