//////////////////// ALL ASSIGNMENTS INCLUDE THIS SECTION /////////////////////
// Semester:        CS400 Spring 2018
// Project:         p2
// Files:           BalancedSearchTree.java 
//                  TestSearchTree.java 
//                  SearchTreeADT.java 
//                  DuplicateKeyException.java
//
// Author:          Stephen Squires III
// Email:           svsquires@wisc.edu
// Instructor:      Deb Deppeler
// Due Date:        Monday, 2/26/2018
//
// Known Bugs:
//////////////////// PAIR PROGRAMMERS COMPLETE THIS SECTION ///////////////////
//
// Partner Name:    Mary Xu
// Partner Email:   yxu368@wisc.edu
// Lecturer's Name: Deb Deppeler
// 
// VERIFY THE FOLLOWING BY PLACING AN X NEXT TO EACH TRUE STATEMENT:
//   _X_ Write-up states that pair programming is allowed for this assignment.
//   _X_ We have both read and understand the course Pair Programming Policy.
//   _X_ We have registered our team prior to the team registration deadline.
//
///////////////////////////// CREDIT OUTSIDE HELP /////////////////////////////
//
// Students who get help from sources other than their partner must fully 
// acknowledge and credit those sources of help here.  Instructors and TAs do 
// not need to be credited here, but tutors, friends, relatives, room mates 
// strangers, etc do.  If you received no outside help from either type of 
// source, then please explicitly indicate NONE.
//
// Persons:         (identify each person and describe their help in detail)
// Online Sources:  (identify each URL and describe their assistance in detail)
//
/////////////////////////////// 80 COLUMNS WIDE ///////////////////////////////

/**
 * This is the balanced search tree class. It contains
 * all the functionality required to add, and remove 
 * items from a tree and maintain balance, as well as
 * some calls that can be made on the tree to retrieve
 * the size and contents.
 * 
 * @author Stephen Squires III
 * @author Mary Xu
 *
 * @param <T> 
 */
public class BalancedSearchTree<T extends Comparable<T>> implements SearchTreeADT<T> {

    // class fields
    protected Treenode<T> root;
    private int height = 0;
    
    
    /**
     * Returns a string representation of the contents 
     * of the search tree sorted in ascending order. Each
     * item has a space between it and the next.
     * 
     * @return string of items with spaces between each
     *          in ascending order
     */
    public String inAscendingOrder() {
        return getAllItems(root);
    }


    /**
     * Checks whether the search tree is or is not empty.
     * 
     * @return boolean value of true for empty and false 
     *          for not empty
     */
    public boolean isEmpty() {

        if (root == null){
            return true;
        }

        return false;

    }


    /**
     * Returns the height of the longest path of the tree
     * 
     * @return int value of height of tree
     */
    public int height() {
        
        if(isEmpty()) {
            return 0;
        }
        
        else if(root.left == null && root.right == null) {
            return 1;
        }

        return max(getHeightOfNode(root.left), getHeightOfNode(root.right)) +1;
   
    }


    /**
     * Searches the tree for an item and tells you whether
     * or not it's there.
     * 
     * @param item of generic comparable type T that you
     *          are searching the tree for
     *          
     * @return boolean true if the item is found, false
     *          if it is not
     */
    public boolean lookup(T item) { //throws IllegalArgumentException{

        if (item == null) {
            return false;
        }

        else {
            return lookupHelper(item, root);
        }

    }


    /**
     * Inserts an item into the tree in its proper location
     * to maintain the BST order and shape properties.
     * 
     * @param item of generic type T to be inserted into the tree
     */
    public void insert(T item) throws DuplicateKeyException { 

        if(item == null) {
            throw new IllegalArgumentException();
        }

        Treenode<T> newNode = new Treenode(item);

        if (root == null) {
            root = newNode;
        }

        else {
            insertHelper(root, item);
        }

    }


    /**
     * Deletes an item from the tree and replaces it with
     * its successor.
     * 
     * @param item of generic type T to be deleted from the BST
     */
    public void delete(T item) { 
     
        if(item == null || !lookup(item)) {
            return;
        }

        else {
            deleteHelper(root, item);
        }
        
    }


