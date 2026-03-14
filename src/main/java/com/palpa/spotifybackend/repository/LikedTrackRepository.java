package com.palpa.spotifybackend.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import com.palpa.spotifybackend.model.LikedTrack;

import java.util.List;

public interface LikedTrackRepository extends JpaRepository<LikedTrack, Long> {

    List<LikedTrack> findByUserId(Long userId);

}