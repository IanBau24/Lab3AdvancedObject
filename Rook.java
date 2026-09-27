public class Rook extends Chesspiece{

    public Rook() {
        this.pieceName = "ROOK";
        this.color = "WHITE";
        this.posX = 'a';
        this.posY = 1;
    }

    public Rook(String pieceName, String color, char posX, int posY){
        super(pieceName, color, col, row); //call chesspiece constructor and fills it out from there
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
        int x_diff = Math.abs(this.posX - newPosX);
        int y_diff = Math.abs(this.posX - newPosY);

        return (this.posX == newPosX || this.poxY == newPosY); // Checks if the rook only moves one direction
    }
}
