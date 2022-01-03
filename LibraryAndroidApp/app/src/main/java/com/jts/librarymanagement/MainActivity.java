package com.jts.librarymanagement;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // initialize the LibraryUtil
        LibraryUtil.getInstance(this);

        ListView listView = (ListView)findViewById(R.id.mainMenu);

        List<String> menuItems = new ArrayList<>();
        menuItems.add("Add Book");
        menuItems.add("Borrow/Return Book");

        ArrayAdapter arrayAdapter = new ArrayAdapter(
                getApplicationContext(), android.R.layout.simple_list_item_1, menuItems);
        listView.setAdapter(arrayAdapter);

        listView.setOnItemClickListener((parent, view, position, id) -> {
            switch (position) {
                case 0:
                    addBook();
                    break;
                case 1:
                    manageBookEvent();
                    break;
            }
        });
    }

    private void addBook() {
    }

    private void manageBookEvent() {
        Intent intent = new Intent(this, ViewBooksActivity.class);
        intent.putExtra("TITLE", "Books & Stocks");
        startActivity(intent);
    }
}