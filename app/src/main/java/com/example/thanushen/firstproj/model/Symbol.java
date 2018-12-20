package com.example.thanushen.firstproj.model;

/**
 * This enumeration class holds all the possible symbols a sum entered by the user could have.
 * 
 * @author Thanushen Balaskandar
 *
 */

public enum Symbol {
  LEFT_BRACKET('('), RIGHT_BRACKET(')'), TIMES('*'), DIVIDE('/'), PLUS('+'), MINUS('-'), INVALID(
      '~');

  private char operation;

  Symbol(char operation) {
    this.operation = operation;
  }

  char getChar() {
    return this.operation;
  }
  
  static Symbol getTypeSymbol(String ch) {
    switch(ch) {
      case "+":
        return Symbol.PLUS;
      case "-":
        return Symbol.MINUS;
      case "*":
        return Symbol.TIMES;
      case "/":
        return Symbol.DIVIDE;
      case "(":
        return Symbol.LEFT_BRACKET;
      case ")":
        return Symbol.RIGHT_BRACKET;
      default:
        System.out.println("Invalid: " + ch);
        return Symbol.INVALID;      
    }
  }

}
