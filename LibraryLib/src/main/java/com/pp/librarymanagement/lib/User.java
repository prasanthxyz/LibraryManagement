package com.pp.librarymanagement.lib;

public class User {
    public String username;

    public User() { }

    public User(String[] content) {
        this.username = content[0];
    }

    void print() {
        System.out.println("Username: " + this.username);
    }

    public String[] getValues() {
        return new String[] { this.username };
    }
}
