import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.io.File;
import java.io.FileReader;
import java.io.*;
import java.util.Arrays;
import java.io.BufferedReader;
import java.util.Iterator; 
import java.io.IOException;


public class MovieDB{
    String[] hard,medium,easy;
    // ArrayList hard = new ArrayList<String>();
    // ArrayList medium = new ArrayList<String>();
    // ArrayList easy = new ArrayList<String>();
     // take a random element from list and print them
    // Function select an element base on index  
    // and return an element 
    public void setHard(String[] h){
        this.hard=h;
    }
    public void setEasy(String[] e){
        this.easy=e;
    }
    public void setMedium(String[] m){
        this.medium=m;
    }
    public String[] getHard(){
        return this.hard;
    }
    public String[] getEasy(){
        return this.easy;
    }
    public String[] getMedium(){
        return this.medium;
    }
    public void arraysInput() 
    {
        ArrayList<String> records = new ArrayList<String>();
        try{
        BufferedReader reader = new BufferedReader(new FileReader("movies.txt"));
        String line;
        while ((line = reader.readLine()) != null)
        {
        records.add(line);
        //System.out.println(line);
        }
        reader.close();
        //System.out.println(records);
        }
        catch(IOException x){
            x.printStackTrace();
        }
        String joined = String.join(";", records);
        //System.out.println(joined);
        String[] tokens = joined.split(";");
        String sample = "";
        for(String each:tokens){
            if(each.length()>1){
            sample+=(String)each+";";
            }
            //System.out.println(each);
        }
        //System.out.println(sample);
        String[] tokens1 = sample.split(";");
        String[] h=new String[10];
        String[] m=new String[10];
        String[] e=new String[10];
        int j = 0;
        int k = 0;
        int l = 0;
        System.out.println(tokens1.length);
        for(int i =0;i<tokens1.length-3;i+=4){
            if(tokens1[i+1].equals("Easy")){
                e[j]=tokens1[i];
                j++;
            }
            else if(tokens1[i+1].equals("Medium")){
                m[k]=tokens1[i];
                k++;
            }
           else if(tokens1[i+1].equals("Hard")){
                h[l]=tokens1[i];
                l++;
            }
        }
        setHard(h);        
        System.out.println(Arrays.toString(getHard()));
        
        
        //Random rand = new Random(); 
        //return list.get(rand.nextInt(list.size())); 
    } 
    public static void main(String[] args)  {
        MovieDB b = new MovieDB();
        try{
        b.arraysInput();   
        }
        catch(ArrayIndexOutOfBoundsException x){
            x.printStackTrace();
        }
    }
}