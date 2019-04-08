package com.example.albumapi.data;

import java.util.List;

import io.reactivex.Maybe;
import io.reactivex.Single;

public class LocalDataSource implements DataSource {
    private final AlbumDatabase albumDatabase;

    public LocalDataSource(AlbumDatabase albumDatabase) {
        this.albumDatabase = albumDatabase;
    }

    @Override
    public Single<List<AlbumResponse>> getAlbumResults() {
        return albumDatabase.albumDAO().getAlbums();
    }

    @Override
    public void addAlbum(AlbumResponse albumResponse) {
        albumDatabase.albumDAO().addAlbum(albumResponse);
    }
}
