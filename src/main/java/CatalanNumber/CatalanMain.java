package CatalanNumber;

public class CatalanMain {

	/*
	 * Given N pair of parenthesis. Write an algorithm which would print out all
	 * possible permutations possible with those parenthesis given that
	 * parenthesis are in correct order (i.e. every open parenthesis is matched
	 * with closed parenthesis)
	 * 
	 * For .e.g. .. N =3 should give:
	 * 
	 * ()()() (()()) ()(()) (())() ((()))
	 */

	public static void main(String[] args) {

		printPermuteBracket(3,3,0,0,"");
		printPermuteDyckWords(3,3,0,0,"");
		
	}

	private static void printPermuteBracket(int openBraceAvail,int closeBraceAvail, int currOpen, int currClose,String str)
    {

		if (openBraceAvail >= 1) {

			printPermuteBracket(openBraceAvail - 1, closeBraceAvail, currOpen + 1, currClose, str + "{");

		}

		if (closeBraceAvail >= 1) 
		{

			if (currOpen - currClose >= 1) {

				if (openBraceAvail == 0 && closeBraceAvail - 1 == 0) {
					System.out.println(str + "}");
					return;
				}

				printPermuteBracket(openBraceAvail, closeBraceAvail - 1, currOpen, currClose + 1, str + "}");

			}

		}

	}

	private static void printPermuteDyckWords(int XAvail,int YAvail, int currX, int currY,String str)
    {

		if (XAvail >= 1) {

			printPermuteDyckWords(XAvail - 1, YAvail, currX + 1, currY, str + "X");

		}

		if (YAvail >= 1) 
		{

			if (currX - currY >= 1) {

				if (XAvail == 0 && YAvail - 1 == 0) {
					System.out.println(str + "Y");
					return;
				}

				printPermuteDyckWords(XAvail, YAvail - 1, currX, currY + 1, str + "Y");

			}

		}

	}

	
	
}
