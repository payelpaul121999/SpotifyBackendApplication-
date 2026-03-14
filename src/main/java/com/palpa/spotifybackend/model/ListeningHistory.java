package com.palpa.spotifybackend.model;


import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
public class ListeningHistory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long userId;

    @ManyToOne
    @JoinColumn(name = "track_id")
    private Track track;

    private LocalDateTime playedAt;

    public ListeningHistory() {}

    public ListeningHistory(Long userId, Track track, LocalDateTime playedAt) {
        this.userId = userId;
        this.track = track;
        this.playedAt = playedAt;
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

    public LocalDateTime getPlayedAt() {
        return playedAt;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public void setTrack(Track track) {
        this.track = track;
    }

    public void setPlayedAt(LocalDateTime playedAt) {
        this.playedAt = playedAt;
    }
}
