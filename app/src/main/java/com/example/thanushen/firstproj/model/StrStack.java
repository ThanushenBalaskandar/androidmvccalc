package com.example.thanushen.firstproj.model;

import com.example.thanushen.firstproj.model.exceptions.BadType;
import com.example.thanushen.firstproj.model.exceptions.EmptyStack;

/**
 * This class defines a stack that can only hold strings.
 * 
 * @author Thanushen Balaskandar
 *
 */

public class StrStack {
  Stack strStack;

  public StrStack() {
    strStack = new Stack();
  }

  /**
   * Adds a string to the top of the stack.
   * 
   * @param i the entry being pushed onto the stack.
   */

  public void push(String i) {
    strStack.push(new Entry(i));
  }

  /**
   * Removes the top string of the stack.
   * 
   * @return The top element of the stack that was removed.
   */

  public String pop() throws BadType, EmptyStack {
    if (strStack.size == 0) {
      throw new EmptyStack();
    }
    return strStack.pop().getString();
  }

  /**
   * Checks if the stack is empty and returns either true or false.
   * 
   * @return If the stack is empty or not.
   */

  public boolean isEmpty() {
    return strStack.size == 0; // If stack size equal to 0 then it is empty.
  }

}
