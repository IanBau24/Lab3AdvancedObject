import java.util.Scanner;


public class Runner{
    public static void readUser(){
        Scanner scan = new Scanner(System.in);
        // per lab specifications, the user must input 6 chesspieces
        Chesspiece[] array = new Chesspiece[6];
        // read user input and fill chesspiece array

        for (int i = 0; i < 6; i++){
            Enums.PieceType piece = null;

            // use enum to verify user input
            while (piece == null){
                System.out.println("Enter chess piece " + (i + 1) + "/6. PAWN,ROOK,KNIGHT etc.");

                try {
                    // save cleaned input to piece type using enums for the 
                    piece = Enums.PieceType.valueOf(scan.nextLine().trim().toUpperCase());                 
                } catch (IllegalArgumentException e) {
                    System.out.println("Not valid chess piece, try again");
                }
            }
            System.out.println("Sucess done piece " + (i + 1));
            
        }
    }


    public static void main(String[] args){
        readUser();    
    }
}