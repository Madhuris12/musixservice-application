package com.stackroute.musixservice.service;

import com.stackroute.musixservice.domain.Track;

import java.util.List;

import com.stackroute.musixservice.exceptions.TrackNotFoundException;
import com.stackroute.musixservice.repository.TrackRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

    @Service
    public class TrackServiceImpl implements TrackService {

        @Autowired
        private TrackRepository trackRepository;
        private TrackServiceImpl trackServiceImpl;

        public void setTrackRepository(TrackRepository trackRepository) {
            this.trackRepository = trackRepository;
        }

        public TrackServiceImpl(TrackRepository trackRepository) {
            this.trackRepository = trackRepository;
        }

        @Override
        public Track saveTrack(Track track) throws Exception {
            if (trackRepository.existsById(track.getTrackID()))
            {
                throw new Exception("Exception in saveTrack");
            }
            Track track1=trackRepository.save(track);
            if(track1==null)
            {
                throw new Exception("Exception in saveTrrack");
            }
            return track1;
        }

        @Override
        public List<Track> showAllTrack() {
            List<Track> track1=(List<Track>) trackRepository.findAll();
            return track1;
        }

        @Override
        public Track updateComment(Track track) throws TrackNotFoundException {
            if(trackRepository.existsById(track.getTrackID()))
            {
                Track track1=trackRepository.findById(track.getTrackID()).get();
                track1.setTrackComments(track.getTrackComments());
                trackRepository.save(track1);
                return track1;
            }
            else
            {
                throw new TrackNotFoundException("track not found");
            }
            //return null;
        }

        @Override
        public boolean deleteTrack(Track track) throws Exception{
            if(trackRepository.existsById(track.getTrackID()))
            {
                trackRepository.deleteById(track.getTrackID());
                return true;
            }
            else
            {
                throw new Exception("Exception in deleteTrack");
            }
            //return false;
        }

        @Override
        public List<Track> getTrackByName(String trackName) throws Exception {
            List<Track> trackList=null;
            trackList=trackRepository.getTrackByName(trackName);
            if(trackList.equals(null))
            {
                throw new Exception("Exception in gettrackName");
            }
            return trackList;
        }
    }

