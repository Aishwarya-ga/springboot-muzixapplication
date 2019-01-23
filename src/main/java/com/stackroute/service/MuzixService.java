package com.stackroute.service;

import com.stackroute.domain.Muzix;
import com.stackroute.exception.MuzixAlreadyExistsException;
import com.stackroute.exception.MuzixNotFoundException;

import java.util.List;

public interface MuzixService {
    public Muzix saveMuzix(Muzix muzix) throws MuzixAlreadyExistsException;
    public List<Muzix> deleteById(int trackId);
    public List<Muzix> getAllMuzix() throws MuzixNotFoundException;
    public Muzix getTrack(int trackId) ;
    public Muzix updateTrackComment(Muzix muzix);
    public Muzix getTrackByName(String trackName);
}
