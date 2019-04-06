package com.example.albumapi.UI.DI;

import com.example.albumapi.DI.AppComponent;
import com.example.albumapi.UI.home.MainActivity;

import dagger.Component;

@Component(modules = HomeModule.class, dependencies = AppComponent.class)
@HomeScope
public interface HomeComponent {
    void inject(MainActivity mainActivity);
}
