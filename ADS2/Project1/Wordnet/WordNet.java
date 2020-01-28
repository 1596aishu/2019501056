import java.util.ArrayList;
import java.util.HashMap;
import edu.princeton.cs.algs4.Digraph;
import edu.princeton.cs.algs4.DirectedCycle;
import edu.princeton.cs.algs4.In;

public class WordNet {

    private final Digraph G;
    private final SAP sapObj;
    // private final In in;
    private final HashMap<Integer, String> key;
    private final HashMap<String, ArrayList<Integer>> val;

    public WordNet(String Synset, String Hypernyms) {
        if (Synset == null || Hypernyms == null) {
            throw new IllegalArgumentException("File name is null");
        }
        key = new HashMap<Integer, String>();
        val = new HashMap<String, ArrayList<Integer>>();
        this.synsets(Synset);
        G = new Digraph(key.size());
        this.hypernyms(Hypernyms);
        sapObj = new SAP(G);
    }

    private void synsets(String file) {
        In in = new In(file);
        while (in.hasNextLine()) {
            String[] a = in.readLine().split(",");
            String[] b = a[1].split(" ");
            for (String str :b) {
                key.put(Integer.parseInt(a[0]), a[1]);
                if (!val.containsKey(str)) {
                    val.put(str, new ArrayList<Integer>());
                }
            }
        }
    }
    
    private void hypernyms(String file) {
        In in = new In(file);
        while (in.hasNextLine()) {
            String[] b = in.readLine().split(",");
            for (int i = 1; i < b.length; i++) {
                G.addEdge(Integer.parseInt(b[0]), Integer.parseInt(b[i]));
            }
        }
        DirectedCycle d = new DirectedCycle(G);
        if (d.hasCycle()) {
            throw new IllegalArgumentException("Cycle detected");
        }
        int numRoot = 0;
        for (int i = 0; i < G.V(); ++i) {
            if (G.outdegree(i) == 0) {
                ++numRoot;
                if (numRoot > 1) {
                    throw new IllegalArgumentException("More than 1 root");
                }
            }
        }
    }



    public Iterable<String> nouns() {
        return val.keySet();
    }

    public int distance(String nounA, String nounB) {
        if (!isNoun(nounA) || !isNoun(nounB)) {
            throw new IllegalArgumentException();
        }
        else return sapObj.length(val.get(nounA), val.get(nounB));
    }

    public String sap(String nounA, String nounB) {
        if (!isNoun(nounA) || !isNoun(nounB)) {
            throw new IllegalArgumentException();
        }
        return key.get(sapObj.ancestor(val.get(nounA), val.get(nounB)));
    }

    public boolean isNoun(String word) {
        if (word == null) {
            throw new IllegalArgumentException("word is null");
        }
        return val.containsKey(word);
    }

}
