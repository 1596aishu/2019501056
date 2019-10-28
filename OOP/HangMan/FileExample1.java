import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class FileExample1 {

    public static void main(String[] args) {
	int index = 0;
	        
		
	try{ 
            FileReader reader = new FileReader("movies.txt");
            BufferedReader br = new BufferedReader(reader);
            String[] array = new String[index];
            // read line by line
            String line;
			while ((line = br.readLine()) != null) {
                index++;
                array = new String[index];
				// System.out.println(line);
                array[index-1] = line;
                System.out.println(array[index-1]);                
            }
            for(int i=0; i<index; i++){
                System.out.println(array[i]);
            }

        } catch (IOException e) {
            System.err.format("IOException: %s%n", e);
        }
		
	}
}
