package com.zurefaseverler.kithub;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

public class DeleteBook extends AppCompatActivity implements View.OnClickListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_delete_book);

        ImageButton go_back = findViewById(R.id.go_back);
        go_back.setOnClickListener(this);

        final Intent toSearch = new Intent(this, DeleteBookSearch.class);
        ImageButton searchButton = findViewById(R.id.delete_book_search_button);
        searchButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(toSearch);
            }
        });
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.go_back:
                onBackPressed();
                break;
        }
    }
}
