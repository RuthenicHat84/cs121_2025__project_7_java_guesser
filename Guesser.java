// Guesser.java
import java.util.Random;
import java.util.Scanner;

public class Guesser {

    public static void main(String[] args){
        new Guesser(); // Creates new instance of Guesser
    } // end main

    public Guesser(){
        Menu(); // Calls Menu and starts program.
    } // end constructor

    public void Menu(){
        boolean runMenu = true;
        boolean runGame = true;
        Scanner menu = new Scanner(System.in); // Create scanner once for whole program

        while(runMenu){
            System.out.println("\033[4m" + "\n~~Welcome to the Random Number Guesser Game!~~" + "\033[0m");
            System.out.println("*Please Type the Number of the Mode You Would Like:\n");
            pause(500);
            System.out.println("1.) Human Guesser");
            pause(500);
            System.out.println("2.) Computer Guesser");
            pause(800);
            System.out.println("\nType 'q' or 'quit' to Quit");
            
            String input = menu.nextLine();

            try {

                if(input.equals("1")){
                    runGame = true;
                    System.out.println("\nYou have selected 'Human Guesser.'\nLoading now. . .");
                    pause(1000);
                    Computer(menu);  // Call Computer Method with a Scanner passed on by Menu()'s menu instead of making a brand new Scanner.
                    while (runGame) {
                        boolean continuePlaying = Computer(menu);
                        if (!continuePlaying) {
                            runGame = false;
                        } // end if
                    } // end while
                } // end if
                else if(input.equals("2")){
                    runGame = true;
                    System.out.println("\nYou have selected 'Computer Guesser.'\nLoading now. . .");
                    pause(1000);
                    Human(menu);  // Call the Human Method with a Scanner passed on by Menu()'s menu instead of making a brand new Scanner.

                    while(runGame){
                        boolean continuePlaying = Human(menu);
                        if (!continuePlaying) {
                            runGame = false; // Exit back to menu
                        } // end if
                    } // end while
                } // end if
                else if(input.equalsIgnoreCase("quit") || input.equalsIgnoreCase("q")){ // checks user input ignoring case sensitivity
                    pause(100);
                    System.out.println("\nThank you for Playing!!\n\n");
                    pause(200);
                    runMenu = false;
                } // end if
                else{
                    System.out.println("Please Enter a Valid Number\n");
                } // end else
            } // end try
            catch(NumberFormatException e){ // Catch num conversion error (catches anything that isnt a number)
                System.out.println("Please Enter a Valid Number\n");
            } // end catch
        } // end while

        menu.close(); // Close Scanner when program is about to be terminated
    } // end Menu

    public boolean Computer(Scanner input){
        Random rng = new Random();
        int randInt = rng.nextInt(100) + 1;  // Random Num Gen 1-100 (had issues with generating numbers including 0 and 101 before). Only runs once per cycle.

        System.out.println("\n\033[4m" + "~~Computer-Generated Mode!~~" + "\033[0m");
        pause(200);
        System.out.println("*Please Guess a Number 1-100. The Computer Will Hint 'Lower' or 'Higher.'");
        pause(200);
        System.out.println("*Enter 'q' to Quit. (In Some Cases May Need to Enter 'q' Twice)");
        pause(200);

        while(true){
            pause(500);
            System.out.print("\nPlease Input a Number or Type 'q' to Quit: ");
            String userNum = input.nextLine();
            
            if(userNum.equalsIgnoreCase("q")){ // Checks user input while ignoring case sensitivity for q or Q
                System.out.println("Returning to the Main Menu. . . ");
                pause(200);
                return false;
            }

            try{
                int userNumInt = Integer.parseInt(userNum); // Convert input to integer

                if(userNumInt > randInt){
                    pause(300);
                    System.out.println("Too High! Try Lower. . .\n");
                } // end if
                else if(userNumInt < randInt){
                    pause(300);
                    System.out.println("Too Low! Try Higher. . .\n");
                } // end if
                else{
                    pause(300);
                    System.out.println("Great Job! You guessed the number!!\n");
                    pause(500);
                    return true; // Return true to restart the game with a new number
                } // end else
            } // end try
        
            catch(NumberFormatException e){ // Catch incorrect input
                System.out.println("Please Enter a Valid Number.\n");
            } // end catch
        
        } // end while
    } // end Computer

    // User Generated Numbers
    public boolean Human(Scanner input){
        float lBound = 1;    // using floats for memory purposes. doubles would be better if I was using more complex decimals in the answers.
        float uBound = 100;  // using floats for memory purposes. doubles would be better if I was using more complex decimals in the answers.
        float guess = 50;    // using floats for memory purposes. doubles would be better if I was using more complex decimals in the answers.

        System.out.println("\033[4m" + "~~Computer-Guesser Mode!~~" + "\033[0m");
        pause(200);
        System.out.println("\n*Please Think of a Number 1-100. The Computer will Guess What it is.");
        pause(200);
        System.out.println("*Do Not Change Your Number After Program Has Started. . .");
        pause(200);
        System.out.println("*Please Respond with 'l' to Say Guess Lower, 'h' to Guess Higher, or 'c' for Correct.");
        pause(200);
        System.out.println("*Enter 'q' to Quit. (In Some Cases May Need to Enter 'q' Twice)");
        while(true){
            pause(500);
            System.out.println("\nMy Guess Is: " + Math.round(guess) + ". Is This Correct?\n");
            String user = input.nextLine();
            if(user.equalsIgnoreCase("q")){ // checks input ignoring case sensitivity
                System.out.println("Returning to Main Menu. . .");
                pause(200);
                return false;
            } // end if

            else{

                try{

                    if(user.equalsIgnoreCase("h")){
                        lBound = guess + 1;
                        guess = (lBound + uBound) / 2;
                    } // end if
                    else if(user.equalsIgnoreCase("l")){
                        uBound = guess - 1;
                        guess = (lBound + uBound) / 2;
                    } // end if
                    else if(user.equalsIgnoreCase("c")){
                        System.out.println("Oh Fun! The Number was: " + Math.round(guess) + "!\n");
                        pause(500);
                        return true;
                    } // end if
                    else{
                        System.out.println("Please enter a valid input ('l' for lower, 'h' for higher, 'c' for correct, 'q' to quit).\n");
                    } // end else
                } // end try

                catch(NumberFormatException e){ // Catch incorrect input
                    System.out.println("Invalid input. Please enter 'l', 'h', 'c', or 'q'.\n");
                } // end catch
            
            } // end else
        
        } // end while
    
    } // end Human

    // Makes program wait for 'n' milliseconds before continuing (1000ms = 1s). Can easily be disabled, as it is just for visuals.
    public void pause(int n){

        try{
            Thread.sleep(n); // puts program to 'sleep' for n milliseconds
        } // end try

        catch(InterruptedException e){ // If the program gets interrupted or times out, print Stack Logs
            e.printStackTrace();
        } // end catch

    } // end pause
} // end Guesser Class