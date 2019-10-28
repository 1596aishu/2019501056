/**
 * This is to check if the given position is a valid move for the Queen piece or not.
 * @author Aiswarya
 */
class Game {
    Piece[][] playBoard;
    // Constructor creates an empty playBoard
    Game() {
        playBoard = new Piece[8][8];
    }
}

class Position {
    int row;
    int column;
    // Constructor using row and column values
    Position() {
        row = 3;
        column = 9;
    }
    //parametrised constructor
    Position(int r, int c) {
        this.row = r;
        this.column = c;
    }
}

class Piece {
    Position p;
    //default constructor
    Piece() {
        p = new Position(3, 7);
    }
    // to check if the given postion is a valid move or not
    public boolean isValidMove(Position newPosition) {
        if (newPosition.row > 0 && newPosition.column > 0 && newPosition.row < 8 && newPosition.column < 8) {
            return true;
        } else {
            return false;
        }
    }
    // to move the piece to the new postion if its a valid move
    public final void move(Position newPosition) {
        if (isValidMove(newPosition)) {
            this.p= newPosition;
        }
    }
}

//inheriting the parent Piece class
class Queen extends Piece {
    Queen() {}
    //defining the valid move for the queen
    public boolean isValidMove(Position newPosition) {
        if ((newPosition.column == this.p.column) || (newPosition.row == this.p.row) ||
            (Math.abs(newPosition.column - this.p.column) == Math.abs(newPosition.row - this.p.row))) {
            return true;
        } else {
            return false;
        }
    }
}

public class Queenn {
    public static void main(String[] args) {
        //creating a object for the queen class and to check if thats valid position or not.
        Queen q = new Queen();
        Position testPosition = new Position(3, 8);
        if (q.isValidMove(testPosition)) {
            System.out.println(q.isValidMove(testPosition));
            q.move(testPosition);
        } else {
            System.out.println(q.isValidMove(testPosition));
        }
    }
}