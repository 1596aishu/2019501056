import edu.princeton.cs.algs4.Digraph;
import edu.princeton.cs.algs4.BreadthFirstDirectedPaths;

public class SAP {
    private final Digraph G;   

    public SAP(Digraph G) {
        this.G = G;
    }         
    public int length(int v, int w) {
        
        if (v < 0 || w < 0 || v > G.V() - 1 || w > G.V() - 1) {
            throw new IllegalArgumentException();
        }
        // if (v == 0 || w == 0) {
        //     throw new IllegalArgumentException();
        // }
        BreadthFirstDirectedPaths v1 = new BreadthFirstDirectedPaths(G, v);
        BreadthFirstDirectedPaths w1 = new BreadthFirstDirectedPaths(G, w);
        int len = Integer.MAX_VALUE;
        for (int i = 0; i < G.V(); i++) {
            if (v1.hasPathTo(i) && w1.hasPathTo(i)) {
                int L = v1.distTo(i) + w1.distTo(i);
                if (L < len) {
                    len = L;
                }
            }
        }
        if (len == Integer.MAX_VALUE) return -1;
        else return len;
    }

    public int ancestor(int v, int w) {
        
        if (v < 0 || w < 0 || v > G.V() - 1 || w > G.V() - 1) {
            throw new IllegalArgumentException();
        }
        BreadthFirstDirectedPaths v1 = new BreadthFirstDirectedPaths(G, v);
        BreadthFirstDirectedPaths w1 = new BreadthFirstDirectedPaths(G, w);
        int len = Integer.MAX_VALUE;
        int ancestor = -1;
        for (int i = 0; i < G.V(); i++) {
            if (v1.hasPathTo(i) && w1.hasPathTo(i)) {
                int L = v1.distTo(i) + w1.distTo(i);
                if (L < len) {
                    len = L;
                    ancestor = i;
                }
            }
        }
        return ancestor;
    }
    

    public int length(Iterable<Integer> v, Iterable<Integer> w) {
        int len = Integer.MAX_VALUE;
        if (v == null || w == null) {
            throw new IllegalArgumentException();
        }
        // int ancestor = -1;
        for (int i :v) {
            for (int j :w) {
                int z = length(i, j);
                if (len > z && z != -1) {
                    len = z;
                }
            }
        }
        if (len == Integer.MAX_VALUE) return -1;
        else return len;
    }

    public int ancestor(Iterable<Integer> v, Iterable<Integer> w) {
        int len = Integer.MAX_VALUE;
        if (v == null || w == null) {
            throw new IllegalArgumentException();
        }
        int ancestor = -1;
        for (int i :v) {
            for (int j :w) {
                int z = length(i, j);
                if (len > z && z != -1) {
                    len = z;
                    ancestor = ancestor(i, j);
                }
            }
        }
        return ancestor;
    }   
}