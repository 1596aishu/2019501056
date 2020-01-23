import java.io.*;
import java.util.*;
 
public class Hypernym_file{
    static  ArrayList<String> key = new ArrayList<String>();
    static ArrayList<String[]> val = new ArrayList<String[]>();
    public static void main(String[] args) throws Exception {   
        
        Hypernym_file  word = new Hypernym_file();
        String file = "C:\\Users\\aishwarya\\Desktop\\2019501056\\ADS2\\Day1\\Assignment1\\wordNet\\hypernyms.txt";
        word.Hypernyms(file);
        Digraph a2 = new Digraph(key.size());
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
            In in = new In("C:\\Users\\aishwarya\\Desktop\\2019501056\\ADS2\\Day1\\Assignment1\\wordNet\\digraph1.txt");
            Digraph G = new Digraph(in);
            SAP sap = new SAP(G);
            System.out.println(sap.length(3,11) + " : " + sap.ancestor(3,11));
            // System.out.println(sap.length(3,4) + " : " + sap.ancestor(3,4));
            // System.out.println(sap.length(5,6) + " : " + sap.ancestor(5,6));
            // System.out.println(sap.length(7,8) + " : " + sap.ancestor(7,8));
    
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
        // System.out.println("Vertices : "+ c);            
    }
}