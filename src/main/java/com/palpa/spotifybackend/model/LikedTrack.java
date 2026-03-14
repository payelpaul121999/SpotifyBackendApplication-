package com.palpa.spotifybackend.model;


import jakarta.persistence.*;

@Entity
public class LikedTrack {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long userId;

    @ManyToOne
    @JoinColumn(name = "track_id")
    private Track track;

    public LikedTrack() {}

    public LikedTrack(Long userId, Track track) {
        this.userId = userId;
        this.track = track;
    }

    public Long getId() {
        return id;
    }

    public Long getUserId() {
        return userId;
    }

    public Track getTrack() {
        return track;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public void setTrack(Track track) {
        this.track = track;
    }
}
