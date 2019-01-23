package com.stackroute.service;

import com.stackroute.domain.Muzix;
import com.stackroute.exception.MuzixAlreadyExistsException;
import com.stackroute.exception.MuzixNotFoundException;

import java.util.List;
/*
 * This is an interface to implement the Muzix class of domain package.
 */
public interface MuzixService {

    /*
     * This method provide user a mean to add new track in the database.
     */
    public Muzix saveMuzix(Muzix muzix) throws MuzixAlreadyExistsException;

    /*
     * This method help user to remove the track from database based on the input track Id.
     */
    public List<Muzix> deleteById(int trackId) throws MuzixNotFoundException;

    /*
     * This method provide user with all the track in the database.
     */
    public List<Muzix> getAllMuzix();

    /*
     *This method provide track details to the user of particular track Id.
     */
    public Muzix getTrackById(int trackId) throws MuzixNotFoundException;

    /*
     * This method help user to update track comment of a particular track Id.
     */
    public Muzix updateTrackComment(Muzix muzix);

    /*
     * This method help user to get track based a particular track Id.
     */
    public Muzix getTrackByName(String trackName) throws MuzixNotFoundException;
}
