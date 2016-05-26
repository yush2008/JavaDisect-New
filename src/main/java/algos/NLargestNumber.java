package algos;

public class NLargestNumber {

	/**
	 * Find the 3 largest elements of the array.
	 * @param args
	 */
	public static void main(String[] args) {

		Integer[] intArr = {3,5,4,12,67,14,16,1,19,6};
        int a=0, b=0, c=intArr[0];
        for(int i=0; i<intArr.length-1; i++){
        	if(c<intArr[i+1]){
        		a=b;
        		b=c;
        		c=intArr[i+1];
        	}
        }
		System.out.println(a+":"+b+":"+c);
	}

}
