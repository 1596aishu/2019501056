/**
 * @author Aiswarya
 */
import java.util.Scanner;

class RansomNoteFunctions {
    SeparateChainingHashST<String,Integer> hashTable;
    RansomNoteFunctions() {
        this.hashTable = new SeparateChainingHashST<String,Integer>();
    }
    public void add(String word) {
        if (hashTable.contains(word)) {
            hashTable.put(word, hashTable.get(word) + 1);
        }
        else {
            hashTable.put(word,1);
        }
    }
    public boolean checkAndUpdate(String word) {
        if (hashTable.contains(word)) {
            hashTable.put(word, hashTable.get(word) - 1);
            if (hashTable.get(word) == 0) {
                hashTable.delete(word);
            }
            return true;
        }
        return false;
    }
}
public class RansomNote{
public static void main(String[] args) {
    Scanner scan = new Scanner(System.in);
    RansomNoteFunctions hashTable = new RansomNoteFunctions();

    String[] magazine = scan.nextLine().split(" ");
    for (String eachWord : magazine) {
        hashTable.add(eachWord);
    }
    String[] noteWords = scan.nextLine().split(" ");
    boolean canMakeNote = true;
    for (String eachWord : noteWords) {
        if (! hashTable.checkAndUpdate(eachWord)) {
            canMakeNote = false;
            break;
        }
    }
    if (canMakeNote) {
        System.out.println("Yes can make a note");
    }
    else {
        System.out.println("No cant make a note");
    }
    scan.close();
}
}