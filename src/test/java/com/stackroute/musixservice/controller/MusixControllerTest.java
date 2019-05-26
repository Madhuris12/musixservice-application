package com.stackroute.musixservice.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.stackroute.musixservice.domain.Track;
import com.stackroute.musixservice.exceptions.TrackAlreadyExistsException;
import com.stackroute.musixservice.service.TrackService;
import org.apache.catalina.User;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@RunWith(SpringRunner.class)
@WebMvcTest
public class MusixControllerTest {

    @Autowired
    private MockMvc mockMvc;
    private Track track;
    @MockBean
    private TrackService trackService;
    @InjectMocks
    private TrackControl trackControl;

    private List<User> list = null;
  private Object Track;

  @Before
    public void setUp() {

      MockitoAnnotations.initMocks(this);
      mockMvc = MockMvcBuilders.standaloneSetup().build();
      Track = new Track();
      trackControl.settrackId(26);
      trackControl.settrackName("Jonny");
      trackControl.settrackComments("Awesome");
      list = new ArrayList();
      list.add(track);
    }

    @Test
    public void saveUser() throws Exception {
      when(trackService.saveTrack(any())).thenReturn((com.stackroute.musixservice.domain.Track) Track);
      mockMvc.perform(MockMvcRequestBuilders.post("/api/v1/userservice")
        .contentType(MediaType.APPLICATION_JSON).content(asJsonString(track)))
        .andExpect(MockMvcResultMatchers.status().isCreated())
        .andDo(MockMvcResultHandlers.print());


    }

    @Test
    public void saveUserFailure() throws Exception {
      when(trackService.saveTrack(any())).thenThrow(TrackAlreadyExistsException.class);
      mockMvc.perform(MockMvcRequestBuilders.post("/api/v1/userservice")
        .contentType(MediaType.APPLICATION_JSON).content(asJsonString(track)))
        .andExpect(MockMvcResultMatchers.status().isConflict())
        .andDo(MockMvcResultHandlers.print());
    }

    @Test
    public void getAllUser() throws Exception {
      when(trackService.showAllTrack()).thenReturn(list);
      mockMvc.perform(MockMvcRequestBuilders.get("/api/v1/userservice")
        .contentType(MediaType.APPLICATION_JSON).content(asJsonString(track)))
        .andExpect(MockMvcResultMatchers.status().isOk())
        .andDo(MockMvcResultHandlers.print());

    }


    private String asJsonString(final Object obj) {
      try {
        return new ObjectMapper().writeValueAsString(obj);

      } catch (Exception e) {
        throw new RuntimeException(e);
      }
    }
  }
