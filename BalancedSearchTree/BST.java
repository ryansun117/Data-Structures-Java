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

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

// DO IMPLEMENT A BINARY SEARCH TREE IN THIS CLASS

/**
 * Defines the operations required of student's BST class.
 *
 * NOTE: There are many methods in this interface that are required solely to support gray-box
 * testing of the internal tree structure. They must be implemented as described to pass all grading
 * tests.
 * 
 * @author Deb Deppeler (deppeler@cs.wisc.edu)
 * @param <K> A Comparable type to be used as a key to an associated value.
 * @param <V> A value associated with the given key.
 */
public class BST<K extends Comparable<K>, V> implements STADT<K, V> {
  private Node root; // private root variable of type K
  private int size; // private int variable keep track of size
  private List<K> traversalList; // private List for traversal operations

  /**
   * Private inner class representing a node in BST Node
   * 
   * @author Xuxiang Sun (2020)
   *
   */
  private class Node {
    private K key; // key variable of type comparable K
    private V value; // value variable of type V
    private Node leftNode; // left node of current node
    private Node rightNode; // right node of current node

    /**
     * No argument constructor for an empty Node class
     */
    private Node() {
      key = null;
      leftNode = null;
      rightNode = null;
    }

    /**
     * Constructor that takes a comparable K key as input
     * 
     * @param key - K key stored as data in node
     */
    private Node(K key) {
      this.key = key;
      leftNode = null;
      rightNode = null;
    }

    /**
     * Constructor that takes a String key and String value as inputs
     * 
     * @param key   - K key stored as data in node
     * @param value - V value stored as data
     */
    private Node(K key, V value) {
      this.key = key;
      this.value = value;
      leftNode = null;
      rightNode = null;
    }

    /**
     * Getter for key field.
     * 
     * @return The key of this Node
     */
    private K getKey() {
      return this.key;
    }

    /**
     * Getter for value field.
     * 
     * @return The value of this Node
     */
    private V getValue() {
      return this.value;
    }

    /**
     * Getter for leftNode field.
     * 
     * @return The leftNode of this Node
     */
    private Node getLeftNode() {
      return leftNode;
    }

    /**
     * Getter for rightNode field.
     * 
     * @return The rightNode of this Node
     */
    private Node getRightNode() {
      return rightNode;
    }

    /**
     * Setter for key field
     * 
     * @param key, the comparable K variable key that the key field will be set to
     */
    private void setKey(K key) {
      this.key = key;
    }

    /**
     * Setter for value field
     * 
     * @param value, the V variable value that the key field will be set to
     */
    private void setValue(V value) {
      this.value = value;
    }

    /**
     * Setter for leftNode field
     * 
     * @param node, the Node that the leftNode field will be set to
     */
    private void setLeftNode(Node node) {
      this.leftNode = node;
    }

    /**
     * Setter for rightNode field
     * 
     * @param node, the Node that the rightNode field will be set to
     */
    private void setRightNode(Node node) {
      this.rightNode = node;
    }
  }

  /**
   * No argument constructor for DS_My class
   */
  public BST() {
    // TODO Auto-generated method stub
    this.root = null; // initialize to null
    this.size = 0; // initialize to 0
  }

  /**
   * Returns the key that is in the root node of this ST. If root is null, returns null.
   * 
   * @return key found at root node, or null
   */
  public K getKeyAtRoot() {
    if (this.root == null) {
      return null;
    }
    return this.root.getKey();
  }

  /**
   * Tries to find a node with a key that matches the specified key. If a matching node is found, it
   * returns the returns the key that is in the left child. If the left child of the found node is
   * null, returns null.
   * 
   * @param key A key to search for
   * @return The key that is in the left child of the found key
   * 
   * @throws IllegalNullKeyException if key argument is null
   * @throws KeyNotFoundException    if key is not found in this BST
   */
  public K getKeyOfLeftChildOf(K key) throws IllegalNullKeyException, KeyNotFoundException {
    // throws IllegalNullKeyException if key argument is null
    if (key == null) {
      throw new IllegalNullKeyException();
    }
    // throws KeyNotFoundException if key is not found in this BST
    if (this.contains(key) == false) {
      throw new KeyNotFoundException();
    }
    Node temp = root; // creates a temp node serving as the current key
    while (temp != null) { // loops through BST
      // return temp's value if key is found
      if (key.compareTo(temp.getKey()) == 0) {
        // return null if key node is null
        try {
          if (temp.getLeftNode().getKey() == null) {
            return null;
          }
        } catch (NullPointerException e) {
          return null;
        }
        return temp.getLeftNode().getKey();

        // if key is less than current key (temp), move down left subtree
      } else if (key.compareTo(temp.getKey()) < 0) {
        temp = temp.getLeftNode();

        // if key is more than current key (temp), move down right subtree
      } else if (key.compareTo(temp.getKey()) > 0) {
        temp = temp.getRightNode();
      }
    }
    throw new KeyNotFoundException(); // throw KeyNotFoundException() if key is not found
  }

