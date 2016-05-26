package General;

public class EnumTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		String str = "INDIA";
		Country cnt = Country.valueOf(str);
		
		switch(cnt)
		{
		
		case INDIA: System.out.println("indi");
		case AUSTRALIA: System.out.println("Aus");
		case ENGLAND: System.out.println("England");
		default: System.out.println(str);
		}
		
	}

}
enum Country
{
	INDIA,
 
	AUSTRALIA,
 
	ENGLAND;
 
}