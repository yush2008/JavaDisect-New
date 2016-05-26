package algos;

public class QuickSort {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

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

			while (lo < hi && arr[lo] <= mid)
				lo++;

			while (lo < hi && arr[hi] > mid)
				hi--;

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

	public static void mergeSort_srt(int array[], int lo, int n) {
		int low = lo;
		int high = n;
		if (low >= high) {
			return;
		}

		int middle = (low + high) / 2;
		mergeSort_srt(array, low, middle);
		mergeSort_srt(array, middle + 1, high);
		int end_low = middle;
		int start_high = middle + 1;
		
		while ((lo <= end_low) && (start_high <= high)) 
		{
			if (array[low] < array[start_high]) 
			{
				low++;
			} 
			else 
			{
				int Temp = array[start_high];
				
				for (int k = start_high - 1; k >= low; k--) 
				{
					array[k + 1] = array[k];
				}
				
				array[low] = Temp;
				low++;
				end_low++;
				start_high++;
			}
		}
	}
}
