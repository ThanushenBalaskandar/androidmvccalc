package com.example.thanushen.firstproj.model;

import com.example.thanushen.firstproj.model.exceptions.BadType;
import com.example.thanushen.firstproj.model.exceptions.EmptyStack;

/**
 * This class defines a stack that can only hold operation symbols.
 * 
 * @author Thanushen Balaskandar
 *
 */

public class OpStack {
  Stack opStack;

  public OpStack() {
    opStack = new Stack();
  }
  
  /**
   * Adds an operation symbol to the top of the stack.
   * 
   * @param i the entry being pushed onto the stack.
   */

  public void push(Symbol i) {
    opStack.push(new Entry(i));
  }
  
  /**
   * Removes the top operation symbol of the stack.
   * 
   * @return The top element of the stack that was removed.
   */

  public Symbol pop() throws BadType, EmptyStack {
    if (opStack.size == 0) {
      throw new EmptyStack();
    }
    return opStack.pop().getSymbol();
  }
  
  public Symbol top() throws BadType, EmptyStack {
    if (opStack.size == 0) {
      throw new EmptyStack();
    }
    return opStack.top().getSymbol();
  }
  
  /**
   * Checks if the stack is empty and returns either true or false.
   * 
   * @return If the stack is empty or not.
   */

  public boolean isEmpty() {
    return opStack.size() == 0; //If stack size equal to 0 then it is empty.
  }

}


