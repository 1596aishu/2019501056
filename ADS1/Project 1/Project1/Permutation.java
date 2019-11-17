// import edu.princeton.cs.algs4.StdIn;
// import edu.princeton.cs.algs4.StdOut;
// import java.util.NoSuchElementException;
// import java.util.stdIn;
import java.util.*;

public class Permutation
{
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        int N = Integer.parseInt(args[0]);
        RandomizedQueue<String> sub = new RandomizedQueue<String>();
   
        try
        {
            String values = sc.next();
            while(values != null)
            {
                sub.enqueue(values);
                values = sc.next();
            }
        }
        catch(NoSuchElementException e)
        {
            System.out.print(" ");
        }
        
        while(N>0)
        {
            N--;
            System.out.println(sub.dequeue());
        }
    }
}