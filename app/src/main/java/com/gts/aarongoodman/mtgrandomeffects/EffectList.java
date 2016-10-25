package com.gts.aarongoodman.mtgrandomeffects;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class EffectList {
    public Effect CurrentEffect = new Effect(0, "Default Effect",
                                            "Please select a new effect",true);
    public List<Effect> mEffectList = new ArrayList<>();

    public void LoadList(Effect inputEffect){
        mEffectList.add(inputEffect);

    }

    static void randomEffect(){


    }





    public Effect getEffect(int effectIndex){
        return this. CurrentEffect;

    }
}




