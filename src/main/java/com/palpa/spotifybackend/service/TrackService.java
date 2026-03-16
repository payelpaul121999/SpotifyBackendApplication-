package com.palpa.spotifybackend.service;


import com.palpa.spotifybackend.dto.CreateTrackRequest;
import com.palpa.spotifybackend.model.Album;
import com.palpa.spotifybackend.model.Track;
import com.palpa.spotifybackend.repository.AlbumRepository;
import com.palpa.spotifybackend.repository.TrackRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import com.palpa.spotifybackend.model.User;
import com.palpa.spotifybackend.model.Role;
import com.palpa.spotifybackend.model.SubscriptionType;
import com.palpa.spotifybackend.repository.UserRepository;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

@Service
public class TrackService {

    private final TrackRepository trackRepository;
    private final AlbumRepository albumRepository;
    private final UserRepository userRepository;

    public TrackService(TrackRepository trackRepository,
                        AlbumRepository albumRepository,
                        UserRepository userRepository) {
        this.trackRepository = trackRepository;
        this.albumRepository = albumRepository;
        this.userRepository = userRepository;
    }

    // ADMIN creates track
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

    // BULK INSERT
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

    // PLAY TRACK WITH SUBSCRIPTION CHECK
    public Track playTrack(Long trackId){

        Authentication authentication =
                SecurityContextHolder.getContext().getAuthentication();

        String username = authentication.getName();

        User user = userRepository.findByUsername(username)
                .orElseThrow(() -> new RuntimeException("User not found"));

        Track track = trackRepository.findById(trackId)
                .orElseThrow(() -> new RuntimeException("Track not found"));

        // ADMIN bypass
        if(user.getRole() == Role.ADMIN){
            return track;
        }

        // FREE user restriction
        if(user.getSubscriptionType() == SubscriptionType.FREE){

            if(user.getListeningTimeToday() >= 1800){
                throw new RuntimeException("Free user limit reached (30 minutes)");
            }

            user.setListeningTimeToday(
                    user.getListeningTimeToday() + track.getDuration()
            );

            userRepository.save(user);
        }

        return track;
    }
}