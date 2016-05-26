package ios;

import java.io.File;
import java.io.IOException;

/**
 * Created with IntelliJ IDEA.
 * User: pratyush
 * Date: 25/10/13
 * Time: 11:32 PM
 * To change this template use File | Settings | File Templates.
 */
public class FileCreation {


    public static void main(String[] args) {
        File dir = new File("/home/pratyush/Downloads/dir");
        dir.mkdir();
        File f1 = new File(dir, "f1.txt");
        try {
            f1.createNewFile();
        } catch (IOException e) {
            System.out.println(e);
        }
        File newDir = new File("/home/pratyush/Downloads/newDir");
        dir.renameTo(newDir);

    }

}
