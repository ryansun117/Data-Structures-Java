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

import java.util.LinkedList;
import java.util.List;

/**
 * Implements a generic Red-Black tree extension of BST<K,V>.
 *
 * DO NOT CHANGE THE METHOD SIGNATURES OF PUBLIC METHODS DO NOT ADD ANY PACKAGE LEVEL OR PUBLIC
 * ACCESS METHODS OR FIELDS.
 * 
 * You are not required to override remove. If you do not override this operation, you may still
 * have the method in your type, and have the method throw new UnsupportedOperationException. See
 * https://docs.oracle.com/javase/7/docs/api/java/lang/UnsupportedOperationException.html
 * 
 * @param <K> is the generic type of key, must be a Comparable tyle
 * @param <V> is the generic type of value
 */
public class RBT<K extends Comparable<K>, V> implements STADT<K, V> {
  private Node root; // private root variable of type K
  private int size; // private int variable keep track of size
  private List<K> traversalList; // private List for traversal operations

  // USE AND DO NOT EDIT THESE CONSTANTS
  public static final int RED = 0;
  public static final int BLACK = 1;

  /**
   * Private inner class representing a node in RBT Node
   * 
   * @author Xuxiang Sun (2020)
   *
   */
  private class Node {
    private K key; // key variable of type comparable K
    private V value; // value variable of type V
    private Node leftNode; // left node of current node
    private Node rightNode; // right node of current node
    private int color; // int variable that represents color of Node
    private Node parent; // Node to keep track of parent Node

