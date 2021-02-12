/**
 * Main.java created by Xuxiang Sun on ThinkPad in p3a_HashTable
 *
 * Author: Xuxiang Sun (xsun272@wisc.edu) Date: March 3, 2020
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

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 
 * HashTable - HashTable class representing a hashtable using a chanined bucket array of linked list
 * 
 * @author Xuxiang Sun (2020)
 *
 * @param <K> - generic type K
 * @param <V> - generic type V
 */
public class HashTable<K extends Comparable<K>, V> implements HashTableADT<K, V> {
  private static int initialCapacity = 277; // arbitrary prime number
  private static double loadFactorThreshold = 0.75; // chosen constant 0.75
  private int curCapacity; // tracks current table size
  private LinkedList<Pair> hashtable[]; // hashtable that stores Entry K, V pairs
  private int size; // num of items in hashtable

  /**
   * Private inner class representing a key-value pair in hashtable
   * 
   * @author Xuxiang Sun (2020)
   *
   */
  private class Pair {
    private K key; // key variable of type comparable K
    private V value; // value variable of type V

    /**
     * No argument constructor for an empty Node class
     */
    private Pair() {
      key = null;
    }

    /**
     * Constructor that takes a comparable K key as input
     * 
     * @param key - K key stored as data in node
     */
    private Pair(K key) {
      this.key = key;
    }

    /**
     * Constructor that takes a String key and String value as inputs
     * 
     * @param key   - K key stored as data in node
     * @param value - V value stored as data
     */
    private Pair(K key, V value) {
      this.key = key;
      this.value = value;
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
  }

  /**
   * Default no-arg constructor for hashtable
   */
  public HashTable() {
    this(initialCapacity, loadFactorThreshold);
  }

  /**
   * constructor that accepts initial capacity and load factor threshold threshold is the load
   * factor that causes a resize and rehash
   * 
   * @param initialCapacity     - initial capacity of hashtable
   * @param loadFactorThreshold - the load factor that causes a resize and rehash
   */
  public HashTable(int initialCapacity, double loadFactorThreshold) {
    this.curCapacity = initialCapacity; // sets the curCapacity
    this.loadFactorThreshold = loadFactorThreshold; // sets the loadFactorThreshold
    // instantiates an array of linkedlist
    this.hashtable =
        (LinkedList<Pair>[]) Array.newInstance(new LinkedList<Pair>().getClass(), curCapacity);
    this.size = 0; // initially sets num of items to 0;
  }

  /**
   * Add the key,value pair to the data structure and increase the number of keys. If key is null,
   * throw IllegalNullKeyException; If key is already in data structure, replace value with new
   * value
   * 
   * @param key   - key to be added
   * @param value - value associated with key
   * 
   * @throws IllegalNullKeyException - if key is null
   */
  @Override
  public void insert(K key, V value) throws IllegalNullKeyException {
    // expand if loadfactor is too large
    if (this.getLoadFactor() >= this.getLoadFactorThreshold()) {
      this.hashtable = expand(); // replaces original hashtable with new hashstable
    }

    // throws exception if key is null
    if (key == null)
      throw new IllegalNullKeyException();

    int index = hashFunc(key); // gets hash index

    // checks if bucket at this index is null
    if (hashtable[index] == null) {
      hashtable[index] = new LinkedList<Pair>(); // if null, initialize a new linked list as bucket
    }

    // loops through K-V pair bucket to find if any duplicate is present and replace
    for (Pair pair : hashtable[index]) {
      if (pair.getKey().equals(key)) {
        pair.setValue(value);
        return;
      }
    }
    hashtable[index].add(new Pair(key, value)); // add K-V pair in linked list
    size++; // increments size
  }

  /**
   * Private helper method to expand the capacity of hashtable to: 2 * original size + 1
   * 
   * @return newtable - a newly initialized array of linked list
   */
  private LinkedList<Pair>[] expand() {
    this.curCapacity = this.curCapacity * 2 + 1; // increases capacity

    // instantiate a new array of linkedlist
    LinkedList<Pair> newtable[] =
        (LinkedList<Pair>[]) Array.newInstance(new LinkedList<Pair>().getClass(), curCapacity);

    // re-hash every item in the original hashtable to new hashtable
    for (int i = 0; i < hashtable.length; i++) {
      // checks if index i in the original hashtable is not empty, meaning there exists an element
      if (hashtable[i] != null) {
        // loops through every item in bucket
        for (int x = 0; x < hashtable[i].size(); x++) {
          if (hashtable[i].get(x) != null) {
            int index = hashFunc(hashtable[i].get(x).getKey()); // computes hash index for item

            // if index at new ht is null, initialize a new linked list as bucket
            if (newtable[index] == null) {
              newtable[index] = new LinkedList<Pair>();
              newtable[index].add(hashtable[i].get(x)); // adds item to new ht
            } else if (newtable[index] != null) {
              newtable[index].add(hashtable[i].get(x)); // adds item to new ht
            }
          }
        }
      }
    }
    return newtable; // return new hashtable
  }

