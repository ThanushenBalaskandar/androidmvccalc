package com.example.thanushen.firstproj;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.RadioButton;

import com.example.thanushen.firstproj.controller.Controller;
import com.example.thanushen.firstproj.view.GUIView;

public class Main extends AppCompatActivity {
    Controller c = new Controller(this);
    GUIView view = new GUIView(this);
    Button calculateB;
    RadioButton isInfixB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        view = view.getInstance(this);
        view.addCalcObserver(c::calculate);
        view.addTypeObserver(c::expressionType);
    }
}
