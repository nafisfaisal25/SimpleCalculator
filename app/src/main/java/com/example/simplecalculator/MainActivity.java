package com.example.simplecalculator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    EditText mEditText;
    List<Character> mSignList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mEditText = findViewById(R.id.edittext);
        mSignList = new ArrayList<>();
        initSignList();
    }

    private void initSignList() {
        mSignList.add('+');
        mSignList.add('-');
        mSignList.add('*');
        mSignList.add('/');
        mSignList.add('%');
        mSignList.add('^');
    }

    public void cancelButton(View v) {
        mEditText.setText("");
    }

    public void divideButton(View v) {
        if(!mEditText.getText().toString().equals("") && !isLastWordIsASign(mEditText.getText().toString())) {
            mEditText.setText(mEditText.getText().append("/"));
        }
    }
    public void multiplyButton(View v) {
        if(!mEditText.getText().toString().equals("") && !isLastWordIsASign(mEditText.getText().toString())) {
            mEditText.setText(mEditText.getText().append("*"));
        }
    }
    public void backspaceButton(View v) {
        String text = mEditText.getText().toString();
        if(!text.equals("")){
            text = text.substring(0, text.length()-1);
            mEditText.setText(text);
        }
    }
    public void addButton(View v) {
        if(!mEditText.getText().toString().equals("") && !isLastWordIsASign(mEditText.getText().toString())) {
            mEditText.setText(mEditText.getText().append("+"));
        }
    }

    public void subtractButton(View v) {
        if(!isLastWordIsASign(mEditText.getText().toString())) {
            mEditText.setText(mEditText.getText().append("-"));
        }
    }
    public void powerButton(View v) {
        if(!mEditText.getText().toString().equals("") && !isLastWordIsASign(mEditText.getText().toString())) {
            mEditText.setText(mEditText.getText().append("^"));
        }
    }

    public void modulusButton(View v) {
        if(!mEditText.getText().toString().equals("") && !isLastWordIsASign(mEditText.getText().toString())) {
            mEditText.setText(mEditText.getText().append("%"));
        }
    }

    public void equalButton(View v) {
        if(!mEditText.getText().toString().equals("")) {
//
        }
    }
    public void oneButton(View v) {
        mEditText.setText(mEditText.getText().append("1"));
    }
    public void twoButton(View v) {
        mEditText.setText(mEditText.getText().append("2"));
    }
    public void threeButton(View v) {
        mEditText.setText(mEditText.getText().append("3"));
    }
    public void fourButton(View v) {
        mEditText.setText(mEditText.getText().append("4"));
    }
    public void fiveButton(View v) {
        mEditText.setText(mEditText.getText().append("5"));
    }
    public void sixButton(View v) {
        mEditText.setText(mEditText.getText().append("6"));
    }
    public void sevenButton(View v) {
        mEditText.setText(mEditText.getText().append("7"));
    }
    public void eightButton(View v) {
        mEditText.setText(mEditText.getText().append("8"));
    }
    public void nineButton(View v) {
        mEditText.setText(mEditText.getText().append("9"));
    }
    public void zeroButton(View v) {
        mEditText.setText(mEditText.getText().append("0"));
    }
    public void dotButton(View v) {
        if(isValid(mEditText.getText().toString())){
            mEditText.setText(mEditText.getText().append("."));
        }
    }

    private boolean isValid(String str) {
        int i = str.length()-1;
        while(i>=0) {
            if(str.charAt(i) == '.') {
                return false;
            } else if(mSignList.contains(str.charAt(i))) {
                return true;
            }
            i--;
        }
        return true;
    }


    private boolean isLastWordIsASign(String str) {
        if(str.equals(""))return false;
        return mSignList.contains(str.charAt(str.length()-1));
    }

}
