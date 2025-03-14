# cs121_2025__project_7_java_guesser
A RNG Guesser Game Built with Java

This game is a Random Number Guessing Game that goes both ways. 
Players are given a main menu where they can select to do either Computer Generated Numbers to guess at, 
or to think of a number and have the computer guess. 
Each game is available through a main menu, 
and will continue until the user quits out themself. 
The program will then return to the main menu, 
where users are free to try a different game or quit.


### the Methods for the program are as follows:
* public static void main() - makes new instance of Guesser()
* public Guesser() - constructor
* public void Menu() - controls the main and secondary ui and calls game methods
* public bool Computer(Scanner input) - computer generated number
* public bool Human(Scanner input) - human generated number
* public void pause(int n) - adds visual pauses into program using Thread class for aesthetic reasons


## Menu()
* Creates and maintains two Menu UIs for users, and calls the programs.
```
    bool runMenu set to true
    while runMenu:
        print menu options and instructions
        get input from user
        if input is 1:
            bool runGame = true
            Computer(menu) // calling the method while borrowing the Scanner 'menu'
            while (runGame):
                boolean continuePlaying set to Computer()
                if continuePlaying returns false:
                    runGame = false
        if input is 2:
            bool runGame = true
            Human(menu) // calling the method while borrowing the Scanner 'menu'
            while (runGame):
                boolean continuePlaying set to the value of Human()
                if continuePlaying returns false:
                    runGame = false
        if input is 'q' or 'quit':
            runMenu = false

    when program is about to be terminated, close Scanner
```

## bool Computer(Scanner input)
* Computer generates a number 1-100. User tries to guess it. Computer provides feedback. Scanner input taken so there aren't unnecessary scanners being made
```
    create a random number rng using Random Class when the Computer Method is called
    while (true):
        Get user input
        if user typed 'q':
            return false
        else:
            try:
                convert input into an int
                if input < number:
                    print "too high. guess lower"
                if input > number:
                    print "too low. guess higher"
                else:
                    print "correct"
                    return true  // so game loops until user quits
            catch NumberFormatException: // this is so it won't accept non-number answers
                    print "try again"

```

## bool Human(Scanner input)
* User Thinks of Number and Computer Guesses it. User provides feedback. Scanner input taken so there aren't unnecessary scanners being made
```
float lower bound = 1   // using float for better memory management.
float upper bound = 100 // using float for better memory management.
float guess = 50        // using float for better memory management.

print instructions

while(true):
    print guess
    get input from user (expecting 'h', 'l', 'c', or 'q')
    if input is 'q':
        return false
    
    else:
        try:
            if input is 'h':
                lower bound = guess + 1
                guess = (lower bound + upper bound) / 2
            if input is 'l':
                upper bound = guess - 1
                calculate guess (same as above)
            if input is 'c':
                print winning message
                return true // so game loops until user quits
            else:
                print error message
        catch number conversion error:
            print error message

```

## void pause(int n)
* Made to allow for Thread Class integration without making the program bloated.
```

try:
    Thread.sleep(n) // puts the program to sleep for n milliseconds

catch(Interrupted Exception e): // if the program gets interrupted or crashes, print out the stack log.
    e.printStackTrace

```
