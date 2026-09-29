/**
 * Holds the chess piece object, constructor, attributes, setters and getters, valid check
 * 
 * @author Ismael Renova & Ricardo Carranza
 * @version 1.0.0
 * @since 2026-09-26
 * 
 * Change Log:
 * 2026-09-26 - setting up Queen and its inheritances to Rook.
 * 2026-09-26 - Refactor Queen class to use Enums for position
 */
public class Queen extends Rook{
    
    /**
     * Empty constructor.
     * Sets the default Queen information.
     */
    public Queen() {
        this.pieceName = "QUEEN";
        this.color = "WHITE";
        this.posX = Enums.LocationX.A;
        this.posY = 1;
    }
    
    /**
     * Constructor of Queen that fills out its param.
     * @param pieceName chesspiece name
     * @param color color of piece
     * @param posX column
     * @param posY row
     */

    public Queen (String pieceName, String color, Enums.LocationX posX, int posY){
        super(pieceName, color, posX, posY); //Gets the constructors from chesspieces and fills it out.
    }

    /**
     * Checks whether the Queen can move to the target position.
     *
     * @param newPosX target column
     * @param newPosY target row
     * @return true if the Queen can move to the target position
     */
    @Override
    public boolean isValid(Enums.LocationX newPosX, int newPosY){
        // enums on column to check
        int x_diff = Math.abs(this.posX.ordinal() - newPosX.ordinal());
        int y_diff = Math.abs(this.posY - newPosY);
        // Checks if its moving only diagonal on the x & y axis.
        return (posX.ordinal() == newPosX.ordinal() || posY == newPosY || x_diff == y_diff);
    }
}
