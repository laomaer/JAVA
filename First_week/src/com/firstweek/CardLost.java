package com.firstweek;

public class CardLost extends Lost{

    private final String LostType = "Card";
    private String name; //记录学生卡名字
    private String CardCode; //记录学号
    private String StudentCollege; //记录学生所处学院

    public void CardLost(String name,String CardCode,String StudentCollege){

        this.name=name;
        this.CardCode=CardCode;
        this.StudentCollege=StudentCollege;

    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCardCode() {
        return CardCode;
    }

    public void setCardCode(String cardCode) {
        CardCode = cardCode;
    }

    public String getStudentCollege() {
        return StudentCollege;
    }

    public void setStudentCollege(String studentCollege) {
        StudentCollege = studentCollege;
    }

    @Override
    public String getLostType() {
        return LostType;
    }
}
