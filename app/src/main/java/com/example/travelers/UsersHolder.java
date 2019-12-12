package com.example.travelers;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

public class UsersHolder extends RecyclerView.ViewHolder {
    private TextView firstName;
    private TextView birthday;
    private ImageView cover;
    public UsersHolder(@NonNull View itemView) {
        super(itemView);
        firstName = itemView.findViewById(R.id.tv_first_name);
        birthday = itemView.findViewById(R.id.tv_birthday);
        cover = itemView.findViewById(R.id.iv_cover);
    }

    public void populateUser(final User user) {
        firstName.setText(user.getFirstName());
        birthday.setText(user.getBirthday());
        Picasso.get()
                .load(user.getProfilPicture()).fit().centerCrop().into(cover);
    }
}
