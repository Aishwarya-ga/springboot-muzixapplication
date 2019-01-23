package com.stackroute.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Value;

import javax.persistence.Entity;
import javax.persistence.Id;


@Entity
@Data  //Lombok will generate all setter and getter
@NoArgsConstructor //generate no argument constructore
@AllArgsConstructor // generate all arguments constructor
@Builder
public class Muzix {
    @Id                   //indicates that trackId is primary key
    private int trackId;
    private String trackName;
    private String comments;

//    public Muzix() {
//    }
//
//    public Muzix(int trackId, String trackName, String comments) {
//        this.trackId = trackId;
//        this.trackName = trackName;
//        this.comments = comments;
//    }
//
//    public int getTrackId() {
//        return trackId;
//    }
//
//    public void setTrackId(int trackId) {
//        this.trackId = trackId;
//    }
//
//    public String getTrackName() {
//        return trackName;
//    }
//
//    public void setTrackName(String trackName) {
//        this.trackName = trackName;
//    }
//
//    public String getComments() {
//        return comments;
//    }
//
//    public void setComments(String comments) {
//        this.comments = comments;
//    }
//
//    @Override
//    public String toString() {
//        return "Muzix{" +
//                "trackId=" + trackId +
//                ", trackName='" + trackName + '\'' +
//                ", comments='" + comments + '\'' +
//                '}';
//    }
}
