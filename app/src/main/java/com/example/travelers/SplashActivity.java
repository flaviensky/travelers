package com.example.travelers;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

public class SplashActivity extends AppCompatActivity implements OnRequestsCompleted {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        new HttpGetEventsRequest(this).execute();

    }

    @Override
    public void getEvents(String s) {
        Intent intent = new Intent(SplashActivity.this, MainActivity.class);
        intent.putExtra("KEY", s);
        startActivity(intent);
        finish();
    }
}
