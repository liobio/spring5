package com.liobio.bean;

public class Book {
    private  String bookname;
    private  String author;

    @Override
    public String toString() {
        return "Book{" +
                "bookname='" + bookname + '\'' +
                ", author='" + author + '\'' +
                '}';
    }
    public void myInit(){
        System.out.println("书本被初始化了====");
    }
    public void mydestory(){
        System.out.println("书本被销毁了====");
    }
    public Book() {
        System.out.println("书本被创建了====");
    }

    public Book(String bookname, String author) {
        this.bookname = bookname;
        this.author = author;
    }

    public String getBookname() {
        return bookname;
    }

    public void setBookname(String bookname) {
        this.bookname = bookname;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }
}
