import edu.princeton.cs.algs4.Picture;

public class PrintSeams {
    private static final boolean HORIZONTAL = true;
    private static final boolean VERTICAL = false;

    private static void printSeam(SeamCarver carver, int[] seam, boolean direction) {
        double totalSeamEnergy = 0.0;

        for (int row = 0; row < carver.height(); row++) {
            for (int col = 0; col < carver.width(); col++) {
                double energy = carver.energy(col, row);
                String marker = " ";
                if ((direction == HORIZONTAL && row == seam[col]) ||
                    (direction == VERTICAL   && col == seam[row])) {
                    marker = "*";
                    totalSeamEnergy += energy;
                }
                System.out.printf("%7.2f%s ", energy, marker);
            }
            System.out.println();
        }                
        // System.out();
        System.out.printf("Total energy = %f\n", totalSeamEnergy);
    }

    public static void main(String[] args) {
        Picture picture = new Picture(args[0]);
        int removeColumns = Integer.parseInt(args[1]);
        int removeRows = Integer.parseInt(args[2]);
        System.out.printf("%s (%d-by-%d image)\n", args[0], picture.width(), picture.height());
        System.out.println();
        System.out.println("The table gives the dual-gradient energies of each pixel.");
        System.out.println("The asterisks denote a minimum energy vertical or horizontal seam.");
        System.out.println();

        SeamCarver carver = new SeamCarver(picture);
        
        System.out.printf("Vertical seam: { ");
        int[] verticalSeam = carver.findVerticalSeam();
        for (int x : verticalSeam)
            System.out.print(x + " ");
        System.out.println("}");
        printSeam(carver, verticalSeam, VERTICAL);

        System.out.printf("Horizontal seam: { ");
        int[] horizontalSeam = carver.findHorizontalSeam();
        for (int y : horizontalSeam)
            System.out.print(y + " ");
        System.out.println("}");
        printSeam(carver, horizontalSeam, HORIZONTAL);
        // Picture picture = new Picture(args[0]); 

        System.out.printf("image is %d columns by %d rows\n", picture.width(), picture.height());
        SeamCarver sc = new SeamCarver(picture);

        Stopwatch sw = new Stopwatch();

        for (int i = 0; i < removeRows; i++) {
            int[] horizontalSeam1 = sc.findHorizontalSeam();
            sc.removeHorizontalSeam(horizontalSeam1);
        }

        for (int i = 0; i < removeColumns; i++) {
            int[] verticalSeam1 = sc.findVerticalSeam();
            sc.removeVerticalSeam(verticalSeam1);
        }
        Picture outputImg = sc.picture();

        System.out.printf("new image size is %d columns by %d rows\n", sc.width(), sc.height());

        System.out.println("Resizing time: " + sw.elapsedTime() + " seconds.");
        picture.show();
        outputImg.show();

    }

}
