/**
 * Main.java created by Xuxiang Sun on ThinkPad in p2_BalancedSearchTree
 *
 * Author: Xuxiang Sun (xsun272@wisc.edu) Date: February 20, 2020
 *
 * Course: CS400 Semester: Spring 2020 Lecture: 001
 *
 * IDE: Eclipse IDE for Java Developers Version: 2019-12 (4.14.0) Build id: 20191212-1212
 *
 * Device: ThinkPad X1 Carbon OS: Windows 10 Pro Version: 1809 OS Build: 17763.973
 *
 * List Collaborators: Name, email@wisc.edu, lecture number
 * 
 * Other Credits: describe other source (web sites or people)
 *
 * Known Bugs: describe known unresolved bugs here
 */

import static org.junit.Assert.fail;

import org.junit.Assert;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * 
 * TestBST - Test class for BST class
 * 
 * @author Xuxiang Sun (2020)
 *
 */
// @SuppressWarnings("rawtypes")
public class TestBST {
  protected STADT<Integer, String> bst;

  /**
   * @throws java.lang.Exception
   */
  @BeforeEach
  void setUp() throws Exception {
    bst = new BST<Integer, String>();
  }

  /**
   * @throws java.lang.Exception
   */
  @AfterEach
  void tearDown() throws Exception {
  }

  /**
   * CASE 123 Insert three values in sorted order and then check the root, left, and right keys to
   * see if insert worked correctly.
   */
  @Test
  void testBST_001_insert_sorted_order_simple() {
    try {
      bst.insert(10, "10");
      if (!bst.getKeyAtRoot().equals(10))
        fail("insert at root does not work");

      bst.insert(20, "20");
      if (!bst.getKeyOfRightChildOf(10).equals(20))
        fail("insert to right child of root does not work");

      bst.insert(30, "30");
      if (!bst.getKeyAtRoot().equals(10))
        fail("inserting 30 changed root");

      if (!bst.getKeyOfRightChildOf(20).equals(30))
        fail("inserting 30 as right child of 20");

      // IF rebalancing is working,
      // the tree should have 20 at the root
      // and 10 as its left child and 30 as its right child

      Assert.assertEquals(bst.getKeyAtRoot(), Integer.valueOf(10));
      Assert.assertEquals(bst.getKeyOfRightChildOf(10), Integer.valueOf(20));
      Assert.assertEquals(bst.getKeyOfRightChildOf(20), Integer.valueOf(30));

      bst.print();

    } catch (Exception e) {
      e.printStackTrace();
      fail("Unexpected exception 001: " + e.getMessage());
    }
  }

  /**
   * CASE 321 Insert three values in reverse sorted order and then check the root, left, and right
   * keys to see if insert worked in the other direction.
   */
  @Test
  void testBST_002_insert_reversed_sorted_order_simple() {
    try {
      bst.insert(30, "30");
      if (!bst.getKeyAtRoot().equals(30))
        fail("insert at root does not work");

      bst.insert(20, "20");
      if (!bst.getKeyOfLeftChildOf(30).equals(20))
        fail("insert to left child of root does not work");

      bst.insert(10, "10");
      if (!bst.getKeyAtRoot().equals(30))
        fail("inserting 10 changed root");

      if (!bst.getKeyOfLeftChildOf(20).equals(10))
        fail("inserting 10 as left child of 20");

      // IF rebalancing is working,
      // the tree should have 20 at the root
      // and 10 as its left child and 30 as its right child

      Assert.assertEquals(bst.getKeyAtRoot(), Integer.valueOf(30));
      Assert.assertEquals(bst.getKeyOfLeftChildOf(30), Integer.valueOf(20));
      Assert.assertEquals(bst.getKeyOfLeftChildOf(20), Integer.valueOf(10));

      bst.print();

    } catch (Exception e) {
      e.printStackTrace();
      fail("Unexpected exception 001: " + e.getMessage());
    }
  }

