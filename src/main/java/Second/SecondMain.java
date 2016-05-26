package Second;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

import InnerClass.SuperAPI;

public class SecondMain {

	public static void main(String[] args) throws FileNotFoundException, IOException {

		SuperAPI sup =  new SuperAPI();
		
		ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("abc.txt"));
		oos.defaultWriteObject();
		
	}

}
class Object
{
	
}

final class FinalTest extends Object{


}
