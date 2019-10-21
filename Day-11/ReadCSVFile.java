/**
 * Given a CSV file, we will read the data from the CSV file and parses each
 * line of the file.
 * @author: Siva Sankar
 * @author: Nemnous
 */
import java.*;
import java.util.Scanner;
import java.util.ArrayList;
import java.io.File;

/**
 * This class reads the CSV file.
 */
public class ReadCSVFile {
    /**
     * This is a static method.
     * 
     * @param fileName the name of the CSV file. Should be located in the same
     *                 directory.
     * @return null if the file cannot be read.
     */
    public static String[] readFile(String fileName) {

        ArrayList<String> lines = new ArrayList<String>();
        Scanner scan = null;
        try {
            scan = new Scanner(new File(fileName));
            while (scan.hasNext()) {
                lines.add(scan.nextLine());
            }
            String linesArray[] = lines.toArray(new String[lines.size()]);
            return linesArray;
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        } finally {
            if (scan != null)
                scan.close();
        }
        return null;
    }
}
