package ios;

import java.io.*;

public class IOTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		try {
			//FileReader fr = new FileReader(new File("abc.txt"));

			
			FileInputStream fio = new FileInputStream(new File("D://Mama-info.txt"));
			FileReader fr = new FileReader(new File("D://Mama-info.txt"));
			
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

}
