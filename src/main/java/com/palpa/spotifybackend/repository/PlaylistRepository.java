package com.palpa.spotifybackend.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import com.palpa.spotifybackend.model.Playlist;

import java.util.List;

public interface PlaylistRepository extends JpaRepository<Playlist, Long> {

    List<Playlist> findByUserId(Long userId);

}
