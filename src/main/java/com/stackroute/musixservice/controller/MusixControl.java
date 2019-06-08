package com.stackroute.musixservice.controller;

import com.stackroute.musixservice.domain.Track;
import com.stackroute.musixservice.exceptions.TrackNotFoundException;
import com.stackroute.musixservice.service.TrackService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/")
public class MusixControl {
    private TrackService trackService;
    @Value("${app.title}")
    private String appTitle;

    @GetMapping("value")
    public String getValue()
    {
        return appTitle;
    }
    @Autowired
    public TrackControl(TrackService trackService)
    {
        this.trackService=trackService;
    }

    public void setTrackService(TrackService trackService)
    {
        this.trackService=trackService;
    }

    @RequestMapping(value = "track",method = RequestMethod.POST)
    public ResponseEntity<Track> saveTrack(@RequestBody Track track)
    {
        ResponseEntity responseEntity;
        try {
            Track track1=trackService.saveTrack(track);
            responseEntity=new ResponseEntity<String>("Successfully Added Track", HttpStatus.CREATED);
        }
        catch (Exception e)
        {
            responseEntity=new ResponseEntity<String>(e.getMessage(),HttpStatus.CONFLICT);
            e.printStackTrace();
        }
        return responseEntity;
    }


    @RequestMapping(value = "track",method = RequestMethod.GET)
    public ResponseEntity<List<Track>> showAllTracks()
    {
        List<Track> track1=trackService.showAllTrack();
        return new ResponseEntity<List<Track>>(track1,HttpStatus.OK);
    }

    @RequestMapping(value="track", method=RequestMethod.PUT)
    public ResponseEntity<Track> updateTrack(@RequestBody Track track)
    {
        ResponseEntity responseEntity;
        try {
            Track track1=trackService.updateComment(track);
            return new ResponseEntity<Track>(track1,HttpStatus.OK);
        }
        catch (TrackNotFoundException e)
        {
            responseEntity=new ResponseEntity<String>(e.getMessage(), HttpStatus.CONFLICT);
            e.printStackTrace();
        }
        return responseEntity;
    }


    @RequestMapping(value = "track", method= RequestMethod.DELETE)
    public ResponseEntity<String> deleteTrack(@RequestBody Track track)
    {
        ResponseEntity responseEntity;
        try {
            boolean answer=trackService.deleteTrack(track);
            return new ResponseEntity<String>("Successfully deleted", HttpStatus.OK);
        }
        catch (Exception e)
        {
            responseEntity=new ResponseEntity<String>(e.getMessage(), HttpStatus.CONFLICT);
            e.printStackTrace();
        }
        return responseEntity;
    }


    @RequestMapping(value = "track/{trackName}", method = RequestMethod.GET)
    public ResponseEntity<List<Track>> getTrackByName(@PathVariable("trackName") String trackName) throws Exception
    {
        List<Track> track1=trackService.getTrackByName(trackName);
        return new ResponseEntity<List<Track>>(track1, HttpStatus.OK);
    }

}
