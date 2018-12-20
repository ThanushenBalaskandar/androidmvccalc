package com.example.thanushen.firstproj.model;

import com.example.thanushen.firstproj.model.exceptions.BadType;
import com.example.thanushen.firstproj.model.exceptions.EmptyStack;
import com.example.thanushen.firstproj.model.exceptions.InvalidExpression;

/**
 * This class is used to calculate an expression given in Infix notation.
 * 
 * @author Thanushen Balaskandar
 *
 */


public class StandardCalc implements Calculator {

  OpStack values;
  RevPolishCalc rpCalc;

  // Creates a standard calc object with its own opStack and RevPolishCalc.
  public StandardCalc() {
    values = new OpStack();
    rpCalc = new RevPolishCalc();
  }

  /**
   * Takes a symbol and returns a number representing its precedence against over other symbols.
   * 
   * @param ch1 Symbol to find precedence
   * @return
   */

  private static int precedence(Symbol ch1) {
    if (ch1.equals(Symbol.LEFT_BRACKET) || ch1.equals(Symbol.RIGHT_BRACKET)) {
      return 1;
    }
    if (ch1.equals(Symbol.MINUS) || ch1.equals(Symbol.PLUS)) {
      return 2;
    }
    if (ch1.equals(Symbol.TIMES) || ch1.equals(Symbol.DIVIDE)) {
      return 3;
    }
    return 0; // 0 if it is not an operator
  }

  /**
   * Takes a string holding a operator and finds its equivalent in the Symbol object form
   * 
   * @param s The symbol in string form
   * @return
   */

  private static Symbol getSymbol(String s) {
    return Symbol.getTypeSymbol(s);
  }

  /**
   * Takes a char and finds out if it is an operator.
   * 
   * @param ch The character to check.
   * @return
   */

  private static boolean isOp(char ch) {
    return ch == '+' || ch == '-' || ch == '*' || ch == '/' || ch == '^' || ch == '(' || ch == ')';
  }

  /**
   * Checks if the given expression is in infix.
   * 
   * @param whatExp
   * @return
   */

  private static boolean isInfix(String whatExp) {
    String what = whatExp.replace(" ", "");

    int op = 0;
    int num = what.length() - 1;

    // Find the position of the character after a left bracket if there is one.
    while (what.charAt(op) == '(') {
      op++;
    }

    // Find the position of the character before the right bracket at the end if there is one.
    while (what.charAt(num) == ')') {
      num--;
    }

    // Checks if the 2nd character after the left bracket is a operator and the character just
    // before the right brackets and the end for a number.
    return isOp(what.charAt(1 + op)) && Character.toString(what.charAt(num)).matches(".*\\d+.*");
  }

  /**
   * Calculates an expression in infix by converting it to postfix and using ReversePolishCalc
   * 
   * @param what
   * @return
   * @throws InvalidExpression
   * @throws BadType
   * @throws EmptyStack
   */

  public float evaluate(String what) throws InvalidExpression, BadType, EmptyStack {
    // Checks if is in infix otherwise throw InvalidExpression
	/*
    if (!isInfix(what)) {
      throw new InvalidExpression();
    }
    */

    String postfix = "";
    // Splits expression by spaces
    for (String s : what.split(" ")) {
      if (s.matches(".*\\d+.*")) {
        postfix += s + " "; // If number is found, it is kepts in the string with a space.
      } else if (s.equals("(")) {
        values.push(getSymbol(s)); // If left bracket push onto stack
      } else if (s.equals("")) { // If nothing left
        while (!values.isEmpty() && values.top() != Symbol.LEFT_BRACKET) {
          postfix += values.pop().getChar() + " "; // Keep popping values stack until stack is empty
                                                   // and top is a left bracket
        }
        if (values.isEmpty()) {
          throw new InvalidExpression(); // If stack is empty it means there is not enough symbols,
                                         // therefore an invalid expressions.
        } else {
          values.pop();
        }
      } else {
        while (!values.isEmpty() && (precedence(getSymbol(s)) <= precedence(values.top()))) {
          postfix += values.pop().getChar() + " "; // If stack is not empty and current string
                                                   // has a less or equal precedence to the symbol
                                                   // at top of the stack pop stack to expression
                                                   // string
        }
        values.push(getSymbol(s)); // Push string onto stack
      }
    }
    while (!values.isEmpty()) {
      postfix += values.pop().getChar() + " "; // Pops remainder of whats in the stack onto the
                                               // expression.
    }
    // Gets rid of brackets from the expression
    postfix = postfix.replace("( ", "");
    postfix = postfix.replace(") ", "");

    // Returns the answer of the newly formulated infix expression.
    return rpCalc.evaluate(postfix);
  }
}
