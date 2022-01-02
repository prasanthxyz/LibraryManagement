package com.pp.librarymanagement.lib;

enum EventType {
    BORROW,
    RETURN
}

public class UserEvent {
    String username;
    String datetime;
    EventType eventType;
    String bookId;

    void print() {
        System.out.println("User " + this.username
                + " did a " + eventType.toString()
                + " on book id " + this.bookId
                + " at " + this.datetime);
    }
}
