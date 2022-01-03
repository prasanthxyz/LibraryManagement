package com.pp.librarymanagement.lib;

public class UserEvent {
    public String username;
    public String datetime;
    public EventType eventType;
    public String bookId;

    public UserEvent(String[] content) {
        this.username = content[0];
        this.datetime = content[1];
        this.eventType = EventType.valueOf(content[2]);
        this.bookId = content[3];
    }

    public UserEvent(String username, String datetime, EventType eventType, String bookId) {
        this.username = username;
        this.datetime = datetime;
        this.eventType = eventType;
        this.bookId = bookId;
    }

    public void print() {
        System.out.println("User " + this.username
                + " did a " + eventType.toString()
                + " on book id " + this.bookId
                + " at " + this.datetime);
    }

    public String[] getValues() {
        return new String[] { this.username, this.datetime, this.eventType.toString(), this.bookId};
    }
}
