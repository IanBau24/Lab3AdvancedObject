/**
 * Represents a King chess piece.
 * 
 * The King inherits from the Queen class.
 * The King can move one space in any direction.
 * 
 * @author Ismael Renova & Ricardo Carranza
 * @version 1.0.0
 * @since 22026-09-26
 * Updates: 2026-09-19 King Skeleton
 *          2026-09-26 Updated King skeleton and inhertiance
            2026-09-29 Refactor Enums variable type for posX
 */
public class King extends Queen{
    /**
     * Empty constructor.
     */
    public King() {
        this.pieceName = "KING";
        this.color = "WHITE";
        this.posX = Enums.LocationX.A;
        this.posY = 1;
    }
     /**
     * Constructor that sets the Kings info.
     * @param pieceName name of piece
     * @param color color of piece
     * @param posX column position 
     * @param posY row position
     */

    public King(String pieceName, String color, Enums.LocationX posX, int posY){
        super(pieceName, color, posX, posY); //Grabs the chesspiece constructor and fills it out
    }

    /**
     * Checks whether the King can move to the target position.
     *
     * @param newPosX target column
     * @param newPosY target row
     * @return true if the King can move to the target position
     */
    @Override
    public boolean isValid(Enums.LocationX newPosX, int newPosY){
        int x_diff = Math.abs(this.posX.ordinal() - newPosX.ordinal());
        int y_diff = Math.abs(this.posY - newPosY);

        return (x_diff <= 1 && y_diff <= 1); // Checks if adjacent spots are open to reposition.
    }
}
