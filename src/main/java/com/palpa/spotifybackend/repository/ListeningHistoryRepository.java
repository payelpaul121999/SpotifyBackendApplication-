package com.palpa.spotifybackend.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import com.palpa.spotifybackend.model.ListeningHistory;

import java.util.List;

public interface ListeningHistoryRepository extends JpaRepository<ListeningHistory, Long> {

    List<ListeningHistory> findByUserId(Long userId);

}
