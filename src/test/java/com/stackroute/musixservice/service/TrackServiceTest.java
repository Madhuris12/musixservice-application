package com.stackroute.musixservice.service;
import com.stackroute.musixservice.domain.Track;
import com.stackroute.musixservice.exceptions.TrackAlreadyExistsException;
import com.stackroute.musixservice.repository.TrackRepository;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;


public class TrackServiceTest {
  private Track track;

  //Create a mock
  @Mock
  private TrackRepository trackRepository;


  @InjectMocks
  private TrackServiceImpl trackService;
  List<Track> list = null;


  @Before
  public void setUp() {
    //Initialising the mock object
    MockitoAnnotations.initMocks(this);
    track = new Track();
    track.setTrackID(10);
    track.setTrackName("mungaru male 2");
    track.setTrackComments("awesome");
    list = new ArrayList<>();
    list.add(track);


  }

  @Test
  public void saveTrackTestSuccess() throws Exception {

    when(trackRepository.save((Track) any())).thenReturn(track);
    Track savedTrack = trackService.saveTrack(track);
    Assert.assertEquals(track, savedTrack);

    //verify here verifies that userRepository save method is only called once
    verify(trackRepository, times(1)).save(track);

  }

  @Test(expected = TrackAlreadyExistsException.class)
  public void saveTrackTestFailure() throws Exception {
    when(trackRepository.save((Track) any())).thenReturn(null);
    Track savedUser = trackService.saveTrack(track);
    System.out.println("savedUser" + savedUser);
    Assert.assertEquals(track, savedUser);


  }

  @Test
  public void showAllTrack() {

    trackRepository.save(track);
    //stubbing the mock to return specific data
    when(trackRepository.findAll()).thenReturn(list);
    List<Track> tracklist = trackService.showAllTrack();
    Assert.assertEquals(list, tracklist);
  }
}



