package com.example.project;

public class Book{
    //requires 5 attributes String title, String author, int yearPublished, String isbn, int quantity
    private String Title;
    private String Author;
    private int yearPublished;
    private String ID;
    int Quantity;
    //requires 1 constructor with 5 arguments that intitialize the attribtues of the class.
    //constroctor
    public Book(String title, String author, int yearPublished, String Isbn, int quantity){
        Title=title;
        Author = author;
        this.yearPublished = yearPublished;
        ID=Isbn;
        Quantity=quantity;
    }

    public String getTitle() {
        return Title;
    }

    public void setTitle(String newTitle) {
        Title=newTitle;
    }

    public String getAuthor() {
        return Author;
    }

    public void setAuthor(String newAuthor) {
        Author=newAuthor;
    }

    public int getYearPublished() {
        return yearPublished;
    }

    public void setYearPublished(int newyear) {
        yearPublished= newyear;
    }

    public String getIsbn() {
        return ID;
    }

    public void setIsbn(String newID) {
        ID=newID;
    }

    public int getQuantity() {
        return Quantity;
    }

    public void setQuantity(int newQ) {
        Quantity=newQ;
    }

    public void addQuantity(int q){
        Quantity+=q;
    }

    //returns "Title: [], Author: [], Year: [], ISBN: [], Quantity: []"
    public String bookInfo(){
        return "Title: "+ Title+", Author: "+Author+", Year: "+ yearPublished+", ISBN: "+ ID+", Quantity: "+Quantity;
    } 
    
    public Book copy(){
        Book copy = new Book(Title, Author, yearPublished, ID, Quantity);
        return copy; 
    }
}