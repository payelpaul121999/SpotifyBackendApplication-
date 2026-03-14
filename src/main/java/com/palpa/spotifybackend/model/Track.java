package com.palpa.spotifybackend.model;


import jakarta.persistence.*;

@Entity
public class Track {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;

    private int duration;

    private String audioUrl;

    @ManyToOne
    @JoinColumn(name = "album_id")
    private Album album;

    public Track() {}

    public Track(String title, int duration, String audioUrl, Album album) {
        this.title = title;
        this.duration = duration;
        this.audioUrl = audioUrl;
        this.album = album;
    }

    public Long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public int getDuration() {
        return duration;
    }

    public String getAudioUrl() {
        return audioUrl;
    }

    public Album getAlbum() {
        return album;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public void setAudioUrl(String audioUrl) {
        this.audioUrl = audioUrl;
    }

    public void setAlbum(Album album) {
        this.album = album;
    }
}
