package com.palpa.spotifybackend.dto;


public class CreateArtistRequest {

    private String name;
    private String bio;
    private String imageUrl;

    public CreateArtistRequest() {
    }

    public String getName() {
        return name;
    }

    public String getBio() {
        return bio;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setBio(String bio) {
        this.bio = bio;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }
}
