package StaticFactoryTest;

public class StaticFactoryMain {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		SubClass2 sb2 = new SubClass2();
		SubClass sb = new SubClass();
	}

}
class SubClass
{
public static void show()
{
System.out.println("SubClass");	
}

}