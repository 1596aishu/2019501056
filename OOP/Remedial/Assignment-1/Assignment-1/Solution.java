import java.io.BufferedInputStream;
import java.util.Scanner;
import java.util.Arrays;

/**
 * Class for set.
 * @author : aiswarya
 */
class Set {
    //your code goes here...
    //Good luck :-)
    public int[] intList;
    public int size;
    public Set() {
        intList = new int[10];
        size = 0;
    }

    public int size() {
        return size;
    }

    public void resize() {
        intList = Arrays.copyOf(intList, intList.length*2);
    }

    public String toString() {
        StringBuffer sb = new StringBuffer();
        sb.append("{");
        for(int i=0; i<size-1; i++)
            sb.append(intList[i] + ",");
        sb.append(intList[size-1]);
        sb.append("}");
        return sb.toString();
    }

    public boolean contains(int item) {
        for (int i=0; i<size; i++) {
            if (intList[i] == item) {
                return true;
            }
        } return false;
    }

    public void add(int item) {
        if (size == intList.length){
            this.resize();
        }
        intList[this.size()] = item;
        size += 1;
        
    }

    public void add(int[] arr){
        if ((size+arr.length) >= intList.length){
            this.resize();
        }
        for (int i=0; i<arr.length; i++){
            intList[size] = arr[i];
            size += 1;
        }
    }

    public Set intersection(Set s){
        for(int i = 0; i<size; i++ ) {
            for(int j = 0; j<s.size; j++) {
               if(intList[i]==s.intList[j]) {
                  System.out.println(s.intList[j]);
               }
            }
        }
        return s;
    }
    public int[] retainAll(int[] arr) {
        // Set s = arr;
        for(int i = 0; i<size; i++ ) {
            for(int j = 0; j<arr.length; j++) {
               if(intList[i]==arr[j]) {
                  System.out.println(arr[j]);
               }
            }
        }
        return arr;
    }
    public int[][] cartesianProduct(Set s) {
        int[][] a = new int[size][s.size];
        for (int i = 0; i < size; i++){
            for (int j = 0; j < s.size; j++)
                // a[i][j] = Integer.parseInt(intList[i],s.intList[j]);
                // a[i][j] = s.intList[j];
                System.out.print("["+ intList[i]+", "+ s.intList[j]+"], ");
        }
        return a;
    }
    
}

/**
 * Solution class for code-eval.
 */
public final class Solution {
    /**
     * Constructs the object.
     */
    private Solution() {

    }
    /**
     * helper function to convert string input to int array.
     *
     * @param      s     { string input from test case file }
     *
     * @return     { int array from the given string }
     */
    public static int[] intArray(final String s) {
        String input = s;
        if (input.equals("[]")) {
            return new int[0];
        }
        if (s.contains("[")) {
            input = s.substring(1, s.length() - 1);
        }
        return Arrays.stream(input.split(","))
                            .mapToInt(Integer::parseInt)
                            .toArray();
    }
    /**
     * main function to execute test cases.
     *
     * @param      args  The arguments
     */
    public static void main(final String[] args) {
        // instantiate this set
        Set s = new Set();
        // code to read the test cases input file
        Scanner stdin = new Scanner(new BufferedInputStream(System.in));
        // check if there is one more line to process
        while (stdin.hasNext()) {
            // read the line
            String line = stdin.nextLine();
            // split the line using space
            String[] tokens = line.split(" ");
            // based on the list operation invoke the corresponding method
            switch (tokens[0]) {
                case "size":
                System.out.println(s.size());
                break;
                case "contains":
                System.out.println(s.contains(Integer.parseInt(tokens[1])));
                break;
                case "print":
                System.out.println(s);
                break;
                case "add":
                int[] intArray = intArray(tokens[1]);
                if (intArray.length == 1) {
                    s.add(intArray[0]);
                } else {
                    s.add(intArray);
                }
                break;
                case "intersection":
                s = new Set();
                Set t = new Set();
                intArray = intArray(tokens[1]);
                s.add(intArray);
                intArray = intArray(tokens[2]);
                t.add(intArray);
                System.out.println(s.intersection(t));
                break;
                // case "retainAll":
                // s = new Set();
                // intArray = intArray(tokens[1]);
                // s.add(intArray);
                // intArray = intArray(tokens[2]);
                // System.out.println(s.retainAll(intArray));
                // break;
                case "cartesianProduct":
                s = new Set();
                t = new Set();
                intArray = intArray(tokens[1]);
                s.add(intArray);
                intArray = intArray(tokens[2]);
                t.add(intArray);
                System.out.println(Arrays.deepToString(s.cartesianProduct(t)));
                break;
                default:
                break;
            }
        }
    }
}