  /**
   * CASE 132 Insert three values so that rebalancing requires new key to be the "new" root of the
   * rebalanced tree.
   * 
   * Then check the root, left, and right keys to see if insert occurred correctly.
   */
  @Test
  void testBST_003_insert_smallest_largest_middle_order_simple() {
    try {
      bst.insert(10, "10");
      if (!bst.getKeyAtRoot().equals(10))
        fail("insert at root does not work");

      bst.insert(30, "30");
      if (!bst.getKeyOfRightChildOf(10).equals(30))
        fail("insert to right child of root does not work");
      Assert.assertEquals(bst.getKeyOfRightChildOf(10), Integer.valueOf(30));

      bst.insert(20, "20");
      if (!bst.getKeyAtRoot().equals(10))
        fail("inserting 20 changed root");

      if (!bst.getKeyOfLeftChildOf(30).equals(20))
        fail("inserting 20 as left child of 30");

      // IF rebalancing is working,
      // the tree should have 20 at the root
      // and 10 as its left child and 30 as its right child

      Assert.assertEquals(bst.getKeyAtRoot(), Integer.valueOf(10));
      Assert.assertEquals(bst.getKeyOfRightChildOf(10), Integer.valueOf(30));
      Assert.assertEquals(bst.getKeyOfLeftChildOf(30), Integer.valueOf(20));

      bst.print();

    } catch (Exception e) {
      e.printStackTrace();
      fail("Unexpected exception 001: " + e.getMessage());
    }
  }

  /**
   * CASE 312 Insert three values so that rebalancing requires new key to be the "new" root of the
   * rebalanced tree.
   * 
   * Then check the root, left, and right keys to see if insert occurred correctly.
   */
  @Test
  void testBST_004_insert_largest_smallest_middle_order_simple() {
    try {
      bst.insert(30, "30");
      if (!bst.getKeyAtRoot().equals(30))
        fail("insert at root does not work");

      bst.insert(10, "10");
      if (!bst.getKeyOfLeftChildOf(30).equals(10))
        fail("insert to left child of root does not work");

      bst.insert(20, "20");
      if (!bst.getKeyAtRoot().equals(30))
        fail("inserting 10 changed root");

      if (!bst.getKeyOfRightChildOf(10).equals(20))
        fail("inserting 20 as right child of 10");

      // the tree should have 30 at the root
      // and 10 as its left child and 20 as 10's right child

      Assert.assertEquals(bst.getKeyAtRoot(), Integer.valueOf(30));
      Assert.assertEquals(bst.getKeyOfLeftChildOf(30), Integer.valueOf(10));
      Assert.assertEquals(bst.getKeyOfRightChildOf(10), Integer.valueOf(20));

      bst.print();

    } catch (Exception e) {
      e.printStackTrace();
      fail("Unexpected exception 001: " + e.getMessage());
    }
  }


  // TODO: Add your own tests
  /**
   * insert one node and remove it, then confirm size is 0.
   */
  @Test
  void testBST_005_delete_one_element() {
    try {
      bst.insert(30, "30");
      if (!bst.getKeyAtRoot().equals(30))
        fail("insert at root does not work");
      try {
        bst.remove(30);
      } catch (IllegalNullKeyException e) {
        fail("Should not have catched exception" + e.getMessage());
      }
      if (bst.numKeys() != 0) {
        fail("BST should be size = 0");
      }
    } catch (Exception e) {
      e.printStackTrace();
      fail("Unexpected exception 001: " + e.getMessage());
    }
  }

  /**
   * remove null, then confirm exception was thrown
   */
  @Test
  void testBST_006_delete_null() {
    try {
      bst.insert(30, "30");
      if (!bst.getKeyAtRoot().equals(30))
        fail("insert at root does not work");
      try {
        bst.remove(null);
        fail("Should have catched exception");
      } catch (IllegalArgumentException e) {
      }
      if (bst.numKeys() != 1) {
        fail("BST should be size = 1");
      }

    } catch (Exception e) {
      e.printStackTrace();
      fail("Unexpected exception 001: " + e.getMessage());
    }
  }

  /**
   * Inserts many items and check if rebalancing occur.
   */
  @Test
  void testBST_007_insert_many_items() {
    try {
      bst.insert(40, "40");
      if (!bst.getKeyAtRoot().equals(40))
        fail("insert at root does not work");

      bst.insert(10, "10");
      if (!bst.getKeyOfLeftChildOf(40).equals(10))
        fail("insert to left child of root does not work");

      // inserts a list of many numbers
      bst.insert(20, "20");
      bst.insert(50, "50");
      bst.insert(35, "35");
      bst.insert(60, "60");
      bst.insert(70, "70");
      bst.insert(15, "15");
      // checks if the output matches the level order traversal string
      if (!bst.getLevelOrderTraversal().toString().equals("[40, 10, 50, 20, 60, 15, 35, 70]")) {
        fail("Insert many items resulted in wrong order");
      }
    } catch (Exception e) {
      e.printStackTrace();
      fail("Unexpected exception 001: " + e.getMessage());
    }
  }

