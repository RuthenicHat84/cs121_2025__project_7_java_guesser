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
* public static void main()
* public Guesser (constructor)
* public void Menu()
* public bool Computer (computer generated number)
* public bool Human (human generated number)

### Aditional Flourishes
* use of Thread to add in delays to certain parts of the program. For aesthetics (called "pause(n)" in the program), where n is number of ms the program waits for).


## Menu()
* Creates a UI for users, and calls the programs.
```
    bool runMenu set to true
    while runMenu:
        print menu options and instructions
        get input from user
        if input is 1:
            bool runGame = true
            Computer()
            while (runGame):
                boolean continuePlaying set to Computer()
                if continuePlaying returns false:
                    runGame = false
        if input is 2:
            bool runGame = true
            Human()
            while (runGame):
                boolean continuePlaying set to the value of Human()
                if continuePlaying returns false:
                    runGame = false
        if input is 'q' or 'quit':
            isRunning = false

    when program is about to be terminated, close Scanner
```

## Computer()
* Computer generates a number 1-100. User tries to guess it. Computer provides feedback.
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
                    return true (so game loops until user quits)
            catch NumberFormatException: (this is so it won't accept non-number answers)
                    print "try again"

```

## Human()
* User Thinks of Number and Computer Guesses it. User provides feedback.
```
double lower bound = 1
double upper bound = 100
double guess = 50

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
                guess = (lower bound - upper bound) / 2
            if input is 'l':
                upper bound = guess - 1
                calculate guess
            if input is 'c':
                print winning message
                return true
            else:
                print error message
        catch number conversion error:
            print error message

```