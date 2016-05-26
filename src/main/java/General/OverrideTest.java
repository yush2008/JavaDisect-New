package General;

import java.io.IOException;

public class OverrideTest {

	/**
	 * @param args
	 */
	/**
	 * @param args
	 */
	public static void main(String[] args) {

		//Parent.temp.test();
		Child p = new Child();
		System.out.println(p.as);
		
		
		try {
			p.getName();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		p.protVodshow("STR");
		p.pubStcVodshow(10);
		new Child().show(20);
	}

}

class Parent
 {

	public int as=10;
	
	private void prvVoidshow(int x, int y) {
		System.out.println("Private  Show: X=" + x + " Y=" + y);
	}
	private void prvVoidshow(int x, int y, int z) {
		System.out.println("Private  Show: X=" + x + " Y=" + y);
	}

	private static void prvStcVodshow() {
		System.out.println("Private Static Show");
	}

	public static void pubStcVodshow(int x) {
		System.out.println("Public Static Show:" + x);
	}

	protected void protVodshow(String x)
	{
		System.out.println("Protected show x="+x);
	}
	
	public static void test()
	{
		//Child.show(10);
		Parent p = new Child();
		p.prvVoidshow(120, 12);
		p.protVodshow("x");
		p.prvStcVodshow();
		p.pubStcVodshow(111);
		
	}
	
	public void getName() throws Exception {
	System.out.println("Parent");	
	}
	
}

class Child extends Parent
{
	public int as=20;
	public void getName()throws IOException {
		System.out.println("Child");	
		}
	
	public void show(int x, int y) {
		System.out.println("Child:Private Static Show: X=" + x + " Y=" + y);
	}
	private static void show() {
		System.out.println("Child:Private Static Show");
	}
	public static void show(int x) {
		System.out.println("Child:Private Static Show:" + x);
	}
	protected void protVodshow(String x)
	{
		System.out.println("Child private show x="+x);
	}
}

 abstract class FinalAbstract
{
	}