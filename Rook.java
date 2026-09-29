/**
 * Represents a Rook chess piece.
 * Inherits from Chesspiece class
 * @author Ismael Renova & Ricardo Carranza
 * @version 1.0.0
 * @since 2026-09-26
 * @updates: 2026-09-26 Updated Rook skeleton and filled it out.
 *           2026-09-29 Refactor Rook to use Enums for position
 */
public class Rook extends Chesspiece{

    public Rook() {
        this.pieceName = "ROOK";
        this.color = "WHITE";
        this.posX = Enums.LocationX.A;
        this.posY = 1;
    }

    /**
     * Constructor of Rook that fills out its param.
     * @param pieceName chesspiece name
     * @param color color of piece
     * @param posX column
     * @param posY row
     */
    public Rook(String pieceName, String color, Enums.LocationX posX, int posY){
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
    public boolean isValid(Enums.LocationX newPosx, int newPosY){

        return (this.posX.ordinal() == newPosx.ordinal() || this.posY == newPosY); // Checks if the rook only moves one direction
    }
}
