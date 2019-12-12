package com.example.travelers;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import org.w3c.dom.Text;

public class UsersHolder extends RecyclerView.ViewHolder {
    private TextView firstName;
    private TextView birthday;
    private TextView lastName;
    private ImageView cover;
    private TextView email;
    private TextView phone;
    public UsersHolder(@NonNull View itemView) {
        super(itemView);
        firstName = itemView.findViewById(R.id.tv_first_name);
        lastName = itemView.findViewById(R.id.tv_last_name);
        birthday = itemView.findViewById(R.id.tv_birthday);
        cover = itemView.findViewById(R.id.iv_cover);
        email = itemView.findViewById(R.id.tv_email);
        phone = itemView.findViewById(R.id.tv_phone);
    }

    public void populateUser(final User user) {
        firstName.setText(user.getFirstName());
        lastName.setText(user.getLastName());
        birthday.setText(user.getBirthday());
        email.setText(user.getEmail());
        phone.setText(user.getPhone());
        Picasso.get()
                .load(user.getProfilPicture()).fit().centerCrop().into(cover);
    }
}
