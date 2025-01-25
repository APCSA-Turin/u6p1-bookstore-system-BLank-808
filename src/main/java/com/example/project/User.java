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

    public Book getBookat(int i) {
        return books[i];
    }

    public void setBooks(Book[] b) {
        books=b;
    }

    public boolean addBook(Book b) {
        boolean worked=false;
        for (int i = 0; i < books.length; i++) {
            if(books[i]==null){
                books[i]=b.copy();
                books[i].setQuantity(1);
                worked=true;
                break;
            }
        }
        if (worked){
            System.out.println("Successfully added copy to account");
        }else{
            System.out.println("Goes over account book limit, book not added;");
        }
        return worked;
    }

    public boolean removeBook(Book b) {
        boolean worked=false;
        for (int i = 0; i < books.length; i++) {
            if(books[i].getTitle().equals(b.getTitle())){
                books[i]=null;
                worked=true                          ;
                break;
            }
        }
        if (worked){
            System.out.println("Successfully removed book from account");
        }else{
            System.out.println("book not found in account");
        }
        return worked;
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