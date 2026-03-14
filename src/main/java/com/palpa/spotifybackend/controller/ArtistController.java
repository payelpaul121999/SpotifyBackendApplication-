package com.palpa.spotifybackend.controller;

import com.palpa.spotifybackend.dto.CreateArtistRequest;
import com.palpa.spotifybackend.model.Artist;
import com.palpa.spotifybackend.service.ArtistService;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/artists")
public class ArtistController {

    private final ArtistService artistService;

    public ArtistController(ArtistService artistService) {
        this.artistService = artistService;
    }

    @PostMapping
    public Artist createArtist(@RequestBody CreateArtistRequest request){

        Artist artist = new Artist();
        artist.setName(request.getName());
        artist.setBio(request.getBio());
        artist.setImageUrl(request.getImageUrl());

        return artistService.createArtist(artist);
    }

    @GetMapping
    public List<Artist> getArtists(){
        return artistService.getAllArtists();
    }

    @GetMapping("/{id}")
    public Artist getArtist(@PathVariable Long id){
        return artistService.getArtist(id);
    }

    @DeleteMapping("/{id}")
    public String deleteArtist(@PathVariable Long id){
        artistService.deleteArtist(id);
        return "Artist deleted";
    }
}
