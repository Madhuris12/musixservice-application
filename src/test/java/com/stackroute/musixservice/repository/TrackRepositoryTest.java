package com.stackroute.musixservice.repository;

import com.stackroute.musixservice.domain.Track;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@DataJpaTest
public class TrackRepositoryTest {


    @Autowired
    private TrackRepository trackRepository;
    private Track track;

    @Before
    public void setUp()
    {
        track = new Track();
        track.setTrackID(11);
        track.setTrackName("galipata");
        track.setTrackComments("good");

    }

    @After
    public void tearDown(){

        trackRepository.deleteAll();
    }


    @Test
    public void testSaveTrack(){
        trackRepository.save(track);
        Track fetchTrack = trackRepository.findById(track.getTrackID()).get();
        Assert.assertEquals(11,fetchTrack.getTrackID());

    }

    @Test
    public void testSaveTrackFailure(){
        Track testTrack = new  Track(4,"mungaru male","Singer :Sonu Nigam");
        trackRepository.save(track);
        Track fetchTrack = trackRepository.findById(track.getTrackID()).get();
        Assert.assertNotSame(testTrack,track);
    }

    @Test
    public void testGetAlltrack(){
        Track track = new Track(4,"mungaru male","Singer :Sonu Nigam");
        Track track1 = new Track(11,"mungaru male","good");
        trackRepository.save(track);
        trackRepository.save(track1);

        List<Track> list = (List<Track>) trackRepository.findAll();
        Assert.assertEquals("mungaru male",list.get(0).getTrackName());
    }

}