    /**
     * Returns a string of all items in the subtree rooted
     * at item in ascending order.
     * 
     * @param item root of subtree of items to return in string
     * 
     * @return string of items in the tree separated by spaces
     *          in ascending order
     * 
     */
    private String getAllItems(Treenode<T> item) {

        String a = "";

        if(isEmpty()) {
            return "";
        }

        else {

            if (item.left != null) { 
                a+=getAllItems(item.left); 
            }

            if(item.key != null) {
                a += item.key + " ";
            }

            if(item.right != null) { 
                a+=getAllItems(item.right); 
            }

            return a;
        }
        
    }

    
    /** 
     * Steps through the nodes in the tree to find the one
     * that matches the key. Once found, it finds the leaf 
     * that will take its place and updates the parent and
     * children references to keep the tree working properly.
     * 
     * @param currNode of type Treenode<T> starting node in 
     *          the search for the node that will be deleted
     *          
     * @param key of generic type T the key of the item being
     * searched for
     * 
     */
    private void deleteHelper(Treenode<T> currNode, T key) {

        int comesAfter = currNode.key.compareTo(key);

        if(comesAfter < 0) {
            deleteHelper(currNode.right, key);
        }

        if(comesAfter > 0) {
            deleteHelper(currNode.left, key);
        }

        if(comesAfter == 0) {
            Treenode<T> thisNode = currNode;
            Treenode<T> minParent;
            Treenode<T> thisLeft;
            Treenode<T> thisParent;

            if (currNode == root) {

                if (root.left == null && root.right == null) {
                    root = null;
                }

                else if(root.right == null) {
                    root = root.left;
                }

                else if(root.left == null){
                    root = root.right;
                }

                else {

                    if(root.right.left != null) {
                        thisLeft = root.left;
                        root = findMinValue(root.right);
                        root.left = thisLeft;
                        minParent = getParent(root, root.right);
                        minParent.left = null;

                    }

                    else {
                        thisLeft = root.left; 
                        root = root.right;
                        root.left = thisLeft;
                    }

                }

            }

            else {

                if (currNode.left == null && currNode.right == null) {
                    currNode = null;
                }

                else if(currNode.right == null) {
                    thisNode = currNode.left;
                    thisParent = getParent(root,currNode); 

                    if (thisParent.key.compareTo(currNode.key) > 0) {
                        thisParent.right = thisNode;
                    }

                    else {
                        thisParent.left = thisNode;
                    }

                }

                else if(currNode.left == null){
                    thisNode = currNode.right;
                    thisParent = getParent(root,currNode);

                    if (thisParent.key.compareTo(currNode.key) > 0) {
                        thisParent.right = thisNode;
                    }

                    else {
                        thisParent.left = thisNode;
                    }

                }

                else {
                    thisNode = findMinValue(currNode.right);
                    minParent = getParent(root,findMinValue(currNode.right));
                    minParent.left = null;
                    thisParent = getParent(root,currNode);

                    if (thisParent.key.compareTo(currNode.key) > 0) {
                        thisParent.right = thisNode;
                    }

                    else {
                        thisParent.left = thisNode;
                    }

                    thisNode.left = currNode.left;
                    thisNode.right = currNode.right;

                }

            }
            
        }
        
    }

    
    /**
     * Searches the tree for the child node and returns its parent.
     * 
     * @param currNode of type Treenode<T> starting node of the subtree 
     *          where it will search for the child
     *          
     * @param child of type Treenode<T> node that is being searched
     *          for so that its parent can be returned
     *          
     * @return Treenode<T> parent of the aforepassed child node
     */
    private Treenode<T> getParent(Treenode<T> currNode, Treenode<T> child) {

        int comesAfter = currNode.key.compareTo(child.key);

        if (currNode.left.key != null) {
            int compareLeft = currNode.left.key.compareTo(child.key);
            
            if (compareLeft == 0) {
                return currNode;
            }
            
        }

        if (currNode.right.key != null) {
            int compareRight = currNode.right.key.compareTo(child.key);

            if(compareRight == 0) {
                return currNode;
            }

        }

        if (comesAfter < 0) {
            getParent(currNode.right, child); 
        }

        if (comesAfter > 0) { 
            getParent(currNode.left, child); 
        }

        return currNode;

    }


    /**
     * Helper for the insert method. Searches the tree top to 
     * bottom for the leaf node where it fits to maintain the 
     * BST order and shape properies. Once inserted, the tree
     * should balance itself with left-right roatons.
     * 
     * @param currNode of type Treenode<T> the root node of the
     *          current subtree being traversed
     * 
     * @param key of generic type T the key of the node being
     *          inserted
     */
    private void insertHelper(Treenode<T> currNode, T key) throws DuplicateKeyException {

        if(lookup(key)) {
            throw new DuplicateKeyException();
        }

        int comesAfter = currNode.key.compareTo(key);

        if (comesAfter > 0) {

            if (currNode.left != null) { 
                insertHelper(currNode.left, key); 
            }
            
            else {
                currNode.left = new Treenode<T>(key);
            }
            
        }

        if (comesAfter < 0) {

            if (currNode.right != null) {
                insertHelper(currNode.right, key); 
            }

            else { 
                currNode.right = new Treenode<T>(key);
            }

        }
        
        
        currNode.height = max(getHeightOfNode(currNode.left), getHeightOfNode(currNode.right)) +1;
        int balanceFactor = getHeightOfNode(currNode.left)-getHeightOfNode(currNode.right);
        
        if(balanceFactor == -2) {
            leftRotate(currNode);
            balanceFactor = getHeightOfNode(currNode.left)-getHeightOfNode(currNode.right);
            if(balanceFactor == 2) {
                rightRotate(currNode);
            }
            
        }
        if(balanceFactor == 2) {
            rightRotate(currNode);
            balanceFactor = getHeightOfNode(currNode.left)-getHeightOfNode(currNode.right);
            if(balanceFactor == -2) {
                rightRotate(currNode);
            }
        }


        
    }


