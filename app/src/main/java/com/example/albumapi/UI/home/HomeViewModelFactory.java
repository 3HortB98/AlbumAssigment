package com.example.albumapi.UI.home;


import android.arch.lifecycle.ViewModel;
import android.arch.lifecycle.ViewModelProvider;
import android.support.annotation.NonNull;

import com.example.albumapi.data.DataSource;

public class HomeViewModelFactory implements ViewModelProvider.Factory {
    private  DataSource albumRepository;

    public HomeViewModelFactory(DataSource albumRepository) {
        this.albumRepository = albumRepository;
    }

    @NonNull
    @Override
    public <T extends ViewModel> T create(@NonNull Class<T> modelClass) {
        if(modelClass.isAssignableFrom(HomeViewModel.class)){
            return (T) new HomeViewModel(albumRepository);
        }
        throw  new IllegalArgumentException("modelclass has to be of type" + HomeViewModel.class.getSimpleName());
    }
}
