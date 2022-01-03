package com.pp.librarymanagement.lib;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class Library implements ILibrary {
    IStorageManager storageManager;

    public Library(IStorageManager storageManager) {
        this.storageManager = storageManager;
    }

    @Override
    public void addBook(Book book) {
        List<Book> books = this.storageManager.readBooks();
        books.add(book);
        this.storageManager.writeBooks(books);
    }

    @Override
    public void borrowBook(String bookId, String username) {
        List<Book> books = this.storageManager.readBooks();
        for (int i = 0; i < books.size(); i++) {
            if (!books.get(i).id.equals(bookId)) {
                continue;
            }
            Book temp = books.get(i);
            temp.stock--;
            books.set(i, temp);
        }
        this.storageManager.writeBooks(books);

        List<UserEvent> userEvents = this.storageManager.readUserEvents();
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
        userEvents.add(
                new UserEvent(username, dtf.format(LocalDateTime.now()), EventType.BORROW, bookId));
        this.storageManager.writeUserEvents(userEvents);
    }

    @Override
    public void returnBook(String bookId, String username) {
        List<Book> books = this.storageManager.readBooks();
        for (int i = 0; i < books.size(); i++) {
            if (!books.get(i).id.equals(bookId)) {
                continue;
            }
            Book temp = books.get(i);
            temp.stock++;
            books.set(i, temp);
        }
        this.storageManager.writeBooks(books);

        List<UserEvent> userEvents = this.storageManager.readUserEvents();
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
        userEvents.add(
                new UserEvent(username, dtf.format(LocalDateTime.now()), EventType.RETURN, bookId));
        this.storageManager.writeUserEvents(userEvents);
    }

    @Override
    public List<Book> getAvailableBooks() {
        List<Book> books = this.storageManager.readBooks();
        List<Book> availableBooks = new ArrayList<>();
        for (int i = 0; i < books.size(); i++) {
            if (books.get(i).stock > 0) {
                availableBooks.add(books.get(i));
            }
        }
        return availableBooks;
    }

    @Override
    public List<UserEvent> getUserHistory(String username) {
        List<UserEvent> allUserEvents = this.storageManager.readUserEvents();
        List<UserEvent> userEvents = new ArrayList<>();
        for (UserEvent userEvent: allUserEvents) {
            if (userEvent.username.equals(username)) {
                userEvents.add(userEvent);
            }
        }
        return userEvents;
    }

    @Override
    public Book getBookDetails(String bookId) {
        for (Book book: this.storageManager.readBooks()) {
            if (book.id.equals(bookId)) {
                return book;
            }
        }

        return null;
    }
}
