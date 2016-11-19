package com.gts.aarongoodman.mtgrandomeffects;

public class Effect {
    public int ID;
    public int DisplayNum;
    public String Name;
    public String Description;
    public boolean IsMulti;
    public String Rarity;


    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public int getDisplayNum() {
        return DisplayNum;
    }

    public void setDisplayNum(int displayNum) {
        DisplayNum = displayNum;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String description) {
        Description = description;
    }

    public boolean isMulti() {
        return IsMulti;
    }

    public void setMulti(boolean multi) {
        IsMulti = multi;
    }

    public String getRarity() {
        return Rarity;
    }

    public void setRarity(String rarity) {
        Rarity = rarity;
    }
}