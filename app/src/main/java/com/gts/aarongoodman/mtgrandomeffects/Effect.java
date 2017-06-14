package com.gts.aarongoodman.mtgrandomeffects;

/**
 * This is an object to record deserilization from the JSON and allow us to manipulate the data
 */
public class Effect {
    String Number;
    String Name;
    String Effect;
    String PictureName;


    public String getNumber() {
        return Number;
    }

    public void setNumber(String number) {
        this.Number = number;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        this.Name = name;
    }

    public String getEffect() {
        return Effect;
    }

    public void setEffect(String effect) {
        this.Effect = effect;
    }
    public String getPictureName() {
        return PictureName;
    }

    public void setPictureName(String pictureName) {
        PictureName = pictureName;
    }





}