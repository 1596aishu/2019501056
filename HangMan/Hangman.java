class Hangman extends user{
    public static void main(String[] args) {
        String[] words = {"writer", "that", "program"};
        // Pick random index of words array
        int randomWordNumber = (int) (Math.random() * words.length);
        // Create an array to store already entered letters
        char[] enteredLetters = new char[words[randomWordNumber].length()];
        int triesCount = 0;
        boolean wordIsGuessed = false;
        do {
        // infinitely iterate through cycle as long as enterLetter returns true
        // if enterLetter returns false that means user guessed all the letters
        // in the word e. g. no asterisks were printed by printWord
        switch (enterLetter(words[randomWordNumber], enteredLetters)) {
            case 0:
                triesCount++;
                break;
            case 1:
                triesCount++;
                break;
            case 2:
                break;
            case 3:
                wordIsGuessed = true;
                break;
        }
        } while (! wordIsGuessed);
        System.out.println("\nThe word is " + words[randomWordNumber] +
            " You missed " + (triesCount - findEmptyPosition(enteredLetters)) +
            " time(s)");
    }
    
}
