import java.awt.Color;
public class SeamCarver {

    private static final boolean Vertical = false;
    private static final boolean Horizontal = true;
    private Picture pic;
    private int width;
    private int height;
    private double[] distanceTo;
    private int[][] edgeTo;

    public SeamCarver(Picture picture) {
        pic = new Picture(picture);
        width = pic.width();
        height = pic.height();

    }   
    public Picture picture() {
        return pic;

    }   
    public int width() {
        return width;

    }   

    public int height() {
        return height;

    }

    public double energy(int x, int y) {

        if(x < 0 || x >= width() || y < 0 || y >= height()) 
            throw new IndexOutOfBoundsException();

        if(x == 0 | y == 0 || x == width() - 1 || y == height() - 1)
            return 1000;

        double deltaX = 0.0, deltaY = 0.0;
        Color x1,x2,y1,y2;
        x1 = pic.get(x - 1, y);
        x2 = pic.get(x + 1, y);
        y1 = pic.get(x, y - 1);
        y2 = pic.get(x, y + 1);

        deltaX = Math.pow((x1.getRed() - x2.getRed()),2) + 
        Math.pow((x1.getGreen() - x2.getGreen()),2) + Math.pow((x1.getBlue() - x2.getBlue()),2);

        deltaY = Math.pow((y1.getRed() - y2.getRed()), 2) +
        Math.pow((y1.getGreen() - y2.getGreen()),2) + Math.pow((y1.getBlue() - y2.getBlue()), 2);
        return Math.sqrt(deltaX + deltaY);
    }

    public int[] findHorizontalSeam(){
        return Seam(Horizontal);
    }

    public int[] findVerticalSeam(){
        return Seam(Vertical);
    }

    private int[] Seam(boolean axis) {
        if (axis == Vertical) this.distanceTo = new double[this.width()];
        else this.distanceTo = new double[this.height()];

        this.edgeTo = new int[this.width()] [this.height()];
        int d1,d2;
        for (int i=0; i<this.distanceTo.length; i++) {
            this.distanceTo[i] = 1000;
        }

        if (axis == Vertical) {
            d1 = this.height();
            d2 = this.width();
        }
        else {
            d1 = this.width();
            d2 = this.height();
        }
        for (int i=1;i<d1;i++) {
            double[] lastdistanceTo = this.distanceTo.clone();
            for(int m = 0; m < this.distanceTo.length; m++) {
                this.distanceTo[m] = Double.POSITIVE_INFINITY;
            }
            int x, y;
            for(int j=1; j<d2; j++){
                if(axis == Vertical){
                    x = j;
                    y = i;
                }
                else{
                    x = i;
                    y = j;
                }
                double energy = energy(x, y);
                relax (j-1, x, y, energy, lastdistanceTo, axis);
                relax (j, x, y, energy, lastdistanceTo, axis);
                relax (j+1, x, y, energy, lastdistanceTo, axis);
            }
        }
        double minimumWeight = Double.POSITIVE_INFINITY;
        int minimum = 0;
        for (int i = 0; i < this.distanceTo.length; i++) {
            double weight = this.distanceTo[i];
            if (weight < minimumWeight) {
                minimum = i;
                minimumWeight = weight;
            }
        }

        int[] Seam;
        if (axis == Vertical) {
            Seam = new int[this.height()];
        }
        else {
            Seam = new int[this.width()];
        }
        if (axis==Vertical) {
            for (int K = this.height()-1; K>=0; K--) {
                Seam[K] = minimum;
                minimum = edgeTo[minimum][K];            
            }
        }
        else {
            for (int L = this.width()-1; L >= 0; L--) {
                Seam[L] = minimum;
                minimum = edgeTo[L][minimum];
            }
        }
        return Seam;
    }
    public void relax(int prev, int x, int y, double energy, double[]lastdistanceTo, boolean axis){
        if (prev < 0|| prev >= lastdistanceTo.length) {
            return;
        }
        double Weight = lastdistanceTo[prev];
        int index;
        if (axis == Vertical) index = x;
        else index = y;
        if (this.distanceTo[index] > Weight + energy) {
            this.distanceTo[index] = Weight + energy;
            this.edgeTo[x][y] = prev;
        }
    }
}