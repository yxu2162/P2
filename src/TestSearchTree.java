import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/////////////////////////////////////////////////////////////////////////////
// Semester:         CS400 Spring 2018
// PROJECT:          cs400_p2_201801
// FILES:            TestSearchTree.java
//                   SearchTreeADT.java
//                   BalancedSearchTree.java
//
// USER:             deppeler
//
// Instructor:       Deb Deppeler (deppeler@cs.wisc.edu)
// Bugs:             no known bugs, but not complete either
//
// 2018 Feb 8, 2018 5:13:18 PM TestSearchTree.java 
//////////////////////////// 80 columns wide //////////////////////////////////

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

    //
    //	@Test
    //	/** tests that the height of an empty tree is 0 */
    //	public void test03_height_on_empty_tree() {
    //		expected = "0";
    //		actual = "" + strTree.height();
    //		if (! expected.equals(actual))
    //			fail("expected: "+expected+ " actual: "+actual);
    //	}
    //
    //	@Test
    //	public void test04_isEmpty_after_one_insert() {
    //		strTree.insert("1");
    //		expected = "false";
    //		actual = "" + strTree.isEmpty();
    //		if (! expected.equals(actual))
    //			fail("expected: "+expected+ " actual: "+actual);
    //	}
    //
    //	@Test
    //	/** tests that the ascending order after inserting A item is "A," */
    //	public void test05_ascending_order_after_one_insert() {
    //		strTree.insert("A");
    //		expected = "A,";
    //		actual = strTree.inAscendingOrder();
    //		if (! expected.equals(actual))
    //			fail("expected: "+expected+ " actual: "+actual);
    //	}
    //
    //	@Test
    //	/** tests that the height after inserting A is 1 */
    //	public void test06_height_after_one_insert() {
    //		strTree.insert("A");
    //		expected = "1";
    //		actual = "" + strTree.height();
    //		if (! expected.equals(actual))
    //			fail("expected: "+expected+ " actual: "+actual);
    //	}
    //
    //	@Test
    //	/** tests that the height after inserting A and B and and deleting A is 1 */
    //	public void test07_height_after_two_insert_and_one_delete() {
    //		strTree.insert("A");
    //		strTree.insert("B");
    //		strTree.delete("A");
    //		expected = "1";
    //		actual = "" + strTree.height();
    //		if (! expected.equals(actual))
    //			fail("expected: "+expected+ " actual: "+actual);
    //	}

    //<<<<<<< HEAD
    //	@Test
    //	/** tests that the height of an empty tree is 0 */
    //	public void test03_height_on_empty_tree() {
    //		expected = "0";
    //		actual = "" + strTree.height();
    //		if (! expected.equals(actual))
    //			fail("expected: "+expected+ " actual: "+actual);
    //	}
    //
    //	@Test
    //	public void test04_isEmpty_after_one_insert() {
    //		strTree.insert("1");
    //		expected = "false";
    //		actual = "" + strTree.isEmpty();
    //		if (! expected.equals(actual))
    //			fail("expected: "+expected+ " actual: "+actual);
    //	}
    //
    //	@Test
    //	/** tests that the ascending order after inserting A item is "A," */
    //	public void test05_ascending_order_after_one_insert() {
    //		strTree.insert("A");
    //		expected = "A,";
    //		actual = strTree.inAscendingOrder();
    //		if (! expected.equals(actual))
    //			fail("expected: "+expected+ " actual: "+actual);
    //	}
    //
    //	@Test
    //	/** tests that the height after inserting A is 1 */
    //	public void test06_height_after_one_insert() {
    //		strTree.insert("A");
    //		expected = "1";
    //		actual = "" + strTree.height();
    //		if (! expected.equals(actual))
    //			fail("expected: "+expected+ " actual: "+actual);
    //	}
    //
    //	@Test
    //	/** tests that the height after inserting A and B and and deleting A is 1 */
    //	public void test07_height_after_two_insert_and_one_delete() {
    //		strTree.insert("A");
    //		strTree.insert("B");
    //		strTree.delete("A");
    //		expected = "1";
    //		actual = "" + strTree.height();
    //		if (! expected.equals(actual))
    //			fail("expected: "+expected+ " actual: "+actual);
    //	}


//    @Test
//    public void test08_checkEmptyHeight() {
//        expected = "0";
//        actual = "" + strTree.isEmpty();
//        if(! expected.equals(actual))
//            fail("expected: " +expected+ " actual: " +actual);
//    }
//
//    @Test
//    public void test09_checkLookUp() {
//        strTree.insert("A");
//        expected = "true";
//        actual = "" + strTree.lookup("A");
//        if(! expected.equals(actual))
//            fail("expected: " +expected+ " actual: " +actual);
//    }
//
//    @Test
//    public void test10_checkMultipleLookUp() {
//        strTree.insert("D");
//        strTree.insert("A");
//        strTree.insert("C");
//        strTree.insert("E");
//        strTree.insert("B");
//        expected = "true";
//        actual = "" + strTree.lookup("D");
//        if(! expected.equals(actual)) {
//            fail("expected: " +expected+ " actual: " +actual);
//        }
//    }
//
//    @Test
//    public void test11_insertNull() {
//        try {
//            strTree.insert(null);
//            fail("expected: " +expected+ " actual: " +actual);
//        } catch (IllegalArgumentException e) {
//
//        }
//    }
//
//    @Test
//    public void test12_insertDupes() {
//        try {
//            strTree.insert("A");
//            strTree.insert("A");
//            fail("expected: " +expected+ " actual: " +actual);
//        } catch (DuplicateKeyException e) {
//            
//        }
//    }
//}

    @Test
    public void test08_checkEmptyHeight() {
        expected = "0";
        actual = "" + strTree.isEmpty();
        if(! expected.equals(actual))
            fail("expected: " +expected+ " actual: " +actual);
    }

    @Test
    public void test09_checkLookUp() throws DuplicateKeyException {
        strTree.insert("A");
        expected = "true";
        actual = "" + strTree.lookup("A");
        if(! expected.equals(actual))
            fail("expected: " +expected+ " actual: " +actual);
    }

    @Test
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
    public void test11_insertNull() throws DuplicateKeyException {
        try {
            strTree.insert(null);
            fail("expected: " +expected+ " actual: " +actual);
        } catch (IllegalArgumentException e) {

        }
    }

    @Test
    public void test12_insertDupes() {
        try {
            strTree.insert("A");
            strTree.insert("A");
            fail("expected: " +expected+ " actual: " +actual);
        } catch (DuplicateKeyException e) {
            
        }
    }


}


