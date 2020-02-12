import edu.princeton.cs.algs4.SET;


public class BoggleSolver {
  
    private TrieSET t;

    public BoggleSolver(String[] dict) {
        this.t = new TrieSET();
            for (String i : dict) {
                this.t.add(i);
        }
    }

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
        if (marked[row][col]) return;

        char letter = board.getLetter(row, col);
        String word = prefix;

        if (letter == 'Q') word += "QU";
        else word += letter;
        if (!t.hasPrefix(word)) return;
        if (word.length() > 2 && t.contains(word)) set.add(word);

        marked[row][col] = true;

        for (int i = -1; i <= 1; i++) {
            for (int j = -1; j <= 1; j++) {
                if (i == 0 && j == 0) continue;
                if ((row + i >= 0) && (row + i < board.rows()) && (col + j >= 0) && (col + j < board.cols())) {
                    collect(board, row + i, col + j, marked, word, set);
                }
            }
        }

        marked[row][col] = false;
    }

    public int scoreOf(String word) {
        if (t.contains(word)) {
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