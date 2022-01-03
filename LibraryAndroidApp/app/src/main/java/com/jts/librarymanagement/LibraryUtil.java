package com.jts.librarymanagement;

import android.content.Context;

import com.pp.librarymanagement.lib.CsvStorageManager;
import com.pp.librarymanagement.lib.ILibrary;
import com.pp.librarymanagement.lib.IStorageManager;
import com.pp.librarymanagement.lib.Library;

public class LibraryUtil {
    private static LibraryUtil instance;
    public ILibrary library;

    private LibraryUtil(Context context) {
        IStorageManager storageManager = new CsvStorageManager(context.getFilesDir());
        this.library = new Library(storageManager);
    }

    public static synchronized LibraryUtil getInstance(Context context) {
        if (instance == null) {
            instance = new LibraryUtil(context);
        }
        return instance;
    }

    public static synchronized LibraryUtil getInstance() {
        return instance;
    }
}
