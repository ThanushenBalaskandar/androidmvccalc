package com.example.thanushen.firstproj.model;

import java.util.ArrayList;
import java.util.List;

/**
 * This class hold the stack of which elements of the sum are held in.
 * 
 * @author Thanushen Balaskandar
 *
 */

public class Stack {

  int size; //Variable to hold size of the stack
  List<Entry> entries; //List to hold the entries of the sum

  //Creates an empty stack
  public Stack() {
    this.size = 0;
    entries = new ArrayList<Entry>();
  }

  /**
   * Adds an entry to the top of the stack.
   * 
   * @param i the entry being pushed onto the stack.
   */
  
  public void push(Entry i) {
    entries.add(i);
    size++; //Size increases with the addition of a new element
  }
  
  /**
  * Removes the top element of the stack.
  * 
  * @return The top element of the stack that was removed.
  */
  
  public Entry pop() {
    Entry popped = entries.get(size - 1); //Store removed element in variable
    entries.remove(size - 1);
    size--; //Decrease list size
    return popped; //Return the removed element.
  }

  /**
   * Returns the element at the top of the stack.
   * 
   * @return the top element of the stack.
   */
  
  public Entry top() {
    return entries.get(size - 1);
  }
  
  /**
   * Returns the number of elements in the stack.
   * 
   * @return the size of the stack.
   */
  
  public int size() {
    return size;
  }
}
