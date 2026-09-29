import java.util.Scanner;

/**
 * Holds the chess piece object, constructor, attributes, setters and getters, valid check
 * 
 * @author Ian Bautista Ambriz & Ricardo Carranza
 * @version 1.0.0
 * @since 2026-09-19
 * 
 * Change Log:
 * 2026-09-19 - Set up class and did skeleton
 * 2026-09-22 - Worked on simple implementations without error handling
 * 2026-09-28 - Finished error handling and looping
 * 2026-09-29 - Refactor Runner.java for improved input handling. Added functionality for enumerated column positions and prohibiting user from repeating chesspiece types..
 */
public class Runner{
    public static void readUser(){
        Scanner scan = new Scanner(System.in);
        // per lab specifications, the user must input 6 chesspieces
        Chesspiece[] array = new Chesspiece[6];
        // read user input and fill chesspiece array

        // run six times to fill array
        for (int i = 0; i < 6; i++){
            Enums.PieceType piece = null;

            // use enum to verify user input
            boolean repeatedPiece= true;
            while (piece == null || repeatedPiece){
                System.out.println("Enter chess piece " + (i + 1) + "/6. PAWN,ROOK,KNIGHT etc.");

                try {
                    // save cleaned input to piece type using enums for the piece type format
                    piece = Enums.PieceType.valueOf(scan.nextLine().trim().toUpperCase());
                } catch (IllegalArgumentException e) {
                    System.out.println("Not valid chess piece, try again");
                }
                // makes sure pieces don't repeat.
                repeatedPiece=false;
                for (int j = 0; j < i; j++){
                    if (piece!=null && array[j].getPieceName().toUpperCase()==piece.name()){
                        repeatedPiece=true;
                        System.out.println("You have already included the " + piece.name().toLowerCase() + " chess piece. Please select another piece you have not selected already.");
                        break;
                    }
                }
            }

            // ask for a color, keep looping until the user types WHITE or BLACK
            String color = null;
            while (color == null){
                System.out.println("Enter the color of the piece (WHITE or BLACK):");
                String input = scan.nextLine().trim().toUpperCase();

                if (input.equals("WHITE") || input.equals("BLACK")){
                    color = input;
                } else {
                    System.out.println("Not a valid color, try again");
                }
            }

            // ask for a starting position, keep looping until it is actually on the board
            Enums.LocationX startCol = null;
            int startRow = 0;
            boolean validStart = false;
            while (!validStart){
                System.out.println("Enter starting column (a-h):");
                try {
                    // save cleaned input to piece type using enums for the piece type format
                    startCol = Enums.LocationX.valueOf(scan.nextLine().trim().toUpperCase());
                } catch (IllegalArgumentException e) {
                    
                }

                System.out.println("Enter starting row (1-8):");
                try {
                    startRow = Integer.parseInt(scan.nextLine().trim());
                } catch (NumberFormatException e) {
                    System.out.println("Row must be a number, try again");
                    continue; // will allow it to remain in the while loop but break out of this iteration
                }

                // calls within chessboard for increased usability
                validStart = Chessboard.withinChessboard(startCol, startRow);
                if (!validStart){
                    System.out.println("That position is off the board, try again");
                }
            }

            // at this point the input is cleaned so we can create the chesspiece
            // add to array, inheritance will take care of calling the correct method
            switch (piece){
                case PAWN:
                    array[i] = new Pawn(piece.toString(), color, startCol, startRow);
                    break;
                case BISHOP:
                    array[i] = new Bishop(piece.toString(), color, startCol, startRow);
                    break;
                case ROOK:
                    array[i] = new Rook(piece.toString(), color, startCol, startRow);
                    break;
                case QUEEN:
                    array[i] = new Queen(piece.toString(), color, startCol, startRow);
                    break;
                case KING:
                    array[i] = new King(piece.toString(), color, startCol, startRow);
                    break;
                case KNIGHT:
                    array[i] = new Knight(piece.toString(), color, startCol, startRow);
                    break;
            }

            System.out.println("Sucessfully created piece " + (i + 1));
        }

        // now that all 6 pieces exist, ask for a target position and validate move for each piece
        Enums.LocationX targetCol = null;
        int targetRow = 0;
        boolean validTarget = false;
        while (!validTarget){
            // loop over until a valid target is input
            System.out.println("Enter target column (a-h):");
            try {
                // save cleaned input to piece type using enums for the piece type format
                targetCol = Enums.LocationX.valueOf(scan.nextLine().trim().toUpperCase());
            } catch (IllegalArgumentException e) {
                
            }

            System.out.println("Enter target row (1-8):");
            try {
                targetRow = Integer.parseInt(scan.nextLine().trim());
            } catch (NumberFormatException e) {
                System.out.println("Row must be a number, try again");
                continue;
            }

            // reuse within chessboard method
            validTarget = Chessboard.withinChessboard(targetCol, targetRow);
            if (!validTarget){
                System.out.println("That position is off the board, try again");
            }
        }
        for (int i = 0; i < array.length; i++){
            Chesspiece current = array[i];

            // use same position from chessboard to check moves
            boolean samePosition=Chessboard.samePosition(current.getColumn(), current.getRow(), targetCol, targetRow);

            // late binding, java calls the isValid method on the chesspiece and figures out which version to use
            boolean result = current.isValid(targetCol, targetRow);

            if (result && !samePosition){
                System.out.println(current.getPieceName() + " at " + current.getColumn() + "," + current.getRow() + " can move to " + targetCol + "," + targetRow);
            } else {
                System.out.println(current.getPieceName() + " at " + current.getColumn() + "," + current.getRow() + " can NOT move to " + targetCol + "," + targetRow);
            }
        }

        scan.close();
    }

    // Main runner method just calls user input
    public static void main(String[] args){
        readUser();
    }
}
