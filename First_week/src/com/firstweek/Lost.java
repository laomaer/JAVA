package com.firstweek;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Lost {

    private Date LostTime; //记录物品丢失的时间。
    private String LostSpace; //记录物品丢失的地点。
    private String LostType;  //记录物品的类型。

    private String ClaimSpace; //记录认领地


    private String ItemColor ;  //纪律物品的丢失物品的颜色

    public  Lost(Date time,String space ,String type ,String submit,String itemColor){

        this.LostTime = time;
        this.LostSpace = space;
        this.LostType= type;
        this.ClaimSpace=submit;
        this.ItemColor = itemColor;


    }

    public Lost() {

    }

    public String getClaimSpace() {
        return ClaimSpace;
    }


    public Date getLostTime() {
        return LostTime;
    }

    public String getLostSpace() {
        return LostSpace;
    }

    public String getLostType() {
        return LostType;
    }

    public void setLostTime(Date lostTime) {
        this.LostTime = lostTime;
    }

    public String getItemColor() {
        return ItemColor;
    }
}
