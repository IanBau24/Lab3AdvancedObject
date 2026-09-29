/**
 * Holds the chess piece object, constructor, attributes, setters and getters, valid check
 * 
 * @author Ian Bautista Ambriz
 * @version 1.0.0
 * @since 2026-09-25
 * 
 * Change Log:
 * 2026-09-22 - Set up pawn class skeleton
 * 2026-09-25 - Finished pawn class implementation, used inheritance from abstract class
 * 2026-09-29 - Refactor Pawn class to use Enums for position
 */
public class Pawn extends Chesspiece{

    public Pawn() {
        this.pieceName = "PAWN";
        this.color = "WHITE";
        this.posX = Enums.LocationX.A;
        this.posY = 1;
    }

    /**
     * Constructor of Pawn that fills out its param.
     * @param pieceName chesspiece name
     * @param color color of piece
     * @param posX column
     * @param posY row
     */
    public Pawn(String pieceName, String color, Enums.LocationX col, int row){
        super(pieceName, color, col, row); // call chesspiece constructor and fill out fields from there
    }
    
    /**
     * Checks whether the Pawn can move to the target position.
     *
     * @param newPosX target column
     * @param newPosY target row
     * @return true if the Pawn can move to the target position
     */
    @Override
    public boolean isValid(Enums.LocationX newPosX, int newPosY){
        if(this.color.equals("WHITE")){
            // white pieces keep the x position and move up one row
            return (this.posX.ordinal() == newPosX.ordinal() && (this.posY + 1) == newPosY);
        }
        else{
            // black pieces keep the x position the same and move DOWN one row
            return (this.posX.ordinal() == newPosX.ordinal() && (this.posY - 1) == newPosY);
        }
    }
}
