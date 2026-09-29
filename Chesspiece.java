/**
 * Abstract class with some implementation to inherit to all chess pieces
 * 
 * @author Ian Bautista Ambriz & Ricardo Carranza
 * @version 1.0.0
 * @since 2026-09-19
 * 
 * Change Log:
 * 2026-09-19 - Initialized class and left skeletion
 * 2026-09-22 - Finished implementation, left abstract is valid method
 * 2026-09-29 - Refactor Chesspiece to use Enums for position
 */
abstract class Chesspiece {
    protected String pieceName;
    protected String color;
    protected Enums.LocationX posX;
    protected int posY;

    public Chesspiece() {
    }


    public Chesspiece(String pieceName, String color, Enums.LocationX col, int row){
        this.pieceName = pieceName;
        this.color = color;
        this.posX = col;
        this.posY = row;
    }

    // Getters and setters that will be inherited by child classes.
    public String getPieceName(){
        return this.pieceName;
    }

    public Enums.LocationX getColumn(){
        return this.posX;
    }

    public int getRow(){
        return this.posY;
    }

    public String getColor(){
        return this.color;
    }

    public void setColumn(Enums.LocationX posX){
        this.posX=posX;
    }

    public void setRow(int posY){
        this.posY=posY;
    }

    //abstract method
    abstract boolean isValid(Enums.LocationX newPosX, int newPosY);
}
