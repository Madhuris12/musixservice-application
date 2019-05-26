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


public class MusixServiceTest {

  private Track track;

  //Create a mock for UserRepository
  @Mock
  private TrackRepository trackRepository;

  //Inject the mocks as dependencies into UserServiceImpl
  @InjectMocks
  private TrackServiceImpl trackService;
  List<Track> list= null;


  @Before
  public void setUp(){
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
  public void saveUserTestSuccess() throws TrackAlreadyExistsException {

    when(trackRepository.save((Track) any())).thenReturn(track);
    Track savedTrack = trackService.savedTrack(track);
    Assert.assertEquals(track,savedTrack);

    //verify here verifies that userRepository save method is only called once
    verify(trackRepository,times(1)).save(track);

  }

  @Test(expected = TrackAlreadyExistsException.class)
  public void saveUserTestFailure() throws TrackAlreadyExistsException {
    when(trackRepository.save((Track) any())).thenReturn(null);
    Track savedTrack = trackService.savedTrack(track);
    System.out.println("savedUser" + savedTrack);
    Assert.assertEquals(track,savedUser);

       /*doThrow(new UserAlreadyExistException()).when(userRepository).findById(eq(101));
       userService.saveUser(user);*/


  }

  @Test
  public void getAllUser(){

    trackRepository.save(track);
    //stubbing the mock to return specific data
    when(trackRepository.findAll()).thenReturn(list);
    List<Track> userlist = trackService.getAllTrack();
    Assert.assertEquals(list,userlist);
  }





}



