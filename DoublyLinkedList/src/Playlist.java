//////////////////// ALL ASSIGNMENTS INCLUDE THIS SECTION /////////////////////
//
// Title: P07 Study Playlist
// Files: Song.java, DoublyLinkedNode.java, SongCollection.java, Playlist.java, ReversePlaylist.java
// Course: CS 300 LEC 002 Fall 2019
//
// Author: Xuxiang Sun
// Email: xsun272@wisc.edu
// Lecturer's Name: Professor Gary Dahl
//
//////////////////// PAIR PROGRAMMERS COMPLETE THIS SECTION ///////////////////
//
// Partner Name: NONE
// Partner Email: NONE
// Partner Lecturer's Name: NONE
//
// VERIFY THE FOLLOWING BY PLACING AN X NEXT TO EACH TRUE STATEMENT:
// ___ Write-up states that pair programming is allowed for this assignment.
// ___ We have both read and understand the course Pair Programming Policy.
// ___ We have registered our team prior to the team registration deadline.
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
 * An instance of this class represents a Playlist object
 * 
 * @author Xuxiang Sun
 */
public class Playlist implements java.util.Iterator<Song> {
  private DoublyLinkedNode<Song> node;

  /**
   * Initializes a new Playlist with the specified node
   * 
   * @param node - expected to be the head node of a doubly linked list
   */
  public Playlist(DoublyLinkedNode<Song> node) {
    this.node = node;
  }

  /**
   * Returns false if the node in the list is null, true otherwise
   * 
   * @return false if the node in the list is null, true otherwise
   */
  @Override
  public boolean hasNext() {
    // TODO Auto-generated method stub
    if (node == null)
      return false;
    return true;
  }

  /**
   * Returns the current node and sets node to the next node
   * 
   * @return data of current node
   * 
   * @throws java.util.NoSuchElementException if there are no songs left to be returned by an
   *                                          iterator
   */
  @Override
  public Song next() {
    // TODO Auto-generated method stub
    if (node == null)
      throw new java.util.NoSuchElementException("Error: no songs left");
    Song temp = node.getData(); // stores current node in temp variable
    node = node.getNext(); // points node to next node
    return temp; // returns temp variable
  }
}
