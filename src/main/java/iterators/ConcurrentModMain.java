package iterators;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ConcurrentModMain {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		List<Integer> intLst = new ArrayList<Integer>();
		intLst.add(1);
		intLst.add(2);
		intLst.add(3);
		intLst.add(4);
		
		Adder adder = new Adder();
		adder.setIntLst(intLst);
		
		Traverser itr = new Traverser();
		itr.setIntLst(intLst);
		
		Thread t1 = new Thread(itr);
		t1.start();
		
		
		Thread t2 = new Thread(adder);
		t2.start();
	}

}

class Adder implements Runnable{
	private List<Integer> intLst = null;

	public void setIntLst(List<Integer> intLst) {
		this.intLst = intLst;
	}

	public List<Integer> getIntLst() {
		return intLst;
	}
	

	@Override
	public void run() {
        System.out.println("Adding");
		intLst.add(100);
		intLst.remove(new Integer(100));
		
	}
	
}

class Traverser implements Runnable{
	private List<Integer> intLst = null;

	public void setIntLst(List<Integer> intLst) {
		this.intLst = intLst;
	}

	public List<Integer> getIntLst() {
		return intLst;
	}
	

	@Override
	public void run() {
		System.out.println("Iterator");
		Iterator itr = intLst.iterator();
		while(itr.hasNext()){
			System.out.println(itr.next());
		}
		
	}
	
}