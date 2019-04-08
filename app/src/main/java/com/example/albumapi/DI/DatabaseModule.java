package com.example.albumapi.DI;

import android.app.Application;
import android.arch.persistence.db.SupportSQLiteDatabase;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.migration.Migration;
import android.support.annotation.NonNull;

import com.example.albumapi.Constants;
import com.example.albumapi.data.AlbumDatabase;
import com.example.albumapi.data.DataSource;
import com.example.albumapi.data.LocalDataSource;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class DatabaseModule {

    @Provides
    @Singleton
    public AlbumDatabase providesAlbumDatabase(Application application){
        return Room.databaseBuilder(application, AlbumDatabase.class, Constants.DATABASE_NAME)
                .addMigrations(MIGRATION_1_2)
                .build();
    }

    @Provides
    @Local
    @Singleton
    public DataSource provideLocalDatabase(AlbumDatabase albumDatabase){
        return new LocalDataSource(albumDatabase);
    }

    static final Migration MIGRATION_1_2 = new Migration(1,2) {
        @Override
        public void migrate(@NonNull SupportSQLiteDatabase database) {

        }
    };
}