    /**
     * Helper for the lookup method. Traverses the tree
     * to check whether or not an item exists.
     * 
     * @param node of type Treenode<T> being examined and
     *          its key being compared against the input
     *          key to check for a match
     *          
     * @param item of generic type T being searched for in
     *          the tree
     *          
     * @return boolean true if the item is found false if
     *          it is not
     */
    private boolean lookupHelper(T item, Treenode<T> node) {

        boolean lookup = false;

        if(node == null) {
            return false;
        }

        if(item.equals(node.key)) {
            lookup = true;
            return lookup;
        }

        else {

            if(item.compareTo(node.key)<0) {
                lookup = lookupHelper(item, node.left);
            }

            if(item.compareTo(node.key)>0) {
                lookup = lookupHelper(item, node.right);
            }

            return lookup;
        }

    }


    /**
     * Rotates 3 nodes right about the input node
     * 
     * @param node of type Treenode<T> to rotate about
     */
    private void rightRotate(Treenode <T> node) {
        Treenode<T> newParent = node.left;
        node.left = newParent.right;
        newParent.right = node;
        newParent.height = max(getHeightOfNode(newParent.left), getHeightOfNode(newParent.right)) +1;
        node.height = max(getHeightOfNode(node.left), getHeightOfNode(node.right)) +1;
        if(node == root) {
            root = newParent;
        }
    }


    /**
     * Rotates 3 nodes left about the input node
     * 
     * @param node of type Treenode<T> to rotate about
     */
    private void leftRotate(Treenode<T> node) {
        Treenode<T> newParent = node.right;
        node.right = newParent.left;
        newParent.left = node;
        newParent.height = max(getHeightOfNode(newParent.left), getHeightOfNode(newParent.right)) +1;
        node.height = max(getHeightOfNode(node.left), getHeightOfNode(node.right)) +1;
        if(node == root) {
            root = newParent;
        }
    }


    /**
     * Gets the height of the specified node
     * 
     * @param node of type Treenode<T> the height of which
     *          is returned
     *          
     * @return int value of the height of the specified node
     */
    private int getHeightOfNode(Treenode<T> node) {

        if(node != null) {
            return node.height;
        }
        
        else {
            return 0;
        }

    }


    /** 
     * Compares the height of 2 nodes and returns
     * the larger height
     * 
     * @param height1 of type int that is being compared
     * 
     * @param height2 of type int that is being compared
     * 
     * @return int higher of the 2 heights
     */
    private int max(int height1, int height2) {

        if(height1 > height2) {
            return height1;
        }

        else if (height1 < height2) {
            return height2;
        }

        else {
            return height1;
        }

    }

    
    /**
     * Finds the minimum value of the specified subtree
     * 
     * @param currNode of type Treenode<T> the root of the 
     *          subtree being searched for its smallest node
     *          
     * @return Treenode<T> the smallest node of the subtree         
     */
    private Treenode<T> findMinValue(Treenode<T> currNode) {

        Treenode <T> minRightValue = null;

        while(currNode != null) {
            minRightValue = findMinValue(currNode.left);
        }
        return minRightValue;

    }


    /**
     * This class contains the contents of the treenodes in the
     * BST. It has pointers to the left and right children as well
     * as a key to identify it. 
     * 
     * @author Stephen Squires III
     * @author Mary Xu
     * @param <K> comparabe generic data type
     */

    protected class Treenode<K extends Comparable<K>> {

        K key;
        Treenode<K> left;
        Treenode<K> right;
        int height;             // height of the node

        /**
         * Constructor for the treenode item
         * 
         * @param item of generic type K that contains
         *          the contents of the node
         */
        public Treenode(K item) {
            this(item,null,null);
        }
        
        /**
         * Constructor for the treenode that sets its key,
         * as well as left and right children
         * 
         * @param item of generic type K contains the contents
         *          of the node
         *          
         * @param left of type Treenode<K> that references the left child
         * 
         * @param right of type Treenode<K> what references the right child
         */
        public Treenode(K item, Treenode<K> left, Treenode<K> right) {
            key = item;
            this.left = left;
            this.right = right;
            this.height = 1;
        }

    }

}

