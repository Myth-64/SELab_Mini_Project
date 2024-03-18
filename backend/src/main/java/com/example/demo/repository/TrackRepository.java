package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.demo.model.Track;

public interface TrackRepository extends JpaRepository<Track,Long>{
    
    @Query(value="SELECT T.* FROM tracks T, user_tracks U, paper_tracks P WHERE U.id=?1 AND P.paper_id=?2 AND  U.track_id=P.track_id AND T.track_id=U.track_id",nativeQuery=true)
    List<Track> findCommonTracks(Long id,Long paperId);
}
