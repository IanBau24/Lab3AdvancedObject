

abstract class Chesspiece {
    protected String pieceName;
    protected String color;
    protected char posX;
    protected int posY;

    public Chesspiece() {
    }

    

    abstract boolean isValid();
}
