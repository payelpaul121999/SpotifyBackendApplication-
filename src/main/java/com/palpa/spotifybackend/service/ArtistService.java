package com.palpa.spotifybackend.service;


import com.palpa.spotifybackend.model.Artist;
import com.palpa.spotifybackend.repository.ArtistRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ArtistService {

    private final ArtistRepository artistRepository;

    public ArtistService(ArtistRepository artistRepository) {
        this.artistRepository = artistRepository;
    }

    public Artist createArtist(Artist artist){
        return artistRepository.save(artist);
    }

    public List<Artist> getAllArtists(){
        return artistRepository.findAll();
    }

    public Artist getArtist(Long id){
        return artistRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Artist not found"));
    }

    public void deleteArtist(Long id){
        artistRepository.deleteById(id);
    }
}
