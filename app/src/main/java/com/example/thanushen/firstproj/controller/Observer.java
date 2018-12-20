package com.example.thanushen.firstproj.controller;

import com.example.thanushen.firstproj.model.exceptions.BadType;
import com.example.thanushen.firstproj.model.exceptions.EmptyStack;
import com.example.thanushen.firstproj.model.exceptions.InvalidExpression;

@FunctionalInterface
public interface Observer {
    public void tell() throws InvalidExpression, BadType, EmptyStack;
}
