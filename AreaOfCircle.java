/**
 * This class is to find the area and perimeter of a cirlce.
 * 
 * @author Siva Sankar
 */
public class AreaOfCircle {
    
    private static final double PI = 3.14159;

    /**
     * This method calculates the area of the circle.
     * Use the PI variable defined in the line number 8.
     * 
     * @param radius, the radius of the circle
     * @return the area of the circle
     */
    public static double areaOfCircle(double radius) {
        //  Your code goes here....
        double area = PI * radius *radius;
        System.out.println("Area of circle with radius" + radius + " is: " + area);
        return(area);
    }

    /**
     * This method returns the perimiter of the circle.
     * Use the PI variable defined in the line number 8.
     * 
     * @param radius, the radius of the circle.
     * @return the perimeter of the circle.
     */
    public static double perimeterOfCircle(double radius) {
        //  Your code goes here....
        double perimeter = 2 * PI * radius;
        System.out.println("Perimeter of circle with radius" + radius + " is: " + perimeter);
        return(perimeter);
    }
    public static void main(String args[])
    {
        areaOfCircle(5);
        perimeterOfCircle(5);
    }
    
}