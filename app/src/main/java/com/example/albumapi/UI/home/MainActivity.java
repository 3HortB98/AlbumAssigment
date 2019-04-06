package com.example.albumapi.UI.home;

import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;

import com.example.albumapi.MyApplication;
import com.example.albumapi.R;
import com.example.albumapi.UI.DI.DaggerHomeComponent;
import com.example.albumapi.UI.DI.HomeModule;
import com.example.albumapi.databinding.ActivityMainBinding;

import javax.inject.Inject;

public class MainActivity extends AppCompatActivity {

    @Inject
    HomeViewModel homeViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ActivityMainBinding binding =
                DataBindingUtil.setContentView(this, R.layout.activity_main);

        DaggerHomeComponent.builder()
                .appComponent(((MyApplication)getApplication()).getAppComponent())
                .homeModule(new HomeModule(this))
                .build()
                .inject(this);

        binding.setProgressVisibility(homeViewModel.getProgressObservable());

        AlbumAdapter albumAdapter = new AlbumAdapter();
        binding.rvAlbums.setLayoutManager(new LinearLayoutManager(this));
        binding.rvAlbums.setAdapter(albumAdapter);

        homeViewModel.getAlbumObservable().observe(this, albumAdapter::setData);

    }
}
