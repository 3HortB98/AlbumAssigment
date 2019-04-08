package com.example.albumapi.net;

import com.example.albumapi.Constants;
import com.example.albumapi.data.AlbumResponse;

import java.util.List;

import io.reactivex.Maybe;
import io.reactivex.Single;
import retrofit2.http.GET;

public interface AlbumService {
    @GET(Constants.ENDPOINT)
    Single<List<AlbumResponse>> getAlbumResults();

}
