package com.example.travelers;


import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 */
public class ProfileFragment extends Fragment {


    public ProfileFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_profile, container, false);
        List<User> result = AppUtils.getUsers();

        Log.i("SHOW DATA", "RESULT :" + result);

        RecyclerView recyclerView = view.findViewById(R.id.rv_profile_fragment);

        UsersAdapter usersAdapter = new UsersAdapter(getContext(), result);

        LinearLayoutManager linearLayoutManager =
                new LinearLayoutManager(
                        getContext(),
                        LinearLayoutManager.VERTICAL,
                        false);
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setAdapter(usersAdapter);

        // Inflate the layout for this fragment
        return view;
    }

}
