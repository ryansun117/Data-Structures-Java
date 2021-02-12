import static org.junit.Assert.fail;

/**
 * CompareDS.java created by Xuxiang Sun on ThinkPad in p2_BalancedSearchTree
 *
 * Author: Xuxiang Sun (xsun272@wisc.edu) Date: Feb 20, 2020
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

/**
 * CompareDS - TODO compares the efficiency of BST and RBT classes
 * 
 * @author Xuxiang Sun (2020)
 *
 */
public class CompareDS {

  /**
   * Main method for CompareDS, computes the elapsed time
   * 
   * @param args
   * @throws DuplicateKeyException
   * @throws IllegalNullKeyException
   * @throws KeyNotFoundException 
   */
  public static void main(String[] args) throws IllegalNullKeyException, DuplicateKeyException, KeyNotFoundException {
    // TODO Auto-generated method stub
    System.out.println("CompareDS.main Compares work time for: BST and RBT");
    RBT<Integer, Integer> rbt1 = new RBT<Integer, Integer>(); // creates a new BST instance
    rbt1.insert(40, 30);
    rbt1.insert(20, 20);

    rbt1.insert(10, 30);

    rbt1.insert(50, 30);
    rbt1.insert(30, 30);
    rbt1.insert(70, 30);
    rbt1.insert(0, 30);
    rbt1.insert(15, 15);
    rbt1.insert(22, 22);
    rbt1.insert(66, 66);
    System.out.println(rbt1.getLevelOrderTraversal());
//    rbt1.print();

    // try catch any exception, which should not even occur
    try {
      BST<String, String> bst = new BST<String, String>(); // creates a new BST instance
      RBT<String, String> rbt = new RBT<String, String>(); // creates a new RBT instance
      // n = 100
      int n = 100;
      System.out.println("BST is inserting, getting    for " + n + " values");
      long startTime = System.nanoTime(); // gets current time in nano secs
      // for loop to insert, getting and remove 100 times
      for (int i = 0; i < n / 2; i++) {
        bst.insert(Integer.toString(49 - i), "one");
        bst.insert(Integer.toString(50 + i), "one");

      }
      for (int i = 0; i < n; i++) {
        bst.get(Integer.toString(i));
      }
      long endTime = System.nanoTime();
      // computes the elapsed time
      System.out.println("It took " + (endTime - startTime) + " to process " + n + " items");
      System.out.println("RBT is inserting, getting    for " + n + " values");
      startTime = System.nanoTime();
      // for loop to insert, getting and remove 100 times
      for (int i = 0; i < n / 2; i++) {
        rbt.insert(Integer.toString(49 - i), "one");
        rbt.insert(Integer.toString(50 + i), "one");


      }
      for (int i = 0; i < n; i++) {
        rbt.get(Integer.toString(i));
      }
      endTime = System.nanoTime();
      // computes the elapsed time
      System.out.println("It took " + (endTime - startTime) + " to process " + n + " items\n");

      bst = new BST<String, String>(); // creates a new BST instance
      rbt = new RBT<String, String>(); // creates a new RBT instance
      // n = 1000
      n = 1000;
      System.out.println("BST is inserting, getting    for " + n + " values");
      startTime = System.nanoTime(); // gets current time in nano secs
      // for loop to insert, getting and remove 1000 times
      for (int i = 0; i < n / 2; i++) {
        bst.insert(Integer.toString(499 - i), "one");
        bst.insert(Integer.toString(500 + i), "one");

      }
      for (int i = 0; i < n; i++) {
        bst.get(Integer.toString(i));
      }
      endTime = System.nanoTime();
      // computes the elapsed time
      System.out.println("It took " + (endTime - startTime) + " to process " + n + " items");
      System.out.println("RBT is inserting, getting    for " + n + " values");
      startTime = System.nanoTime();
      // for loop to insert, getting and remove 1000 times
      for (int i = 0; i < n / 2; i++) {
        rbt.insert(Integer.toString(499 - i), "one");
        rbt.insert(Integer.toString(500 + i), "one");
      }
      for (int i = 0; i < n; i++) {
        rbt.get(Integer.toString(i));
      }
      endTime = System.nanoTime();
      // computes the elapsed time
      System.out.println("It took " + (endTime - startTime) + " to process " + n + " items\n");

      bst = new BST<String, String>(); // creates a new BST instance
      rbt = new RBT<String, String>(); // creates a new RBT instance
      n = 10000;
      System.out.println("BST is inserting, getting    for " + n + " values");
      startTime = System.nanoTime(); // gets current time in nano secs
      // for loop to insert, getting and remove 10000 times
      for (int i = 0; i < n / 2; i++) {
        bst.insert(Integer.toString(4999 - i), "one");
        bst.insert(Integer.toString(5000 + i), "one");
      }
      for (int i = 0; i < n; i++) {
        bst.get(Integer.toString(i));
      }
      endTime = System.nanoTime();
      // computes the elapsed time
      System.out.println("It took " + (endTime - startTime) + " to process " + n + " items");
      System.out.println("RBT is inserting, getting    for " + n + " values");
      startTime = System.nanoTime();
      // for loop to insert, getting and remove 10000 times
      for (int i = 0; i < n / 2; i++) {
        rbt.insert(Integer.toString(4999 - i), "one");
        rbt.insert(Integer.toString(5000 + i), "one");
      }
      for (int i = 0; i < n; i++) {
        rbt.get(Integer.toString(i));
      }
      endTime = System.nanoTime();
      // computes the elapsed time
      System.out.println("It took " + (endTime - startTime) + " to process " + n + " items\n");
    } catch (Exception e) {
      e.printStackTrace();
      fail("Unexpected exception 001: " + e.getMessage());
    }
  }
}
