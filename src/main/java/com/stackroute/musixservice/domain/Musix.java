package com.stackroute.musixservice.domain;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.Entity;
import javax.persistence.Id;

    @Entity
    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    @Builder

    public class Musix {

        @Id
        private int trackID;
        private String trackName;
        private String trackComments;

   /*public Track() {
   }

   public Track(int trackID, String trackName, String trackComments) {
       this.trackID = trackID;
       this.trackName = trackName;
       this.trackComments = trackComments;
   }

   @Override
   public String toString() {
       return "Track{" +
               "trackID=" + trackID +
               ", trackName='" + trackName + '\'' +
               ", trackComments='" + trackComments + '\'' +
               '}';
   }

   public int getTrackID() {
       return trackID;
   }

   public void setTrackID(int trackID) {
       this.trackID = trackID;
   }

   public String getTrackName() {
       return trackName;
   }

   public void setTrackName(String trackName) {
       this.trackName = trackName;
   }

   public String getTrackComments() {
       return trackComments;
   }

   public void setTrackComments(String trackComments) {
       this.trackComments = trackComments;
   }*/
}
