package com.example.albumapi.data;

import java.util.List;

import io.reactivex.Maybe;
import io.reactivex.Single;

public interface DataSource {
    Single<List<AlbumResponse>> getAlbumResults();
    void addAlbum(AlbumResponse albumResponse);
}
