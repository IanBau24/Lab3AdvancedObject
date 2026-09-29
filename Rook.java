/**
 * Represents a Rook chess piece.
 * Inherits from Chesspiece class
 * @author Ismael Renova
 * @version 1.0.0
 * @since 2026-09-26
 * @updates: 2026-09-26 Updated Rook skeleton and filled it out.
 */
public class Rook extends Chesspiece{

    public Rook() {
        this.pieceName = "ROOK";
        this.color = "WHITE";
        this.posX = 'a';
        this.posY = 1;
    }

    public Rook(String pieceName, String color, char posX, int posY){
        super(pieceName, color, posX, posY); //call chesspiece constructor and fills it out from there
    }
    /**
     * Checks whether the Rook can move to the target position.
     *
     * The Rook must remain in the same row or same column.
     *
     * @param newPosX target column
     * @param newPosY target row
     * @return true if the Rook can move to the target position
     */
    @Override
    public boolean isValid(char newPosx, int newPosY){

        return (this.posX == newPosx || this.posY == newPosY); // Checks if the rook only moves one direction
    }
}
