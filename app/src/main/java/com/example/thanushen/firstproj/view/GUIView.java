package com.example.thanushen.firstproj.view;

import android.app.Activity;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;

import com.example.thanushen.firstproj.controller.Observer;
import com.example.thanushen.firstproj.R;
import com.example.thanushen.firstproj.model.exceptions.BadType;
import com.example.thanushen.firstproj.model.exceptions.EmptyStack;
import com.example.thanushen.firstproj.model.exceptions.InvalidExpression;

public class GUIView implements ViewInterface {
    Activity activity;

    public GUIView(Activity _activity) {
        this.activity = _activity;
    }

    private static GUIView instance = null;

    public synchronized static GUIView getInstance(Activity _activity) {
        if(instance == null) {
            instance = new GUIView(_activity);
        }
        return instance;
    }

    @Override
    public void addCalcObserver(Observer f) {
        Button calculateB = this.activity.findViewById(R.id.button);
        calculateB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    f.tell();
                } catch (InvalidExpression invalidExpression) {
                    invalidExpression.printStackTrace();
                } catch (BadType badType) {
                    badType.printStackTrace();
                } catch (EmptyStack emptyStack) {
                    emptyStack.printStackTrace();
                }
            }
        });
    }

    @Override
    public void addTypeObserver(Observer f) {
        RadioButton isInfixB = this.activity.findViewById(R.id.radioButton);
        isInfixB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    f.tell();
                } catch (InvalidExpression invalidExpression) {
                    invalidExpression.printStackTrace();
                } catch (BadType badType) {
                    badType.printStackTrace();
                } catch (EmptyStack emptyStack) {
                    emptyStack.printStackTrace();
                }
            }
        });
    }
}
