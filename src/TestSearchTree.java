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

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;


/**
 * @author 
 *
 */
public class TestSearchTree {

    SearchTreeADT<String> strTree = null;
    SearchTreeADT<Integer> iTree = null;
    String expected = null;
    String actual = null;

    /**
     * @throws java.lang.Exception
     */
    @BeforeClass
    public static void setUpBeforeClass() throws Exception {

    }

    /**
     * @throws java.lang.Exception
     */
    @AfterClass
    public static void tearDownAfterClass() throws Exception {

    }

    /**
     * @throws java.lang.Exception
     */
    @Before
    public void setUp() throws Exception {
        strTree = new BalancedSearchTree<String>();
        iTree = new BalancedSearchTree<Integer>();
    }

    /**
     * @throws java.lang.Exception
     */
    @After
    public void tearDown() throws Exception {
        strTree = null;
        iTree = null;
    }

    @Test
    // fails if isEmpty() returns false for a newly constructed search tree
    public void test01_isEmpty_on_empty_tree() {
        expected = "true";
        actual = "" + strTree.isEmpty();
        if (! expected.equals(actual))
            fail("expected: "+expected+ " actual: "+actual);
    }

    @Test
    public void test02_ascending_order_on_empty_tree() {
        expected = "";
        actual = strTree.inAscendingOrder();
        if (! expected.equals(actual))
            fail("expected: "+expected+ " actual: "+actual);
    }


    @Test
    /* tests that the height of an empty tree is 0 
     * 
     */
    public void test03_height_on_empty_tree() {
        expected = "0";
        actual = "" + strTree.height();
        if (! expected.equals(actual))
            fail("expected: "+expected+ " actual: "+actual);
    }

    @Test
    /* tests that the height of an empty tree is 0 
     * 
     */
    public void test04_isEmpty_after_one_insert() throws DuplicateKeyException {
        strTree.insert("1");
        expected = "false";
        actual = "" + strTree.isEmpty();
        if (! expected.equals(actual))
            fail("expected: "+expected+ " actual: "+actual);
    }

    @Test
    /* tests that the ascending order after inserting A item is "A," 
     * 
     */
    public void test05_ascending_order_after_one_insert() throws DuplicateKeyException {
        strTree.insert("A");
        expected = "A ";
        actual = strTree.inAscendingOrder();
        if (! expected.equals(actual))
            fail("expected: "+expected+ " actual: "+actual);
    }

    @Test
    /* tests that the height of an empty tree is 0 
     * 
     */
    public void test06_height_after_one_insert() throws DuplicateKeyException {
        strTree.insert("A");
        expected = "1";
        actual = "" + strTree.height();
        if (! expected.equals(actual))
            fail("expected: "+expected+ " actual: "+actual);
    }

    @Test
    /* tests that the height of an empty tree is 0 
     * 
     */
    public void test07_height_after_two_insert_and_one_delete() throws DuplicateKeyException {
        strTree.insert("A");
        strTree.insert("B");
        strTree.delete("A");
        expected = "1";
        actual = "" + strTree.height();
        if (! expected.equals(actual))
            fail("expected: "+expected+ " actual: "+actual);
    }

    @Test
    /* tests that the height of an empty tree is 0 
     * 
     */
    public void test08_checkEmptyHeight() {
        expected = "0";
        actual = "" + strTree.height();
        if(! expected.equals(actual))
            fail("expected: " +expected+ " actual: " +actual);
    }

    @Test
    /* tests that the height of an empty tree is 0 
     * 
     */
    public void test09_checkLookUp() throws DuplicateKeyException {
        strTree.insert("A");
        expected = "true";
        actual = "" + strTree.lookup("A");
        if(! expected.equals(actual))
            fail("expected: " +expected+ " actual: " +actual);
    }

    @Test
    /* tests that the height of an empty tree is 0 
     * 
     */
    public void test10_checkMultipleLookUp() throws DuplicateKeyException {
        strTree.insert("D");
        strTree.insert("A");
        strTree.insert("C");
        strTree.insert("E");
        strTree.insert("B");
        expected = "true";
        actual = "" + strTree.lookup("D");
        if(! expected.equals(actual)) {
            fail("expected: " +expected+ " actual: " +actual);
        }
    }

    @Test
    /* tests that the height of an empty tree is 0 
     * 
     */
    public void test11_insertNull() throws DuplicateKeyException {
        try {
            strTree.insert(null);
            fail("expected: " +expected+ " actual: " +actual);
        } catch (IllegalArgumentException e) {

        }
    }

    @Test
    /* tests that the height of an empty tree is 0 
     * 
     */
    public void test12_insertDupes() {
        try {
            strTree.insert("A");
            strTree.insert("A");
            fail("Should have thrown DuplicateKeyException");
        } catch (DuplicateKeyException e) {

        }
    }
    
    @Test
    /* tests that the height of an empty tree is 0 
     * 
     */
    public void test13_testForBalance() throws DuplicateKeyException {
        strTree.insert("A");
        strTree.insert("B");
        strTree.insert("C");
        expected = "2";
        actual = "" + strTree.height();
        if(! expected.equals(actual)) {
            fail("expected: " +expected+ " actual: " +actual);
        }
    }
    
    @Test
    /* tests that the height of an empty tree is 0 
     * 
     */
    public void test14_testAscendingOrder_MultipleInserts_OneDelete() throws DuplicateKeyException {
        strTree.insert("A");
        strTree.insert("C");
        strTree.insert("B");
//        strTree.delete("C");
        strTree.height();
        expected = "A B ";
        actual = "" + strTree.inAscendingOrder();
        if(! expected.equals(actual)) {
            fail("expected: " +expected+ " actual: " +actual);
        }
    }
    
    @Test
    /* tests that the height of an empty tree is 0 
     * 
     */
    public void test15_testAscendingOrder_MultipleInserts() throws DuplicateKeyException {
        strTree.insert("A");
        strTree.insert("C");
        strTree.insert("B");
        expected = "A B C ";
        actual = "" + strTree.inAscendingOrder();
        if(! expected.equals(actual)) {
            fail("expected: " +expected+ " actual: " +actual);
        }
    }
    
}

