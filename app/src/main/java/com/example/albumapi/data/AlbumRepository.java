package com.example.albumapi.data;

import java.util.List;

import io.reactivex.Single;

public class AlbumRepository implements DataSource {

    private final DataSource remoteDataSource;
    private final DataSource localDataSource;

    public AlbumRepository(DataSource remoteDataSource, DataSource localDataSource) {
        this.remoteDataSource = remoteDataSource;
        this.localDataSource = localDataSource;
    }

    @Override
    public Single<List<AlbumResponse>> getAlbumResults() {
        return remoteDataSource.getAlbumResults();
    }

    @Override
    public void addAlbum(AlbumResponse albumResponse) {
        localDataSource.addAlbum(albumResponse);

    }
}
