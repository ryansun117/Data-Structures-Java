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

import java.util.NoSuchElementException;

/**
 * This class models and implements a linked list of MegaBlock objects
 * 
 * @author Xuxiang Sun & Daniel Kouchekinia
 *
 */
public class LinkedListMegaBlock {
  private LinkedMegaBlock head; // head of this list
  private LinkedMegaBlock tail; // tail of this list
  private int size; // size of this list (total number of megablocks stored in this list)
  private int redCount; // number of RED megablocks stored in this list
  private int yellowCount; // number of YELLOW megablocks stored in this list
  private int blueCount; // number of BLUE megablocks stored in this list

  /**
   * Creates an empty linked list of mega blocks
   */
  public LinkedListMegaBlock() {
    head = tail = null;
    size = redCount = yellowCount = blueCount = 0;
  }

  /**
   * Returns true if this list contains no elements.
   * 
   * @return true if this list is empty, and false otherwise.
   */
  public boolean isEmpty() {
    if (size == 0)
      return true;
    return false;
  }

  /**
   * Returns the size of this list
   * 
   * @return the number of megablocks stored in this list
   */
  public int size() {
    return this.size;
  }

  /**
   * Removes all of the elements from this list. The list will be empty after this call returns.
   */
  public void clear() {
    this.head = null;
    this.tail = null;
    size = redCount = blueCount = yellowCount = 0;
  }

  /**
   * Adds a blueBlock at the end of this list
   * 
   * @param blueBlock - new element to be added to this list
   * 
   * @throws java.lang.IllegalArgumentException - if blueBlock is null or if the color of the
   *                                            specific blueBlock is not equal to Color.BLUE
   */
  public void addBlue(MegaBlock blueBlock) throws java.lang.IllegalArgumentException {
    if (blueBlock == null || blueBlock.getColor() != Color.BLUE)
      throw new IllegalArgumentException(
          "Error: Added block is null, or color is not equal to blue");
    add(blueBlock, size);
    blueCount++;
  }

  /**
   * Adds a new object at the head of this list
   * 
   * @param redBlock - new element to be added to this list
   * 
   * @throws java.lang.IllegalArgumentException - if redBlock is null or if its color does not equal
   *                                            to Color.RED
   */
  public void addRed(MegaBlock redBlock) throws java.lang.IllegalArgumentException {
    if (redBlock == null || redBlock.getColor() != Color.RED)
      throw new IllegalArgumentException(
          "Error: Added block is null, or color is not equal to red");
    add(redBlock, 0);
    redCount++;
  }

  /**
   * Adds the provided yellowBlock at the position index in this list
   * 
   * @param index       - index at which the specified yellow block is to be inserted
   * @param yellowBlock - new element to be added to this list
   * 
   * @throws java.lang.IllegalArgumentException  - if yellowBlock is null or if it does not have a
   *                                             Color.YELLOW color
   * @throws java.lang.IndexOutOfBoundsException - if the index is out of the range reserved for
   *                                             yellow blocks (index < redCount || index > size -
   *                                             blueCount)
   */
  public void addYellow(int index, MegaBlock yellowBlock) {
    if (yellowBlock == null || yellowBlock.getColor() != Color.YELLOW)
      throw new IllegalArgumentException(
          "Error: Added block is null, or color is not equal to yellow");
    if (index < redCount || index > size - blueCount)
      throw new IndexOutOfBoundsException("Error: Index is out of range");
    add(yellowBlock, index);
    yellowCount++;
  }

  /**
   * Returns the element stored at position index of this list without removing it.
   * 
   * @param index - position within this list
   * @return the megablock object stored at position index of this list
   * 
   * @throws java.lang.IndexOutOfBoundsException - if the index is out of range (index < 0 || index
   *                                             >= size())
   */
  public MegaBlock get(int index) {
    return getLink(index).getBlock();
  }

  /**
   * Replaces the megablock at the specified position in this list with the specified element if
   * they have the same Color
   * 
   * @param index - index of the block to replace
   * @param block - element to be stored at the specified position
   * 
   * @return the element previously at the specified position
   * 
   * @throws java.lang.IllegalArgumentException  - if object is null or is not equal to the
   *                                             megablock already at at index position
   * @throws java.lang.IndexOutOfBoundsException - if the index is out of range (index < 0 || index
   *                                             >= size())
   */
  public MegaBlock set(int index, MegaBlock block) {
    if (block == null)
      throw new IllegalArgumentException("Block given was null.");
    if (index < 0 || index >= size)
      throw new IndexOutOfBoundsException("Invalid index.");

    if (head != null) {
      int i = 0;

      // Loops through the list to copy the block
      for (LinkedMegaBlock cur = head; cur != null; cur = cur.getNext()) {
        if (index == i + 1) {
          MegaBlock oldBlock = cur.getNext().getBlock();

          // Checks if the new block has the same color as the old one
          if (!oldBlock.getColor().equals(block.getColor()))
            throw new IllegalArgumentException("Block must be same color as previous block.");
          cur.setNext(new LinkedMegaBlock(block, cur.getNext().getNext()));
          return oldBlock;
        }
        i++; // increments i
      }
    }
    return null;
  }

