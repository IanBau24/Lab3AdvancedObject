
/**
 * Abstract class with some implementation to inherit to all chess pieces
 * 
 * @author Ian Bautista Ambriz
 * @version 1.0.0
 * @since 2026-09-19
 * 
 * Change Log:
 * 2026-09-19 - Initialized class and left skeletion
 * 2026-09-22 - Finished implementation, left abstract is valid method
 */
abstract class Chesspiece {
    protected String pieceName;
    protected String color;
    protected char posX;
    protected int posY;

    public Chesspiece() {
    }


    public Chesspiece(String pieceName, String color, char col, int row){
        this.pieceName = pieceName;
        this.color = color;
        this.posX = col;
        this.posY = row;
    }

    // let me know if this is how we are supposed to inherit all the setters and getters
    public String getPieceName(){
        return this.pieceName;
    }

    public char getColumn(){
        return this.posX;
    }

    public int getRow(){
        return this.posY;
    }

    public String getColor(){
        return this.color;
    }

    public void setColumn(char posX){
        this.posX=posX;
    }

    public void setRow(int posY){
        this.posY=posY;
    }

    abstract boolean isValid(char newPosX, int newPosY);
}
