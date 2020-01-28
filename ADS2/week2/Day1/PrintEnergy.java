
// import edu.princeton.cs.algs4.Picture;
// import edu.princeton.cs.algs4.StdOut;

public class PrintEnergy {

    public static void main(String[] args) {
        Picture picture = new Picture(args[0]);
        System.out.printf("image is %d pixels wide by %d pixels high.\n", picture.width(), picture.height());
        
        SeamCarver sc = new SeamCarver(picture);
        
        System.out.printf("Printing energy calculated for each pixel.\n");
        // System.out.printf("\n Printing width: " , sc.width());
        // System.out.printf("\n Printing height:" , sc.height());        

        for (int row = 0; row < sc.height(); row++) {
            for (int col = 0; col < sc.width(); col++)
            System.out.printf("%9.0f ", sc.energy(col, row));
            System.out.println();
        }
    }

}
