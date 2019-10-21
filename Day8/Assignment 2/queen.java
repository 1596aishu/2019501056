class queen extends piece{
    position pos;
    queen(){
        pos = new position(0,3);
    }
    boolean isValidMove(final position newPos){
        if(super.isValidMove(newPos)){
            if((pos.getRow()==newPos.getRow()) || (pos.getCol()==newPos.getCol())) return true;
            else if(Math.abs(pos.getRow()-newPos.getRow())==Math.abs(pos.getCol()-newPos.getCol())) return true;
            else return false;
        }
        else return false;
    }
}