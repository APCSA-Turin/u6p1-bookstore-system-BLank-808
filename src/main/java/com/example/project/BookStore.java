package com.example.project;


public class BookStore{

    //requires at least 2 attributes Book[] books, User[] users (initialized to an empty array of 10 max users) 
    Book[] books;
    User[] users= new User[10];
    //creates a new bookstore with 6 empty books
    BookStore(){
        books= new Book[0];
    }
    //returns users
    public User[] getUsers(){
        return users;
    }
    //set users ate index
    public void setUsers(User[] user){
        users=user;
    }

    public Book[] getBooks(){
        return books;
    }

    //adds user at first empty index
    public void addUser(User user){
        for (int index = 0; index < users.length; index++) {
            if(users[index]==null){
                users[index]=user;
                break;
            }
        }
    } 

    public void removeUser(User user){
        for (int index = 0; index < users.length; index++) {
            if(users[index]==user){
                users[index]=null;
                break;
            }
        }
        consolidateUsers();
    }

    //shifts users to have no empty spots between them on the user list
    public void consolidateUsers(){
        int i=0;
        int count=0;
        int chain=-1;
        int prevchain=0;
        while(chain!=0){
            for (int index = 1; index < users.length; index++) {
            if(users[index]!=null && users[index-1]==null){
                users[index-1]=users[index];
                users[index]=null;
                i=index;
            }else{count++;}
        }
        chain=Math.max(chain, count);
        if(chain==prevchain){
            chain=0;
        }
        prevchain=chain;
    }
        if(i+1<users.length){
        users[i+1]=null;
        }
    }

    public void addBook(Book book){
        int size=books.length+1;
        Book[] temp=new Book[size];
        int i=0;
        if(size!=1){
            for (int index = 0; index < books.length; index++) {
                if(books[index]==null){continue;}
                temp[i]=books[index];
                i++;
            }
        }
        temp[size-1]=book;
        books=temp;
    }

    public void insertBook(Book book, int Indx){
        int i=0;
        Book[] temp=new Book[books.length+1];
            for (int index = 0; index < temp.length; index++) {
                if(index==Indx){continue;}
                temp[index]=books[i];
                i++;
            }
        temp[Indx]=book;
        books=temp;
    }

    public void removeBook(Book book){
        for (int index = 0; index < books.length; index++) {
            if(books[index]==book){
                books[index].setQuantity(books[index].getQuantity()-1);
                if(books[index].getQuantity()==0){
                    books[index]=null;
                    Book[] temp=new Book[books.length-1];
                    int i=0;
                        for (int g = 0; g < books.length; g++) {
                            if(books[g]==null){continue;}
                            temp[i]=books[g];
                            i++;
                        }
                    books=temp;
                    break;
                }
            }
        }
    }
      

    // public String bookStoreBookInfo(){} //you are not tested on this method but use it for debugging purposes

    // public String bookStoreUserInfo(){} //you are not tested on this method but use it for debugging purposes

}