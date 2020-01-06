import java.io.*;  
public class fileReader {  
    public static void main(String args[]) throws Exception{    
          FileReader fr = new FileReader("C:\\Users\\aishwarya\\Desktop\\2019501056\\ADS2\\Day1\\Assignment1\\wordNet\\synsets.txt");    
          BufferedReader br = new BufferedReader(fr);
          String j;
          int c = 0;
        while((j = br.readLine())!=null){
            if(c<5)
                System.out.println(j);
            c = c+1;   
          }
          fr.close();    
    }    
}    