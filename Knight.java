/**
 * Represents a Knight chess piece.
 * 
 * The Knight inherits from the Chesspiece class.
 * The Knight can move in an L-shape.
 * 
 * @author Ismael Renova
 * @version 1.0.0
 * @since 22026-09-26
 * Updates: 2026-09-19 Knight Skeleton
 *          2026-09-26 Updated Knight skeleton and inheritance
            2026-09-29 Refactor Knight class to use Enums for position
 */
public class Knight extends Chesspiece{
     /**
     * Empty constructor.
     */
    public Knight() {
        this.pieceName = "KNIGHT";
        this.color = "WHITE";
        this.posX = Enums.LocationX.A;
        this.posY = 1;
    }
     /**
     * Constructor that sets the Knight information parameters.
     * 
     * @param pieceName name of piece
     * @param color color of piece
     * @param posX column position 
     * @param posY row position 
     */
    public Knight(String pieceName, String color, Enums.LocationX posX, int posY){
        super(pieceName, color, posX, posY); //Grabs the chesspiece constructor and fills it out.
    }

    /**
     * Checks whether the Knight can move to the target position.
     *
     * @param newPosX target column
     * @param newPosY target row
     * @return true if the Knight can move to the target position
     */
    //Overrides the isValid method from chesspiece class
    @Override
    public boolean isValid(Enums.LocationX newPosX, int newPosY){
        int x_diff = Math.abs(this.posX.ordinal() - newPosX.ordinal());
        int y_diff = Math.abs(this.posY - newPosY);

        return((x_diff == 2 && y_diff == 1) || (x_diff == 1 && y_diff == 2)); //Able to move if its respectifully 1 and 3 spaces in either posX & posY
    }
}
