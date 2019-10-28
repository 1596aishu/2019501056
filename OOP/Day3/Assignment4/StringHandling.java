/**
 * Given an array of Strings, convert each string of the array into 
 * lower case String and then return the array. 
 * 
 * Input : {"Hello", "Hi"}
 * Output : {"hello", "hi"}
 * 
 * @author Siva Sankar and aiswarya
 */

public class StringHandling {

    /**
     * This method returns the array of lower case strings.
     * @param arr, the input array.
     * @return the array of lower case Strings based on the input parameter.
     */
    public static String[] lower(String[] arr) {
        //  your code goes here....
        int i;
        String[] arr1 = new String[arr.length];
        for(i=0 ; i<arr.length;i++){
            arr1[i] = arr[i].toLowerCase();
        }
        
        return arr1;
    }
}