package com.example.albumapi.data;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.RoomDatabase;

import com.example.albumapi.Constants;

@Database(entities = {AlbumResponse.class},version = Constants.DATABASE_VERSION)
public abstract class AlbumDatabase extends RoomDatabase {
    public  abstract AlbumDAO albumDAO();
}
