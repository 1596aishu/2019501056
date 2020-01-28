
import java.awt.Color;
public class SeamCarver {

    // create a seam carver object based on the given picture
    private Picture p;
    private int width;
    private int height;

    public SeamCarver(Picture picture) {
        p = new Picture(picture);
        width = p.width();
        height = p.height();
    }   
 
    // current picture
    public Picture picture() {
        return p;
    }   
 
    // width of current picture
    public int width() {
        return width;
    }   
 
    // height of current picture
    public int height() {
        return height;
    }
 
    // energy of pixel at column x and row y
    public double energy(int x, int y) {

        if(x < 0 || x >= width() || y < 0 || y >= height())
        throw new IndexOutOfBoundsException();

        if(x == 0 | y == 0 || x == width() - 1 || y == height() - 1) return 1000; 

        double deltaX = 0.0, deltaY = 0.0;
        Color x1,x2,y1,y2; 
        x1 = p.get(x - 1, y);
        x2 = p.get(x + 1,y);
        y1 = p.get(x, y - 1);
        y2 = p.get(x, y + 1);

        deltaX = Math.pow((x1.getRed() - x2.getRed()),2) + 
        Math.pow((x1.getGreen() - x2.getGreen()),2) + Math.pow((x1.getBlue() - x2.getBlue()), 2);

        deltaY = Math.pow((y1.getRed() - y2.getRed()), 2) +
        Math.pow((y1.getGreen() - y2.getGreen()),2) + Math.pow((y1.getBlue() - y2.getBlue()), 2);
        return Math.sqrt(deltaX + deltaY);
    }

     
}
 