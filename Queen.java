/**
 * Holds the chess piece object, constructor, attributes, setters and getters, valid check
 * 
 * @author Ismael Renova
 * @version 1.0.0
 * @since 2026-09-26
 * 
 * Change Log:
 * 2026-09-26 - setting up Queen and its inheritances to Rook.
 */
public class Queen extends Rook{
    
    /**
     * Empty constructor.
     * Sets the default Queen information.
     */
    public Queen() {
        this.pieceName = "QUEEN";
        this.color = "WHITE";
        this.posX = 'a';
        this.poxY = 1;
    }
    
    /**
     * Constructor of Queen that fills out its param.
     * @param pieceName chesspiece name
     * @param color color of piece
     * @param posX column
     * @param posY row
     */

    public Queen (String pieceName, String color, char posX, int posY){
        super(pieceName, color, posX, posY); //Gets the constructors from chesspieces and fills it out.
    }
    //Checks rooks method and replacec with queen signature.
    @Override
    public boolean isValid(char newPosX, int newPosY){
        // enums on column to check
        int x_diff = Math.abs(this.posX - newPosX);
        int y_diff = Math.abs(this.posY - newPosY);
        // Checks if its moving only diagonal on the x & y axis.
        return (posX == newPosX || posY == newPosY || x_diff == y_diff);
    }
}
