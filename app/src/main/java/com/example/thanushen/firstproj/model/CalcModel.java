package com.example.thanushen.firstproj.model;

import com.example.thanushen.firstproj.model.exceptions.BadType;
import com.example.thanushen.firstproj.model.exceptions.EmptyStack;
import com.example.thanushen.firstproj.model.exceptions.InvalidExpression;

/**
 * Model of the whole calculator
 * 
 * @author Thanushen Balaskandar
 *
 */

public class CalcModel {
  private Calculator revPolish = new RevPolishCalc();
  private Calculator standard = new StandardCalc();

  /**
   * Depending on expression format the method will return the answer of the sum
   * 
   * @param expr expression to solve
   * @param infix is it in infix or not
   * @return answer to expression
   * @throws InvalidExpression
   * @throws BadType
   * @throws EmptyStack
   */
  public float evaluate(String expr, boolean infix) throws InvalidExpression, BadType, EmptyStack {
    if (infix) {
      return standard.evaluate(expr);
    }
    return revPolish.evaluate(expr);
  }
}
