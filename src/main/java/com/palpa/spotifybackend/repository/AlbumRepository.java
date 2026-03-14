package com.palpa.spotifybackend.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import com.palpa.spotifybackend.model.Album;
import com.palpa.spotifybackend.model.Artist;

import java.util.List;

public interface AlbumRepository extends JpaRepository<Album, Long> {

    List<Album> findByArtist(Artist artist);

}
