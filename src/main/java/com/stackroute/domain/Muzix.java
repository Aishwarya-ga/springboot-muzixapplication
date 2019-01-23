package com.stackroute.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@Data                           //Lombok will generate all setter and getter
@NoArgsConstructor              //generate no argument constructore
@AllArgsConstructor             // generate all arguments constructor
@Builder

/*
 * Track class which deifne the track object property viz,
 * trackId, trackName and trackComment.
 */
public class Muzix {
    @Id                          //indicates that trackId is primary key
    private int trackId;         //Primary key to identify each track uniquely.
    private String trackName;    //Stores the music name.
    private String comments;     // Provide added comment about the particular music.
}