  /**
   * Tries to find a node with a key that matches the specified key. If a matching node is found, it
   * returns the returns the key that is in the right child. If the right child of the found node is
   * null, returns null.
   * 
   * @param key A key to search for
   * @return The key that is in the right child of the found key
   * 
   * @throws IllegalNullKeyException if key is null
   * @throws KeyNotFoundException    if key is not found in this BST
   */
  public K getKeyOfRightChildOf(K key) throws IllegalNullKeyException, KeyNotFoundException {
    // throws IllegalNullKeyException if key argument is null
    if (key == null) {
      throw new IllegalNullKeyException();
    }
    // throws KeyNotFoundException if key is not found in this BST
    if (this.contains(key) == false) {
      throw new KeyNotFoundException();
    }
    Node temp = root; // creates a temp node serving as the current key
    while (temp != null) { // loops through BST
      // return temp's value if key is found
      if (key.compareTo(temp.getKey()) == 0) {
        // return null if key node is null
        try {
          if (temp.getRightNode().getKey() == null) {
            return null;
          }
        } catch (NullPointerException e) {
          return null;
        }
        return temp.getRightNode().getKey();

        // if key is less than current key (temp), move down left subtree
      } else if (key.compareTo(temp.getKey()) < 0) {
        temp = temp.getLeftNode();

        // if key is more than current key (temp), move down right subtree
      } else if (key.compareTo(temp.getKey()) > 0) {
        temp = temp.getRightNode();
      }
    }
    throw new KeyNotFoundException(); // throw KeyNotFoundException() if key is not found
  }

  /**
   * Returns the height of this BST. H is defined as the number of levels in the tree.
   * 
   * If root is null, return 0 If root is a leaf, return 1 Else return 1 + max( height(root.left),
   * height(root.right) )
   * 
   * Examples: A BST with no keys, has a height of zero (0). A BST with one key, has a height of one
   * (1). A BST with two keys, has a height of two (2). A BST with three keys, can be balanced with
   * a height of two(2) or it may be linear with a height of three (3) ... and so on for tree with
   * other heights
   * 
   * @return the number of levels that contain keys in this BINARY SEARCH TREE
   */
  public int getHeight() {
    // return 0 if root is null
    if (this.root == null) {
      return 0;
    }
    // return 1 if root is the only node in BST
    if (size == 1) {
      return 1;

      // else calls the helper method
    } else {
      return getHeightHelp(this.root);
    }
  }

  /**
   * Private recursive helper method to computer max height of the tree
   * 
   * @param node - the Node we are at currently
   * @return number of nodes along the longest path from the root node down to the farthest leaf
   *         node
   */
  private int getHeightHelp(Node node) {
    // return 0 if root is 0
    if (node == null) {
      return 0;
    }
    // returns 1 + the max between height of left subtree and height of right subtree of BST
    return 1 + Math.max(getHeightHelp(node.getLeftNode()), getHeightHelp(node.getRightNode()));
  }

  /**
   * Returns the keys of the data structure in sorted order. In the case of binary search trees, the
   * visit order is: L V R
   * 
   * If the SearchTree is empty, an empty list is returned.
   * 
   * @return List of Keys in-order
   */
  public List<K> getInOrderTraversal() {
    // initialize LinkedList for first time traversing
    if (traversalList == null) {
      traversalList = new LinkedList<K>();
    } else {
      // clears the list for starting over a new traversal
      traversalList.clear();
    }
    getInOrderTraversalHelp(this.root); // calls recursive helper method
    return traversalList; // returns list
  }

  /**
   * Private helper method that returns a list of keys in inorder fashion
   * 
   * @param current - Node that we are currently at
   */
  private void getInOrderTraversalHelp(Node current) {
    // Base case
    if (current == null) {
      return;
    }
    getInOrderTraversalHelp(current.getLeftNode()); // visits left node
    traversalList.add(current.getKey()); // prints/adds current node node
    getInOrderTraversalHelp(current.getRightNode()); // visits right node
  }

