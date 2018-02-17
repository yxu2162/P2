

// starter class for a BalancedSearchTree
// you may implement AVL, Red-Black, 2-3 Tree, or 2-3-4 Tree
// be sure to include in class header which tree you have implemented
public class BalancedSearchTree<T extends Comparable<T>> implements SearchTreeADT<T> {

	
	// inner node class used to store key items and links to other nodes

    protected Treenode<T> root;
    int height = 0;

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
        return height;
    }

    public boolean lookup(T item) { //throws IllegalArgumentException{

        if (item == null) {
            return false;
        }
        else {
            return lookupHelper(item, root);
        }
        //	- if n's key equals the key, 
        //	    - return true
        //	- if (key < n's key) 
        //	    - return lookup (left, key)
        //	- return lookup (right, key)		
    }

    private boolean lookupHelper(T item, Treenode<T> node) {
        boolean lookup = false;
        if(item == node) {
            return true;
        }
        else {
            if(item.compareTo(root.key)<0) {
                lookup = lookupHelper(item, node.left);
            }
            if(item.compareTo(root.key)>0) {
                lookup = lookupHelper(item, node.right);
            }
            return lookup;
        }
    }

    public void insert(T item) { //throws DuplicateKeyException, IllegalArgumentException{
        
        Treenode<T> newNode = new Treenode(item);
        
        if (root == null) {
            root = newNode;
            height+=1;
        }
        
        else {
            try {
                insertHelper(root,newNode);
                height+=1;
            } catch ( DuplicateKeyException e) {  
            }
        }
        
        
    }

    public void delete(T item) { //throws IllegalArgumentException{
        //TODO if item is null or not found in tree, return without error
        // else remove this item key from the tree and rebalance

        // NOTE: if you are unable to get delete implemented
        // it will be at most 5% of the score for this program assignment
    }

    private void rightRotation(Treenode<T> node) {
//        if(node.height)
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
        
        if(isEmpty()) {
            return "";
        }
        
        else {
            
            if (item.left != null) { 
                getAllItems(item.left); 
            }
            
            a += item.key;
            
            if(item.right != null) { 
                getAllItems(item.right); 
            }
            
            return a;
        }
        
    }
    
    private void insertHelper(Treenode<T> currNode, Treenode<T> newNode) throws DuplicateKeyException {
        
        int comesAfter = currNode.key.compareTo(newNode.key);
        
        if (comesAfter > 0) {
          
            if (currNode.left != null) { 
                insertHelper(currNode.left, newNode); 
            }
            
            else { 
                currNode.left = newNode; 
            }
            
        }
        
        else if (comesAfter < 0) {
            
            if (currNode.right != null) { 
                insertHelper(currNode.right, newNode); 
            }
            
            else { currNode.right = newNode; }
            
        }
        
        else { 
            throw new DuplicateKeyException(); 
        }
    }

    // inner node class used to store key items and links to other nodes

    protected class Treenode<K extends Comparable<K>> {

        K key;
        Treenode<K> left;
        Treenode<K> right;
        int height;

        public Treenode(K item) {
            this(item,null,null);
        }

        public Treenode(K item, Treenode<K> left, Treenode<K> right) {
            key = item;
            this.left = left;
            this.right = right;
            this.height = 0;
        }

    }

}

