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

}
