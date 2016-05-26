package ios;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.channels.FileChannel;
import java.nio.channels.WritableByteChannel;
import java.util.Scanner;
import java.util.regex.Pattern;

public class IOMain {

	
	
	public static void main(String[] args) throws IOException {
/*
		File in = null;
		Scanner scan = null;
		int count = 0;
		try{
		 in = new File("C:/Users/lenovo/Desktop/Study/java data structures.pdf");
		 scan = new Scanner(in);
		
		while(scan.findWithinHorizon(Pattern.compile("Structure"), 0) != null){
			count++;
		}
		}finally{
			scan.close();
			System.out.println("Count:"+count);
		}*/
		
		
		//FileInputStream fI = new FileInputStream("C:/Users/lenovo/Desktop/Study/java data structures.pdf");
		//File in = new File("C:/Users/lenovo/Desktop/Study/java data structures.pdf");
		//File out = new File("C:/Users/lenovo/Desktop/Study/chumma.txt");
		/*if(!out.exists())
			out.createNewFile();
		
        FileWriter fw = new FileWriter(out);
		FileReader fr =new FileReader(in);
		char[] buffer = new char[64*1024];
		int line = 0;
		while((line=fr.read(buffer)) != -1){
			fw.write(buffer);
		}
		
		fw.close();
		fr.close();*/
		
		   int tot = 0;  
	        Pattern pattern = Pattern.compile("the");  
	        Scanner scan = new Scanner(new File("C:/Users/lenovo/Desktop/Study/chumma.txt"));
	        try {  
	            while (scan.findWithinHorizon(pattern, 0) != null)  
	                tot++;  
	        } finally {  
	            scan.close();  
	        }  
	        System.out.println("Results found: " + tot);  	
		
		/*\*/
		
	}

}
