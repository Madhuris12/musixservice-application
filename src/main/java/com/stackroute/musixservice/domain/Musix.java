package com.stackroute.musixservice.domain;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.Entity;
import javax.persistence.Id;

    @Entity
    @Data
    @Builder

    public class Musix {

        @Id
        private int trackID;
        private String trackName;
        private String trackComments;

}
