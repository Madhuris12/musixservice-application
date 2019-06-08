package com.stackroute.musixservice.repository;

import java.util.List;
import com.stackroute.musixservice.domain.Track;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

    public interface MusixRepository extends CrudRepository<Track, Integer> {

        @Query(value = "select * from track where track_name=?1", nativeQuery = true)
        public List<Track> getTrackByName(String trackName);
    }
