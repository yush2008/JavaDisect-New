package threadlivelock;

public class ThreadGroupTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		ThreadGroup group = new ThreadGroup("MyGroup");
		
		
	}

}
class MyRunnable implements Runnable
{

	@Override
	public void run() {
		// TODO Auto-generated method stub
		
	}
	
}

class DVDInfo implements Comparable {   // #1
	private int age;
	private int ID;
	
	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public int getID() {
		return ID;
	}

	public void setID(int iD) {
		ID = iD;
	}

	// existing codetest
	  public int compareTo(DVDInfo d) {             
	    if(ID  < d.getID())
	    	return -1;
	    if(ID  == d.getID())
	    	return 0;
	    if(ID  > d.getID())
	    	return 1;
		return 0;
		  
	}

	@Override
	public int compareTo(Object o) {
		// TODO Auto-generated method stub
		return 0;
	} }