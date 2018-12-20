package com.example.thanushen.firstproj.model;

import com.example.thanushen.firstproj.model.exceptions.BadType;
import com.example.thanushen.firstproj.model.exceptions.EmptyStack;
import com.example.thanushen.firstproj.model.exceptions.InvalidExpression;

/**
 * Interface to be implemented with classes RevPolishCalc and StandardCalc
 * 
 * @author Thanushen Balaskandar
 *
 */

public interface Calculator {
  // Evaluate the string containing an expression and return answer in float
  public float evaluate(String what) throws InvalidExpression, BadType, EmptyStack;
}
