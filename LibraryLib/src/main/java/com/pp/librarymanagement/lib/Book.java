package com.pp.librarymanagement.lib;

public class Book {
    String id;
    String name;
    String author;
    int stock;

    void print() {
        System.out.println("Book " + this.id);
        System.out.println("\t" + this.name + " (" + this.author + ")");
        System.out.println("\tStock left: " + this.stock);
    }
}
