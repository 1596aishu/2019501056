import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

class movies {
    public String[] movies;
    public String[] hints;
    public String[] level;
    public String[] array;

    public String[] FileLoad{

        try{ 
            FileReader reader = new FileReader("movies.txt");
             BufferedReader br = new BufferedReader(reader);

            // read line by line
            String line;
            int index = 0;
            while ((line = br.readLine()) != null) {
                System.out.println(line);
                array[index] = line;
                index++;
            }

        } catch (IOException e) {
            System.err.format("IOException: %s%n", e);
        }
    }
}