  /**
   * Returns the keys of the data structure in pre-order traversal order. In the case of binary
   * search trees, the order is: V L R
   * 
   * If the SearchTree is empty, an empty list is returned.
   * 
   * @return List of Keys in pre-order
   */
  public List<K> getPreOrderTraversal() {
    // initialize LinkedList for first time traversing
    if (traversalList == null) {
      traversalList = new LinkedList<K>();
    } else {
      // clears the list for starting over a new traversal
      traversalList.clear();
    }
    getPreOrderTraversalHelp(this.root); // calls recursive helper method
    return traversalList; // returns list
  }

  /**
   * Private helper method that returns a list of keys in preorder fashion
   * 
   * @param current - Node that we are currently at
   */
  private void getPreOrderTraversalHelp(Node current) {
    // Base case
    if (current == null) {
      return;
    }
    traversalList.add(current.getKey()); // prints/adds current node node
    getPreOrderTraversalHelp(current.getLeftNode()); // visits left node
    getPreOrderTraversalHelp(current.getRightNode()); // visits right node
  }

  /**
   * Returns the keys of the data structure in post-order traversal order. In the case of binary
   * search trees, the order is: L R V
   * 
   * If the SearchTree is empty, an empty list is returned.
   * 
   * @return List of Keys in post-order
   */
  public List<K> getPostOrderTraversal() {
    // initialize LinkedList for first time traversing
    if (traversalList == null) {
      traversalList = new LinkedList<K>();
    } else {
      // clears the list for starting over a new traversal
      traversalList.clear();
    }
    getPostOrderTraversalHelp(this.root); // calls recursive helper method
    return traversalList; // returns list
  }

  /**
   * Private helper method that returns a list of keys in postorder fashion
   * 
   * @param current - Node that we are currently at
   * @return traversalList - a list of keys in postorder fashion
   */
  private void getPostOrderTraversalHelp(Node current) {
    // Base case
    if (current == null) {
      return;
    }
    getPostOrderTraversalHelp(current.getLeftNode()); // visits left node
    getPostOrderTraversalHelp(current.getRightNode()); // visits right node
    traversalList.add(current.getKey()); // prints/adds current node node
  }

  /**
   * Returns the keys of the data structure in level-order traversal order.
   * 
   * The root is first in the list, then the keys found in the next level down, and so on.
   * 
   * If the SearchTree is empty, an empty list is returned.
   * 
   * @return List of Keys in level-order
   */
  public List<K> getLevelOrderTraversal() {
    // initialize LinkedList for first time traversing
    if (traversalList == null) {
      traversalList = new LinkedList<K>();
    } else {
      // clears the list for starting over a new traversal
      traversalList.clear();
    }
    getLevelOrderTraversalHelp(this.root); // calls recursive helper method
    return traversalList; // returns list
  }

  /**
   * Private helper method that returns a list of keys in levelorder fashion
   * 
   * @param current - Node that we are currently at
   * @return traversalList - a list of keys in levelorder fashion
   */
  private void getLevelOrderTraversalHelp(Node current) {
    // Base case
    if (current == null) {
      return;
    }
    List<Node> q = new LinkedList<>(); // initialize a new list as queue for Nodes
    q.add(current); // enqueue root

    // loops until queue is empty
    while (!q.isEmpty()) {
      Node tempNode = q.remove(0); // dequeues nodes at current level
      traversalList.add(tempNode.getKey()); // adds dequeued nodes to traversalList

      // enqueues left subtree nodes of next level
      if (tempNode.getLeftNode() != null) {
        q.add(tempNode.getLeftNode());
      }
      // enqueues right subtree nodes of next level
      if (tempNode.getRightNode() != null) {
        q.add(tempNode.getRightNode());
      }
    }
  }

  /**
   * Add the key,value pair to the data structure and increase the number of keys. If key is null,
   * throw IllegalNullKeyException; If key is already in data structure, throw
   * DuplicateKeyException(); Do not increase the num of keys in the structure, if key,value pair is
   * not added.
   * 
   * @param key   - key to be passed in
   * @param value - value associated with key
   * 
   * @throws IllegalNullKeyException - if key is null
   * @throws DuplicateKeyException   - if key is present
   */
  public void insert(K key, V value) throws IllegalNullKeyException, DuplicateKeyException {
    // throw IllegalArgumentException if key is null
    if (key == null) {
      throw new IllegalNullKeyException();
    }
    // throw RuntimeException if key is duplicate
    if (this.contains(key) == true) {
      throw new DuplicateKeyException();
    }
    root = insertHelp(root, key, value); // calls recursive helper method
    size++; // increments size
  }

