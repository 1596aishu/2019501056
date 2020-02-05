import edu.princeton.cs.algs4.Picture;

import java.awt.Color;

public class SeamCarver {

    private static final boolean horizontal = true;
    private static final boolean vertical = false;
    private Picture picture;
    private double[] distTo;
    private int[][] edgeTo;
    public SeamCarver(Picture picture) {
        // if (picture == null) {
        //     throw new IllegalArgumentException();
        // }
        this.picture = new Picture(picture);
    }

    public Picture picture() {
        return new Picture(this.picture);
    }                          
    public int width() {
        return this.picture.width();
    }
    public int height() {
        return this.picture.height();
    }
    public double energy(int x, int y) {
        if (x == 0 || x == width() - 1 || y == height() - 1 || y == 0 ) {
            return 1000;
        }
        
        double D1 = 0.0, D2=0.0;
        Color x1    = this.picture.get(x, y + 1);
        Color x2 = this.picture.get(x, y - 1);
        Color y1   = this.picture.get(x - 1, y);
        Color y2  = this.picture.get(x + 1, y);
        D1 = Math.pow((x1.getRed() - x2.getRed()), 2) + Math.pow((x1.getGreen() - x2.getGreen()), 2) + Math.pow((x1.getBlue() - x2.getBlue()), 2);
        D2 = Math.pow((y1.getRed() - y2.getRed()), 2) + Math.pow((y1.getGreen() - y2.getGreen()), 2) + Math.pow((y1.getBlue() - y2.getBlue()), 2);
        return Math.sqrt(D1 + D2);
    }

    public int[] findHorizontalSeam() {
        return seam(horizontal);
    }

    public int[] findVerticalSeam() {
        return seam(vertical);
    }

    private int[] seam(boolean axis) {
        if(axis == vertical) this.distTo = new double[this.width()];
        else this.distTo = new double[this.height()];

        this.edgeTo = new int[this.width()][this.height()];
        int var1, var2;
        
        for (int i = 0; i < this.distTo.length; i++) {
            this.distTo[i] = 1000;
        }
        if(axis == vertical) {
            var1 = this.height();
            var2 = this.width();
        }
        else {
            var1 = this.width();
            var2 = this.height();
        }
        for (int i = 1; i < var1; i++) {
            double[] lastDistTo = this.distTo.clone();
            for (int k = 0; k < this.distTo.length; k++) {
                this.distTo[k] = Double.POSITIVE_INFINITY;
            }
            for (int j = 1; j < var2; j++) {
                int x = (axis == vertical) ? j : i;
                int y = (axis == vertical) ? i : j;
                double energy = energy(x, y);
                relax(j - 1, x, y, energy, lastDistTo, axis);
                relax(j, x, y, energy, lastDistTo, axis);
                relax(j + 1, x, y, energy, lastDistTo, axis);
            }
        }
        double minWeight = Double.POSITIVE_INFINITY;
        int min = 0;
        for (int i = 0; i < this.distTo.length; i++) {
            double weight = this.distTo[i];
            if (weight < minWeight) {
                min = i;
                minWeight = weight;
            }
        }
        int[] seam = (axis == vertical) ? new int[this.height()] : new int[this.width()];
        if (axis == vertical) {
            for (int y = this.height() - 1; y >= 0; y--) {
                seam[y] = min;
                min = edgeTo[min][y];
            }
        } else {
            for (int x = this.width() - 1; x >= 0; x--) {
                seam[x] = min;
                min = edgeTo[x][min];
            }
        }
        return seam;
    }
    private void relax(int prev, int x, int y, double energy, double[] lastDistTo, boolean axis) {
        if (prev < 0 || prev >= lastDistTo.length) {
            return;
        }
        double weight = lastDistTo[prev];
        int index = (axis == vertical) ? x : y;
        if (this.distTo[index] > weight + energy) {
            this.distTo[index] = weight + energy;
            this.edgeTo[x][y] = prev;
        }
    }
    public void removeVerticalSeam(int[] seam) {
        if(seam == null) {
            throw new IllegalArgumentException();
        }
        Picture pic1 = new Picture(width()-1, height());
        Color color;
        int col;
        for (int j = 0; j < height(); j++)
        {
           for (int i = 0; i < width(); i++)            
           {
                if (i == seam[j])
                    continue;
                color = this.picture.get(i, j);
                col = i;
                if (i > seam[j])
                    col--;
                pic1.set(col, j, color);
            }
        }
        this.picture = pic1;
    }
    public void removeHorizontalSeam(int[] seam) {
        if(seam == null) {
            throw new IllegalArgumentException();
        }
        Picture pic2 = new Picture(width(), height()-1);
        Color color;
        int row;
        for (int j = 0; j < width(); j++)
        {
            for (int i = 0; i < height(); i++)            
            {
                if (i == seam[j])
                    continue;
                    color = this.picture.get(j, i);
                    row = i;
                    if (i > seam[j])
                        row--;
                    pic2.set(j, row, color);
            }
        }
        this.picture = pic2;
    }
}
