package com.example.albumapi;

import android.app.Application;

import com.example.albumapi.DI.AppComponent;
import com.example.albumapi.DI.DaggerAppComponent;

public class MyApplication extends Application {
    private AppComponent appComponent;

    @Override
    public void onCreate() {
        super.onCreate();
        appComponent = DaggerAppComponent.builder()
                .application(this)
                .build();
    }

    public AppComponent getAppComponent(){
        return appComponent;
    }
}
