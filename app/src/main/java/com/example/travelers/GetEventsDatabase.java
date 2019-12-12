package com.example.travelers;

import android.content.Context;
import android.os.AsyncTask;

import java.util.List;

public class GetEventsDatabase extends AsyncTask<String, Void, String> {

    private Context context;
    private List<Events> eventsList;

    public GetEventsDatabase(Context context) {
        this.context = context;
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
    }
}
