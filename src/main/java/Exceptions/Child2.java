package Exceptions;

import General.Parent1;

public class Child2 extends Parent1
{
	
public void pub_show()
{
	System.out.println(x);
	System.out.println(y);
	System.out.println();
	System.out.println(new Parent1().x);
	System.out.println(new Parent1());	
}

protected void pro_show()
{
	System.out.println(new Parent1().x);
	System.out.println(new Parent1());	
}

}