  /**
   * Recursive helper method to insert.
   * 
   * @param current - The "root" of the subtree we are inserting into, ie the node we are currently
   *                at.
   * @param key     - the key to be inserted into the tree
   * @param value   - the value associated with key
   * @return the root of the modified subtree we inserted into
   */
  private Node insertHelp(Node current, K key, V value) {
    // base case, if tree is empty, return current node, which means assigning new node to root
    if (current == null) {
      current = new Node(key, value);
      return current;
    }

    // if key < current's key, recurse down the left subtree
    if (key.compareTo(current.getKey()) < 0) {
      current.setLeftNode(insertHelp(current.getLeftNode(), key, value));

      // if key > current's key, recurse down the right subtree
    } else if (key.compareTo(current.getKey()) > 0) {
      current.setRightNode(insertHelp(current.getRightNode(), key, value));
    }
    return current; // returns the current pointer
  }

  /**
   * If key is found, remove the key,value pair from the data structure and decrease num keys, and
   * return true. If key is not found, do not decrease the number of keys in the data structure,
   * return false. If key is null, throw IllegalNullKeyException
   * 
   * @param key - key to be passed int
   * @return true if key removed, false if not found
   * 
   * @throws IllegalNullKeyException - if key is null
   */
  public boolean remove(K key) throws IllegalNullKeyException {
    // throw IllegalArgumentException if key is null
    if (key == null) {
      throw new IllegalArgumentException();
    }
    // try-catch block to check if the key is found
    try {
      root = deleteHelp(root, key); // calls recursive helper method
      size--; // decrements size
    } catch (java.util.NoSuchElementException e) {
      return false; // return false if key is not found
    }
    return true; // return true if key is successfully removed
  }

  /**
   * Recursive helper method to delete.
   * 
   * @param current - The "root" of the subtree we are deleting from, ie the node we are currently
   *                at.
   * @param key     - key of the node to be deleted from the tree
   * @return the root of the modified subtree we deleted from
   * 
   * @throws NoSuchElementException - if the node is not in the tree
   */
  private Node deleteHelp(Node current, K key) {
    // base case, if node is not found, throw exception
    if (current == null) {
      throw new java.util.NoSuchElementException();
    }

    // if key < current's key, recurse down the left subtree
    if (key.compareTo(current.getKey()) < 0) {
      current.setLeftNode(deleteHelp(current.getLeftNode(), key));

      // if key < current's key, recurse down the right subtree
    } else if (key.compareTo(current.getKey()) > 0) {
      current.setRightNode(deleteHelp(current.getRightNode(), key));
    }

    // if key is equal to current's key
    else {
      // node with only one child or no child, if current's left node is empty, then sets current to
      // its right node
      if (current.getLeftNode() == null) {
        return current.getRightNode();

        // node with only one child or no child, if current's right node is empty, then sets current
        // to its left node
      } else if (current.getRightNode() == null) {
        return current.getLeftNode();
      }

      // node with two children, get the smallest successor in the right subtree (left-most node in
      // right subtree) and set current to it
      current.setKey(successor(current.getRightNode()));
      current.setValue(successorval(current.getRightNode()));

      // then removes the smallest successor in the right subtree
      current.setRightNode(deleteHelp(current.getRightNode(), current.getKey()));
    }
    return current; // returns the current pointer
  }

  /**
   * Private helper method that finds the key of smallest node in a tree (left-most node in a
   * subtree)
   * 
   * @param node - node that is passed into the method
   * @return the smallest successor in the subtree
   */
  private K successor(Node node) {
    K temp = node.getKey(); // stores node's data in temporary

    // find the smallest successor, which is the last leaf in the subtree
    while (node.getLeftNode() != null) {
      temp = node.getLeftNode().getKey();
      node = node.getLeftNode();
    }
    return temp;
  }

  /**
   * Private helper method that finds the value of smallest node in a tree (left-most node in a
   * subtree)
   * 
   * @param node - node that is passed into the method
   * @return the smallest successor in the subtree
   */
  private V successorval(Node node) {
    V temp = node.getValue(); // stores node's data in temporary

    // find the smallest successor, which is the last leaf in the subtree
    while (node.getLeftNode() != null) {
      temp = node.getLeftNode().getValue();
      node = node.getLeftNode();
    }
    return temp;
  }

