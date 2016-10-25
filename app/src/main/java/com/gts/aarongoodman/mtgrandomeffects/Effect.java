package com.gts.aarongoodman.mtgrandomeffects;

public class Effect {
    private int mNumber;
    private String mName;
    private String mText;
    private boolean mIsMulti;

    public Effect( int effectNumber, String effectName, String effectText, boolean isMulti){
        mNumber = effectNumber;
        mName = effectName;
        mText = effectText;
        mIsMulti = isMulti;


    }

    public int getNumber() {
        return mNumber;
    }

    public void setNumber(int number) {
        mNumber = number;
    }

    public String getName() {
        return mName;
    }

    public void setName(String name) {
        mName = name;
    }

    public String getText() {
        return mText;
    }

    public void setText(String text) {
        mText = text;
    }
}


