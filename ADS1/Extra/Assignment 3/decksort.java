/*
* @author Aiswarya
* Time Complexity: N^2
*/


import java.util.Arrays;
import java.util.Collections;
import java.util.List;
/**
 * create a class called Card with suit and facevalue(fv)
 */
class card implements Comparable<card> {
    String suit;
    int fv;
    /*
     * here we create a card constructor to the class Card
     */
    public card(String suit, int fv){
        this.suit = suit;
        this.fv = fv;
    }

    // public card(String suit,int fv) {
    //     if (suit.equals("S")) {
    //         suit = "0";
    //     } else if (suit.equals("H")) {
    //         suit = "1";
    //     } else if (suit.equals("C")) {
    //         suit = "2";
    //     } else if (suit.equals("D")){
    //         suit = "3";
    //     }
    //     this.suit=suit;
    //     this.fv=fv;
    //}
    /*
    * compares the suits and facevalues and returns the values -1,0 or 1.
    */ 
        public int compareTo(card that){
        if((this.suit).compareTo(that.suit) < 0){
            return 1;
        }
        else if((this.suit).compareTo(that.suit) > 0){
            return -1;
        }
        else{
            if(this.fv > that.fv){
                return 1;
            }
            else if(this.fv < that.fv){
                return -1;
            }
        }
        return 0;
        }

    /*
     * return the string  
     */
        public String toString(){
            return this.suit + this.fv;
        }
}

class decksort {
    /*
    * sorts the given cards based on compareTo.
    */
    public card[] insertionSort(card[] arr){
        for(int i=0; i<arr.length;i++){
            for(int j=i; j>0 && arr[j].compareTo(arr[j-1]) < 0;j--){
                card temp=arr[j];
                arr[j]=arr[j-1];
                arr[j-1]=temp;
            }
        }
        // System.out.println(Arrays.toString(arr));
        return arr;
    }


    public static void main(String[] args) {
        int[] fv ={1,2,3,4,5,6,7,8,9,10,11,12,13};
        String[] suit={"S","H","C","D"};
        card[] arr = new card[52];
        int size=0;
        /**
         * insert the cards into the array
         */
        for(int i=0;i<suit.length;i++){
            for(int j=0;j<fv.length;j++){
                arr[size++] = new card(suit[i],fv[j]);
            }
        }
        // System.out.println(Arrays.toString(arr));
        decksort d = new decksort();
        List<card> deck = Arrays.asList(arr);
        Collections.shuffle(deck);
        deck.toArray(arr);
        //System.out.println(Arrays.toString(arr));
        d.insertionSort(arr);
        System.out.println(Arrays.toString(arr));

    }   
}
