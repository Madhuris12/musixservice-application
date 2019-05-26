package com.stackroute.musixservice.repository;

import com.stackroute.musixservice.domain.Track;
import org.apache.catalina.User;
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

public class MusixRepositoryTest {


    @Autowired
    private TrackRepository trackRepository;
    private Track track;

    @Before
    public void setUp()
    {
      track = new Track();
      track.setTrackID(10);
      track.setTrackName("mungaru male 2");
      track.setTrackComments("Awesome");


    }

    @After
    public void tearDown(){

      trackRepository.deleteAll();
    }


    @Test
    public void testSaveUser(){
      trackRepository.save(track);
      Track fetchtrack = trackRepository.findById(track.getTrackID()).get();
      Assert.assertEquals(10,fetchtrack.getTrackID());

    }

    @Test
    public void testSaveUserFailure(){
      Track testtrack= new Track(11,"galipata","good");
      trackRepository.save(track);
      Track fetchTrack = trackRepository.findById(track.getTrackID()).get();
      Assert.assertNotSame(testtrack,track);
    }

    @Test
    public void testGetAllTrack(){
      Track t = new Track(10,"mungaru male 2","awesome");
      Track t1 = new Track(11,"galipata","good");
      trackRepository.save(t);
      trackRepository.save(t1);

      List<Track> list = (List<Track>) trackRepository.findAll();
      Assert.assertEquals("mungaru male 2",list.get(0).getTrackName());




    }


  }



