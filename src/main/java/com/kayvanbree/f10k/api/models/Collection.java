package com.kayvanbree.f10k.api.models;

import javax.persistence.Entity;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Collection {
    private String userId;

    private List<String> tracks;
    private List<String> albums;
    private List<String> artists;

    public Collection(String userId) {
        this.tracks = new ArrayList<>();
        this.albums = new ArrayList<>();
        this.artists = new ArrayList<>();
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public List<String> getTracks() {
        return tracks;
    }

    public void setTracks(List<String> tracks) {
        this.tracks = tracks;
    }

    public List<String> getAlbums() {
        return albums;
    }

    public void setAlbums(List<String> albums) {
        this.albums = albums;
    }

    public List<String> getArtists() {
        return artists;
    }

    public void setArtists(List<String> artists) {
        this.artists = artists;
    }
}
