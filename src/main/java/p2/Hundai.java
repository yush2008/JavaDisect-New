package p2;

import Random.Vehicle;

public class Hundai extends Car{

	private static Integer wheels = 4;
	private String color;
	
	public Hundai() {
		super(wheels);
	}

	public void color()
	{
		System.out.println(color);
	}

	public void hundaiFun()
	{
		System.out.println("Hundai Fun");
	}
	
	public static void main(String args[])
	{
		Vehicle hundai = new Hundai();
		
	}
}


