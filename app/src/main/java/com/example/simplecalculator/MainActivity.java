package com.example.simplecalculator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    EditText editText;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        editText = findViewById(R.id.edittext);
    }

    public void cancelButton(View v) {

    }

    public void divideButton(View v) {

    }
    public void multiplyButton(View v) {

    }
    public void backspaceButton(View v) {

    }
    public void addButton(View v) {

    }
    public void subtractButton(View v) {

    }
    public void powerButton(View v) {

    }
    public void equalButton(View v) {

    }
    public void oneButton(View v) {

    }
    public void twoButton(View v) {

    }
    public void threeButton(View v) {

    }
    public void fourButton(View v) {

    }
    public void fiveButton(View v) {

    }
    public void sixButton(View v) {

    }

    public void sevenButton(View v) {
        editText.setText("7");
    }
    public void eightButton(View v) {
        editText.setText(editText.getText().append("8"));
    }
    public void nineButton(View v) {

    }
    public void zeroButton(View v) {

    }
    public void dotButton(View v) {

    }
    public void modulusButton(View v) {

    }

}
