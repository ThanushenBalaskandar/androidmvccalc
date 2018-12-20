package com.example.thanushen.firstproj.model.exceptions;

/**
 * This is the exception to be returned when a incorrect data type is inputed.
 * 
 * @author Thanushen Balaskandar
 *
 */

@SuppressWarnings("serial")
public class BadType extends Exception {
  public BadType() {
    System.err.println("Bad value, please enter correct type of value");
  }
}
