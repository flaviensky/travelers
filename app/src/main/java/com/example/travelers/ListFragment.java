package com.example.travelers;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class ListFragment extends Fragment implements OnItemClicked{

    public ListFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_list, container, false);
        String result = getArguments().getString("DATA_MAIN_FRAGMENT");

        Log.i("SHOW DATA", "RESULT :" + result);

        RecyclerView recyclerView = view.findViewById(R.id.rv_list_fragment);

        EventsAdapter eventsAdapter = new EventsAdapter(this, result);

        LinearLayoutManager linearLayoutManager =
                new LinearLayoutManager(
                        getActivity(),
                        LinearLayoutManager.VERTICAL,
                        false);
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setAdapter(eventsAdapter);

        // Inflate the layout for this fragment
        return view;
    }

    @Override
    public void onItemClicked(Events event) {
        Intent intent = new Intent(getActivity(), DetailsActivity.class);
        intent.putExtra("EVENT", event);
        startActivity(intent);
        //Toast.makeText(getApplicationContext(), event.getTitle() , Toast.LENGTH_SHORT).show();
    }
}
