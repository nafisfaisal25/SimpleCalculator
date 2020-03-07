package com.example.simplecalculator;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Stack;

public class Converter {
    private List<Character>mOperatorList;

    private String mInfixString = "";
    private String mPostFixString = "";
    private Map<Character, Integer> mOperatorPrecedenceMap;
    private List<Character> mNumberList;

    public Converter() {
        initializeList();
        initPrecedenceMap();
    }

    private void initializeList() {
        mNumberList = new ArrayList<>();
        for(int i=0;i<10;i++){
            mNumberList.add((char) (i+'0'));
        }
        mNumberList.add('.');
    }

    private void initPrecedenceMap() {
        mOperatorPrecedenceMap = new HashMap<>();
        mOperatorPrecedenceMap.put('(',1);
        mOperatorPrecedenceMap.put('+',2);
        mOperatorPrecedenceMap.put('-',2);
        mOperatorPrecedenceMap.put('*',3);
        mOperatorPrecedenceMap.put('/',3);
        mOperatorPrecedenceMap.put('%',4);
        mOperatorPrecedenceMap.put('^',5);
    }

    public String getInfixString() {
        return mInfixString;
    }

    public void setInfixString(String mInfixString) {
        this.mInfixString = mInfixString;
    }

    public String getPostFixString() {
        return mPostFixString;
    }

    public void setPostFixString(String mPostFixString) {
        this.mPostFixString = mPostFixString;
    }

    public void convertInfixToPostfix() {
        setPostFixString("");
        Stack<Character> stack = new Stack<>();
        for(int i=0;i<mInfixString.length();i++){
            if(mNumberList.contains(mInfixString.charAt(i))) {
                mPostFixString += mInfixString.charAt(i);
            }
            else if(mOperatorPrecedenceMap.keySet().contains(mInfixString.charAt(i))) {
                if(mInfixString.charAt(i) == '(') {
                    stack.push(mInfixString.charAt(i));
                } else {
                    mPostFixString += " ";
                    while(!stack.isEmpty() && mOperatorPrecedenceMap.get(mInfixString.charAt(i)) <= mOperatorPrecedenceMap.get(stack.peek())) {
                        mPostFixString += stack.pop() + " ";
                    }
                    stack.push(mInfixString.charAt(i));
                }
            }

            else if(mInfixString.charAt(i) == ')') {
                while (stack.peek() != '(') {
                    mPostFixString += " " + stack.pop();
                }
                stack.pop();
            }
        }
        while (!stack.isEmpty()) {
            mPostFixString += " " + stack.pop();
        }

        removeExtraSpaces();
    }

    private void removeExtraSpaces() {
        String temp = "";
        int i = 0;
        while(true) {
            if(mPostFixString.charAt(i) != ' ') {
                temp += mPostFixString.charAt(i);
                i++;
                break;
            }
            i++;
        }
        for(;i<mPostFixString.length();i++) {
            if(!(mPostFixString.charAt(i) == ' ' && mPostFixString.charAt(i-1) == ' ')) {
                temp += mPostFixString.charAt(i);
            }
        }
        mPostFixString = temp;
    }

    public void convertInfixToPostfix(String string) {
        setInfixString(string);
        convertInfixToPostfix();
    }
}
