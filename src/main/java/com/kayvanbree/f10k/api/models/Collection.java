package com.kayvanbree.f10k.api.models;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "collection")
public class Collection {
    @Id()
    private String userId;

    @Column
    @ElementCollection(targetClass=String.class)
    private List<String> tracks;

    @Column
    @ElementCollection(targetClass=String.class)
    private List<String> albums;

    @Column
    @ElementCollection(targetClass=String.class)
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
