public class SAP{

    public SAP(Digraph G){

    }   
    
    public int length(int v, int w){

    }

    public int ancestor(int v, int w){

    }

    public int length(Iterable<Integer> v, Iterable<Integer> w){

    }

    public int ancestor(Iterable<Integer> v, Iterable<Integer> w){

    }

    public static void main(String[] args){
        In in = new In(args[0]);
        Digraph G = new Digraph(in);
        SAP sap = new SAP(G);
    }

}