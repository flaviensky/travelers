package com.example.travelers;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class EventsAdapter extends RecyclerView.Adapter<EventsHolder> {

    private final static String TAG = EventsAdapter.class.getSimpleName();

    private List<Events> eventsList;
    private OnItemClicked onItemClicked;

    EventsAdapter(Context context, OnItemClicked onItemClicked, List<Events> result){

        this.onItemClicked = onItemClicked;

        eventsList = result;


        final EventsDao eventsDao = AppDatabase.getInstance(context).getEventsDao();

        Thread thread = new Thread(){
            @Override
            public void run() {
                super.run();
                eventsDao.insertAllEvents(eventsList);
            }
        };
        thread.start();
    }

    @NonNull
    @Override
    public EventsHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType){
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.event_item, parent, false);
        return new EventsHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull EventsHolder holder, int position) {
        Events event = eventsList.get(position);
        holder.populate(onItemClicked, event);
    }

    @Override
    public int getItemCount() {
        return eventsList.size();
    }

}
