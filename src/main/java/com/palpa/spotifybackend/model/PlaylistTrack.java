package com.palpa.spotifybackend.model;


import jakarta.persistence.*;

@Entity
public class PlaylistTrack {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "playlist_id")
    private Playlist playlist;

    @ManyToOne
    @JoinColumn(name = "track_id")
    private Track track;

    public PlaylistTrack() {}

    public PlaylistTrack(Playlist playlist, Track track) {
        this.playlist = playlist;
        this.track = track;
    }

    public Long getId() {
        return id;
    }

    public Playlist getPlaylist() {
        return playlist;
    }

    public Track getTrack() {
        return track;
    }

    public void setPlaylist(Playlist playlist) {
        this.playlist = playlist;
    }

    public void setTrack(Track track) {
        this.track = track;
    }
}
