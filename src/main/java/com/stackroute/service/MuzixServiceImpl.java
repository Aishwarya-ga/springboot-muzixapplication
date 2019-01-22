package com.stackroute.service;

import com.stackroute.domain.Muzix;
import com.stackroute.exception.MuzixAlreadyExistsException;
import com.stackroute.exception.MuzixNotFoundException;
import com.stackroute.repository.MuzixRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MuzixServiceImpl implements MuzixService {
    MuzixRepository muzixRepository;
    @Autowired
    public MuzixServiceImpl(MuzixRepository muzixRepository){
        this.muzixRepository = muzixRepository;
    }

    @Override
    public Muzix saveMuzix(Muzix muzix) throws MuzixAlreadyExistsException {
        if(muzixRepository.existsById(muzix.getTrackId())){
            throw new MuzixAlreadyExistsException("track already exists");
        }
        Muzix saveMuzix = muzixRepository.save(muzix);
        if(saveMuzix == null){
            throw new MuzixAlreadyExistsException("track already exista");
        }
        return saveMuzix;
    }

    @Override
    public List<Muzix> deleteById(int trackId) throws MuzixNotFoundException {
        if(trackId == 0){
            throw new MuzixNotFoundException("track not found");
        }
        muzixRepository.deleteById(trackId);
        return muzixRepository.findAll();
    }

    @Override
    public List<Muzix> getAllMuzix(){
        return muzixRepository.findAll();
    }

    @Override
    public Muzix getTrack(int trackId) throws MuzixNotFoundException {
        if(trackId == 0){
            throw new MuzixNotFoundException("track not found");
        }
        Optional<Muzix> muzix = muzixRepository.findById(trackId);
        return muzix.get();
    }

    @Override
    public Muzix updateTrackComment(Muzix muzix) {
        Muzix updateTrack=muzixRepository.save(muzix);
        return updateTrack;
    }

    @Override
    public Muzix getTrackByName(String trackName) throws MuzixNotFoundException {
        if(trackName == null){
            throw new MuzixNotFoundException("track name not existed");
        }
        return muzixRepository.findTrackByName(trackName);
    }


}