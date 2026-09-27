public class Knight extends Chesspiece{
     /**
     * Empty constructor.
     */
    public Knight() {
        this.pieceName = "KNIGHT";
        this.color = "WHITE";
        this.posX = 'a';
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
    public Knight(String pieceName, String color, char posX, int posY){
        super(pieceName, color, posX, posY); //Grabs the constructor and fills it out.
    }
    //Overrides the isValid method from chesspiece class
    @Override
    public boolean isValid(char newPosX, int newPosY){
        int x_diff = Math.abs(this.posX - newPosX);
        int y_diff = Math.abs(this.posY - newPosY);

        return((x_diff == 2 && y_diff == 1) || (x_diff == 1 && y_diff == 2)); //Able to move if its respectifully 1 and 3 spaces in either posX & posY
    }
}
