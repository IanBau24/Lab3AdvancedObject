import java.util.Scanner;


public class Runner{
    public static void readUser(){
        Scanner scan = new Scanner(System.in);
        // per lab specifications, the user must input 6 chesspieces
        Chesspiece[] array = new Chesspiece[6];
        // read user input and fill chesspiece array

        System.out.println("Enter the piece you wanna create:");
        String piece = scan.nextLine().trim();
        System.out.println("Enter the color and position:");
        String[] input = scan.nextLine().split(","); // split the color and postion
        // ask user for target position
        String color = input[0].trim().toUpperCase();

        // get second element and trim and format to be a char
        char posX = input[1].trim().toLowerCase().charAt(0);

        int posY = Integer.parseInt(input[2].trim());

        Bishop newBishop = new Bishop("BISHOP", color, posX, posY);

        // print out results

        System.out.println("Enter the desired move position");
        input = scan.nextLine().split(",");
        posX = input[0].trim().toLowerCase().charAt(0);
        posY = Integer.parseInt(input[1].trim());
        if(newBishop.isValid(posX, posY)){
            System.out.println("Success");
        }
        else{
            System.out.println("Wrong move");
        }
        
    }


    public static void main(String[] args){
        readUser();    
    }
}