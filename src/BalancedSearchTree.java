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


    public String inAscendingOrder() {
        return getAllItems(root);
    }


    /**
     * (non-Javadoc)
     * @see SearchTreeADT#isEmpty()
     */
    public boolean isEmpty() {

        if (root == null){
            return true;
        }

        return false;

    }


    /**
     * (non-Javadoc)
     * @see SearchTreeADT#height()
     */
    public int height() {
        if(isEmpty()) {
            return 0;
        }
        else if(root.left == null && root.right == null) {
            return 1;
        }
        System.out.println(root.key);
        return max(getHeightOfNode(root.left), getHeightOfNode(root.right)) +1;
    }


    /**
     * (non-Javadoc)
     * @see SearchTreeADT#lookup(java.lang.Comparable)
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
     * (non-Javadoc)
     * @see SearchTreeADT#insert(java.lang.Comparable)
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
     * (non-Javadoc)
     * @see SearchTreeADT#delete(java.lang.Comparable)
     */
    public void delete(T item) { //throws IllegalArgumentException{
        //TODO if item is null or not found in tree, return without error
        // else remove this item key from the tree and rebalance
        if(item == null || !lookup(item)) {
            return;
        }
        else {
            deleteHelper(this.root, item);
        }

        // NOTE: if you are unable to get delete implemented
        // it will be at most 5% of the score for this program assignment

    }


    /**
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

    private void deleteHelper(Treenode<T> currNode, T key) {
        //System.out.println(root.key);
        int comesAfter = currNode.key.compareTo(key);
        if(comesAfter < 0) { //currentNode is smaller, go right
            deleteHelper(currNode.right, key);
        }
        if(comesAfter > 0) { //currentNode is bigger, go left
            deleteHelper(currNode.left, key);
        }
        if(comesAfter == 0) {
            if(currNode.left == null || currNode.right == null) {
                if(currNode.left == null && currNode.right == null) { //if no child
                    currNode = null;
                }
                else if(currNode.right == null) { //if one child on left
                    Treenode<T> temp = currNode;
                    currNode = currNode.left;
                    temp = null;
                }
                else { //if one child on right
                    Treenode<T> temp = currNode;
                    currNode = currNode.right;
                    temp = null;
                }
            }
            else {
                Treenode <T> temp = findMinValue(currNode.right);
                currNode.key = temp.key;
                temp = null;
            }
        }
    }
    //        if(currNode == null) {
    //            return null;
    //        }
    //        int comesAfter = currNode.key.compareTo(key);
    //
    //        if(comesAfter < 0) {
    //            currNode.right = deleteHelper(currNode.right, key);
    //        }
    //        if(comesAfter > 0) {
    //            currNode.left = deleteHelper(currNode.left, key);
    //        }
    //
    //        if(currNode.left == null || currNode.right == null) { //one child or no child
    //            
    //            if(currNode.left == null && currNode.right == null) {
    //                currNode = null;
    //            }
    //            if(currNode.left == null) {
    //                currNode = currNode.right;
    //                return currNode.right;
    //            }
    //            else if(currNode.right == null) {
    //                currNode = currNode.left;
    //                return currNode.left;
    //            }
    //        }
    //        currNode.key = findMinValue(root.right).key;
    //        currNode.right = deleteHelper(currNode.right, currNode.key);
    //        return currNode;


    /*
     * 
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
        System.out.println(currNode.key + " " + balanceFactor);
        
        if(balanceFactor == -2 && key.compareTo(currNode.right.key) > 0) { //left rotate
            System.out.println("Left Rotate");
            leftRotate(currNode);
        }
        
        if(balanceFactor == 2 && key.compareTo(currNode.left.key) < 0) { //right rotate
            System.out.println("Right rotate");
            rightRotate(currNode);
        }

        if(balanceFactor == 2 && key.compareTo(currNode.left.key) < 0) { //left right rotate
            System.out.println("Right rotate");
            leftRotate(currNode);
            rightRotate(currNode);

        }
        
        if(balanceFactor == -2 && key.compareTo(currNode.left.key) > 0) { //right left rotate
            System.out.println("Right Rotate");
            rightRotate(currNode);
            leftRotate(currNode);
        }
    }

    /*
     * 
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


    /*
     * 
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


    /*
     * 
     */
    private void leftRotate(Treenode <T> node) {
        Treenode<T> newParent = node.right;
        node.right = newParent.left;
        newParent.left = node;
        newParent.height = max(getHeightOfNode(newParent.left), getHeightOfNode(newParent.right)) +1;
        node.height = max(getHeightOfNode(node.left), getHeightOfNode(node.right)) +1;
        if(node == root) {
            root = newParent;
        }
    }


    /*
     * 
     */
    private int getHeightOfNode(Treenode<T> node) {

        if(node != null) {
            return node.height;
        }
        else {
            return 0;
        }

    }


    /*
     * 
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

    /*
     * 
     */
    private Treenode<T> findMinValue(Treenode<T> currNode) {

        Treenode <T> minRightValue = null;

        while(currNode != null) {
            minRightValue = findMinValue(currNode.left);
        }
        return minRightValue;

    }





    /**
     * 
     * @author squir
     *
     * @param <K>
     */

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
            this.height = 1;
        }

    }

}

