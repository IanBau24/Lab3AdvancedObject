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
 */
public class Pawn extends Chesspiece{

    public Pawn() {
        this.pieceName = "PAWN";
        this.color = "WHITE";
        this.posX = 'a';
        this.posY = 1;
    }

    public Pawn(String pieceName, String color, char col, int row){
        super(pieceName, color, col, row); // call chesspiece constructor and fill out fields from there
    }
    
    @Override
    public boolean isValid(char newPosX, int newPosY){
        if(this.color.equals("WHITE")){
            // white pieces keep the x position and move up one row
            return (this.posX == newPosX && (this.posY + 1) == newPosY);
        }
        else{
            // black pieces keep the x position the same and move DOWN one row
            return (this.posX == newPosX && (this.posY - 1) == newPosY);
        }
    }
}
