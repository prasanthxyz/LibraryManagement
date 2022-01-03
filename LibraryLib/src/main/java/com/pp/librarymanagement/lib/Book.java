package com.pp.librarymanagement.lib;

public class Book {
    public String id;
    public String name;
    public String author;
    public int stock;

    public Book() {}

    public Book(String id, String name, String author, int stock) {
        this.id = id;
        this.name = name;
        this.author = author;
        this.stock = stock;
    }

    public Book(String[] data) {
        this.id = data[0];
        this.name = data[1];
        this.author = data[2];
        this.stock = Integer.parseInt(data[3]);
    }

    public void print() {
        System.out.println("Book " + this.id);
        System.out.println("\t" + this.name + " (" + this.author + ")");
        System.out.println("\tStock left: " + this.stock);
    }

    String[] getValues() {
        return new String[] {this.id, this.name, this.author, String.valueOf(this.stock)};
    }
}
