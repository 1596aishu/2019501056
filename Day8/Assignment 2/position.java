class position{
    private int row;
    private int col;
    position(final int row, final int col){
        this.row=row;
        this.col=col;
    }
    public void setRow(final int r){
        row=r;
    }
    public void setCol(final int c){
        col=c;
    }
    public int getRow(){
        return row;
    }
    public int getCol(){
        return col;
    }
}