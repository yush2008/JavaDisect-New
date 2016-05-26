package p1;

import java.sql.SQLException;
import java.util.*;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.ScheduledThreadPoolExecutor;

public class OverrideMain {
	public static void main(String[] args) {

		
		
		Par c1 = new chld(10, 12);
		c1.show();
		
		Map<String,String> ht = new Hashtable<String,String>();

		ExecutorService executor = new ScheduledThreadPoolExecutor(5);

		
	}

}

interface Inter
{
	final int x=10;
public void show(int x) throws Exception;	
}
abstract class Abs implements Inter 
{
	public void disp(){}
	
}
class Impl extends Abs
{

	public void disp(){
		
	}
	
	@Override
	public void show(int X) {
		// TODO Auto-generated method stub
		
	}}

class Def
{
	public Def()
	{
		super();
	}
}

abstract class Abs2 extends Def
{
	
}
abstract class Abs3 extends Par
{

	public Abs3(int x) {
		super(x);
		// TODO Auto-generated constructor stub
	}
}
class Par
{
private int x=0;
private int y=0;

public Par(int x) {
	super();
	this.x = x;
}

public Par(int x, int y) {
	super();
	this.x = x;
	this.y = y;
	disp();
}	
	public void disp()
	{
		System.out.println("Super");
	}
	public int disp(int x)
	{
		System.out.println("Super");
		return 0;
	}

public void show()
{
	
}

}


class chld extends Par
{

	public void Par(int x)
	{
		int xt=10;
	}
	public chld(int x, int y) {
		super(x, y);
		// TODO Auto-generated constructor stub
	}
	public void disp()
	{
		System.out.println("Sub");
	}
	public void show()
	{
//		super.disp();
		
	}
	
}
