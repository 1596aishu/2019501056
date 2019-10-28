import java.util.*;
/* Hint user to enter a guess letter,
    returns 0 if letter entered is not in the word (counts as try),
    returns 1 if letter were entered 1st time (counts as try),
    returns 2 if already guessed letter was REentered,
    returns 3 if all letters were guessed */
public class user{
    public static int enterLetter(String word, char[] enteredLetters)    {
        System.out.print("(Guess) Enter a letter in word ");
        // If-clause is true if no asterisks were printed so
        // word is successfully guessed
        if (!printWord(word, enteredLetters))
            return 3;
        System.out.print(" > ");
        Scanner input = new Scanner(System.in);
        int emptyPosition = findEmptyPosition(enteredLetters);
        char userInput = input.nextLine().charAt(0);
        if (inEnteredLetters(userInput, enteredLetters)) {
            System.out.println(userInput + " is already in the word");
            return 2;
        }
        else if (word.contains(String.valueOf(userInput))) {
            enteredLetters[emptyPosition] = userInput;
            return 1;
        }
        else {
            System.out.println(userInput + " is not in the word");
            return 0;
            }
    }
    /* Check if letter is in enteredLetters array */
    public static boolean inEnteredLetters(char letter, char[] enteredLetters) {
        return new String(enteredLetters).contains(String.valueOf(letter));
    }
    /* Print word with spaces for hidden letters, returns true if
    asterisks were printed, otherwise return false */
    public static boolean printWord(String word, char[] enteredLetters) {
        // Iterate through all letters in word
        boolean asteriskPrinted = false;
        for (int i = 0; i < word.length(); i++) {
            char letter = word.charAt(i);
            // Check if letter already have been entered bu user before
            if (inEnteredLetters(letter, enteredLetters))
                System.out.print(letter); // If yes - print it
            else {
                System.out.print('_');
                asteriskPrinted = true;
            }
        }
        return asteriskPrinted;
    }
    /* Find first empty position in array of entered letters (one with code \u0000) */
    public static int findEmptyPosition(char[] enteredLetters) {
        int i = 0;
        while (enteredLetters[i] != '\u0000') i++;
        return i;
    }
}
