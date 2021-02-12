//////////////////// ALL ASSIGNMENTS INCLUDE THIS SECTION /////////////////////
//
// Title: P03 Kaleidoscopic Pen
// Files: LinkedListMegaBlock.java, LinkedMegaBlock.java, MegaBlockBuilderTester.java
// Course: CS 300 LEC 002 Fall 2019
//
// Author: Xuxiang Sun
// Email: xsun272@wisc.edu
// Lecturer's Name: Professor Gary Dahl
//
//////////////////// PAIR PROGRAMMERS COMPLETE THIS SECTION ///////////////////
//
// Partner Name: Daniel Kouchekinia
// Partner Email: kouchekinia@wisc.edu
// Partner Lecturer's Name: Gary Dahl
//
// VERIFY THE FOLLOWING BY PLACING AN X NEXT TO EACH TRUE STATEMENT:
// X Write-up states that pair programming is allowed for this assignment.
// X We have both read and understand the course Pair Programming Policy.
// X We have registered our team prior to the team registration deadline.
//
///////////////////////////// CREDIT OUTSIDE HELP /////////////////////////////
//
// Students who get help from sources other than their partner must fully
// acknowledge and credit those sources of help here. Instructors and TAs do
// not need to be credited here, but tutors, friends, relatives, room mates,
// strangers, and others do. If you received no outside help from either type
// of source, then please explicitly indicate NONE.
//
// Persons: NONE
// Online Sources: NONE
//
/////////////////////////////// 80 COLUMNS WIDE ///////////////////////////////

/**
 * This class tests method implementation of LinkedListMegaBlock, LinkedMegaBlock, and MegaBlock
 * classes
 * 
 * @author Xuxiang Sun & Daniel Kouchekinia
 *
 */
public class MegaBlockBuilderTester {

  /**
   * Prints out the results of all test methods
   * 
   * @param args
   */
  public static void main(String[] args) {
    System.out.println("testMegaBlockEquals - " + (testLinkedMegaBlock() ? "PASSED" : "FAILED"));
    System.out
        .println("testMegaBlockToString - " + (testMegaBlockToString() ? "PASSED" : "FAILED"));
    System.out.println("testLinkedMegaBlock - " + (testLinkedMegaBlock() ? "PASSED" : "FAILED"));
    System.out.println("testLinkedMegaBlockListAddRed - "
        + (testLinkedMegaBlockListAddRed() ? "PASSED" : "FAILED"));
    System.out.println("testLinkedListMegaBlockRemoveBlue - "
        + (testLinkedListMegaBlockRemoveBlue() ? "PASSED" : "FAILED"));
  }

  /**
   * Tests the MegaBlock equals method, making sure it evaluates to true when two blocks have the
   * same color
   * 
   * @return true if two blocks are checked to be have same colors and labels, false otherwise
   */
  public static boolean testMegaBlockEquals() {
    MegaBlock block1 = new MegaBlock(Color.RED, 'R');
    MegaBlock block2 = new MegaBlock(Color.RED, 'W');
    MegaBlock block3 = new MegaBlock(Color.YELLOW, 'G');
    return block1.equals(block2) && !block3.equals(block1);
  }

  /**
   * test MegaBlock toString method, returns true if the outputted String representation of the
   * MegaBlock object is exactly the same as expected
   * 
   * @return true if the outputted String representation of the MegaBlock object is exactly the same
   *         as expected, false otherwise
   */
  public static boolean testMegaBlockToString() {
    return new MegaBlock(Color.BLUE, 'B').toString().equals("BLUE B");
  }

  /**
   * tests LinkedMegaBlock constructor, accessor, and mutator, returns false if any of the
   * constructor, accessor, or mutator does not work
   * 
   * @return true if the constructor, accessor, or mutator are implemented correctly, false
   *         otherwise
   */
  public static boolean testLinkedMegaBlock() {
    LinkedMegaBlock three = new LinkedMegaBlock(new MegaBlock(Color.RED, 'R'));

    if (!three.toString().equals("RED R -> END")) // tests the constructor
      return false;
    if (three.getNext() != null) // tests the accessor method getNext
      return false;
    MegaBlock test = new MegaBlock(Color.BLUE, 'B');
    three.setBlock(test); // utilizes the accessor method setBlock here
    if (three.getBlock() != test)
      return false;
    return true;
  }

  /**
   * Checks for the correctness of the LinkedListMegaBlock.addRed() method
   * 
   * @return true if all tests are passed, false otherwise
   */
  public static boolean testLinkedMegaBlockListAddRed() {
    LinkedListMegaBlock list = new LinkedListMegaBlock();
    MegaBlock redBlock = new MegaBlock(Color.RED, 'a');
    list.addRed(redBlock);

    return list.get(0).equals(redBlock);
  }

  /**
   * Checks for the correctness of the LinkedListMegaBlock.removeBlue() method
   * 
   * @return true if all tests are passed, false otherwise
   */
  public static boolean testLinkedListMegaBlockRemoveBlue() {
    LinkedListMegaBlock list = new LinkedListMegaBlock();
    MegaBlock blueBlock = new MegaBlock(Color.BLUE, 'f');
    list.addBlue(blueBlock);

    return list.removeBlue().equals(blueBlock);
  }
}
