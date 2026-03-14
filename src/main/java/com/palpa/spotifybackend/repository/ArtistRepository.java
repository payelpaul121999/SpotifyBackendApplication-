package com.palpa.spotifybackend.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import com.palpa.spotifybackend.model.Artist;

public interface ArtistRepository extends JpaRepository<Artist, Long> {
}
