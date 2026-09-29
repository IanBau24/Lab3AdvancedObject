import java.util.Scanner;

/**
 * Holds the chess piece object, constructor, attributes, setters and getters, valid check
 * 
 * @author Ian Bautista Ambriz
 * @version 1.0.0
 * @since 2026-09-19
 * 
 * Change Log:
 * 2026-09-19 - Set up class and did skeleton
 * 2026-09-22 - Worked on simple implementations without error handling
 * 2026-09-28 - Finished error handling and looping
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
            while (piece == null){
                System.out.println("Enter chess piece " + (i + 1) + "/6. PAWN,ROOK,KNIGHT etc.");

                try {
                    // save cleaned input to piece type using enums for the piece type format
                    piece = Enums.PieceType.valueOf(scan.nextLine().trim().toUpperCase());
                } catch (IllegalArgumentException e) {
                    System.out.println("Not valid chess piece, try again");
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
            char startCol = 0;
            int startRow = 0;
            boolean validStart = false;
            while (!validStart){
                System.out.println("Enter starting column (a-h):");
                startCol = scan.nextLine().trim().toLowerCase().charAt(0);

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

            System.out.println("Sucess done piece " + (i + 1));
        }

        // now that all 6 pieces exist, ask for a target position for each one and validate move
        for (int i = 0; i < array.length; i++){
            Chesspiece current = array[i];

            // use piece getters to call formatted string
            System.out.println("\nPiece " + (i + 1) + ": " + current.getPieceName() + " at " + current.getColumn() + current.getRow());

            char targetCol = 0;
            int targetRow = 0;
            boolean validTarget = false;
            while (!validTarget){
                // loop uover until a valid target is input
                System.out.println("Enter target column (a-h):");
                targetCol = scan.nextLine().trim().toLowerCase().charAt(0);

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

            // use same position from chessboard to check moves
            if (Chessboard.samePosition(current.getColumn(), current.getRow(), targetCol, targetRow)){
                System.out.println("Piece did not move, invalid move");
                continue;
            }

            // late binding, java calls the isValid method on the chesspiece and figures out which version to use
            boolean result = current.isValid(targetCol, targetRow);

            if (result){
                System.out.println("Valid move!");
            } else {
                System.out.println("Invalid move.");
            }
        }

        scan.close();
    }

    // Main runner method just calls user input
    public static void main(String[] args){
        readUser();
    }
}
