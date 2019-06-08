package com.stackroute.musixservice.service;
import com.stackroute.musixservice.domain.Track;
import com.stackroute.musixservice.exceptions.TrackNotFoundException;

import java.util.List;
public interface MusixService{
    public Track saveTrack(Track track) throws Exception;
    public List<Track> showAllTrack();
    public Track updateComment(Track track) throws TrackNotFoundException;
    public boolean deleteTrack(Track track) throws Exception;
    public List<Track> getTrackByName(String trackName) throws Exception;
}
