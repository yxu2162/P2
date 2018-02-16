import java.util.ArrayList;

// starter class for a BalancedSearchTree
// you may implement AVL, Red-Black, 2-3 Tree, or 2-3-4 Tree
// be sure to include in class header which tree you have implemented
public class BalancedSearchTree<T extends Comparable<T>> implements SearchTreeADT<T> {

	protected Treenode<T> root;

	public String inAscendingOrder() {
		
	    return getAllItems(root);
		
	}

	public boolean isEmpty() {
		
	    if (root == null){
	        return true;
	    }
	    
		return false;
		
	}

	public int height() {
		//TODO return the height of this tree
		return 0; 
	}

	public boolean lookup(T item) { //throws IllegalArgumentException{
	    
	    if (item == null) {
	        return false;
	    }
//	- if n's key equals the key, 
//	    - return true
//	- if (key < n's key) 
//	    - return lookup (left, key)
//	- return lookup (right, key)		
	    return false;
	}

	public void insert(T item) { //throws DuplicateKeyException, IllegalArgumentException{
		
	}

	public void delete(T item) { //throws IllegalArgumentException{
		//TODO if item is null or not found in tree, return without error
		// else remove this item key from the tree and rebalance

		// NOTE: if you are unable to get delete implemented
		// it will be at most 5% of the score for this program assignment
	}


	// HINT: define this helper method that can find the smallest key 
	// in a sub-tree with "node" as its root
	// PRE-CONDITION: node is not null
	private T leftMost(Treenode<T> node) {
		// TODO return the key value of the left most node in this subtree
		// or return node's key if node does not have a left child
		return node.key;
	}
	
	private String getAllItems(Treenode<T> item) {
	   
	    String a = "";
	    if (item.left != null) { getAllItems(item.left); }
	    a += item.key;
	    if(item.right != null) { getAllItems(item.right); }
	    return a;
	}
	
	// inner node class used to store key items and links to other nodes
    protected class Treenode<K extends Comparable<K>> {
        
        K key;
        Treenode<K> left;
        Treenode<K> right;
        
        public Treenode(K item) {
            this(item,null,null);
        }
        
        public Treenode(K item, Treenode<K> left, Treenode<K> right) {
            key = item;
            this.left = left;
            this.right = right;
        }
        
    }

}

