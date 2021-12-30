package com.pp.librarymanagement.lib;

import java.util.List;

public interface IStorageManager {
    List<Book> readBooks();
    void writeBooks(List<Book> books);
    List<User> readUsers();
    void writeUsers(List<User> users);
    List<UserEvent> readUserEvents();
    void writeUserEvents(List<UserEvent> userEvents);
}
