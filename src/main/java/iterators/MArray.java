package iterators;

import java.lang.reflect.Array;
import java.util.ConcurrentModificationException;

public class MArray<T> {

	private int max = 10;
	private int current = -1;
	T[] objLst = null;
	Class<T> clsObj = null;

	MArray(Class<T> clsObj) {
	    this.clsObj = clsObj;
		this.objLst = (T[])Array.newInstance(this.clsObj, max);
	}
    public void add(T item)
    {
    	if(current>=max)
    		increaseArray(objLst);
    	
    	objLst[current++]=item;
    }

    
    private void increaseArray(T[] objLst2) {
		
    	T[] tempArry = objLst2;
    	max = max*2;
    	this.objLst = (T[])Array.newInstance(this.clsObj, max);
	    for(int i=0; i<tempArry.length; i++)
	    {
	    	this.objLst[i] = tempArry[i];
	    }
    	tempArry = null;
	}
	
    public MFailFastIterator getFailFastIterator()
    {
    	return new MFailFastIterator();
    }
	
    public MFailSafeIterator getFailSafeIterator()
    {
    	return new MFailSafeIterator();
    }
    
    private class MFailFastIterator implements Iterable<T>
    {
    	private int arraySize = objLst.length;
    	private int currentIndex = 0;

		@Override
		public boolean hasNext() {
			checkForModification();
			if (arraySize > 0)
				return true;
			else
				return false;
		}

		private void checkForModification() {
			if(arraySize != objLst.length)
				throw new ConcurrentModificationException();
		}

		@Override
		public T next() {
			checkForModification();
			T item = objLst[currentIndex++];
			return item;
		}
    }
  
    private class MFailSafeIterator implements Iterable<T>
    {
    	private int arraySize = objLst.length;
    	private int currentIndex = 0;

		@Override
		public boolean hasNext() {
			if (arraySize > 0)
				return true;
			else
				return false;
		}
		@Override
		public T next() {
			T item = objLst[currentIndex++];
			return item;
		}
    }

}
