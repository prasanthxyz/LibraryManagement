package com.pp.librarymanagement.lib;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

public class CsvStorageManager implements IStorageManager {
    File booksCsv;
    File usersCsv;
    File userEventsCsv;

    public CsvStorageManager(File baseDir) {
        this.booksCsv = new File(baseDir, "books.csv");
        this.usersCsv = new File(baseDir, "users.csv");
        this.userEventsCsv = new File(baseDir, "userevents.csv");
    }

    @Override
    public List<Book> readBooks() {
        List<String[]> content = this.readCsv(this.booksCsv);
        List<Book> books = new ArrayList<>();
        for (int i = 0; i < content.size(); i++) {
            books.add(new Book(content.get(i)));
        }

        return books;
    }

    @Override
    public void writeBooks(List<Book> books) {
        List<String[]> content = new ArrayList<>();
        for (Book book: books) {
            content.add(book.getValues());
        }
        this.writeCsv(content, this.booksCsv);
    }

    @Override
    public List<User> readUsers() {
        List<String[]> content = this.readCsv(this.usersCsv);
        List<User> users = new ArrayList<>();
        for (int i = 0; i < content.size(); i++) {
            users.add(new User(content.get(i)));
        }

        return users;
    }

    @Override
    public void writeUsers(List<User> users) {
        List<String[]> content = new ArrayList<>();
        for (User user: users) {
            content.add(user.getValues());
        }
        this.writeCsv(content, this.usersCsv);
    }

    @Override
    public List<UserEvent> readUserEvents() {
        List<String[]> content = this.readCsv(this.userEventsCsv);
        List<UserEvent> userEvents = new ArrayList<>();
        for (int i = 0; i < content.size(); i++) {
            userEvents.add(new UserEvent(content.get(i)));
        }

        return userEvents;
    }

    @Override
    public void writeUserEvents(List<UserEvent> userEvents) {
        List<String[]> content = new ArrayList<>();
        for (UserEvent userEvent: userEvents) {
            content.add(userEvent.getValues());
        }
        this.writeCsv(content, this.userEventsCsv);
    }

    private void writeCsv(List<String[]> content, File file) {
        try {
            PrintWriter writer = new PrintWriter(file);
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < content.size(); i++) {
                for (int j = 0; j < content.get(i).length; j++) {
                    sb.append(content.get(i)[j]);
                    if (j != content.get(i).length-1) {
                        sb.append(",");
                    }
                }
                sb.append("\n");
            }

            writer.write(sb.toString());
            writer.close();
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        }
    }

    private List<String[]> readCsv(File file) {
        List<String[]> content = new ArrayList<>();
        try {
            BufferedReader br = new BufferedReader(new FileReader(file));
            String line = "";
            while ((line = br.readLine()) != null) {
                content.add(line.split(","));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return content;
    }
}
