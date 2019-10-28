
public class Factorial {

    /**
     * This method finds the factorial of a value n. If n is in the range of 
     * 1 to 20 (inclusive) and retuns the factorial otherwise -1
     * @param n, the integer n.
     * @return factorial of n if n is in 1 to 20 (inclusive) and -1 otherwise.
     */
    public static long factorial(int n) {
        if (n>=1 && n<=20)
        { long fact = 1;
           for(int i=1;i<=n;i++)
           {
                fact = fact * i;
            }   System.out.println(fact);
                return fact;
        }
        else if(n==0){
                return 1;
            }
        else{
            return -1;
        }
    }

 }