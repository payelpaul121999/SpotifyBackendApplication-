package com.palpa.spotifybackend.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import com.palpa.spotifybackend.model.Track;
import com.palpa.spotifybackend.model.Album;

import java.util.List;

public interface TrackRepository extends JpaRepository<Track, Long> {

    List<Track> findByAlbum(Album album);

}