  /**
   * If key is found, remove the key,value pair from the data structure decrease number of keys.
   * return true If key is null, throw IllegalNullKeyException If key is not found, return false
   * 
   * @param key - key to be removed
   * @return true if successfully removed, false if not found
   * 
   * @throws IllegalNullKeyException - if key is null
   */
  @Override
  public boolean remove(K key) throws IllegalNullKeyException {
    // throws exception if key is null
    if (key == null)
      throw new IllegalNullKeyException();

    int index = hashFunc(key); // gets hash index
    // loops through bucket to find if the K-V pair with given key exists
    for (Pair pair : hashtable[index])
      // checks if pair is not null, meaning it exists
      if (pair != null && pair.getKey().equals(key)) {
        hashtable[index].remove(pair);
        size--;
        return true;
      }
    return false; // return false if not found
  }

  /**
   * Returns the value associated with the specified key Does not remove key or decrease number of
   * keys. If key is null, throw IllegalNullKeyException If key is not found, throw
   * KeyNotFoundException().
   * 
   * @param key - key to be get
   * @return value of the key to be get
   * 
   * @throws IllegalNullKeyException - If key is null
   * @throws KeyNotFoundException    - If key is not found
   */
  @Override
  public V get(K key) throws IllegalNullKeyException, KeyNotFoundException {
    // throws exception if key is null
    if (key == null)
      throw new IllegalNullKeyException();

    int index = hashFunc(key); // gets hash index

    // checks if bucket at the index is not null, meaning it exists
    if (hashtable[index] != null) {
      // Loops through the bucket to find the K-V pair with the key
      for (Pair pair : hashtable[index])
        if (pair.getKey().equals(key))
          return pair.getValue();
    }
    throw new KeyNotFoundException(); // throw exception if key is not found
  }

  /**
   * Returns the number of key,value pairs in the data structure
   * 
   * @return integer size of the number of K-V pairs in hashtable
   */
  @Override
  public int numKeys() {
    return this.size;
  }

  /**
   * Returns the load factor threshold that was passed into the constructor when creating the
   * instance of the HashTable. When the current load factor is greater than or equal to the
   * specified load factor threshold, the table is resized and elements are rehashed.
   * 
   * @return double value of load factor threshold of the hashtable
   */
  @Override
  public double getLoadFactorThreshold() {
    return this.loadFactorThreshold;
  }

  /**
   * Returns the current load factor for this hash table load factor = number of items / current
   * table size
   * 
   * @return the current load factor for this hash table load factor = number of items / current
   *         table size
   */
  @Override
  public double getLoadFactor() {
    return ((double) this.numKeys() / (double) this.getCapacity());
  }

  /**
   * Return the current Capacity (table size) of the hash table array.
   * 
   * The initial capacity must be a positive integer, 1 or greater and is specified in the
   * constructor.
   * 
   * REQUIRED: When the load factor threshold is reached, the capacity must increase to: 2 *
   * capacity + 1
   * 
   * Once increased, the capacity never decreases
   * 
   * @return curCapacity - the current Capacity (table size) of the hash table array
   */
  @Override
  public int getCapacity() {
    return this.curCapacity;
  }


  /**
   * Returns the collision resolution scheme used for this hash table. Implement with one of the
   * following collision resolution strategies. Define this method to return an integer to indicate
   * which strategy.
   * 
   * 1 OPEN ADDRESSING: linear probe 2 OPEN ADDRESSING: quadratic probe 3 OPEN ADDRESSING: double
   * hashing 4 CHAINED BUCKET: array of arrays 5 CHAINED BUCKET: array of linked nodes 6 CHAINED
   * BUCKET: array of search trees 7 CHAINED BUCKET: linked nodes of arrays 8 CHAINED BUCKET: linked
   * nodes of linked node 9 CHAINED BUCKET: linked nodes of search trees
   * 
   * @return 5 CHAINED BUCKET: array of linked nodes
   */
  @Override
  public int getCollisionResolution() {
    return 5;
  }

  /**
   * Private helper method to compute the hash index given a generic type K key
   * 
   * @param key - key to be find the index
   * @return index - hash index that is computed
   */
  private int hashFunc(K key) {
    int hashcode = key.hashCode(); // uses java's inbuilt hashCode function
    int index = Math.abs(hashcode % this.getCapacity()); // calculates hash index using hashcode %
                                                         // table size
    return index;
  }
}