//    @Test
//    /** tests that the height after inserting A and B and and deleting A is 1 */
//    public void test09_height_after_two_insert_and_one_delete() {
//        strTree.insert("A");
//        strTree.insert("B");
//        strTree.delete("A");
//        expected = "1";
//        actual = "" + strTree.height();
//        if (! expected.equals(actual))
//            fail("expected: "+expected+ " actual: "+actual);
//    }
//
//    @Test
//    /** tests that the height after inserting A and B and and deleting A is 1 */
//    public void test07_height_after_two_insert_and_one_delete() {
//        strTree.insert("A");
//        strTree.insert("B");
//        strTree.delete("A");
//        expected = "1";
//        actual = "" + strTree.height();
//        if (! expected.equals(actual))
//            fail("expected: "+expected+ " actual: "+actual);
//    }
//
//    @Test
//    /** tests that the height after inserting A and B and and deleting A is 1 */
//    public void test07_height_after_two_insert_and_one_delete() {
//        strTree.insert("A");
//        strTree.insert("B");
//        strTree.delete("A");
//        expected = "1";
//        actual = "" + strTree.height();
//        if (! expected.equals(actual))
//            fail("expected: "+expected+ " actual: "+actual);
//    }
//
//    @Test
//    /** tests that the height after inserting A and B and and deleting A is 1 */
//    public void test07_height_after_two_insert_and_one_delete() {
//        strTree.insert("A");
//        strTree.insert("B");
//        strTree.delete("A");
//        expected = "1";
//        actual = "" + strTree.height();
//        if (! expected.equals(actual))
//            fail("expected: "+expected+ " actual: "+actual);
//    }
//
//    @Test
//    /** tests that the height after inserting A and B and and deleting A is 1 */
//    public void test07_height_after_two_insert_and_one_delete() {
//        strTree.insert("A");
//        strTree.insert("B");
//        strTree.delete("A");
//        expected = "1";
//        actual = "" + strTree.height();
//        if (! expected.equals(actual))
//            fail("expected: "+expected+ " actual: "+actual);
//    }
//
//    @Test
//    /** tests that the height after inserting A and B and and deleting A is 1 */
//    public void test07_height_after_two_insert_and_one_delete() {
//        strTree.insert("A");
//        strTree.insert("B");
//        strTree.delete("A");
//        expected = "1";
//        actual = "" + strTree.height();
//        if (! expected.equals(actual))
//            fail("expected: "+expected+ " actual: "+actual);
//    }
//
//    @Test
//    /** tests that the height after inserting A and B and and deleting A is 1 */
//    public void test07_height_after_two_insert_and_one_delete() {
//        strTree.insert("A");
//        strTree.insert("B");
//        strTree.delete("A");
//        expected = "1";
//        actual = "" + strTree.height();
//        if (! expected.equals(actual))
//            fail("expected: "+expected+ " actual: "+actual);
//    }
//
//    @Test
//    /** tests that the height after inserting A and B and and deleting A is 1 */
//    public void test07_height_after_two_insert_and_one_delete() {
//        strTree.insert("A");
//        strTree.insert("B");
//        strTree.delete("A");
//        expected = "1";
//        actual = "" + strTree.height();
//        if (! expected.equals(actual))
//            fail("expected: "+expected+ " actual: "+actual);
//    }
//
//    @Test
//    /** tests that the height after inserting A and B and and deleting A is 1 */
//    public void test07_height_after_two_insert_and_one_delete() {
//        strTree.insert("A");
//        strTree.insert("B");
//        strTree.delete("A");
//        expected = "1";
//        actual = "" + strTree.height();
//        if (! expected.equals(actual))
//            fail("expected: "+expected+ " actual: "+actual);
//    }
//
//    @Test
//    /** tests that the height after inserting A and B and and deleting A is 1 */
//    public void test07_height_after_two_insert_and_one_delete() {
//        strTree.insert("A");
//        strTree.insert("B");
//        strTree.delete("A");
//        expected = "1";
//        actual = "" + strTree.height();
//        if (! expected.equals(actual))
//            fail("expected: "+expected+ " actual: "+actual);
//    }
//
//    @Test
//    /** tests that the height after inserting A and B and and deleting A is 1 */
//    public void test07_height_after_two_insert_and_one_delete() {
//        strTree.insert("A");
//        strTree.insert("B");
//        strTree.delete("A");
//        expected = "1";
//        actual = "" + strTree.height();
//        if (! expected.equals(actual))
//            fail("expected: "+expected+ " actual: "+actual);
//    }
//
//    @Test
//    /** tests that the height after inserting A and B and and deleting A is 1 */
//    public void test07_height_after_two_insert_and_one_delete() {
//        strTree.insert("A");
//        strTree.insert("B");
//        strTree.delete("A");
//        expected = "1";
//        actual = "" + strTree.height();
//        if (! expected.equals(actual))
//            fail("expected: "+expected+ " actual: "+actual);
//    }

