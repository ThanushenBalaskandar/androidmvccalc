package com.example.thanushen.firstproj.model.exceptions;

@SuppressWarnings("serial")
public class InvalidExpression extends Exception {
  public InvalidExpression() {
    System.err.println("Not a valid expression!");
    System.err.println("Remember to use spaces");
  }
}