  /**
   * Utilizes get() and checks if get behaves correctly when getting value or null
   */
  @Test
  void testBST_008_get_items_get_null() {
    try {
      bst.insert(40, "40");
      if (!bst.getKeyAtRoot().equals(40))
        fail("insert at root does not work");

      bst.insert(10, "10");
      if (!bst.getKeyOfLeftChildOf(40).equals(10))
        fail("insert to left child of root does not work");

      // inserts a list of many numbers
      bst.insert(20, "20");
      bst.insert(50, "50");
      bst.insert(35, "35");
      bst.insert(60, "60");
      bst.insert(70, "70");
      bst.insert(15, "15");
      // checks if the output matches the level order traversal string
      if (!bst.getLevelOrderTraversal().toString().equals("[40, 10, 50, 20, 60, 15, 35, 70]")) {
        fail("Insert many items resulted in wrong order");
      }
      // checks if the get method correctly returns the value
      if (bst.get(20) != "20" || bst.get(15) != "15") {
        fail("Get value was incorrect");
      }
      // checks if get throws exception when getting null
      try {
        bst.get(null);
        fail("Exception was not thrown");
      } catch (IllegalNullKeyException e) {
      }
    } catch (Exception e) {
      e.printStackTrace();
      fail("Unexpected exception 001: " + e.getMessage());
    }
  }

  /**
   * Utilizes the getHeight() and checks if correct height is returned
   */
  @Test
  void testBST_009_tree_height() {
    try {
      bst.insert(40, "40");
      if (!bst.getKeyAtRoot().equals(40))
        fail("insert at root does not work");

      bst.insert(10, "10");
      if (!bst.getKeyOfLeftChildOf(40).equals(10))
        fail("insert to left child of root does not work");

      // inserts a list of many numbers
      bst.insert(20, "20");
      bst.insert(50, "50");
      bst.insert(35, "35");
      bst.insert(60, "60");
      bst.insert(70, "70");
      bst.insert(15, "15");
      // checks if the output matches the level order traversal string
      if (!bst.getLevelOrderTraversal().toString().equals("[40, 10, 50, 20, 60, 15, 35, 70]")) {
        fail("Insert many items resulted in wrong order");
      }
      // checks if the correct height of tree is returned
      if (bst.getHeight() != 4) {
        fail("Height returned is incorrect");
      }
    } catch (Exception e) {
      e.printStackTrace();
      fail("Unexpected exception 001: " + e.getMessage());
    }
  }

  /**
   * Inserts many items and remove, check if size is correct after some removes
   */
  @Test
  void testBST_010_insert_delete_half() {
    try {
      bst.insert(40, "40");
      if (!bst.getKeyAtRoot().equals(40))
        fail("insert at root does not work");

      bst.insert(10, "10");
      if (!bst.getKeyOfLeftChildOf(40).equals(10))
        fail("insert to left child of root does not work");

      // inserts a list of many numbers
      bst.insert(20, "20");
      bst.insert(50, "50");
      bst.insert(35, "35");
      bst.insert(60, "60");
      bst.insert(70, "70");
      bst.insert(15, "15");

      // deletes items in random order
      bst.remove(20);
      bst.remove(40);
      bst.remove(50);
      bst.remove(15);
      // check if size is correct after deleting half of items
      if (bst.numKeys() != 4) {
        fail("BST should be size = 4");
      }
      // deletes the rest of the items in random order
      bst.remove(60);
      bst.remove(70);
      bst.remove(35);
      bst.remove(10);
      if (bst.numKeys() != 0) {
        fail("BST should be size = 0");
      }

    } catch (Exception e) {
      e.printStackTrace();
      fail("Unexpected exception 001: " + e.getMessage());
    }
  }
  // Add tests to make sure that bst grows as expected.
  // Does it maintain it's balance?
  // Does the height of the tree reflect it's actual height
  // Use the traversal orders to check.

  // Can you insert many and still "get" them back out?

  // Does delete work?
  // If delete is not implemented, does calling it throw an UnsupportedOperationException
}
