package General;

public class FinalTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		MyClass mc1 = new MyClass(10);
		mc1.setX(100);
		
		
		MyClass mc2 = new MyClass(10);
		mc2 = new MyClass(20);
		mc2.setX(100);
		
	}

}
class MyClass
{
	private int x=10;
	MyClass(final int x)
	{
		this.setX(x);
	}
	public void setX(int x) {
		this.x = x;
	}
	public int getX() {
		return x;
	}
	

}