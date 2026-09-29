/**
 * Holds the withinChessboard method to check the bounds of any given coordinate
 * 
 * @author Ian Bautista Ambriz & Ricardo Carranza
 * @version 1.0.0
 * @since 2026-09-22
 * 
 * Change Log:
 * 2026-09-22 - Set up class reusing the code from lab 2
 * 2026-09-29 - Refactor Chessboard to use Enums for columns
 */
public class Chessboard {
    // * copied the code from the previous lab since functionality should be same

    // leave the constants as static so they can be referenced inside of the method
    private static final int MAX_ROW = 8;
    private static final int MIN_ROW = 1;
    private static final Enums.LocationX MIN_COL = Enums.LocationX.A;
    private static final Enums.LocationX MAX_COL = Enums.LocationX.H;

	// Returns true if a given position is valid. False otherwise.
    public static boolean withinChessboard(Enums.LocationX col, int row){
        // col has Enums.LocationX comparisson, row uses the constants
		return (col!=null)&&(row>=MIN_ROW && row<=MAX_ROW);
    }

    // returns true if two coordiantes are the same position, used to check if pieces remain in the same place
    public static boolean samePosition(Enums.LocationX col, int row, Enums.LocationX newCol, int newRow){
        // return true only if both row and column are the same
        return (col.ordinal() == newCol.ordinal() && row == newRow);
    }
}
