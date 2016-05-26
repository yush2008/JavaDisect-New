package algos;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.PriorityQueue;

public class NWayMerger {

	/**
	 *   1,3,6,8,9
	 *   2,4,5,7,10,
	 *   4,8,12,14,17
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		//Sort k sorted list of size n : k = 3, n=5
		
		List<Integer> op = new ArrayList<Integer>();
		
		Integer[] a = {1,3,6,8,9};
		Integer[] b = {2,4,5,7,10};
		Integer[] c = {4,8,12,14,17};
		int k=3;
         
		PriorityQueue<Node> minHeap = new PriorityQueue<Node>();
	  	
		HashMap<Integer, ArrayList<Integer>> arrayMap = new HashMap<Integer, ArrayList<Integer>>();
		arrayMap.put(1, (ArrayList<Integer>) Arrays.asList(a));
		arrayMap.put(2, (ArrayList<Integer>) Arrays.asList(b));
		arrayMap.put(3, (ArrayList<Integer>) Arrays.asList(c));
		
		Iterator<Integer> itr = arrayMap.keySet().iterator();
		while(itr.hasNext()){
			Integer key = itr.next();
			List<Integer> lst = arrayMap.get(key);
			Integer value = lst.remove(0);
			Node node = new Node(key,value);
			minHeap.offer(node);
		}
		
		//MinHeap: 1,2,4
		
		while(!minHeap.isEmpty()){  //This loop, in worst case will run n*k times
			Node node = minHeap.poll();
			op.add(node.value);
			List<Integer> lst = arrayMap.get(node.id);
			Integer value = lst.remove(0);
			minHeap.offer(new Node(node.id,value));
			//Heapify the minHeap to get the smallest item at the top.  (logK)
		}
		//total complexity = (n*k)log(K)
	}

}
class Node{
	public Node(Integer key, Integer value2) {
      this.id = key;
      this.value = value2;
	}
	int id;
	Integer value;
}