/**
 * Holds the chess piece object, constructor, attributes, setters and getters, valid check
 * 
 * @author Ian Bautista Ambriz & Ricardo Carranza
 * @version 1.0.0
 * @since 2026-09-19
 * 
 * Change Log:
 * 2026-09-19 - Set up bishop class skeleton
 * 2026-09-22 - Finished bishop class implementation, used inheritance from abstract class
 * 2026-09-29 - Refactor Bishop class to use Enums for position
 */
public class Bishop extends Chesspiece{

    public Bishop() {
        this.pieceName = "BISHOP";
        this.color = "WHITE";
        this.posX = Enums.LocationX.A;
        this.posY = 1;
    }

    /**
     * Constructor of Bishop that fills out its param.
     * @param pieceName chesspiece name
     * @param color color of piece
     * @param posX column
     * @param posY row
     */
    public Bishop(String pieceName, String color, Enums.LocationX col, int row){
        super(pieceName, color, col, row); // call chesspiece constructor and fill out fields from there
    }
    
    /**
     * Checks whether the Bishop can move to the target position.
     *
     * @param newPosX target column
     * @param newPosY target row
     * @return true if the Bishop can move to the target position
     */
    @Override
    public boolean isValid(Enums.LocationX newPosX, int newPosY){
        //? see about using enumns to permform the x check
        int x_diff = Math.abs(this.posX.ordinal() - newPosX.ordinal());
        int y_diff = Math.abs(this.posY - newPosY);
        // bishop logic checks if the piece moved the same distance along the x and y positons, or a diagonal
        return (x_diff == y_diff);
    }
}
