package com.jts.librarymanagement;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.MenuItem;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

import com.pp.librarymanagement.lib.Book;

public class BookEventActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_book_event);

        String bookId = getIntent().getStringExtra("BOOK_ID");
        this.loadBookDetails(bookId);
    }


    private void loadBookDetails(String bookId) {
        Book book = LibraryUtil.getInstance().library.getBookDetails(bookId);
        if (book == null) {
            return;
        }

        TableLayout bookDetailsLayout = (TableLayout) findViewById(R.id.bookDetails);
        bookDetailsLayout.addView(this.getBookDetailRow("ID", book.id));
        bookDetailsLayout.addView(this.getBookDetailRow("Name", book.name));
        bookDetailsLayout.addView(this.getBookDetailRow("Author", book.author));
        bookDetailsLayout.addView(this.getBookDetailRow("Stock", String.valueOf(book.stock)));
    }

    private TableRow getBookDetailRow(String label, String value) {
        TextView labelView = new TextView(this);
        labelView.setText(label);
        TextView valueView = new TextView(this);
        valueView.setText(value);
        TableRow tableRow = new TableRow(this);
        tableRow.addView(labelView);
        tableRow.addView(valueView);
        return tableRow;
    }
}