package com.example.project;

public class User{
    //requires 3 private attributes String name, String Id, Book book that is initialized to empty
    private String n;
    private String ID;
    private Book[] books=new Book[5];
    //requires 1 contructor with two parameters that will initialize the name and id
    public User (String name, String id){
        n=name;
        ID=id;
    }
 
    public String getName() {
        return n;
    }

    public void setName(String newName) {
        n=newName;
    }

    public String getId() {
        return ID;
    }

    public void setId(String newID) {
        ID=newID;
    }

    public Book[] getBooks() {
        return books;
    }

    public void setBooks(Book[] b) {
        books=b;
    }

    //returns a booklist for the user, if empty, output "empty"
    public String bookListInfo(){
        String info="Books: \n";
        for (int index = 0; index < books.length; index++) {
            if(books[index]!=null){
                info+=books[index].bookInfo()+"\n";
            }else{
                info+="empty\n";
            }
        }
        return info;
    } 

    //returns  "Name: []\nID: []\nBooks:\n[]"
    public String userInfo(){
        String info= "Name: "+n+"\n"+"Id: "+ID+"\n"+bookListInfo();
        return info;
    }

}