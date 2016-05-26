package SerializableMain;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class SerializableTest {

	/**
	 * @param args
	 * @throws java.io.IOException
	 * @throws java.io.FileNotFoundException
	 * @throws ClassNotFoundException
	 */
	
	/**
	 * @param args
	 * @throws java.io.FileNotFoundException
	 * @throws java.io.IOException
	 * @throws ClassNotFoundException
	 */
	
	public static void main(String[] args) throws FileNotFoundException, IOException, ClassNotFoundException {

		MSerializable s1 = new MSerializable();
		s1.traInsatnceString = "Hi";
		s1.instanceInt = 24  ;
		s1.traInstanceInt = 4;
		s1.childNonSerial = new MChildSerial("hero");
		System.out.println(s1.traStaticInt);
        //s1.traStaticInt = 23;
        //System.out.println(s1.traStaticInt);
        
		MSerializable sOne = new MSerializable();
		sOne.childNonSerial = new MChildSerial("One");

		MSerializable sTwo = new MSerializable();
		sTwo.childNonSerial = new MChildSerial("Two");

/*		ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("D:/abc.txt"));
		oos.writeObject(s1);
		// s1.setStatInt(220);
		// s1.setiIntVar(212);
		// s1.setIintVar(12);
		oos.writeObject(sOne);
		oos.writeObject(sTwo);
*/
		ObjectInputStream ois = new ObjectInputStream(new FileInputStream("D:/abc.txt"));
		MSerializable s2 = (MSerializable) ois.readObject();
        //System.out.println(s2.traInsatnceString);
        //System.out.println(s2.traInstanceInt);
        System.out.println(s2.traStaticInt);
		
	}

}

class MSerializable implements Serializable {
	static final long serialVersionUID = 1L;
	transient MChildSerial childNonSerial;
	transient static Integer traStaticInt  = 100;
	transient static String traStaticString = "World";
	transient String traInsatnceString  = "Hello";
	int instanceInt = 1;
	transient int traInstanceInt = 10;
	transient boolean traInstanceBoolean = true;
}

class MChildSerial {
	String name;

	public MChildSerial(String name) {
		this.name = name;
	}
}