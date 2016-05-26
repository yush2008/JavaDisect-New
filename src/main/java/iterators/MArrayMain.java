package iterators;


public class MArrayMain {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		MArray<Integer> mArray = new MArray<Integer>(Integer.class);
		mArray.add(10);
		mArray.add(20);
		mArray.add(30);
		mArray.add(40);
		
       Iterable itr = mArray.getFailFastIterator();		
		
       while(itr.hasNext())
       {
    	   System.out.println(itr.next());
       }
	}

}

