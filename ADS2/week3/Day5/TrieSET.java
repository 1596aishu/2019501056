import edu.princeton.cs.algs4.Queue;
import java.util.Iterator;
// import java.util.*;

public class TrieSET implements Iterable<String> {
    private static final int R = 256;        // extended ASCII

    private Node root;      // root of trie
    private int n;          // number of keys in trie

    // R-way trie node
    private static class Node {
        private Node[] next = new Node[R];
        private boolean isString;
    }

    public TrieSET() {
    }

    public boolean contains(String key) {
        if (key == null) throw new IllegalArgumentException("argument to contains() is null");
        Node x = get(root, key, 0);
        if (x == null) return false;
        return x.isString;
    }

    private Node get(Node x, String key, int d) {
        if (x == null) return null;
        if (d == key.length()) return x;
        char c = key.charAt(d);
        return get(x.next[c], key, d+1);
    }

    public void add(String key) {
        if (key == null) throw new IllegalArgumentException("argument to add() is null");
        root = add(root, key, 0);
    }

    private Node add(Node x, String key, int d) {
        if (x == null) x = new Node();
        if (d == key.length()) {
            if (!x.isString) n++;
            x.isString = true;
        }
        else {
            char c = key.charAt(d);
            x.next[c] = add(x.next[c], key, d+1);
        }
        return x;
    }

    public int size() {
        return n;
    }

    public boolean isEmpty() {
        return size() == 0;
    }

    public Iterator<String> iterator() {
        return keysWithPrefix("").iterator();
    }


    public Iterable<String> keysWithPrefix(String prefix) {
        Queue<String> results = new Queue<String>();
        Node x = get(root, prefix, 0);
        collect(x, new StringBuilder(prefix), results);
        return results;
    }

    private void collect(Node x, StringBuilder prefix, Queue<String> results) {
        if (x == null) return;
        if (x.isString) results.enqueue(prefix.toString());
        for (char c = 0; c < R; c++) {
            prefix.append(c);
            collect(x.next[c], prefix, results);
            prefix.deleteCharAt(prefix.length() - 1);
        }
    }

    public Iterable<String> keysThatMatch(String pattern) {
        Queue<String> results = new Queue<String>();
        StringBuilder prefix = new StringBuilder();
        collect(root, prefix, pattern, results);
        return results;
    }
        
    private void collect(Node x, StringBuilder prefix, String pattern, Queue<String> results) {
        if (x == null) return;
        int d = prefix.length();
        if (d == pattern.length() && x.isString)
            results.enqueue(prefix.toString());
        if (d == pattern.length())
            return;
        char c = pattern.charAt(d);
        if (c == '.') {
            for (char ch = 0; ch < R; ch++) {
                prefix.append(ch);
                collect(x.next[ch], prefix, pattern, results);
                prefix.deleteCharAt(prefix.length() - 1);
            }
        }
        else {
            prefix.append(c);
            collect(x.next[c], prefix, pattern, results);
            prefix.deleteCharAt(prefix.length() - 1);
        }
    }

    public String longestPrefixOf(String query) {
        if (query == null) throw new IllegalArgumentException("argument to longestPrefixOf() is null");
        int length = longestPrefixOf(root, query, 0, -1);
        if (length == -1) return null;
        return query.substring(0, length);
    }

    private int longestPrefixOf(Node x, String query, int d, int length) {
        if (x == null) return length;
        if (x.isString) length = d;
        if (d == query.length()) return length;
        char c = query.charAt(d);
        return longestPrefixOf(x.next[c], query, d+1, length);
    }

    public void delete(String key) {
        if (key == null) throw new IllegalArgumentException("argument to delete() is null");
        root = delete(root, key, 0);
    }

    private Node delete(Node x, String key, int d) {
        if (x == null) return null;
        if (d == key.length()) {
            if (x.isString) n--;
            x.isString = false;
        }
        else {
            char c = key.charAt(d);
            x.next[c] = delete(x.next[c], key, d+1);
        }

        // remove subtrie rooted at x if it is completely empty
        if (x.isString) return x;
        for (int c = 0; c < R; c++)
            if (x.next[c] != null)
                return x;
        return null;
    }

	public boolean hasPrefix(String word) {
        
        Node x = get(root, word, 0);
        return x!=null;
	}


    // public static void main(String[] args) {
    //     TrieSET set = new TrieSET();
    //     while (!StdIn.isEmpty()) {
    //         String key = StdIn.readString();
    //         set.add(key);
    //     }

    //     // print results
    //     if (set.size() < 100) {
    //         System.out.println("keys(\"\"):");
    //         for (String key : set) {
    //             System.out.println(key);
    //         }
    //         System.out.println();
    //     }

    //     System.out.println("longestPrefixOf(\"shellsort\"):");
    //     System.out.println(set.longestPrefixOf("shellsort"));
    //     System.out.println();

    //     System.out.println("longestPrefixOf(\"xshellsort\"):");
    //     System.out.println(set.longestPrefixOf("xshellsort"));
    //     System.out.println();

    //     System.out.println("keysWithPrefix(\"shor\"):");
    //     for (String s : set.keysWithPrefix("shor"))
    //         System.out.println(s);
    //     System.out.println();

    //     System.out.println("keysWithPrefix(\"shortening\"):");
    //     for (String s : set.keysWithPrefix("shortening"))
    //         System.out.println(s);
    //     System.out.println();

    //     System.out.println("keysThatMatch(\".he.l.\"):");
    //     for (String s : set.keysThatMatch(".he.l."))
    //         System.out.println(s);
    // }
}