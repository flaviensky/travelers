package com.example.travelers;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Toast;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity implements OnItemClicked{

    private BottomNavigationView bottomNavigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        bottomNavigationView = findViewById(R.id.bottom_navigation);
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                switch (menuItem.getItemId()){
                    case R.id.item1:
                        Toast.makeText(getApplicationContext(), "Item 1", Toast.LENGTH_SHORT).show();
                        return true;

                    case R.id.item2:
                        Toast.makeText(getApplicationContext(), "Item 2", Toast.LENGTH_SHORT).show();
                        return true;
                }
                return false;
            }
        });

        String result = getIntent().getStringExtra("KEY");

        RecyclerView recyclerView = findViewById(R.id.rv_events);

        EventsAdapter eventsAdapter = new EventsAdapter(this, result);

        LinearLayoutManager linearLayoutManager =
                new LinearLayoutManager(
                        getApplicationContext(),
                        LinearLayoutManager.VERTICAL,
                        false);
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setAdapter(eventsAdapter);
    }

    @Override
    public void onItemClicked(Events event) {
        Intent intent = new Intent(MainActivity.this, DetailsActivity.class);
        intent.putExtra("EVENT", event);
        startActivity(intent);
        //Toast.makeText(getApplicationContext(), event.getTitle() , Toast.LENGTH_SHORT).show();
    }
}
