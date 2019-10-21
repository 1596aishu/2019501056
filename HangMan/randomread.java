// // package com.javatpoint;  
  
// import java.io.FileReader;  
// public class randomread {  
//     public static void main(String args[])throws Exception{    
//         FileReader fr=new FileReader("movies.txt");    
//         int i;    
//         while((i=fr.read())!=-1)    
//         System.out.print((char)i);
        
//         fr.close();    
//     }    
// }    


import java.util.*;
import java.io.*;

public class randomread {

    private Scanner x;
    public String[] movielist;

    public void openFile(){
      try{
        x=new Scanner(new File("movies.txt"));
      }
      catch(Exception e){
        System.out.println("Could not find file"); }}



    public void readFile(){
        String str;
        int cnt = 2;
        int i = 0;
        while(x.hasNext()){
            String a=x.nextLine();
            System.out.println(a);
            if(cnt == 2){
                movielist[i]=a;
                i++;}
            // a.replaceAll(" ","");
            a = a.replaceAll("\\s+","");
            // System.out.println(a);
            if(cnt == 7)
            cnt = 2;

        }
        System.out.println(this.movielist);
    }

    public void closeFile(){
      x.close();
    }
    public static void main(String[] args) { 
    //  movies m = new randomread();
     randomread r =new randomread();
        r.openFile();
        r.readFile();
        // r.readFile();
        r.closeFile();
    
}
}

