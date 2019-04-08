package com.example.albumapi.data;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import java.util.List;

import io.reactivex.Maybe;
import io.reactivex.Single;

@Dao
public interface AlbumDAO {

    @Query("SELECT * FROM albums")
    Single<List<AlbumResponse>> getAlbums();

    @Insert
    void addAlbum(AlbumResponse albumResponse);

    @Delete
    void deleteAlbum(AlbumResponse albumResponse);

    @Update
    void updateAlbum(AlbumResponse albumResponse);
}
