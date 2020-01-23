public class Outcast {

    private final WordNet Wnet;

    public  Outcast(WordNet wordnet) {
        this.Wnet = wordnet;
    }
    public String outcast(String[] nouns) {
        int temp = 0;
        String outcast = null;

        for (String i : nouns) {
            int dist = 0;
            for (String j : nouns) {
                int dist_len = Wnet.distance(i, j);
                dist += dist_len;
            }    
            if (dist > temp) {
                temp = dist;
                outcast = i;
            }
        }
        return outcast;
    } 
}

