package com.example.albumapi.DI;

import android.app.Application;

import com.example.albumapi.Constants;
import com.example.albumapi.data.DataSource;
import com.example.albumapi.data.RemoteDataSource;
import com.example.albumapi.net.AlbumService;

import java.util.concurrent.TimeUnit;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import okhttp3.Cache;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

@Module
public class NetworkModule {

    @Provides
    @Singleton
    public Cache provideCache(Application application){
        return new Cache(application.getCacheDir(), Constants.CACHE_SIZE);
    }

    @Provides
    @Singleton
    public HttpLoggingInterceptor provideHttpLoggingInterceptor(){
        return  new HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY);
    }

    @Provides
    @Singleton
    public OkHttpClient provideOkHttpClient(Cache cache, HttpLoggingInterceptor httpLoggingInterceptor){
        return  new OkHttpClient.Builder()
                .addInterceptor(httpLoggingInterceptor)
                .readTimeout(Constants.API_TIMEOUT, TimeUnit.SECONDS)
                .connectTimeout(Constants.API_TIMEOUT,TimeUnit.SECONDS)
                .cache(cache)
                .build();
    }

    @Provides
    @Singleton
    public Retrofit providesRetrofit(OkHttpClient okHttpClient){
        return new Retrofit.Builder()
                .baseUrl(Constants.BASE_URL)
                .client(okHttpClient)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();
    }

    @Provides
    @Singleton
    public AlbumService provideAlbumService(Retrofit retrofit){
        return retrofit.create(AlbumService.class);
    }


    @Provides
    @Singleton
    @Remote
    public DataSource provideRemoteDataSource(AlbumService albumService){
        return new RemoteDataSource(albumService);
    }
}
