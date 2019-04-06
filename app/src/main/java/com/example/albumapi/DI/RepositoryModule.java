package com.example.albumapi.DI;

import com.example.albumapi.data.AlbumRepository;
import com.example.albumapi.data.DataSource;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class RepositoryModule {
    @Provides
    @Singleton
    @Repository
    public DataSource provideRepository(@Remote DataSource remoteDataSource,
                                        @Local DataSource localDataSource){
        return new AlbumRepository(remoteDataSource, localDataSource);
    }
}
