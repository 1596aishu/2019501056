

public class SAP{

    private Digraph G;
    
    public SAP(Digraph G){
        this.G = G;
    } 
        
    public int length(int v, int w) throws Exception {
        BreadthFirstDirectedPaths v1 = new BreadthFirstDirectedPaths(G,v);
        BreadthFirstDirectedPaths w1 = new BreadthFirstDirectedPaths(G,w);
        int len = Integer.MAX_VALUE;
        for(int i = 0;i<G.V();i++){
            if(v1.hasPathTo(i)&& w1.hasPathTo(i)){
                int L = v1.distTo(i) + w1.distTo(i);
                if (L < len) {
                    len = L;
                }
            }
        }
        if (len == Integer.MAX_VALUE)
            return -1;
        else
            return len;
    }

    public int ancestor(int v, int w) throws Exception {
        BreadthFirstDirectedPaths v1 = new BreadthFirstDirectedPaths(G,v);
        BreadthFirstDirectedPaths w1 = new BreadthFirstDirectedPaths(G,w);
        int len = Integer.MAX_VALUE;
        int ancestor = -1;
        for (int i = 0; i < G.V(); i++) {
            if (v1.hasPathTo(i) && w1.hasPathTo(i)) {
                int L = v1.distTo(i) + w1.distTo(i);
                if(L<len){
                    len = L;
                    ancestor = i;
                }
            }
        }
        if(len == Integer.MAX_VALUE) return -1;
        else return ancestor;
    }
    

    public int length(Iterable<Integer> v, Iterable<Integer> w)  throws Exception{
        int len = Integer.MAX_VALUE;
        int ancestor = -1;
        for(int i :v){
            for(int j :w){
                int z = length(i,j);
                if(len>z){
                    len = z;
                }
            }
        }
        if (ancestor == -1) return -1;
        else return len;
    }

    public int ancestor(Iterable<Integer> v, Iterable<Integer> w)  throws Exception {
        int len = Integer.MAX_VALUE;
        int ancestor = -1;
        for(int i :v){
            for(int j :w){
                int z = length(i,j);
                if(len>z){
                    len = z;
                    ancestor = ancestor(i,j);
                }
            }
        }
        return ancestor;
    }   
}