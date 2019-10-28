import java.util.Scanner;
public class Main{
    public static void main(String[] args) {
        queen q = new queen();
        Scanner myObj = new Scanner(System.in);  // Create a Scanner object
        System.out.println("Enter X value");
        int newX = myObj.nextInt();  // Read user input
        System.out.println("Enter Y value");
        int newY = myObj.nextInt();  // Read user input
        position p1 = new position(newX,newY);
        if(q.isValidMove(p1)) 
        {
            System.out.println("Yes you can move");
        }
        else
        {
            System.out.println("No you cant move");
        }
    }
}