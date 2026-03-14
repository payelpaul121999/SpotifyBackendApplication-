package com.palpa.spotifybackend.dto;


import java.time.LocalDate;

public class CreateAlbumRequest {

    private String title;
    private LocalDate releaseDate;
    private String coverImage;
    private Long artistId;

    public CreateAlbumRequest() {
    }

    public String getTitle() {
        return title;
    }

    public LocalDate getReleaseDate() {
        return releaseDate;
    }

    public String getCoverImage() {
        return coverImage;
    }

    public Long getArtistId() {
        return artistId;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setReleaseDate(LocalDate releaseDate) {
        this.releaseDate = releaseDate;
    }

    public void setCoverImage(String coverImage) {
        this.coverImage = coverImage;
    }

    public void setArtistId(Long artistId) {
        this.artistId = artistId;
    }
}
