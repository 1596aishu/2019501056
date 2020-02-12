import edu.princeton.cs.algs4.SET;


public class BoggleSolver {
  
    private TrieSET ts;

    public BoggleSolver(String[] dictionary) {
        this.ts = new TrieSET();
            for (String i : dictionary) {
                this.ts.add(i);
        }
    }

    // Returns the set of all valid words in the given Boggle board, as an Iterable.
    public Iterable<String> getAllValidWords(BoggleBoard board) {
        SET<String> valid = new SET<String>();

            for (int i = 0; i < board.rows(); i++) {

                for (int j = 0; j < board.cols(); j++) {

                    boolean[][] marked = new boolean[board.rows()][board.cols()];

                    collect(board, i, j, marked, "", valid);

                }

            }

            return valid;
    }

    private void collect(BoggleBoard board, int row, int col, boolean[][] marked, String prefix, SET<String> set) {
        if (marked[row][col]) {
            return;
        }

        char letters = board.getLetter(row, col);
        String word = prefix;

        if (letters == 'Q') {
            word += "QU";
        } 
        else {
            word += letters;
        }

        if (!ts.hasPrefix(word)) {
            return;
        }

        if (word.length() > 2 && ts.contains(word)) {
            set.add(word);
        }

        marked[row][col] = true;

        for (int i = -1; i <= 1; i++) {

            for (int j = -1; j <= 1; j++) {

                if (i == 0 && j == 0) {
                    continue;
                }

                if ((row + i >= 0) && (row + i < board.rows()) && (col + j >= 0) && (col + j < board.cols())) {
                    collect(board, row + i, col + j, marked, word, set);
                }
            }
        }

        marked[row][col] = false;
    }


    // Returns the score of the given word if it is in the dictionary, zero otherwise.
    // (You can assume the word contains only the uppercase letters A through Z.)
    public int scoreOf(String word) {
        if (ts.contains(word)) {
            switch (word.length()) {
                case 0:
                case 1:
                case 2: return 0;
                case 3:
                case 4: return 1;
                case 5: return 2;
                case 6: return 3;
                case 7: return 5;
                default: return 11;
            }
        } 
        else {
            return 0;
        }
    }
}