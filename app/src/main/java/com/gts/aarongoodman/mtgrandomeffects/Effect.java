package com.gts.aarongoodman.mtgrandomeffects;

public class Effect {
    public String number;
    public String name;
    public String effect;
    //private boolean mIsMulti;

    public Effect( String effectNumber, String effectName, String effectText){
        number = effectNumber;
        name = effectName;
        effect = effectText;
        //mIsMulti = isMulti;

    }
    public String postEffectName(){
        return  name;

    }
}


