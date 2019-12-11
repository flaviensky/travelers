package com.example.travelers;

import android.media.Image;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

class EventsHolder extends RecyclerView.ViewHolder {
    private TextView title;
    private ImageView cover;
    public EventsHolder(@NonNull View itemView) {
        super(itemView);
        title = itemView.findViewById(R.id.tv_event);
        cover = itemView.findViewById(R.id.iv_cover);
    }

    public void populate(final OnItemClicked onItemClicked, final Events event) {
        title.setText(event.getTitle());
        Picasso.get().load(event.getCover_url()).fit().centerCrop().into(cover);
        itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onItemClicked.onItemClicked((event));
            }
        });
    }
}
