package com.stackroute.service;

import com.stackroute.domain.Muzix;
import com.stackroute.exception.MuzixAlreadyExistsException;
import com.stackroute.exception.MuzixNotFoundException;

import java.util.List;

public interface MuzixService {
    public Muzix saveMuzix(Muzix muzix) throws MuzixAlreadyExistsException;
    public List<Muzix> deleteById(int trackId) throws MuzixNotFoundException;
    public List<Muzix> getAllMuzix();
    public Muzix getTrack(int trackId) throws MuzixNotFoundException;
    public Muzix updateTrackComment(Muzix muzix);
    public Muzix getTrackByName(String trackName) throws MuzixNotFoundException;
}
