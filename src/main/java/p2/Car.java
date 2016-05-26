package p2;

import Random.Vehicle;

public abstract class Car implements Vehicle {

	private Integer privateWheels ;
	
	protected String protectedName = "Proceted";

	Car(Integer wheels)
	{
		this.privateWheels  = wheels;
		color();
	}
	
	
	@Override
	public void start() {

		System.out.println("Car Starts.");
	}

	
	public void color()
	{
		System.out.println("Abstract Color");
	}
}
