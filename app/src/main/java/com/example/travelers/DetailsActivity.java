package com.example.travelers;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class DetailsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);

        TextView title = findViewById(R.id.tv_details_title);
        TextView category = findViewById(R.id.tv_details_category);
        Events event = (Events) getIntent().getSerializableExtra("EVENT");

        title.setText(event.getTitle());
        category.setText(event.getCategory());
    }
}
