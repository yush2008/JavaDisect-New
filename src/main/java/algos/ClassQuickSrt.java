package algos;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.TreeSet;

public class ClassQuickSrt {

	enum CoffeSize {
		BIG(10), SMALL(5), OVERWHELMING(15) {
			public String getTagline() {
				return "Best for young";
			}
		};

		private int cupsize;
		private String tagline;

		public int getCupsize() {
			return cupsize;
		}

		public String getTagline() {
			return "Smooth and good";
		}

		CoffeSize(int cupSize) {
			this.cupsize = cupSize;
		}

		private CoffeSize(int cupSize, String tag) {
			this.cupsize = cupSize;
			this.tagline = tag;
		}

	}

	static Integer i = 20;
	int x = 10;

	/**
	 * @param args
	 */
	public static void main(String args[]) {

		// int arr[] = {23,465,76,789,12,45,65,678,22,13,435,76,798,89,33};
		int arr[] = { 23, 465, 789, 12, 45, 65, 678, 22, 13, 435, 76, 798, 89, 33 };
		// int arr[] = {7,8,9,4,5,6,7};

		quickSort(arr, 0, arr.length - 1);

		for (int i = 0; i < arr.length; i++) {
			System.out.println(arr[i]);
		}

		/*
		 * List lst = new LinkedList(); lst.add(1); lst.add("String");
		 * lst.add(12.32); lst.add(1, "five"); lst.add(3, "Seven"); //
		 * System.out.println(lst.toString());
		 * 
		 * //Collections.sort(lst); Set<ClassA> strSet = new TreeSet<ClassA>();
		 * strSet.add(new ClassA()); strSet.add(new ClassA()); strSet.add(new
		 * ClassA()); strSet.add(new ClassA());
		 * 
		 * System.out.println(strSet.toString());
		 * 
		 * CoffeSize cf= CoffeSize.OVERWHELMING;
		 * System.out.println(cf.getTagline()); System.out.println(i);
		 * stcShow(i, null);
		 */

	}

	public static void quickSort(int[] arr, int low, int high) {
		int lo = low;
		int hi = high;

		if (lo >= hi)
			return;

		int mid = arr[(low + high) / 2];

		while (lo < hi) {
			if (lo >= hi)
				break;

			while (lo < hi && arr[lo] <= mid) {
				lo++;
			}

			while (lo < hi && arr[hi] > mid) {
				hi--;
			}

			if (lo < hi) {
				int T = arr[lo];
				arr[lo] = arr[hi];
				arr[hi] = T;
			}

		}

		if (lo > hi) {
			lo = lo - hi;
			hi = lo + hi;
			lo = lo - hi;
		}

		quickSort(arr, low, lo - 1);
		quickSort(arr, lo, high);

	}

	public static void stcShow(int d, String asd) {
		int x = 10;

	}

	public void show() {
		try 
		{
			stcShow(x, null);
		} 
		catch (Exception e) 
		{

		}
		
		// Double x= new Double(10);
		int x = 0;
		switch(x) {
		case 0:
			System.out.println(i);
		case 1:
		}

	}

}

class Super {
	public static void show() {
		List lst = new ArrayList();
		lst.add(1);
		lst.add("String");
		lst.add(12.32);

	}
}

class Sub extends Super {
	public static void show() {
	}
}