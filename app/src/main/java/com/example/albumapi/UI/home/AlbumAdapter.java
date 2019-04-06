package com.example.albumapi.UI.home;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.albumapi.data.AlbumResponse;
import com.example.albumapi.databinding.AlbumItemBinding;

import java.util.ArrayList;
import java.util.List;

public class AlbumAdapter extends RecyclerView.Adapter<AlbumAdapter.AlbumViewHolder>{

    private final List<AlbumResponse> albums = new ArrayList<>();

    public void setData(List<AlbumResponse> data){
        albums.clear();
        albums.addAll(data);
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public AlbumViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        LayoutInflater layoutInflater = LayoutInflater.from(viewGroup.getContext());
        return new AlbumViewHolder(AlbumItemBinding.inflate(layoutInflater,viewGroup,false));
    }

    @Override
    public void onBindViewHolder(@NonNull AlbumViewHolder albumViewHolder, int position) {
        albumViewHolder.bind(albums.get(position));
    }

    @Override
    public int getItemCount() {
        return albums.size();
    }

    public static class AlbumViewHolder extends RecyclerView.ViewHolder{
        private final AlbumItemBinding albumItemBinding;

        public AlbumViewHolder(AlbumItemBinding albumItemBinding) {
            super(albumItemBinding.getRoot());
            this.albumItemBinding = albumItemBinding;
        }
        void bind(AlbumResponse albumResponse){
            albumItemBinding.setAlbum(albumResponse);
            albumItemBinding.executePendingBindings();

        }
    }

    }
