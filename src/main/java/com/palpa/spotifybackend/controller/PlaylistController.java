package com.palpa.spotifybackend.controller;


import com.palpa.spotifybackend.model.Playlist;
import com.palpa.spotifybackend.service.PlaylistService;

import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/playlists")
public class PlaylistController {

    private final PlaylistService playlistService;

    public PlaylistController(PlaylistService playlistService) {
        this.playlistService = playlistService;
    }

    @PostMapping
    public Playlist createPlaylist(@RequestBody Playlist playlist){
        return playlistService.createPlaylist(playlist);
    }

    @GetMapping("/user/{userId}")
    public List<Playlist> getUserPlaylists(@PathVariable Long userId){
        return playlistService.getUserPlaylists(userId);
    }

    @PostMapping("/{playlistId}/tracks/{trackId}")
    public String addTrackToPlaylist(@PathVariable Long playlistId,
                                     @PathVariable Long trackId){

        playlistService.addTrackToPlaylist(playlistId, trackId);

        return "Track added to playlist";
    }
    @PostMapping("/bulk")
    public List<Playlist> createPlaylists(@RequestBody List<Playlist> playlists) {
        return playlistService.createPlaylists(playlists);
    }
}
