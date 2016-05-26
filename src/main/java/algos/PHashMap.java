package algos;

import java.util.*;

public class PHashMap {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		Integer arr[]= new Integer[10]; 
	}

	private Set<PEntry> entryLst = new HashSet<PEntry>();  
	private Set<KeySet> keysetLst = new HashSet<KeySet>();
	
	public void put(Object key, Object value)
	{
		PEntry entry = new PEntry(key, value);
		entryLst.add(entry);
	}
	
	class KeySet
	{
		public KeySet(Object key) {
			super();
			this.key = key;
			put(1,1);
		}

		public Object getKey() {
			return key;
		}

		public void setKey(Object key) {
			this.key = key;
		}

		Object key;
		
		
	}
	
	class PEntry
	{
		Object key;
		Object value;
		
		PEntry(Object key, Object value)
		{
			this.key = key;
			this.value = value;
		}
		
		public Object getKey()
		{
			return this.key;
			
		}
		public Object getValue()
		{
			return this.value;
			
		}
		
		public void setKey(Object key)
		{
			this.key = key;
		}
		
		public void setValue(Object value)
		{
			this.value = value;
		}
		
		
	}
	
	
	
}
