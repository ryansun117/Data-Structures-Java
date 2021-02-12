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

// import org.junit.jupiter.api.AfterAll;
// import org.junit.jupiter.api.BeforeAll;

// TODO: Add tests to test if a Red-Black tree
// extension of BST is correct. Mostly check node color and position

// @SuppressWarnings("rawtypes")
public class TestRBT {
  protected RBT<Integer, String> rbt;

  /**
   * @throws java.lang.Exception
   */
  @BeforeEach
  void setUp() throws Exception {
    rbt = new RBT<Integer, String>();
  }

  /**
   * @throws java.lang.Exception
   */
  @AfterEach
  void tearDown() throws Exception {
  }

  /**
   * CASE 123 Insert three values in sorted order and then check the root, left, and right keys to
   * see if RBT rebalancing occurred.
   * 
   */
  @Test
  void testRBT_001_insert_sorted_order_simple() {
    try {
      rbt.insert(10, "10");
      Assert.assertTrue(rbt.rootIsBlack());

      rbt.insert(20, "20");
      Assert.assertTrue(rbt.getKeyOfRightChildOf(10).equals(20));
      Assert.assertEquals(rbt.colorOf(20), RBT.RED);

      rbt.insert(30, "30"); // SHOULD CAUSE REBALANCING
      Assert.assertTrue(rbt.getKeyOfRightChildOf(20).equals(30));

      // IF rebalancing is working,
      // the tree should have 20 at the root
      // and 10 as its left child and 30 as its right child
      Assert.assertEquals(rbt.getKeyAtRoot(), Integer.valueOf(20));
      Assert.assertEquals(rbt.getKeyOfLeftChildOf(20), Integer.valueOf(10));
      Assert.assertEquals(rbt.getKeyOfRightChildOf(20), Integer.valueOf(30));

      rbt.print();

    } catch (Exception e) {
      // e.printStackTrace();
      fail("Unexpected exception 001: " + e.getMessage());
    }
  }

  /**
   * CASE 321 Insert three values in reverse sorted order and then check the root, left, and right
   * keys to see if rebalancing occurred in the other direction.
   */
  @Test
  void testRBT_002_insert_reversed_sorted_order_simple() {
    try {
      rbt.insert(30, "30");
      if (!rbt.getKeyAtRoot().equals(30))
        fail("insert at root does not work");

      rbt.insert(20, "20");
      if (!rbt.getKeyOfLeftChildOf(30).equals(20))
        fail("insert to left child of root does not work");

      rbt.insert(10, "10");
      if (!rbt.getKeyAtRoot().equals(20))
        fail("inserting 10 changed root");

      if (!rbt.getKeyOfLeftChildOf(20).equals(10))
        fail("inserting 10 as left child of 20");

      // IF rebalancing is working,
      // the tree should have 20 at the root
      // and 10 as its left child and 30 as its right child

      Assert.assertEquals(rbt.getKeyAtRoot(), Integer.valueOf(20));
      Assert.assertEquals(rbt.getKeyOfLeftChildOf(20), Integer.valueOf(10));
      Assert.assertEquals(rbt.getKeyOfRightChildOf(20), Integer.valueOf(30));

      rbt.print();

    } catch (Exception e) {
      e.printStackTrace();
      fail("Unexpected exception 001: " + e.getMessage());
    }

  }

  /**
   * CASE 132 Insert three values so that rebalancing requires new key to be the "new" root of the
   * rebalanced tree.
   * 
   * Then check the root, left, and right keys to see if rebalancing occurred correctly.
   */
  @Test
  void testRBT_003_insert_smallest_largest_middle_order_simple() {
    try {
      rbt.insert(10, "10");
      if (!rbt.getKeyAtRoot().equals(10))
        fail("insert at root does not work");

      rbt.insert(30, "30");
      if (!rbt.getKeyOfRightChildOf(10).equals(30))
        fail("insert to right child of root does not work");

      rbt.insert(20, "20");
      if (!rbt.getKeyAtRoot().equals(20))
        fail("inserting 20 changed root");

      if (!rbt.getKeyOfLeftChildOf(20).equals(10))
        fail("inserting 10 as left child of 30");

      // IF rebalancing is working,
      // the tree should have 20 at the root
      // and 10 as its left child and 30 as its right child

      Assert.assertEquals(rbt.getKeyAtRoot(), Integer.valueOf(20));
      Assert.assertEquals(rbt.getKeyOfLeftChildOf(20), Integer.valueOf(10));
      Assert.assertEquals(rbt.getKeyOfRightChildOf(20), Integer.valueOf(30));

      rbt.print();

    } catch (Exception e) {
      e.printStackTrace();
      fail("Unexpected exception 001: " + e.getMessage());
    }
  }

