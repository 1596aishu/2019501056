import java.io.*;
import java.util.*;
 
public class Hypernym_file{
    static  ArrayList<String> key = new ArrayList<String>();
    static ArrayList<String[]> val = new ArrayList<String[]>();
    public static void main(String[] args) throws Exception {   
        
        Hypernym_file  word = new Hypernym_file();
        String file = "C:\\Users\\aishwarya\\Desktop\\2019501056\\ADS2\\Day1\\Assignment1\\wordNet\\hypernyms.txt";
        word.Hypernyms(file);
        Assignment2 a2 = new Assignment2(key.size());
        int c = 0;
        for ( int i = 0 ; i < key.size(); i++) {
            if(val.get(i) != null) {
                for( int j = 0 ; j< val.get(i).length;j++) {
                    int x = Integer.parseInt(key.get(i));
                    int y = Integer.parseInt(val.get(i)[j]);
                    a2.addEdge(x,y);
                    c++;
                }
            }
        }
        System.out.print("Edges : " + c);    
    }

    public void Hypernyms(String file) throws Exception {
                
        FileReader fr = new FileReader(file);
        BufferedReader br = new BufferedReader(fr);
        String data;
        int c = 0;
        while((data = br.readLine()) != null) {
                String[] str = data.split(",",2);
                c++;
                if(str.length > 1) {
                    key.add(str[0]);
                    val.add(str[1].split(","));
                }
                else {
                    key.add(str[0]);
                    val.add(null);
                }
        }
        System.out.println("Vertices : "+ c);            
    }
}