package com.palpa.spotifybackend.service;


import com.palpa.spotifybackend.model.Playlist;
import com.palpa.spotifybackend.model.PlaylistTrack;
import com.palpa.spotifybackend.model.Track;
import com.palpa.spotifybackend.repository.PlaylistRepository;
import com.palpa.spotifybackend.repository.PlaylistTrackRepository;
import com.palpa.spotifybackend.repository.TrackRepository;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PlaylistService {

    private final PlaylistRepository playlistRepository;
    private final PlaylistTrackRepository playlistTrackRepository;
    private final TrackRepository trackRepository;

    public PlaylistService(PlaylistRepository playlistRepository,
                           PlaylistTrackRepository playlistTrackRepository,
                           TrackRepository trackRepository) {
        this.playlistRepository = playlistRepository;
        this.playlistTrackRepository = playlistTrackRepository;
        this.trackRepository = trackRepository;
    }

    public Playlist createPlaylist(Playlist playlist){
        return playlistRepository.save(playlist);
    }

    public List<Playlist> getUserPlaylists(Long userId){
        return playlistRepository.findByUserId(userId);
    }

    public void addTrackToPlaylist(Long playlistId, Long trackId){

        Playlist playlist = playlistRepository.findById(playlistId)
                .orElseThrow(() -> new RuntimeException("Playlist not found"));

        Track track = trackRepository.findById(trackId)
                .orElseThrow(() -> new RuntimeException("Track not found"));

        PlaylistTrack playlistTrack = new PlaylistTrack();
        playlistTrack.setPlaylist(playlist);
        playlistTrack.setTrack(track);

        playlistTrackRepository.save(playlistTrack);
    }
    public List<Playlist> createPlaylists(List<Playlist> playlists) {
        return playlistRepository.saveAll(playlists);
    }
    public List<Playlist> getAllPlaylists(){
    return playlistRepository.findAll();
}
}
