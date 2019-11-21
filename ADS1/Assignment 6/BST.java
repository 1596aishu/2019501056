import java.util.*;

class BST{
    public Node root;
    public class Node {
        private Node left, right;  // left and right subtrees
        private int data;          // number of nodes in subtree

        public Node(int data) {
            this.data = data;
            left = null; 
            right = null;
        }
    }
    public BST() {
        root = null;
    }
    public boolean bst(){
        return isOrdered(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }
    public boolean isOrdered(Node x, int min, int max){
        if(x == null) return true;
        if(x.data < min && x.data > max) return false;
        return (isOrdered(x.left, min, x.data-1) && isOrdered(x.right, x.data+1, max));
    }

    public static void main(String[] args){
        BST bst = new BST();
        bst.root = bst.new Node(1);
        bst.root.left = bst.new Node(2);
        bst.root.right = bst.new Node(3);
        bst.root.left.left = bst.new Node(4);
        bst.root.left.right = bst.new Node(5);
        bst.root.right.left = bst.new Node(6);
        bst.root.right.right = bst.new Node(7);
        if(bst.bst()) System.out.println("BST");
        else System.out.println("not a BST");
    }
}