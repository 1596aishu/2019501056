import java.util.ArrayList; 
import edu.princeton.cs.algs4.LinearProbingHashST;
import edu.princeton.cs.algs4.Digraph;
import edu.princeton.cs.algs4.In;

public class WordNet {


    private LinearProbingHashST<String, ArrayList<Integer>> keys;
    private LinearProbingHashST<Integer, String> values;
   
    
    private SAP sobj;
    private In in;
    // private int n;
    private Digraph dg;

   
        public WordNet(String synsets, String hypernyms)  {
            if (synsets == null || hypernyms == null) {
                throw new IllegalArgumentException("File name is null");
            }
        //    n = 0;
           readSynsets(synsets);
           readHypernyms(hypernyms);
       }

         private void readSynsets(String synsets) {
            keys = new LinearProbingHashST<String, ArrayList<Integer>>();
            values = new LinearProbingHashST<Integer, String>();

            In scan1 = new In(synsets);
            while (scan1.hasNextLine()) {
                // n++;
                String[] str = scan1.readLine().split(",");
                int id = Integer.parseInt(str[0]);
                values.put(id, str[1]);

                String[] words = str[1].split(" ");
                for (int i = 0; i < words.length; i++) {
                    if (keys.contains(words[i])) {
                        ArrayList<Integer> id_in = keys.get(words[i]);
                        id_in.add(id);
                        keys.put(words[i], id_in);
                    }
                    else {
                        ArrayList<Integer> newin = new ArrayList<Integer>();
                        newin.add(id);
                        keys.put(words[i], newin);
                    }
                }
            }
        
    }

        private void readHypernyms(String hypernyms)  {

             ArrayList<String> k = new ArrayList<String>();
             ArrayList<String[]> v = new ArrayList<String[]>();

            In scan2 = new In(hypernyms);
            while (scan2.hasNextLine()) {
                String[] str = scan2.readLine().split(",", 2);
                if (str.length > 1) {
                    k.add(str[0]);
                    v.add(str[1].split(","));
                }
                 else {
                    k.add(str[0]);
                    v.add(null);
                }
            
            }

            // int count = 0;
            dg = new Digraph(k.size());
            for (int i = 0; i < k.size(); i++) {
                if (v.get(i) != null) {
                    for (int j = 0; j < v.get(i).length; j++) {
                        int k1 = Integer.parseInt(k.get(i));
                        int v1 = Integer.parseInt(v.get(i)[j]);
                        dg.addEdge(k1, v1);
                    //    count++;
                    }
               }
            }
        // System.out.println("edges : " + count);
    }

   
   public Iterable<String> nouns() {
        return keys.keys();
   }

   // is the word a WordNet noun?
   public boolean isNoun(String word) {
        if (word == null) {
            throw new IllegalArgumentException("word is null");
        }
        return keys.contains(word);
   }

   
   
   public int distance(String nounA, String nounB) {
        sobj = new SAP(dg);
        if (!isNoun(nounA) || !isNoun(nounB)) {
            throw new IllegalArgumentException("Not WordNet Noun");
        }
        return sobj.length(keys.get(nounA), keys.get(nounB));
   }
   
   
   public String sap(String nounA, String nounB) {
        sobj = new SAP(dg);
        if (!isNoun(nounA) || !isNoun(nounB)) {
            throw new IllegalArgumentException("Not WordNet Noun");
        }  
        return values.get(sobj.ancestor(keys.get(nounA), keys.get(nounB)));
   }

   

}

