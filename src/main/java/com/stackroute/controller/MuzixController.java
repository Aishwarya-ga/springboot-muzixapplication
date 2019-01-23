package com.stackroute.controller;

import com.stackroute.domain.Muzix;
import com.stackroute.exception.MuzixAlreadyExistsException;
import com.stackroute.exception.MuzixNotFoundException;
import com.stackroute.service.MuzixService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

/*
 *This is controller class which create object of MuzixService class and
 * consume the methods of it.
 */
@RestController
@RequestMapping(value="api/v1")
public class MuzixController {

    /* It instantiate the MuzixService class so as to consume the
     * method of the same
     */
    private MuzixService muzixService;

    /*
     * Parameterized constructor to create TrackController instance.
     */
    @Autowired
    public MuzixController(MuzixService muzixService){
        this.muzixService = muzixService;
    }

    /*
     *  to add new muzix
     */
    @PostMapping("muzix")
    public ResponseEntity<?> saveMuzix(@RequestBody Muzix muzix) throws MuzixAlreadyExistsException{
        ResponseEntity responseEntity;
        muzixService.saveMuzix(muzix);
        responseEntity = new ResponseEntity<String>("Succesfully inserted", HttpStatus.CREATED);
        return responseEntity;
    }

    /*
     *to delete the muzix based in Id
     */
    @DeleteMapping("muzix/{id}")
    public ResponseEntity<?> deleteMuzix(@PathVariable int id) throws MuzixNotFoundException{
        ResponseEntity responseEntity;
        muzixService.deleteById(id);
        responseEntity = new ResponseEntity<List<Muzix>>(muzixService.getAllMuzix(), HttpStatus.OK);
        return responseEntity;
    }

    /*
     *fetch(GET) all Muzix data
     */
    @GetMapping("muzixs")
    public ResponseEntity<?> getAllMuzix() throws MuzixNotFoundException{
        ResponseEntity responseEntity = new ResponseEntity<List<Muzix>>(muzixService.getAllMuzix(),HttpStatus.OK);
        return responseEntity;
    }

    /*
     * track(get) muzix by id
     */
    @GetMapping("muzix/{id}")
    public ResponseEntity<?> getMuzixById(@PathVariable int id) throws MuzixNotFoundException {
        ResponseEntity responseEntity;
        responseEntity =  new ResponseEntity<Muzix>(muzixService.getTrackById(id), HttpStatus.OK);
        return responseEntity;
    }

    /*
     *to update the comment of specific muzix based on id
     */
    @PutMapping("muzix")
    public ResponseEntity<?> updateMuzixByComment(@RequestBody Muzix muzix){
        return new ResponseEntity<Muzix>(muzixService.updateTrackComment(muzix),HttpStatus.OK);
    }

    /*
     *to get muzix by name
     */
    @GetMapping("muzix/{trackName}")
    public ResponseEntity<?> getMuzixByName(@PathVariable String trackName) throws MuzixNotFoundException{
        ResponseEntity responseEntity;
        responseEntity = new ResponseEntity<Muzix>(muzixService.getTrackByName(trackName),HttpStatus.OK);
        return responseEntity;
    }
}
