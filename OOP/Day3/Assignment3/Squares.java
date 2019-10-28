/**
 * Given an array of Integers, return an array of the square
 * of each values in the array. 
 * 
 * Input : {1, 2, 3}
 * Output : {1, 4, 9}
 * 
 * @author Siva Sankar and aiswarya
 * @author Mayank
 */

public class Squares {

    /**
     * This method returns the array of ints that are squares of each element
     * in the input array.
     * 
     * @param nums, the input array.
     * 
     * @return the array of ints that are squares of each element
     * in the input array.
     * 
     */
    public static int[] squared(int[] nums) {
        //  Your code goes here.
        
        int i;
        int x = nums.length;
        int[] nums1= new int[x];
        for(i=0; i<x; i++){
            nums1[i] = nums[i]*nums[i];
        }
        return nums1;
    }
}