    /**
     * No argument constructor for an empty Node class
     */
    private Node() {
      key = null;
      leftNode = null;
      rightNode = null;
      color = 0;
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
     * Getter for color field.
     * 
     * @return The color of this Node
     */
    private int getColor() {
      return this.color;
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

    private Node getParent() {
      return this.parent;
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
     * Setter for color field
     * 
     * @param color, int variable color that the key field will be set to
     */
    private void setColor(int color) {
      this.color = color;
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

    private void setParent(Node node) {
      this.parent = node;
    }
  }

  // TODO: define a default no-arg constructor
  /**
   * No argument constructor for RBT class
   */
  public RBT() {
    this.root = null;
    this.size = 0;
  }

  /**
   * Returns the color of the node that contains the specified key. Returns RBT.RED if the node is
   * red, and RBT.BLACK if the node is black. Returns -1 if the node is not found.
   * 
   * @param key - specified key that has the color
   * @return color of the key
   */
  public int colorOf(K key) {
    Node found = getNodeWith(root, key); // TODO Auto-generated method stub
    return found == null ? -1 : found.color; // return -1 if fount is null, else color of found
  }

  /**
   * Gets the node with given K key
   * 
   * @param node - node to be passed in, root for starting
   * @param key  - key associated with the node that is passed in
   * @return node found with the specific key
   */
  private Node getNodeWith(Node node, K key) {
    // TODO Auto-generated method stub
    while (node != null) { // loops through tree
      // return true if key is found
      if (key.compareTo(node.getKey()) == 0) {
        return node;

        // if key is less than current key (temp), move down left subtree
      } else if (key.compareTo(node.getKey()) < 0) {
        node = node.getLeftNode();

        // if key is more than current key (temp), move down right subtree
      } else if (key.compareTo(node.getKey()) > 0) {
        node = node.getRightNode();
      }
    }
    return null; // return null if not found
  }

  /**
   * Returns true if the color of the root is black. If root is null, returns BLACK.
   * 
   * @return true if root is black, else returns false (for red)
   */
  public boolean rootIsBlack() {
    // TODO implement this method for your RBT
    // return black (true) if root is null
    if (this.root == null) {
      return true;
    }
    return this.root.getColor() == 1; // return true if root is black (1)
  }

  /**
   * Returns true if the node that contains this key is RED. If key is null, throws
   * IllegalNullKeyException. If key is not found, throws KeyNotFoundException.
   * 
   * @return true if the key is found and the node's color is RED, else return false if key is found
   *         and the node's color is BLACK.
   * @throws IllegalNullKeyException
   * @throws KeyNotFoundException
   */
  public boolean isRed(K key) throws IllegalNullKeyException, KeyNotFoundException {
    // throws exception if key is null
    if (key == null) {
      throw new IllegalNullKeyException();
    }
    // throws exception if tree does not contain key
    if (this.contains(key) == false) {
      throw new KeyNotFoundException();
    }
    // return true if color of key is red (0)
    return colorOf(key) == 0;
  }

  /**
   * Returns true if the node that contains this key is BLACK. If key is null, throws
   * IllegalNullKeyException. If key is not found, throws KeyNotFoundException.
   * 
   * @return true if the key is found and the node's color is BLACK, else return false if key is
   *         found and the node's color is RED.
   * @throws IllegalNullKeyException
   * @throws KeyNotFoundException
   */
  public boolean isBlack(K key) throws IllegalNullKeyException, KeyNotFoundException {
    // throws exception if key is null
    if (key == null) {
      throw new IllegalNullKeyException();
    }
    // throws exception if tree does not contain key
    if (this.contains(key) == false) {
      throw new KeyNotFoundException();
    }
    // return true if color of key is black (1)
    return colorOf(key) == 1;
  }

  /**
   * Returns the key that is in the root node of this ST. If root is null, returns null.
   * 
   * @return key found at root node, or null
   */
  @Override
  public K getKeyAtRoot() {
    // TODO Auto-generated method stub
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
  @Override
  public K getKeyOfLeftChildOf(K key) throws IllegalNullKeyException, KeyNotFoundException {
    // TODO Auto-generated method stub
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
  @Override
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
  @Override
  public int getHeight() {
    // TODO Auto-generated method stub
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
    // base case return 0 if root is 0
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
  @Override
  public List<K> getInOrderTraversal() {
    // TODO Auto-generated method stub
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
  @Override
  public List<K> getPreOrderTraversal() {
    // TODO Auto-generated method stub
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
  @Override
  public List<K> getPostOrderTraversal() {
    // TODO Auto-generated method stub
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
  @Override
  public List<K> getLevelOrderTraversal() {
    // TODO Auto-generated method stub
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
   * @param key   - key to be added
   * @param value - value associated with key
   * 
   * @throws IllegalNullKeyException - if key is null
   * @throws DuplicateKeyException   - if key is present
   */
  @Override
  public void insert(K key, V value) throws IllegalNullKeyException, DuplicateKeyException {
    // TODO Auto-generated method stub
    // throw IllegalArgumentException if key is null
    if (key == null) {
      throw new IllegalNullKeyException();
    }
    // throw RuntimeException if key is duplicate
    if (this.contains(key) == true) {
      throw new DuplicateKeyException();
    }

    Node node = new Node(key, value); // temp node variable for tracking purposes

    // assigns new key to root if empty
    if (root == null) {
      root = node;
      node.setColor(BLACK); // sets root to black, always
      size++; // increments size when there is only root
      return;
    }
    int cmp; // compareTo variable
    Node temp = null; // temp Node to keep track of parent
    Node cur = this.root; // Node that represents the current node we are on

    // inserts as in a BST
    while (cur != null) {
      temp = cur;
      cmp = node.getKey().compareTo(cur.getKey());
      if (cmp < 0) {
        cur = cur.getLeftNode();
      } else {
        cur = cur.getRightNode();
      }
    }

    // assigns parent of inserted node
    node.setParent(temp); // sets parent of node as 
    // set left/right of temp as the node that will be added
    if (temp != null) {
      cmp = node.getKey().compareTo(temp.getKey());
      if (cmp < 0) {
        temp.setLeftNode(node);
      } else {
        temp.setRightNode(node);
      }
    } else {
      this.root = node;
    }
    node.setColor(RED); // sets newly added node as red, always
    size++; // increments size
    // this try catch block would not be triggered because null key is checked previously
    try {
      insertAdjust(node); // fixes up tree after regular insert
    } catch (IllegalNullKeyException e) {
      e.printStackTrace();
    } catch (KeyNotFoundException e) {
      e.printStackTrace();
    }
  }

  /**
   * Private helper method that re-balances a RBT using parent, sibling, and grandparent nodes
   * 
   * @param node - Node to be passed in
   * @throws IllegalNullKeyException - from isRed method, should not be triggered
   * @throws KeyNotFoundException    - from isRed method, should not be triggered
   */
  private void insertAdjust(Node node) throws IllegalNullKeyException, KeyNotFoundException {
    Node parent; // Node representing parent of the node thats passed in
    Node grandP; // Node representing grandparent of the node thats passed in

    // if parent exists and is red, meaning fix needs to occur
    while (((parent = node.getParent()) != null) && isRed(parent.getKey())) {
      grandP = parent.getParent(); // sets grandparent Node

      // if parent is left child of grandparent
      if (parent == grandP.getLeftNode()) {
        Node sibling = grandP.getRightNode();
        // first case Recoloring: if sibling of parent is red
        if ((sibling != null) && isRed(sibling.getKey())) {
          sibling.setColor(BLACK); // sets sibling and parent to black
          parent.setColor(BLACK);
          grandP.setColor(RED); // sets grandparent to red
          node = grandP; // return grandparent
          continue; // exit
        }

        // second case TNR when: if sibling is black and cur node is right child
        if (parent.getRightNode() == node) {
          rotateLeft(parent);
          Node temp = parent; // swaps using temp node
          parent = node;
          node = temp;
        }
        // third case (T N R) always execute: if sibling of parent is black and cur node is left
        // child
        parent.setColor(BLACK); // sets color to black
        grandP.setColor(RED); // sets color to red
        rotateRight(grandP); // rotate right on grandparent

        // if parent is right child of grandparent node
      } else {
        Node sibling = grandP.getLeftNode();
        // first case Recoloring: sibling of parent is red
        if ((sibling != null) && isRed(sibling.getKey())) {
          sibling.setColor(BLACK); // sets sibling and parent to black
          parent.setColor(BLACK);
          grandP.setColor(RED); // sets grandparent to red
          node = grandP; // return grandparent
          continue; // exit
        }

        // second case: if sibling of parent is black and cur node is left child
        if (parent.getLeftNode() == node) {
          rotateRight(parent);
          Node temp = parent; // swaps using temp node
          parent = node;
          node = temp;
        }

        // third case (T N R): if sibling of parent is black and cur node is right child
        parent.setColor(BLACK); // sets color to black
        grandP.setColor(RED); // sets color to red
        rotateLeft(grandP); // rotate left on grandparent
      }
    }
    this.root.setColor(BLACK); // sets root as black, always
  }

  /**
   * Private helper method to perform right rotation
   * 
   * @param node - Node to be passed in
   */
  private void rotateRight(Node node) {
    Node temp = node.getLeftNode(); // declare temp to be node's left child (parent)

    node.setLeftNode(temp.getRightNode()); // set temp's right child as node's left child,
                                           // preventing losing this node
    // sets the parent of temp's right child as node if temp's right child is not empty
    if (temp.getRightNode() != null) {
      temp.getRightNode().setParent(node);
    }

    // sets node's parent to be temp's parent
    temp.setParent(node.getParent());

    // sets temp to be root if node's parent is null, meaning node was root before rotate
    if (node.getParent() == null) {
      this.root = temp;
    } else {
      // else sets temp as node's parent's right child, if node was the right child of its parent
      // before rotate
      if (node == node.getParent().getRightNode()) {
        node.getParent().setRightNode(temp);

        // else sets temp as node's parent's left child, if node was the left child of its parent
        // before rotate
      } else {
        node.getParent().setLeftNode(temp);
      }
    }
    temp.rightNode = node; // sets node as right child of temp
    node.parent = temp; // sets temp to be node's parent
  }

  /**
   * Private helper method to perform left rotation
   * 
   * @param node - Node to be passed in
   */
  private void rotateLeft(Node node) {
    Node temp = node.getRightNode(); // declare temp to be node's right child

    node.setRightNode(temp.getLeftNode());// set node's right child as temp's left child, preventing
                                          // losing this node
    // sets node as the parent of temp's left child if temp's left child is not empty
    if (temp.getLeftNode() != null) {
      temp.getLeftNode().setParent(node);
    }

    // sets node's parent to be temp's parent
    temp.setParent(node.getParent());

    // sets temp to be root if node's parent is null, meaning node was root before rotate
    if (node.getParent() == null) {
      this.root = temp;
    } else {
      // else sets temp as node's parent's left child, if node was the left child of its parent
      // before rotate
      if (node.getParent().getLeftNode() == node) {
        node.getParent().setLeftNode(temp);

        // else sets temp as node's parent's right child, if node was the left child of its parent
        // before rotate
      } else {
        node.getParent().setRightNode(temp);
      }
    }
    temp.setLeftNode(node); // sets node as left child of temp
    node.setParent(temp); // sets temp as parent of node
  }

  /**
   * Remove is not implemented
   * 
   * @throws UnsupportedOperationException
   */
  @Override
  public boolean remove(K key) throws UnsupportedOperationException {
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException();
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
  @Override
  public V get(K key) throws IllegalNullKeyException, KeyNotFoundException {
    // TODO Auto-generated method stub
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
  @Override
  public boolean contains(K key) throws IllegalNullKeyException {
    // TODO Auto-generated method stub
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
  @Override
  public int numKeys() {
    // TODO Auto-generated method stub
    return this.size;
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
  @Override
  public void print() {
    // TODO Auto-generated method stub
    printHelp(this.root, 0); // calls the recursive helper method
  }

  /**
   * Private recursive helper method to print a tree horizontally with root at the left for example,
   * here 10 is the root 30
   *
   * 20
   *
   * 10
   * 
   * @param current - root node that is passed in, current node we are at
   * @param blank   - distance inbetween tree levels, initially 0, increase as level grows
   */
  private void printHelp(Node current, int blank) {
    // Base case if cur is null
    if (current == null) {
      return; // exits
    }
    blank += 7; // increments distance between levels as level grows
    printHelp(current.getRightNode(), blank); // Recurse on right child first
    System.out.print("\n"); // Print current node after blank count
    // Prints empty space equivalent to the blank variable
    for (int i = 7; i < blank; i++) {
      System.out.print(" ");
    }
    System.out.print(current.getKey() + "\n"); // Prints current node
    printHelp(current.getLeftNode(), blank); // Recurse on left child
  }
  // TODO: override the insert method so that it rebalances
  // according to red-black tree insert algorithm.


  // TODO [OPTIONAL] you may override print() to include
  // color R-red or B-black.
}
