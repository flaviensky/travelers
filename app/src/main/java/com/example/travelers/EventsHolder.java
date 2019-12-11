package com.example.travelers;

import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

class EventsHolder extends RecyclerView.ViewHolder {
    private TextView title;
    public EventsHolder(@NonNull View itemView) {
        super(itemView);
        title = itemView.findViewById(R.id.tv_event);
    }

    public void populate(final OnItemClicked onItemClicked, final Events event) {
        title.setText(event.getTitle());
        itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onItemClicked.onItemClicked((event));
            }
        });
    }
}
