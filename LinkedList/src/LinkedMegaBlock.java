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
 * This class implements a linked mega block data type
 * 
 * @author Xuxiang Sun & Daniel Kouchekinia
 *
 */
public class LinkedMegaBlock {
  private MegaBlock block; // data field of this linkedMegaBlock
  private LinkedMegaBlock next; // link to the next linkedMegaBlock

  /**
   * Creates a new LinkedMegaBlock that has a specific MegaBlock as data and null as next reference
   * 
   * @param block - data field to be set for this new LinkedMegaBlock
   * 
   */
  public LinkedMegaBlock(MegaBlock block) {
    this(block, null);
  }

  /**
   * Creates a new LinkedMegaBlock with a specific data block and a specific reference to the next
   * LinkedMegaBlock
   * 
   * @param block - data field to be set for this newLinkedMegaBlock
   * @param next  - reference to the next LinkedMegaBlock of this LinkedMegaBlock
   */
  public LinkedMegaBlock(MegaBlock block, LinkedMegaBlock next) {
    this.block = block;
    this.next = next;
  }

  /**
   * Returns the block data field of this LinkedMegaBlock
   * 
   * @return the block data field of this LinkedMegaBlock
   */
  public MegaBlock getBlock() {
    return block;
  }

  /**
   * Sets the block instance field of this LinkedMegaBlock
   * 
   * @param block - the block to set
   */
  public void setBlock(MegaBlock block) {
    this.block = block;
  }

  /**
   * Returns the reference to the next field of this LinkedMegaBlock
   * 
   * @return the next
   */
  public LinkedMegaBlock getNext() {
    return next;
  }

  /**
   * Sets the reference to the next field of this LinkedMegaBlock
   * 
   * @param next - the next to set
   */
  public void setNext(LinkedMegaBlock next) {
    this.next = next;
  }

  /**
   * Returns a String representation of this Linked MegaBlock object. This String will be :
   * block.toString() + " -> " // if next field is not null block.toString() + " -> END" // if next
   * field is null For instance, LinkedMegaBlock block1 = new LinkedMegaBlock(new
   * MegaBlock(Color.BLUE, '1')); LinkedMegaBlock block2 = new LinkedMegaBlock(new
   * MegaBlock(Color.RED, 'A'), block1); block1.toString() returns "BLUE 1 -> END" block2.toString()
   * returns "RED A -> "
   * 
   * @return a String representation of this Linked MegaBlock object
   */
  @Override
  public java.lang.String toString() {
    return block.toString() + " " + "-> " + ((getNext() == null) ? "END" : "");
  }
}
