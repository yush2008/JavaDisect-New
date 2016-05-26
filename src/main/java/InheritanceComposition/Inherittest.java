package InheritanceComposition;

public class Inherittest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Legs leg = new Legs();
		leg.setCount(10);
		
		Horse h = new Horse(leg);
        System.out.println(h.getLeg().getCount());
		leg.setCount(12);
        System.out.println(h.getLeg().getCount());
		
		Animal ah = new Horse();
		
		
		if(ah instanceof Animal){
			System.out.println("Instance of Animal");
		}
		
		if(ah instanceof Horse){
			System.out.println("Instance of Horse");
		}
		
		System.out.println(ah.getClass().equals(Horse.class));
		/*if(ah instanceof Bird){
			System.out.println("Instance of Horse");
		}*/
	}

}
class Animal{
	Animal(){
		System.out.println("Animal");
	}
}
class Horse extends Animal{
	
	Horse(Legs leg){
		super();
		this.leg = leg;
		System.out.println("Horse");
	}
	
	public Horse() {
	}

	private void setLeg(Legs leg) {
		this.leg = leg;
	}

	public Legs getLeg() {
		return leg;
	}

	private Legs leg;
	
}
class Legs{
	
	private int count = 0;

	public void setCount(int count) {
		this.count = count;
	}

	public int getCount() {
		return count;
	}
}
