package com.pp.librarymanagement.lib;

import java.util.List;

public interface ILibrary {
    void addBook(Book book);
    void borrowBook(String bookId, String username);
    void returnBook(String bookId, String username);
    List<Book> getAvailableBooks();
    List<UserEvent> getUserHistory(String username);
}
