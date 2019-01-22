package com.stackroute.repository;

import com.stackroute.domain.Muzix;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;


//interface because depends on abstraction not on concretion
@Repository
public interface MuzixRepository extends JpaRepository<Muzix,Integer> {

    @Query(value = "SELECT m FROM Muzix m where m.trackName = ?1")
    public Muzix findTrackByName(String trackName);
}



