package com.pp.librarymanagement.lib;

import java.util.List;

public class CsvStorageManager implements IStorageManager {
    @Override
    public List<Book> readBooks() {
        return null;
    }

    @Override
    public void writeBooks(List<Book> books) {

    }

    @Override
    public List<User> readUsers() {
        return null;
    }

    @Override
    public void writeUsers(List<User> users) {

    }

    @Override
    public List<UserEvent> readUserEvents() {
        return null;
    }

    @Override
    public void writeUserEvents(List<UserEvent> userEvents) {

    }

    private List<String[]> readCsv(String filename) {

    }
}
