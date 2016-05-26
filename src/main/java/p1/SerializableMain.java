package p1;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class SerializableMain {

	public static void main(String args[]) throws IOException, ClassNotFoundException
	{
		Network n1 =  new Network();
		n1.name = "Before";
		
		
		Network n2 =  new Network();
		n2.name = "After";
		
		Wire w =  new Wire();
		w.name = "Other";
		
		FileOutputStream fos =  new FileOutputStream("D:\\Object.txt");
		ObjectOutputStream oos = new ObjectOutputStream(fos);
		oos.writeObject(w);

		//oos.writeObject(n1);
		//oos.writeObject(n2);R
		
		
		FileInputStream fio = new FileInputStream("D:\\Object.txt");
		ObjectInputStream ois = new ObjectInputStream(fio);

		//The order is important. Objects should be read in the same order in which they
		// are written in to the stream.
		Wire oo = (Wire)ois.readObject();
		System.out.println(oo.name);
		//System.out.println(oo.age);

		//Network n0 = (Network) ois.readObject();
		//System.out.println(n0.name);
		
		
		
		

	}
	
}
class Wire //implements Serializable
{
	
/**
	 * 
	 */
	private static final long serialVersionUID = 5164117951210475366L;
public static String name;
//protected  String age = "12";
}
class Network implements Serializable, Cloneable
{
   public static String name;	
   
   @Override
   public Object clone(){
	return null;
	
   
   }
   @Override
   public void finalize()
   {
	   
	   
   }
   
}