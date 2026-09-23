/**
 * Holds the chess piece object, constructor, attributes, setters and getters, valid check
 * 
 * @author Ian Bautista Ambriz
 * @version 1.0.0
 * @since 2026-09-14
 * 
 * Change Log:
 * 2026-09-19 - Set up bishop class skeleton
 * 2026-09-22 - Finished bishop class implementation, used inheritance from abstract class
 */
public class Bishop extends Chesspiece{

    public Bishop() {
        this.pieceName = "BISHOP";
        this.color = "WHITE";
        this.posX = 'a';
        this.posY = 1;
    }

    Bishop(String pieceName, String color, char col, int row){
        this.pieceName = pieceName;
        this.color = color;
        this.posX = col;
        this.posY = row;
    }
    
    @Override 
    public boolean isValid(char newPosX, int newPosY){
        // see about using enumns to permform the x check
        int x_diff = Math.abs(this.posX - newPosX);
        int y_diff = Math.abs(this.posY - newPosY);
        // bishop logic checks if the piece moved the same distance along the x and y positons, or a diagonal
        return (x_diff == y_diff);
    }
}