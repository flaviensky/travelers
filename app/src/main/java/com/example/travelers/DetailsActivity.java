package com.example.travelers;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Html;
import android.text.Spanned;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.squareup.picasso.Picasso;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DetailsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);

        TextView title = findViewById(R.id.tv_details_title);
        //TextView category = findViewById(R.id.tv_details_category);
        ImageView cover = findViewById(R.id.iv_details_cover);
        TextView description = findViewById(R.id.tv_details_description);

        Events event = (Events) getIntent().getSerializableExtra("EVENT");

        title.setText(event.getTitle());

        Picasso.get().load(event.getCover_url()).fit().centerCrop().into(cover);

        Spanned htmlAsSpanned = Html.fromHtml(event.getDescription());
        description.setText(htmlAsSpanned);

        FloatingActionButton backButton = findViewById(R.id.button);
        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}
