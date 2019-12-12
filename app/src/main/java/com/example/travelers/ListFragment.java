package com.example.travelers;


import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


/**
 * A simple {@link Fragment} subclass.
 */
public class ListFragment extends Fragment {

    private AppCompatActivity mClass;

    public ListFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        String result = getArguments().getString("DATA_MAIN_FRAGMENT");

        Log.i("SHOW DATA", "RESULT :" + result);

        RecyclerView recyclerView = findViewById(R.id.rv_list_fragment);

        EventsAdapter eventsAdapter = new EventsAdapter(null, result);

        LinearLayoutManager linearLayoutManager =
                new LinearLayoutManager(
                        getApplicationContext(),
                        LinearLayoutManager.VERTICAL,
                        false);
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setAdapter(eventsAdapter);


        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_list, container, false);
    }

}
