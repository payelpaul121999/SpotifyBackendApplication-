package com.palpa.spotifybackend.service;


import com.palpa.spotifybackend.dto.CreateTrackRequest;
import com.palpa.spotifybackend.model.Album;
import com.palpa.spotifybackend.model.Track;
import com.palpa.spotifybackend.repository.AlbumRepository;
import com.palpa.spotifybackend.repository.TrackRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TrackService {

    private final TrackRepository trackRepository;
    private final AlbumRepository albumRepository;

    public TrackService(TrackRepository trackRepository,
                        AlbumRepository albumRepository) {
        this.trackRepository = trackRepository;
        this.albumRepository = albumRepository;
    }

    public Track createTrack(Long albumId, Track track){

        Album album = albumRepository.findById(albumId)
                .orElseThrow(() -> new RuntimeException("Album not found"));

        track.setAlbum(album);

        return trackRepository.save(track);
    }

    public List<Track> getAllTracks(){
        return trackRepository.findAll();
    }

    public List<Track> getTracksByAlbum(Long albumId){

        Album album = albumRepository.findById(albumId)
                .orElseThrow(() -> new RuntimeException("Album not found"));

        return trackRepository.findByAlbum(album);
    }
    public List<Track> createTracks(List<CreateTrackRequest> requests) {

    List<Track> tracks = new ArrayList<>();

    for (CreateTrackRequest request : requests) {

        Album album = albumRepository.findById(request.getAlbumId())
                .orElseThrow(() -> new RuntimeException("Album not found"));

        Track track = new Track();
        track.setTitle(request.getTitle());
        track.setDuration(request.getDuration());
        track.setAudioUrl(request.getAudioUrl());
        track.setAlbum(album);

        tracks.add(track);
    }

    return trackRepository.saveAll(tracks);
}
}
