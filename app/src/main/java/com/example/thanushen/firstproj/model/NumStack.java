package com.example.thanushen.firstproj.model;

import com.example.thanushen.firstproj.model.exceptions.BadType;
import com.example.thanushen.firstproj.model.exceptions.EmptyStack;

/**
 * This class defines a stack that can only hold numbers.
 * 
 * @author Thanushen Balaskandar
 *
 */

public class NumStack {
  Stack numStack;

  public NumStack() {
    this.numStack = new Stack();
  }

  /**
   * Adds a number to the top of the stack.
   * 
   * @param i the entry being pushed onto the stack.
   */

  public void push(float i) throws BadType {
    numStack.push(new Entry(i));
  }

  /**
   * Removes the top number of the stack.
   * 
   * @return The top element of the stack that was removed.
   */
  
  public float pop() throws BadType, EmptyStack {
    if (numStack.size == 0) {
      throw new EmptyStack();
    }
    return numStack.pop().getValue();
  }

  /**
   * Checks if the stack is empty and returns either true or false.
   * 
   * @return If the stack is empty or not.
   */

  public boolean isEmpty() {
    return numStack.size() == 0; //If stack size equal to 0 then it is empty.
  }


}
