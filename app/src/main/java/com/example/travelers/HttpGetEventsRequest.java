package com.example.travelers;

import android.os.AsyncTask;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class HttpGetEventsRequest extends AsyncTask<String, Void, String> {

    private final static String TAG = HttpGetEventsRequest.class.getSimpleName();
    private OnRequestsCompleted mOnRequestsCompleted;
    private List<Events> eventsList;

    HttpGetEventsRequest(OnRequestsCompleted onRequestsCompleted){
        mOnRequestsCompleted = onRequestsCompleted;
    }

    @Override
    protected String doInBackground(String... strings) {

        String inputLine;
        JSONArray jsonArray = null;

        try{
            //URL
            URL url = new URL("https://opendata.paris.fr/api/records/1.0/search/?dataset=que-faire-a-paris-&rows=20");

            //Connection
            HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
            httpURLConnection.setRequestMethod("GET");
            httpURLConnection.setReadTimeout(15000);
            httpURLConnection.setConnectTimeout(15000);

            httpURLConnection.setRequestProperty("Content-Type", "application/json");
            httpURLConnection.setRequestProperty("Accept", "application/json");
            //httpURLConnection.setRequestProperty("X-RapidAPI-Key", "");

            //Connect
            httpURLConnection.connect();

            InputStreamReader inputStreamReader = new InputStreamReader(httpURLConnection.getInputStream());

            //buffered reader and string builder
            BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
            StringBuilder stringBuilder = new StringBuilder();

            //check line reading isn't null
            while ((inputLine = bufferedReader.readLine()) != null){
                stringBuilder.append(inputLine);
            }

            //parse to json

            JSONObject jsonObject = new JSONObject(stringBuilder.toString());
            jsonArray = jsonObject.getJSONArray("records");


        } catch (IOException e) {
            e.printStackTrace();
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return jsonArray != null ? jsonArray.toString() : null;
    }

    @Override
    protected void onPostExecute(String s) {
        super.onPostExecute(s);
        mOnRequestsCompleted.getEvents(s);
        eventsList = new ArrayList<>();
        
        try{
            JSONArray jsonArray = new JSONArray(s);



            for(int i = 0; i < jsonArray.length(); i++ ){

                JSONObject jsonObject = jsonArray.getJSONObject(i);

                JSONObject fields = jsonObject.getJSONObject("fields");

                eventsList.add(new Events(
                        fields.getString("id"),
                        fields.getString("title"),
                        fields.getString("category"),
                        fields.getString("cover_url")));
            }
        }catch (JSONException e){
            e.printStackTrace();
        }
    }
}
