package com.example.albumapi.DI;

import android.app.Application;

import com.example.albumapi.data.DataSource;

import javax.inject.Singleton;

import dagger.BindsInstance;
import dagger.Component;

@Component(modules = {NetworkModule.class, RepositoryModule.class, DatabaseModule.class})
@Singleton
public interface AppComponent {
    @Repository
    DataSource repository();

    @Component.Builder
    interface Builder{
        @BindsInstance Builder application(Application application);
        AppComponent build();
    }
}
