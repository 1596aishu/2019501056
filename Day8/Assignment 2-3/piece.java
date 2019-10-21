class piece{
    boolean isValidMove (final position newPostion){
        final boolean minVal = (newPostion.getRow()>0 && newPostion.getCol()>0);
        final boolean maxVal = (newPostion.getRow()<8 && newPostion.getCol()<8);
        if(minVal && maxVal){
            return true;
        }
        else return false;
    }
}