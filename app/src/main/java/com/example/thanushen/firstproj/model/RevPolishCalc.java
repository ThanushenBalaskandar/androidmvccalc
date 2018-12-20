package com.example.thanushen.firstproj.model;

import com.example.thanushen.firstproj.model.exceptions.BadType;
import com.example.thanushen.firstproj.model.exceptions.EmptyStack;
import com.example.thanushen.firstproj.model.exceptions.InvalidExpression;

/**
 * This class is used to calculate an expression given in Reverse Polish Notation
 * 
 * @author Thanushen Balaskandar
 *
 */

public class RevPolishCalc implements Calculator {
  NumStack numbers;

  // Creates an empty NumStack to store the numbers of the sum.
  public RevPolishCalc() {
    numbers = new NumStack();
  }

  /**
   * The evaluate method takes a sum in RPN and returns a float with the answer.
   * 
   * @param what String of the sum
   * @return Answer of the sum.
   * @throws InvalidExpression
   * @throws BadType
   * @throws EmptyStack
   */

  public float evaluate(String what) throws InvalidExpression, BadType, EmptyStack {
    // Splits expression by spaces
    for (String s : what.split(" ")) {
      if (s.matches(".*\\d+.*")) {
        numbers.push((float) Double.parseDouble(s)); // If string is a number, push onto stack
      }

      // When an operation is found the operation is performed and the number is pushed onto the
      // stack for the next operation
      if (s.equals("+")) {
        numbers.push(numbers.pop() + numbers.pop());
      }
      if (s.equals("-")) {
        float num1 = numbers.pop();
        float num2 = numbers.pop();
        numbers.push(num2 - num1);
      }
      if (s.equals("*")) {
        numbers.push(numbers.pop() * numbers.pop());
      }
      if (s.equals("/")) {
        float num1 = numbers.pop();
        float num2 = numbers.pop();
        numbers.push(num2 / num1);
      }
    }
    if (numbers.numStack.size() != 1) {
      throw new InvalidExpression(); // If whats left in the stack is anything but a single number,
                                     // the expression is invalid
    }
    return numbers.pop(); // Returns the only value of the stack left the final answer.
  }
}
