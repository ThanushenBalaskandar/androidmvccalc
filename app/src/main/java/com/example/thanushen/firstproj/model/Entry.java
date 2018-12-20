package com.example.thanushen.firstproj.model;

import com.example.thanushen.firstproj.model.exceptions.BadType;

/**
 * This class is used to store the different parts of the users input into an object.
 * 
 * @author Thanushen Balaskandar
 *
 */

public class Entry {
  float number;
  Symbol other;
  String str;
  Type type;

  // Creates an entry object with a number in it.
  public Entry(float value) {
    type = Type.NUMBER;
    number = value;
  }

  // Creates an entry object with a symbol in it.
  public Entry(Symbol which) {
    type = Type.SYMBOL;
    other = which;
  }

  // Creates an entry object with a string in it.
  public Entry(String str) {
    type = Type.STRING;
    this.str = str;
  }

  /**
   * Returns the type of the data held in the entry object.
   * 
   * @return type The type of data in the entry object.
   */

  public Type getType() {
    return type;
  }

  /**
   * Returns the string held in the entry object entered by the user.
   * 
   * @return str String entered by user held in entry object.
   * @throws BadType throws this exception when wrong data type entered.
   */

  public String getString() throws BadType {
    return str;
  }

  /**
   * Method will get the symbols of the sum entered by the user, stored in an instance on Entry.
   * 
   * @return Symbol found in user inputed sum.
   * @throws BadType throws this exception when wrong data type entered.
   */

  public Symbol getSymbol() throws BadType {
    if (type != Type.SYMBOL) { // Done so if not a symbol an exception will be thrown
      throw new BadType();
    }
    return other;
  }

  /**
   * This method will get the values of the sum entered by the user, stored in an instance on Entry.
   * 
   * @return Value found in user inputed sum.
   * @throws BadType throws this exception when wrong data type entered.
   */

  public float getValue() throws BadType {
    if (type != Type.NUMBER) { // Done so if not a number an exception will be thrown
      throw new BadType();
    }
    return number;
  }

  /**
   * Method gives a unique number representation for each entry object based on the contents.
   * 
   * @return hash code Unique integer for each Entry object
   */

  public int hashCode() {
    int hashcode = 0;
    if (type == Type.NUMBER) {
      try {
        hashcode = 2609 + (int) this.getValue();
      } catch (BadType e) {
        e.printStackTrace();
      }
    }
    if (type == Type.STRING) {
      try {
        hashcode = 50000 + this.getString().length();
      } catch (BadType e) {
        e.printStackTrace();
      }
    }
    if (type == Type.SYMBOL) {
      try {
        hashcode = this.getSymbol().hashCode();
      } catch (BadType e) {
        e.printStackTrace();
      }

    }
    if (type == Type.INVALID) {
      hashcode = -1;
    }

    return hashcode;
  }

  @Override
  public boolean equals(Object o) {
    System.out.println((this.hashCode() + ", " + o.hashCode()));
    return this.hashCode() == o.hashCode();

  }
}
