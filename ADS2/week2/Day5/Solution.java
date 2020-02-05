import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        HashMap<String,Integer> sam = new HashMap<String,Integer>();
        String[] sample = {"B","P","F","V","C","S","K","G","J","Q","X","Z","D","T","L","M","N","R"};
        for(int i = 0;i<18;i++) {
            if(sample[i].equals("B") || sample[i].equals("P") || sample[i].equals("F") || sample[i].equals("V") ) {
                sam.put(sample[i],1);
            }
            if(sample[i].equals("C") || sample[i].equals("S") || sample[i].equals("K") || sample[i].equals("G") || sample[i].equals("J") || sample[i].equals("Q") || sample[i].equals("X") || sample[i].equals("Z") ) {
                sam.put(sample[i],2);
            }
            if(sample[i].equals("D") || sample[i].equals("T")  ) {
                sam.put(sample[i],3);
            }
            if(sample[i].equals("L")  ) {
                sam.put(sample[i],4);
            }
            if(sample[i].equals("M") || sample[i].equals("N")  ) {
                sam.put(sample[i],5);
            }
            if(sample[i].equals("R") ) {
                sam.put(sample[i],6);
            }
        }
        while(sc.hasNextLine()) {
            String str = sc.nextLine();
            String[] st = str.split("");
            String st1 = st[0];
            int j = 0;
            System.out.print(str + ";" + st[0]);
            Set<String> keys = sam.keySet();
            for(int k = 1; k < st.length; k++) {
                for(String i: keys) {
                    if(!(sam.get(st[k]) == sam.get(st1))){
                        if(st[k].equals(i)) {
                            System.out.print(sam.get(i));
                            j++;
                            break;
                        }
                    }
                }
                st1 = st[k];
                if(j == 3){break;}
            }
            // while(j < 3){
            //     System.out.print("0");
            //     j++;
            // }
            // System.out.println("");           
        }
    }
}