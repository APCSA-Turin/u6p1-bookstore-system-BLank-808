package com.example.project;
import java.util.Scanner;


public class BookStore{

    //requires at least 2 attributes Book[] books, User[] users (initialized to an empty array of 10 max users) 
    Book[] books;
    User[] users= new User[10];
    int userC=0;
    //creates a new bookstore with 6 empty books
    BookStore(){
        books= new Book[0];
    }
    //returns users
    public User[] getUsers(){
        return users;
    }
    //returns users as a string with index number in array as prefix
    public String getUsersAsString(){
        StringBuilder s= new StringBuilder("Users: ");
        for (User u : users) {
            if(u!=null){
            s.append(u.getName()+ ", ");
            }
        }
        s.delete((s.length()-2), (s.length()));
        return s.toString();
    }

    //set users ate index
    public void setUsers(User[] user){
        users=user;
    }
    //returns books in store
    public Book[] getBooks(){
        return books;
    }

    //adds user at first empty index
    public void addUser(User user){
        userC++;
        for (int index = 0; index < users.length; index++) {
            if(users[index]==null){
                users[index]=user;
                break;
            }
        }
    } 
    //removes specifed user from store
    public void removeUser(User user){
        userC--;
        for (int index = 0; index < users.length; index++) {
            if(users[index]==user){
                users[index]=null;
                break;
            }
        }
        consolidateUsers();
    }
    //removes specifed user from store based on Id instead
    public void removeUser(String Id){
        userC--;
        for (int index = 0; index < users.length; index++) {
            if(users[index].getId().equals((Id))){
                users[index]=null;
                break;
            }
        }
        consolidateUsers();
    }

        //get user from store based on Id
        public User getUser(String Id){
            User temp= null;
            for (int index = 0; index < users.length; index++) {
                if(users[index].getId().equals((Id))){
                    temp= users[index];
                    break;
                }
            }
            return temp;
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
        //makes a new empty list the size of the previus array plus one for the new book
        Book[] temp=new Book[size];
        int i=0;
        //if the previus book array was empty then this part of the script is unessary and creates a bug so an exeption was built in
        if(size!=1){
            for (int index = 0; index < books.length; index++) {
                temp[i]=books[index];
                i++;
            }
        }
        temp[size-1]=book;
        books=temp;
    }

    public void insertBook(Book book, int Indx){
        int i=0;
        //i is used to traverse the original array out of sync with the temp array
        Book[] temp=new Book[books.length+1];
            for (int index = 0; index < temp.length; index++) {
                //leaves an empty spot for book to be inserted
                if(index==Indx){continue;}
                temp[index]=books[i];
                i++;
            }
        temp[Indx]=book;
        books=temp;
    }

