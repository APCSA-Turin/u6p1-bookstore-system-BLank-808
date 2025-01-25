package com.example.project;
import org.junit.jupiter.api.Test;

import com.example.project.Book;
import com.example.project.IdGenerate;
import com.example.project.User;

import static org.junit.jupiter.api.Assertions.*;

public class TestUser {
    @Test
    public void testUserInfo(){
        IdGenerate.reset(); //reset for test
        IdGenerate.generateID();
        User u1 = new User("John",IdGenerate.getCurrentId());
        String expected = "Name: John\nId: 100\nBooks: \nempty\nempty\nempty\nempty\nempty\n";
        assertEquals(expected, u1.userInfo());
    }

    @Test
    public void testUserConstructor(){
        IdGenerate.reset(); //reset for test
        IdGenerate.generateID();
        User u1 = new User("John",IdGenerate.getCurrentId());
        String expected = "Name: John\nId: 100\nBooks: \nempty\nempty\nempty\nempty\nempty\n";
        assertEquals(expected, u1.userInfo());

        IdGenerate.generateID();
        Book b1 = new Book("The Great Gatsby","Scott Fitzgerald", 1925, "979-8351145013",3);
        User u2 = new User("Jane",IdGenerate.getCurrentId());
        Book[] books = new Book[5];
        books[0] = b1;
        u2.setBooks(books);
       
        expected = "Name: Jane\nId: 101\nBooks: \nTitle: The Great Gatsby, Author: Scott Fitzgerald, Year: 1925, ISBN: 979-8351145013, Quantity: 3\nempty\nempty\nempty\nempty\n";
        assertEquals(expected, u2.userInfo());
    }


    
}
