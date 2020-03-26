import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.io.File;
import java.io.FileReader;
import java.util.Scanner; 
import java.io.*;
import java.util.Arrays;
import java.io.BufferedReader;
// import java.util.Iterator; 
// import java.io.IOException;


public class Solution{
    public static void main(String[] args) throws Exception {
        // BufferedReader reader = new BufferedReader(new FileReader(""));
        // String st;
        // while ((st = reader.readLine()) != null) 
        // System.out.println(st); 
        File file = new File("C:\\Users\\aishwarya\\Desktop\\2019501056\\Remedial\\Assignment-2\\Assignment-1\\testcases\\input004.txt"); 
        Scanner sc = new Scanner(file);
        int sum = 0;
        int size = 0;
        int j = 0;
        int k = 0;
        int[] answers1 = new int[100];
        int[] answers2 = new int[100];
        int[] answers3 = new int[100];
        int[] arr1 = new int[100];
        int[] arr2 = new int[100];
        int[] arr3 = new int[100];
        while (sc.hasNextLine()){ 
            String s = sc.nextLine();
            if(j==0){
                String[] arr4 = s.split(" ");
                size = Integer.parseInt(arr4[1]);
            }
            else if(j>0 && j<=size){
                String[] arr5 = s.split(":");
                System.out.println(arr5[0]);
                System.out.println(arr5[1]);
                answers1[j-1] = Integer.parseInt(arr5[2]);
                answers2[j-1] = Integer.parseInt(arr5[3]);
                answers3[j-1] = Integer.parseInt(arr5[4]);
                // System.out.println(arr5[4]);
            }
            else if(j==size+1){System.out.println(s);}
            else if(j>size+1 && j<(2*size)+2){
                String[] arr6 = s.split(" ");
                int ans = Integer.parseInt(arr6[1]);
                if(answers1[k]==ans){
                    sum = sum + answers2[k];
                }
                else{
                    sum = sum + answers3[k];
                }
                k = k+1;
            }
            else{
                System.out.println(s);
                System.out.println(sum);
            }
            j++;
        }
    }
}