  /**
   * Removes and returns the mega block at the head of this list if its color is red
   * 
   * @return a reference to the removed element
   * 
   * @throws java.util.NoSuchElementException - if this list does not contain any red mega block
   */
  public MegaBlock removeRed() throws NoSuchElementException {
    // If the list doesn't have any red blocks at the beginning, it doesn't have any at all
    if (!head.getBlock().getColor().equals(Color.RED))
      throw new NoSuchElementException("The list does not contain any red blocks.");
    MegaBlock removedBlock = remove(0);
    redCount--;
    return removedBlock;
  }

  /**
   * Removes and returns the element at the tail of this list if it has a blue color
   * 
   * @return a reference to the removed element
   * 
   * @throws java.util.NoSuchElementException - if this list does not contain any blue block
   */
  public MegaBlock removeBlue() throws NoSuchElementException {
    // If the list doesn't have any blue blocks at the end, it doesn't have any at all
    if (!tail.getBlock().getColor().equals(Color.BLUE))
      throw new NoSuchElementException("The list does not contain any blue blocks.");

    MegaBlock removedBlock = remove(size - 1);
    blueCount--;
    return removedBlock;
  }

  /**
   * Removes and returns the element stored at index position in this list
   * 
   * @param index - position of the element to remove in this list
   * 
   * @return a reference to the removed element
   * 
   * @throws java.lang.IndexOutOfBoundsException - if the index is out of range (index < redCount or
   *                                             index >= size - blueCount)
   */
  public MegaBlock removeYellow(int index) throws IndexOutOfBoundsException {
    // If the list doesn't have any blue blocks at the end, it doesn't have any at all
    if (index < redCount || index >= size - blueCount)
      throw new IndexOutOfBoundsException("The index provided is out of range.");

    MegaBlock removedBlock = remove(index);
    yellowCount--;
    return removedBlock;
  }

  /**
   * Returns the number of red mega bloks stored in this list
   * 
   * @return the redCount
   */
  public int getRedCount() {
    return redCount;
  }

  /**
   * Returns the number of yellow mega bloks stored in this list
   * 
   * @return the yellowCount
   */
  public int getYellowCount() {
    return yellowCount;
  }

  /**
   * Returns the number of blue mega bloks stored in this list
   * 
   * @return the blueCount
   */
  public int getBlueCount() {
    return blueCount;
  }

  /**
   * Returns a String representation of the contents of this list
   * 
   * @return a String representation of the content of this list. If this list is empty, an empty
   *         String ("") will be returned.
   */
  @Override
  public java.lang.String toString() {
    String s = "";
    if (head != null)
      for (LinkedMegaBlock cur = head; cur != null; cur = cur.getNext()) {
        s += cur; // Concatenates the String
      }
    return s;
  }

  /**
   * A general purpose add-method that does not discriminate between blocks
   * 
   * @param block The block to be added
   * @param index The index where the block should be added
   */
  private void add(MegaBlock block, int index) {
    if (head == null) {
      head = tail = new LinkedMegaBlock(block);
    } else {
      // Add to beginning
      if (index == 0) {
        head = new LinkedMegaBlock(block, head);
        // Add to end
      } else if (index == size) {
        tail.setNext(new LinkedMegaBlock(block));
        tail = tail.getNext();
      } else {
        // Add at intermediate index
        int i = 0;
        for (LinkedMegaBlock cur = head; cur.getNext() != null; cur = cur.getNext()) {
          if (index == i + 1) {
            cur.setNext(new LinkedMegaBlock(block, cur.getNext()));
          }
          i++;
        }
      }
    }
    size++;
  }

  /**
   * A general purpose get link method that returns the LinkedMegaBlock at the specified index
   * 
   * @param index The index where the LinkedMegaBlock should be retrieved
   * @throws IndexOutOfBoundsException - If the index provided is not in the list
   */
  private LinkedMegaBlock getLink(int index) throws IndexOutOfBoundsException {
    if (head != null) {
      int i = 0;

      // Loops through the link to find the specific LinkedMegaBlock
      for (LinkedMegaBlock cur = head; cur != null; cur = cur.getNext()) {
        if (index == i)
          return cur;
        i++;
      }
    }
    throw new IndexOutOfBoundsException("Invalid index.");
  }

  /**
   * A general purpose add-method that does not discriminate between blocks
   * 
   * @param index The index of the block to be removed
   * @return The MegaBlock which was removed
   */
  private MegaBlock remove(int index) {
    MegaBlock removed;

    if (head == null)
      return null;

    // Remove at beginning
    if (index == 0) {
      removed = head.getBlock();
      head = head.getNext();
      // Remove at end
    } else if (index == size - 1) {
      removed = tail.getBlock();
      tail = getLink(size - 2);
      tail.setNext(null);
      // Remove at intermediate index
    } else {
      removed = getLink(index).getBlock();
      getLink(index - 1).setNext(getLink(index + 1));
    }

    size--;
    return removed;
  }
}
