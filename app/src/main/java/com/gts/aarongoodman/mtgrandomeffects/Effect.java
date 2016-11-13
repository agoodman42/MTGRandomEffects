package com.gts.aarongoodman.mtgrandomeffects;

public class Effect {
    public String FIELD1;
    public String FIELD2;
    public String FIELD3;
    //private boolean mIsMulti;

    public Effect( String effectNumber, String effectName, String effectText){
        FIELD1 = effectNumber;
        FIELD2 = effectName;
        FIELD3 = effectText;
        //mIsMulti = isMulti;

    }
    public String provideEffect(){
        return FIELD1 + " " + FIELD2+ " " + FIELD3;

    }
}


