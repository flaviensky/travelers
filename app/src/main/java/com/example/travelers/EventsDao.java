package com.example.travelers;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import java.util.List;

@Dao
public interface EventsDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    public void insertAllEvents(List<Events> listEvents);

    @Query("SELECT * FROM events")
    public List<Events> getEvents();

    @Query("SELECT * FROM events WHERE id= :id")
    public Events getEventsWithId(String id);
}
