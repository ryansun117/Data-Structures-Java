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

import static org.junit.jupiter.api.Assertions.fail;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * 
 * HashTableTest - Test class for HashTable class
 * 
 * @author Xuxiang Sun (2020)
 *
 */
public class HashTableTest {
  protected HashTableADT htIntegerKey; // hashtable object to be used multiple times

  /**
   * Instantiates a new hashtable
   * @throws Exception
   */
  @Before
  public void setUp() throws Exception {
    htIntegerKey = new HashTable<Integer, String>();
  }

  /**
   * Tear down after tests
   * @throws Exception
   */
  @After
  public void tearDown() throws Exception {
    // nothing to be done
  }

  /**
   * Tests that a HashTable returns an integer code indicating which collision resolution strategy
   * is used. REFER TO HashTableADT for valid collision scheme codes.
   */
  @Test
  public void test000_collision_scheme() {
    HashTableADT htIntegerKey = new HashTable<Integer, String>();
    int scheme = htIntegerKey.getCollisionResolution();
    if (scheme < 1 || scheme > 9)
      fail("collision resolution must be indicated with 1-9");
  }

  /**
   * IMPLEMENTED AS EXAMPLE FOR YOU Tests that insert(null,null) throws IllegalNullKeyException
   */
  @Test
  public void test001_IllegalNullKey() {
    try {
      HashTableADT htIntegerKey = new HashTable<Integer, String>();
      htIntegerKey.insert(null, null);
      fail("should not be able to insert null key");
    } catch (IllegalNullKeyException e) {
      /* expected */ } catch (Exception e) {
      fail("insert null key should not throw exception " + e.getClass().getName());
    }
  }

  /**
   * Inserts one integer K-V pair
   */
  @Test
  public void test002_insert_one() {
    try {
      htIntegerKey.insert(10, 10); // inserting one K-V pair
    } catch (Exception e) {
      fail("should not have thrown unexpected exception"); // should not throw exception
    }
  }

  /**
   * Inserts two integer K-V pair that is duplicate key, should replace previous
   */
  @Test
  public void test003_insert_duplicate() {
    try {
      htIntegerKey.insert(10, 10); // insert one K-V pair
      htIntegerKey.insert(10, 20); // insert one K-V pair with duplicate key
    } catch (Exception e) {
      fail("should not have thrown unexpected exception"); // should not throw exception
    }
  }

  /**
   * Inserts one integer K-V pair and checks if getting it returns correct value
   */
  @Test
  public void test004_insert_and_get() {
    try {
      htIntegerKey.insert(10, 10); // insert one K-V pair
      // checks if getting 10 returns correct value
      if (htIntegerKey.get(10) != (Integer) 10) {
        fail("get method returned wrong value");
      }
    } catch (Exception e) {
      fail("should not have thrown unexpected exception"); // should not throw exception
    }
  }

  /**
   * Inserts one integer K-V pair and checks if removing it returns true
   */
  @Test
  public void test005_insert_and_remove() {
    try {
      htIntegerKey.insert(10, 10); // insert one K-V pair
      // checks if removing the same K-V pair returns true
      if (htIntegerKey.remove(10) == false) {
        fail("remove valid key should not return false");
      }
    } catch (Exception e) {
      fail("should not have thrown unexpected exception"); // should not throw exception
    }
  }

  /**
   * Gets one null K-V pair and checks if exception is thrown
   */
  @Test
  public void test006_get_null() {
    try {
      htIntegerKey.get(null); // get one null K-V pair
      fail("should have thrown exception here");
    } catch (IllegalNullKeyException e) { // expected exception
    } catch (Exception e) {
      fail("should not have thrown unexpected exception"); // should not throw exception
    }
  }

  /**
   * Removes one null K-V pair and checks if exception is thrown
   */
  @Test
  public void test007_remove_null() {
    try {
      htIntegerKey.remove(null); // removes one null K-V pair
      fail("should have thrown exception here");
    } catch (IllegalNullKeyException e) { // expected exception
    } catch (Exception e) {
      fail("should not have thrown unexpected exception"); // should not throw exception
    }
  }

  /**
   * Inserts multiple K-V pair and checks if hashtable has correct num of keys
   */
  @Test
  public void test008_insert_many_size() {
    try {
      HashTableADT htIntegerKey = new HashTable<Integer, String>(7, 0.75); // with capacity 7
      htIntegerKey.insert(10, 10); // inserts 7 K-V pair
      htIntegerKey.insert(20, 10);
      htIntegerKey.insert(30, 10);
      htIntegerKey.insert(40, 10);
      htIntegerKey.insert(50, 10);
      htIntegerKey.insert(60, 10);
      htIntegerKey.insert(70, 10);
      htIntegerKey.insert(80, 10); // inserts one more K-V pair
      if (htIntegerKey.numKeys() != 8) {
        fail("number of keys in hashtable incorrect");
      }
    } catch (Exception e) {
      fail("should not have thrown unexpected exception"); // should not throw exception
    }
  }
  
  /**
   * Inserts a large amount of K-V pair and checks if hashtable successfully expanded
   */
  @Test
  public void test009_insert_expand() {
    try {
      HashTableADT htIntegerKey = new HashTable<Integer, String>(1, 0.75); // with capacity 1
      // inserts 100 K-V pairs, should cause expand
      for (int i = 0; i < 100; i++) {
        htIntegerKey.insert(i, i);
      }
      if (htIntegerKey.numKeys() != 100) {
        fail("number of keys in hashtable incorrect");
      }
    } catch (Exception e) {
      fail("should not have thrown unexpected exception"); // should not throw exception
    }
  }
  
  /**
   * Inserts and remove one K-V pair, re-inserts the same key to check if successful
   */
  @Test
  public void test010_insert_after_remove() {
    try {
      htIntegerKey.insert(10, 10); // inserts one K-V pair
      htIntegerKey.remove(10); // removes it
      htIntegerKey.insert(10, 10); // inserts the same K-V pair with same key value
      if (htIntegerKey.numKeys() != 1) {
        fail("number of keys in hashtable incorrect");
      }
    } catch (Exception e) {
      fail("should not have thrown unexpected exception"); // should not throw exception
    }
  }
}
