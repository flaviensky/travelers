package com.example.travelers;

import android.content.Context;
import android.os.AsyncTask;
import android.util.Log;

import java.util.List;

public class GetEventsDatabase extends AsyncTask<String, Void, String> {

    private Context context;
    private OnRequestsCompleted onRequestsCompleted;
    private List<Events> eventsList;

    public GetEventsDatabase(Context context, OnRequestsCompleted onRequestsCompleted) {
        this.context = context;
        this.onRequestsCompleted = onRequestsCompleted;
    }


    @Override
    protected String doInBackground(String... strings) {
        EventsDao eventsDao = AppDatabase.getInstance(context).getEventsDao();
        eventsList = eventsDao.getEvents();
        return null;
    }

    @Override
    protected void onPostExecute(String s) {
        super.onPostExecute(s);
        Log.i("TAG", "events list" + eventsList);
        onRequestsCompleted.getEvents(eventsList);
    }
}
