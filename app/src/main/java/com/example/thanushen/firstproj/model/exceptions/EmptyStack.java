package com.example.thanushen.firstproj.model.exceptions;

/**
 * This is the exception to be returned when a incorrect data type is inputed.
 * 
 * @author Thanushen Balaskandar
 *
 */

@SuppressWarnings("serial")
public class EmptyStack extends Exception {
  public EmptyStack() {
    System.err.println("Empty Stack!");
  }
}
