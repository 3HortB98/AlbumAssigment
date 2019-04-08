package com.example.albumapi.data;

import com.example.albumapi.net.AlbumService;

import java.util.List;

import io.reactivex.Maybe;
import io.reactivex.Single;

public class RemoteDataSource implements DataSource {

    private final AlbumService albumService;

    public RemoteDataSource(AlbumService albumService) {
        this.albumService = albumService;
    }

    @Override
    public Single<List<AlbumResponse>> getAlbumResults() {
        return albumService.getAlbumResults()
                .map(albumResponses -> albumResponses);
    }

    @Override
    public void addAlbum(AlbumResponse albumResponse) {

    }

}
