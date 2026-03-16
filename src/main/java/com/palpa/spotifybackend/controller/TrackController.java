package com.palpa.spotifybackend.controller;


import com.palpa.spotifybackend.dto.CreateTrackRequest;
import com.palpa.spotifybackend.model.Track;
import com.palpa.spotifybackend.service.TrackService;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tracks")
public class TrackController {

    private final TrackService trackService;

    public TrackController(TrackService trackService) {
        this.trackService = trackService;
    }

    @PostMapping
    public Track createTrack(@RequestBody CreateTrackRequest request){

        Track track = new Track();
        track.setTitle(request.getTitle());
        track.setDuration(request.getDuration());
        track.setAudioUrl(request.getAudioUrl());

        return trackService.createTrack(request.getAlbumId(), track);
    }

    @GetMapping
    public List<Track> getTracks(){
        return trackService.getAllTracks();
    }

    @GetMapping("/album/{albumId}")
    public List<Track> getTracksByAlbum(@PathVariable Long albumId){
        return trackService.getTracksByAlbum(albumId);
    }
    @PostMapping("/bulk")
    public List<Track> createTracks(@RequestBody List<CreateTrackRequest> requests) {
        return trackService.createTracks(requests);
    }
    @GetMapping("/play/{trackId}")
    public Track playTrack(@PathVariable Long trackId){
        return trackService.playTrack(trackId);
    }
}