  /**
   * CASE 312 Insert three values so that rebalancing requires new key to be the "new" root of the
   * rebalanced tree.
   * 
   * Then check the root, left, and right keys to see if rebalancing occurred correctly.
   */
  @Test
  void testRBT_004_insert_largest_smallest_middle_order_simple() {
    try {
      rbt.insert(10, "10");
      if (!rbt.getKeyAtRoot().equals(10))
        fail("insert at root does not work");

      rbt.insert(30, "30");
      if (!rbt.getKeyOfRightChildOf(10).equals(30))
        fail("insert to right child of root does not work");

      rbt.insert(20, "20");
      if (!rbt.getKeyAtRoot().equals(20))
        fail("inserting 20 changed root");

      if (!rbt.getKeyOfLeftChildOf(20).equals(10))
        fail("inserting 10 as left child of 30");

      // IF rebalancing is working,
      // the tree should have 20 at the root
      // and 10 as its left child and 30 as its right child

      Assert.assertEquals(rbt.getKeyAtRoot(), Integer.valueOf(20));
      Assert.assertEquals(rbt.getKeyOfLeftChildOf(20), Integer.valueOf(10));
      Assert.assertEquals(rbt.getKeyOfRightChildOf(20), Integer.valueOf(30));

      rbt.print();

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
  void testRBT_005_delete_one_element() {
    try {
      rbt.insert(30, "30");
      if (!rbt.getKeyAtRoot().equals(30))
        fail("insert at root does not work");
      try {
        rbt.remove(30);
        fail("Should have catched exception");
      } catch (UnsupportedOperationException e) {
      }
      if (rbt.numKeys() != 1) {
        fail("BST should be size = 1" + rbt.numKeys());
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
  void testRBT_006_delete_null() {
    try {
      rbt.insert(30, "30");
      if (!rbt.getKeyAtRoot().equals(30))
        fail("insert at root does not work");
      try {
        rbt.remove(30);
        fail("Should have catched exception");
      } catch (UnsupportedOperationException e) {
      }
      if (rbt.numKeys() != 1) {
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
  void testRBT_007_insert_many_items() {
    try {
      rbt.insert(40, "40");
      if (!rbt.getKeyAtRoot().equals(40))
        fail("insert at root does not work");

      rbt.insert(10, "10");
      if (!rbt.getKeyOfLeftChildOf(40).equals(10))
        fail("insert to left child of root does not work");

      // inserts a list of many numbers
      rbt.insert(20, "20");
      rbt.insert(50, "50");
      rbt.insert(0, "0");
      rbt.insert(60, "60");
      rbt.insert(70, "70");
      rbt.insert(5, "5");
      // checks if the output matches the level order traversal string
      if (!rbt.getLevelOrderTraversal().toString().equals("[20, 5, 50, 0, 10, 40, 60, 70]")) {
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
      rbt.insert(40, "40");
      if (!rbt.getKeyAtRoot().equals(40))
        fail("insert at root does not work");

      rbt.insert(10, "10");
      if (!rbt.getKeyOfLeftChildOf(40).equals(10))
        fail("insert to left child of root does not work");

      // inserts a list of many numbers
      rbt.insert(20, "20");
      rbt.insert(50, "50");
      rbt.insert(0, "0");
      rbt.insert(60, "60");
      rbt.insert(70, "70");
      rbt.insert(5, "5");
      // checks if the output matches the level order traversal string
      if (!rbt.getLevelOrderTraversal().toString().equals("[20, 5, 50, 0, 10, 40, 60, 70]")) {
        fail("Insert many items resulted in wrong order");
      }
      // checks if the get method correctly returns the value
      if (rbt.get(20) != "20" || rbt.get(5) != "5") {
        fail("Get value was incorrect");
      }
      // checks if get throws exception when getting null
      try {
        rbt.get(null);
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
      rbt.insert(40, "40");
      if (!rbt.getKeyAtRoot().equals(40))
        fail("insert at root does not work");

      rbt.insert(10, "10");
      if (!rbt.getKeyOfLeftChildOf(40).equals(10))
        fail("insert to left child of root does not work");

      // inserts a list of many numbers
      rbt.insert(20, "20");
      rbt.insert(50, "50");
      rbt.insert(35, "35");
      rbt.insert(60, "60");
      rbt.insert(70, "70");
      rbt.insert(15, "15");
      // checks if the output matches the level order traversal string
      if (!rbt.getLevelOrderTraversal().toString().equals("[20, 10, 40, 15, 35, 60, 50, 70]")) {
        fail("Insert many items resulted in wrong order");
      }
      // checks if the correct height of tree is returned
      if (rbt.getHeight() != 4) {
        fail("Height returned is incorrect");
      }
    } catch (Exception e) {
      e.printStackTrace();
      fail("Unexpected exception 001: " + e.getMessage());
    }
  }

  /**
   * Inserts many items and remove, check if UnsupportedOperationException is thrown
   */
  @Test
  void testBST_010_insert_delete_half() {
    try {
      rbt.insert(40, "40");
      if (!rbt.getKeyAtRoot().equals(40))
        fail("insert at root does not work");

      rbt.insert(10, "10");
      if (!rbt.getKeyOfLeftChildOf(40).equals(10))
        fail("insert to left child of root does not work");

      // inserts a list of many numbers
      rbt.insert(20, "20");
      rbt.insert(50, "50");
      rbt.insert(35, "35");
      rbt.insert(60, "60");
      rbt.insert(70, "70");
      rbt.insert(15, "15");

      try {
        // deletes items in random order
        rbt.remove(20);
        rbt.remove(40);
        rbt.remove(50);
        rbt.remove(15);
        // check if size is correct after deleting half of items
        if (rbt.numKeys() != 4) {
          fail("BST should be size = 4");
        }
        // deletes the rest of the items in random order
        rbt.remove(60);
        rbt.remove(70);
        rbt.remove(35);
        rbt.remove(10);
        if (rbt.numKeys() != 0) {
          fail("BST should be size = 0");
        }
      } catch (UnsupportedOperationException e) {
      }
    } catch (Exception e) {
      e.printStackTrace();
      fail("Unexpected exception 001: " + e.getMessage());
    }
  }
  // Add tests to make sure that rebalancing occurs even if the
  // tree is larger. Does it maintain it's balance?
  // Does the height of the tree reflect it's actual height
  // Use the traversal orders to check.

  // Can you insert many and still "get" them back out?

  // Does delete work? Does the tree maintain balance when a key is deleted?
  // If delete is not implemented, does calling it throw an UnsupportedOperationException
} // copyright Deb Deppeler, all rights reserved, DO NOT SHARE
