package com.firstweek;

public class BookLost extends Lost {

    private final String LostType="BOOK";
    private String BookName ;  //记录书名

    public void BookLost(String book){

        this.BookName=book;

    }

    public String getBookName() {
        return BookName;
    }

    public void setBookName(String bookName) {
        BookName = bookName;
    }

    @Override
    public String getLostType() {
        return LostType;
    }
}
