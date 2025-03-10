// Guesser.java
import java.util.Random;
import java.util.Scanner;

public class Guesser {

    public static void main(String[] args) {
        new Guesser();
    } // end main

    public Guesser() {
        Menu();
    } // end constructor

    public void Menu() {
        boolean runMenu = true;
        boolean runGame = true;
        Scanner menu = new Scanner(System.in); // Create scanner once

        while (runMenu) {
            System.out.println("\nWelcome to the Random Number Guesser Game!");
            System.out.println("Please Select from the Following:");
            System.out.println("1. Human Guesser");
            System.out.println("2. Computer Guesser");
            System.out.println("Type 'q' or 'quit' to Quit");
            
            String input = menu.nextLine();

            try {

                if (input.equals("1")) {
                    runGame = true;
                    System.out.println("You have selected 'Human Guesser.' Loading now.");
                    Computer(menu);  // Call HumanGuesser
                    while (runGame) {
                        boolean continuePlaying = Computer(menu);
                        if (!continuePlaying) {
                            runGame = false; // Exit back to menu
                        } // end if
                    } // end while
                } // end if
                else if (input.equals("2")) {
                    runGame = true;
                    System.out.println("You have selected 'Computer Guesser.' Loading now.");
                    Human(menu);  // Call the Computer method with Scanner
                  //System.out.println("Under Development. Try Again Later!!");
                    while (runGame) {
                        boolean continuePlaying = Human(menu);
                        if (!continuePlaying) {
                            runGame = false; // Exit back to menu
                        } // end if
                    } // end while
                } // end if
                else if (input.equals("3") || input.equals("quit") || input.equals("q")) {
                    System.out.println("Thank you for Playing!!");
                    runMenu = false;
                } // end if
                else {
                    System.out.println("Please Enter a Valid Number\n");
                } // end else
            } // end try
            catch (NumberFormatException e) { // catch num conversion error
                System.out.println("Please Enter a Valid Number\n");
            } // end catch
        } // end while

        menu.close(); // Close Scanner when program is terminated
    } // end Menu

    public boolean Computer(Scanner input) {
        Random rng = new Random();
        int randInt = rng.nextInt(100) + 1;  // rng 1-100 (had issues with generating numbers 101 and 0 before)
        System.out.println("Please Guess a Number 1-100. The Computer Will Hint 'Lower' or 'Higher.'\n");

        while(true){
            System.out.print("Please Input a Number or type 'q' to Quit: ");
            String userNum = input.nextLine();
            
            if(userNum.equals("q")){
                System.out.println("Returning to the Main Menu...");
                return false;
            }

            try {
                int userNumInt = Integer.parseInt(userNum); // Convert input to integer

                if(userNumInt > randInt){
                    System.out.println("Too High! Try Lower. . .\n");
                } // end if
                else if(userNumInt < randInt){
                    System.out.println("Too Low! Try Higher. . .\n");
                } // end if
                else{
                    System.out.println("Great Job! You guessed the number!!\n");
                    return true; // Return true to restart the game with a new number
                } // end else
            } // end try
        
            catch(NumberFormatException e){ // catch num conversion error
                System.out.println("Please Enter a Valid Number.\n");
            } // end catch
        
        } // end while
    } // end Computer




    // User Generated Numbers
    public boolean Human(Scanner input) {
        double lBound = 1;
        double uBound = 100;
        double guess = 50;
        //System.out.println("*Human Guesser mode is currently under development.");
        System.out.println("*Please Think of a Number 1-100. The Computer will Guess What it is.");
        System.out.println("*Please Respond with 'l' to Say Guess Lower, 'h' to Guess Higher, or 'c' for Correct.");
        System.out.println("*Input 'q' to Quit and Return to the Main Menu!\n");

        while(true){
            System.out.println("My Guess Is: " + Math.round(guess) + ". Is This Correct?\n");
            String user = input.nextLine();
            if(user.equals("q")){
                System.out.println("Returning to Main Menu. . .");
                return false; // return false and leave loop
            } // end if

            else{

                try{

                    if(user.equals("h")){
                        lBound = guess + 1;
                        guess = (lBound + uBound) / 2;
                    } // end if
                    else if(user.equals("l")){
                        uBound = guess - 1;
                        guess = (lBound + uBound) / 2;
                    } // end if
                    else if(user.equals("c")){
                        System.out.println("\u001B[4mOh Fun! The Number was: " + Math.round(guess) + "!\u001B[0m\n");
                        return true;
                    } // end if
                    else{
                        System.out.println("Please enter a valid input ('l' for lower, 'h' for higher, 'c' for correct, 'q' to quit).\n");
                    } // end else
                } // end try

                catch(NumberFormatException e){ // catch num conversion error
                    System.out.println("Invalid input. Please enter 'l', 'h', 'c', or 'q'.\n");
                } // end catch
            
            } // end else
        
        } // end while
    
    } // end Human
} // end Guesser Class