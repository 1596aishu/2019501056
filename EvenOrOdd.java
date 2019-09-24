/**
 * Given n, return true if n is even otherwise false.
 * 
 * @author Siva Sankar
 */

public class EvenOrOdd {

    /**
     * This method returns true if it is an even number false otherwise.
     * @param n, the integer
     * @return true if n is even and false otherwise.
     */
    public static boolean evenOrOdd(int n) {
        //  Your code goes here....
        if (n%2 == 0){
            System.out.println("Even number");
            return true;
        }
        else{
            System.out.println("Odd number");
            return false;
        }        
    }
    public static void main(String args[])
    {
        evenOrOdd(2234);
        evenOrOdd(655353);
    }
}