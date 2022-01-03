package com.jts.librarymanagement;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Space;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

import com.pp.librarymanagement.lib.Book;

import java.util.List;
import java.util.Objects;

public class ViewBooksActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_books);

        Objects.requireNonNull(getSupportActionBar())
                .setTitle(getIntent().getStringExtra("TITLE"));

        this.loadAvailableBooks();
    }

    private void loadAvailableBooks() {
        List<Book> books = LibraryUtil.getInstance().library.getAvailableBooks();
        TableLayout availableBooksLayout = (TableLayout) findViewById(R.id.availableBooksLayout);
        for (Book book: books) {
            TextView bookId = new TextView(this);
            bookId.setTextSize(24);
            bookId.setTextColor(Color.BLUE);
            bookId.setText(book.id);
            bookId.setOnClickListener(this::openBook);

            TextView bookName = new TextView(this);
            bookName.setTextSize(16);
            bookName.setText(book.name);

            TextView bookStock = new TextView(this);
            bookStock.setTextSize(16);
            bookStock.setTextColor(Color.RED);
            bookStock.setText(String.valueOf(book.stock));

            TableRow tableRow = new TableRow(this);
//            tableRow.addView(new Space(this));
            tableRow.addView(bookId);
            tableRow.addView(bookName);
//            tableRow.addView(new Space(this));
            tableRow.addView(bookStock);
//            tableRow.addView(new Space(this));


            availableBooksLayout.addView(tableRow);
        }
    }

    private void openBook(View view) {
        Intent intent = new Intent(this, BookEventActivity.class);
        intent.putExtra("BOOK_ID", ((TextView)view).getText().toString());
        startActivity(intent);
    }

}