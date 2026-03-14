package com.palpa.spotifybackend.service;


import com.palpa.spotifybackend.model.Album;
import com.palpa.spotifybackend.model.Artist;
import com.palpa.spotifybackend.repository.AlbumRepository;
import com.palpa.spotifybackend.repository.ArtistRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AlbumService {

    private final AlbumRepository albumRepository;
    private final ArtistRepository artistRepository;

    public AlbumService(AlbumRepository albumRepository,
                        ArtistRepository artistRepository) {
        this.albumRepository = albumRepository;
        this.artistRepository = artistRepository;
    }

    public Album createAlbum(Long artistId, Album album){

        Artist artist = artistRepository.findById(artistId)
                .orElseThrow(() -> new RuntimeException("Artist not found"));

        album.setArtist(artist);

        return albumRepository.save(album);
    }

    public List<Album> getAllAlbums(){
        return albumRepository.findAll();
    }

    public List<Album> getAlbumsByArtist(Long artistId){

        Artist artist = artistRepository.findById(artistId)
                .orElseThrow(() -> new RuntimeException("Artist not found"));

        return albumRepository.findByArtist(artist);
    }
}
