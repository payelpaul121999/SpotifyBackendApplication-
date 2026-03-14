package com.palpa.spotifybackend.controller;



import com.palpa.spotifybackend.dto.CreateAlbumRequest;
import com.palpa.spotifybackend.model.Album;
import com.palpa.spotifybackend.service.AlbumService;

import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/albums")
public class AlbumController {

    private final AlbumService albumService;

    public AlbumController(AlbumService albumService) {
        this.albumService = albumService;
    }

    @PostMapping
    public Album createAlbum(@RequestBody CreateAlbumRequest request){

        Album album = new Album();
        album.setTitle(request.getTitle());
        album.setReleaseDate(request.getReleaseDate());
        album.setCoverImage(request.getCoverImage());

        return albumService.createAlbum(request.getArtistId(), album);
    }
    @PostMapping("/bulk")
public List<Album> createAlbums(@RequestBody List<CreateAlbumRequest> requests) {

    List<Album> albums = new ArrayList<>();

    for (CreateAlbumRequest request : requests) {

        Album album = new Album();
        album.setTitle(request.getTitle());
        album.setReleaseDate(request.getReleaseDate());
        album.setCoverImage(request.getCoverImage());

        Album savedAlbum = albumService.createAlbum(request.getArtistId(), album);
        albums.add(savedAlbum);
    }

    return albums;
}

    @GetMapping
    public List<Album> getAlbums(){
        return albumService.getAllAlbums();
    }

    @GetMapping("/artist/{artistId}")
    public List<Album> getAlbumsByArtist(@PathVariable Long artistId){
        return albumService.getAlbumsByArtist(artistId);
    }
}