  /**
   * Returns the value associated with the specified key.
   *
   * Does not remove key or decrease number of keys If key is null, throw IllegalNullKeyException If
   * key is not found, throw KeyNotFoundException().
   * 
   * @param key - key to be found
   * @return value associated with the key
   * 
   * @throws IllegalNullKeyException - if key is null
   * @throws KeyNotFoundException    - if key not found
   */
  public V get(K key) throws IllegalNullKeyException, KeyNotFoundException {
    // throw IllegalArgumentException if key is null
    if (key == null) {
      throw new IllegalNullKeyException();
    }
    Node temp = root; // creates a temp node serving as the current key
    while (temp != null) { // loops through BST
      // return temp's value if key is found
      if (key.compareTo(temp.getKey()) == 0) {
        return temp.getValue();

        // if key is less than current key (temp), move down left subtree
      } else if (key.compareTo(temp.getKey()) < 0) {
        temp = temp.getLeftNode();

        // if key is more than current key (temp), move down right subtree
      } else if (key.compareTo(temp.getKey()) > 0) {
        temp = temp.getRightNode();
      }
    }
    throw new KeyNotFoundException(); // throw KeyNotFoundException() if key is not found
  }

  /**
   * Returns true if the key is in the data structure If key is null, throw IllegalNullKeyException
   * Returns false if key is not null and is not present
   * 
   * @param key - key of K type
   * @return true if tree contains the key, false if not
   * 
   * @throws IllegalNullKeyException - if key is null
   */
  public boolean contains(K key) throws IllegalNullKeyException {
    // throw exception if key is null
    if (key == null) {
      throw new IllegalNullKeyException();
    }
    Node temp = root; // creates a temp node
    while (temp != null) { // loops through BST
      // return true if key is found
      if (key.compareTo(temp.getKey()) == 0) {
        return true;

        // if key is less than current key (temp), move down left subtree
      } else if (key.compareTo(temp.getKey()) < 0) {
        temp = temp.getLeftNode();

        // if key is more than current key (temp), move down right subtree
      } else if (key.compareTo(temp.getKey()) > 0) {
        temp = temp.getRightNode();
      }
    }
    return false; // return false if key is not present and not null
  }

  /**
   * Returns the number of key,value pairs in the data structure
   * 
   * @return size of this tree
   */
  public int numKeys() {
    return this.size; // return size variable of this size
  }

  /**
   * Print the tree.
   *
   * For our testing purposes of your print method: all keys that we insert in the tree will have a
   * string length of exactly 2 characters. example: numbers 10-99, or strings aa - zz, or AA to ZZ
   *
   * This makes it easier for you to not worry about spacing issues.
   *
   * You can display a binary search in any of a variety of ways, but we must see a tree that we can
   * identify left and right children of each node
   *
   * For example:
   * 
   * 30 /\ / \ 20 40 / /\ / / \ 10 35 50
   * 
   * Look from bottom to top. Inorder traversal of above tree (10,20,30,35,40,50)
   * 
   * Or, you can display a tree of this kind.
   * 
   * | |-------50 |-------40 | |-------35 30 |-------20 | |-------10
   * 
   * Or, you can come up with your own orientation pattern, like this.
   * 
   * 10 20 30 35 40 50
   * 
   * The connecting lines are not required if we can interpret your tree.
   * 
   */
  public void print() {
    printHelp(this.root, 0); // calls the recursive helper method
  }

  /**
   * Private recursive helper method to print a tree horizontally with root at the left, for
   * example, here 10 is the root 
   *                30
   *
   *        20
   *
   * 10
   * 
   * @param current - root node that is passed in, current node we are at
   * @param blank   - distance inbetween tree levels, initially 0, increase as level grows
   */
  private void printHelp(Node current, int blank) {
    // Base case if current is null
    if (current == null) {
      return;
    }
    blank += 6; // increments distance between levels as level grows
    printHelp(current.getRightNode(), blank); // Recurse on right child first
    System.out.print("\n"); // Print current node after blank count
    // Prints empty space equivalent to the blank variable
    for (int i = 6; i < blank; i++) {
      System.out.print(" ");
    }
    System.out.print(current.getKey() + "\n"); // Prints current node
    printHelp(current.getLeftNode(), blank); // Recurse on left child
  }
} // copyrighted material, students do not have permission to post on public sites
// deppeler@cs.wisc.edu