    //revoves a copy of specifed book if quantity becomes zero removes book from store
    public void removeBook(Book book){
        for (int index = 0; index < books.length; index++) {
            if(books[index]==book){
                books[index].addQuantity(-1);
                //Removes book from book list if quantity reaches 0
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
                }
                break;
            }
        }
    }

     //adds a copy of book to the book store
    public void returnBook(Book book){
        boolean worked=false;
        for (int index = 0; index < books.length; index++) {
            if(books[index].getIsbn()==book.getIsbn()){
                 books[index].addQuantity(1);
                 worked=true;
                break;
            }
        }
        if(!worked){
            addBook(book);
        }
    }

    //returns books as a string with index number in array as prefix
    public String getBooksAsString(){
        StringBuilder s= new StringBuilder("Books\n ");
        for (int i=0; i<books.length; i++) {
            s.append(i+": "+books[i].getTitle()+ "\n");
        }
        return s.toString();
    }
    
    public static void Run(BookStore store){
        boolean on=true;
        System.out.println("****************Welcom to the store****************");
        System.out.println(" **********Select from the following inputs**********");
        System.out.println("Press 0: to exit");
        System.out.println("Press 1: to add new book");
        System.out.println("Press 2: to update book quantity");
        System.out.println("Press 3: to search for a book");
        System.out.println("Press 4: to show all books");
        System.out.println("Press 5: to register or remove a user");
        System.out.println("Press 6: to show all registered users");
        System.out.println("Press 7: to check out book");
        System.out.println("Press 8: to return a book");
        Scanner Scan= new Scanner(System.in);
        while (on) {
            System.out.println("*****************************************************");
            System.out.print("input: ");
            int input = Scan.nextInt();

           switch (input) {
            case 0:
                on=false;
                break;

            case 1:
                System.out.print("Title: ");
                String title= Scan.next();
                System.out.print("Author: ");
                String author= Scan.next();

                System.out.print("Year Published: ");
                int year= Scan.nextInt();
                System.out.print("Isbn: ");
                String Isbn= Scan.next();
                System.out.print("Quantity to add: ");
                int q= Scan.nextInt();
                Book b= new Book(title, author, year, Isbn, q);
                store.addBook(b);
                break;
           
            case 2:
                System.out.println("Books in library");
                System.out.println(store.getBooksAsString());
                System.out.println("Which book to modify quantity: "); 
                int bookindx= Scan.nextInt();
                System.out.print("Quantity to add: ");
                store.books[bookindx].addQuantity(Scan.nextInt());
                break;

            case 3:
            int i=0;
            System.out.print("Enter Isbn,title,author, or year published: ");
            String searchTerm= Scan.next();
            for (Book book : store.books) {
               if(book.getIsbn().equals(searchTerm) ||book.getTitle().equals(searchTerm)||String.valueOf(book.getYearPublished()).equals(searchTerm) ||book.getAuthor().equals(searchTerm)) {
                System.out.println(book.bookInfo());
                i++;
               }
            }
            if(i==0){
            System.out.println("No book found in stock");
            }
                break;
            case 4:
            for (Book book : store.books) {
                System.out.println(book.bookInfo());
            }
            System.out.println("all Books shown");
                break;

            case 5:
            System.out.print(store.getUsersAsString());
            System.out.print("Delete or add user?: ");
            if (Scan.next().equals("add")){
                if((store.userC < 10)){
                    IdGenerate.generateID();
                    System.out.print("User Name:  ");
                    User nUser= new User(Scan.next(), IdGenerate.getCurrentId());
                    store.addUser(nUser);
                }else{System.out.println("Max users reached cannot add new user");}
            }else{
                System.out.print("Enter user index number: ");
                input= Scan.nextInt();
                store.removeUser(store.users[input]);
            }

                break;
           
            case 6:
                for (User user : store.users) {
                    System.out.println(user.userInfo());
                }
                break;

            case 7:
            System.out.println("Select index of book in regestry you wish to take copy of");
            System.out.println(store.getBooksAsString());
            input= Scan.nextInt();
            System.out.println("Enter ID number of account");
            System.out.println(store.getBooksAsString());
            Isbn= Scan.next();
            if(store.getUser(Isbn).addBook(store.books[input])){
                store.removeBook(store.books[input]);
            }           
                break;

            case 8:
            System.out.println("Enter ID number of account");
            Isbn= Scan.next();
            User user=store.getUser(Isbn);
            if (user!=null){
            System.out.println("Books registered under user\n"+user.bookListInfo());
            System.out.print("Index number of book to return: ");
            input= Scan.nextInt();
            store.returnBook(user.getBookat(input));
            user.removeBook(user.getBookat(input));
            }else{
            System.out.println("Not a valid account ID");
            }
                break;
           } 
        }
        Scan.close();
    }



    public static void main(String[] args) {
        BookStore store = new BookStore(); //create a new bookstore with 6 empty books
        IdGenerate.generateID();
        User u1 = new User("John",IdGenerate.getCurrentId());
        IdGenerate.generateID();
        User u2 = new User("Jane",IdGenerate.getCurrentId());
        IdGenerate.generateID();
        User u3 = new User("Mary",IdGenerate.getCurrentId());
        IdGenerate.generateID();
        User u4 = new User("Alex",IdGenerate.getCurrentId());
        store.addUser(u1);store.addUser(u2);store.addUser(u3);store.addUser(u4);

      BookStore.Run(store);
    }

    // public String bookStoreBookInfo(){} //you are not tested on this method but use it for debugging purposes

    // public String bookStoreUserInfo(){} //you are not tested on this method but use it for debugging purposes

}