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

import java.util.Iterator;

/**
 * An instance of this class represents a SongCollection object. (This is actually a Queue, add at end, remove from front)
 * 
 * @author Xuxiang Sun
 */
public class SongCollection implements java.lang.Iterable<Song> {
  private DoublyLinkedNode<Song> head;
  private DoublyLinkedNode<Song> tail;
  private boolean playDirectionForward;

  /**
   * No argument constructor, instantiate variables to null and true
   */
  public SongCollection() {
    this.head = null;
    this.tail = null;
    this.playDirectionForward = true;
  }

  /**
   * Adds song to the end/tail of this doubly linked list. When song is null, throws a
   * NullPointerException
   * 
   * @param song - a Song object
   * 
   * @throws NullPointerException - when song is null
   */
  public void add(Song song) throws NullPointerException {
    if (song == null)
      throw new NullPointerException("Error: song is null");
    DoublyLinkedNode<Song> tempSong = new DoublyLinkedNode<Song>(song);
    if (this.head == null) {
      this.head = this.tail = tempSong; // points head and tail to new song if list is empty
    } else {
      this.tail.setNext(tempSong); // sets tail node's next as new song
      tempSong.setPrevious(this.tail); // sets new song's previous as tail node
      this.tail = tempSong; // points tail to new song
    }
  }

  /**
   * removes and returns song from the front/head of this list. When list is empty, throws a
   * NoSuchElementException
   * 
   * @return Song from the front/head of this list
   */
  public Song remove() throws java.util.NoSuchElementException {
    if (this.head == null)
      throw new java.util.NoSuchElementException("Error: list is empty");
    DoublyLinkedNode<Song> tempSong = this.head; // stores head node in temp variable
    this.head = this.head.getNext(); // points head to the next node
    return tempSong.getData(); // returns temp variable
  }

  /**
   * Sets the play direction variable of the class
   * 
   * @param isForward
   */
  public void setPlayDirection(boolean isForward) {
    this.playDirectionForward = isForward;
  }

  /**
   * Returns a Playlist object when playDirectionForward is set to true, and ReversePlaylist object
   * when playDirectionForward is set to false
   * 
   * @return Playlist or ReversePlaylist object
   */
  @Override
  public Iterator<Song> iterator() {
    // TODO Auto-generated method stub
    if (playDirectionForward == true)
      return new Playlist(head);
    else
      return new ReversePlaylist(tail);
  }

  ///////////////////////////////////////////////////////////////////////////////////
  // For each of the following big-O time complexity analysis, consider the problem
  // size to be the number of Songs that are stored within the argument songs, when
  // the method is first called.
  //
  // For analysisMethodA, the big-O time complexity is ____O(1)________.
  //
  // For analysisMethodB, the big-O time complexity is ____O(N)________.
  //
  // For analysisMethodC, the big-O time complexity is ____O(1)________.
  //
  ///////////////////////////////////////////////////////////////////////////////////
}
