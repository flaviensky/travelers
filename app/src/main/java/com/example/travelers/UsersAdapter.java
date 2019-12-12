package com.example.travelers;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class UsersAdapter extends RecyclerView.Adapter<UsersHolder> {

    private final static String TAG = UsersAdapter.class.getSimpleName();

    private List<User> userList;


    UsersAdapter(Context context, List<User> result){

        userList = result;

    }

    @NonNull
    @Override
    public UsersHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType){
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.profile_item, parent, false);
        return new UsersHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull UsersHolder holder, int position) {
        User user = userList.get(position);
        holder.populateUser(user);
    }

    @Override
    public int getItemCount() {
        return userList.size();
    }
}
