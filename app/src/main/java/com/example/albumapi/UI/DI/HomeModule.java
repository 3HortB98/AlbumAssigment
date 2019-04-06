package com.example.albumapi.UI.DI;


import android.arch.lifecycle.ViewModelProviders;

import com.example.albumapi.DI.Repository;
import com.example.albumapi.UI.home.HomeViewModel;
import com.example.albumapi.UI.home.HomeViewModelFactory;
import com.example.albumapi.UI.home.MainActivity;
import com.example.albumapi.data.DataSource;

import dagger.Module;
import dagger.Provides;

@Module
public class HomeModule {
    private MainActivity mainActivity;

    public HomeModule(MainActivity mainActivity) {
        this.mainActivity = mainActivity;
    }
    @Provides
    @HomeScope
    public HomeViewModelFactory provideHomeViewModelFactory(@Repository DataSource albumRepository){
        return new HomeViewModelFactory(albumRepository);
    }

    @Provides
    @HomeScope
    public HomeViewModel provideHomeViewModel( HomeViewModelFactory homeViewModelFactory){
        return ViewModelProviders.of(mainActivity, homeViewModelFactory).get(HomeViewModel.class);
    }

}
