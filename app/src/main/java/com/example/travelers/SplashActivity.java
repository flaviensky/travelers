package com.example.travelers;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import java.io.Serializable;
import java.util.List;

public class SplashActivity extends AppCompatActivity implements OnRequestsCompleted {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        final EventsDao eventsDao = AppDatabase.getInstance(getApplicationContext()).getEventsDao();

        new HttpGetEventsRequest(this).execute();

    }

    @Override
    public void getEvents(List<Events> s) {
        Intent intent = new Intent(SplashActivity.this, MainActivity.class);
        intent.putExtra("KEY", (Serializable) s);
        startActivity(intent);
        finish();
    }

}
