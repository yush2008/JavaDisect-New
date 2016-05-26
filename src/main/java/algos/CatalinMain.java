package algos;

public class CatalinMain {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		printCatalan(3,3,0,0,"");
	}
	
	
	public static void printCatalan(int noOpenBaces, int noCloseBrase, int currOpen, int currClose, String str)
	{
		if(noOpenBaces>0)
			printCatalan(noOpenBaces-1, noCloseBrase, currOpen+1, currClose, str+"(");
		
		if(noCloseBrase>0 && currOpen-currClose>0)
		{
			  if(noOpenBaces == 0  && noCloseBrase-1==0)
			  {
				  str = str+")";
				  System.out.println(str);
			  }
			  else
				printCatalan(noOpenBaces, noCloseBrase-1, currOpen, currClose+1, str+")");  
		}
		
	}

}
