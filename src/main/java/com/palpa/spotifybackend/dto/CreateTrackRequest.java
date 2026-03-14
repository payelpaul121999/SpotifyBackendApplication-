package com.palpa.spotifybackend.dto;


public class CreateTrackRequest {

    private String title;
    private int duration;
    private String audioUrl;
    private Long albumId;

    public CreateTrackRequest() {
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

    public Long getAlbumId() {
        return albumId;
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

    public void setAlbumId(Long albumId) {
        this.albumId = albumId;
    }
}
