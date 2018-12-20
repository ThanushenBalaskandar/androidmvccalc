package com.example.thanushen.firstproj.controller;

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.widget.EditText;
import android.widget.RadioGroup;

import com.example.thanushen.firstproj.R;
import com.example.thanushen.firstproj.model.exceptions.BadType;
import com.example.thanushen.firstproj.model.CalcModel;
import com.example.thanushen.firstproj.model.exceptions.EmptyStack;
import com.example.thanushen.firstproj.model.exceptions.InvalidExpression;

public class Controller extends AppCompatActivity {
    CalcModel model = new CalcModel();
    boolean isInfix = false;
    RadioGroup rg;
    Activity instance;

    public Controller(Activity _activity) {
        this.instance = _activity;
    }

    public void calculate() throws EmptyStack, BadType, InvalidExpression {
        EditText expressionT = (EditText) this.instance.findViewById(R.id.editText);
        EditText answer = (EditText)this.instance.findViewById(R.id.answer);
        answer.setText(Float.toString(model.evaluate(expressionT.getText().toString(), isInfix)));
    }

    public void expressionType() {
        rg = (RadioGroup)this.instance.findViewById(R.id.radioGroup);
        if(isInfix) {
            rg.clearCheck();
        }
        isInfix = !isInfix;
    }

}
