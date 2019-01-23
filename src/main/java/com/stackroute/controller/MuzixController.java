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

@RestController
@RequestMapping(value="api/v1")
public class MuzixController {
    MuzixService muzixService;
    @Autowired
    public MuzixController(MuzixService muzixService){
        this.muzixService = muzixService;
    }
    //to insert
    @PostMapping("muzix")
    public ResponseEntity<?> saveMuzix(@RequestBody Muzix muzix){
        ResponseEntity responseEntity;
        try {
            muzixService.saveMuzix(muzix);
            responseEntity = new ResponseEntity<String>("Succesfully inserted", HttpStatus.CREATED);
        }catch(MuzixAlreadyExistsException e){
            responseEntity = new ResponseEntity<String>(e.getMessage(), HttpStatus.CONFLICT);

        }
            return responseEntity;
    }
    //to delete
    @DeleteMapping("muzix/{id}")
    public ResponseEntity<?> deleteMuzix(@PathVariable int id){
        ResponseEntity responseEntity;
        try {
            muzixService.deleteById(id);
            responseEntity = new ResponseEntity<List<Muzix>>(muzixService.getAllMuzix(), HttpStatus.OK);
        }catch (MuzixNotFoundException e){
            responseEntity = new ResponseEntity<String>(e.getMessage(), HttpStatus.CONFLICT);

        }
            return responseEntity;
    }
    //fetch(GET) data
    @GetMapping("muzix")
    public ResponseEntity<?> getAllMuzix(){
        ResponseEntity responseEntity = new ResponseEntity<List<Muzix>>(muzixService.getAllMuzix(),HttpStatus.OK);
        return responseEntity;
    }
    //track(get) by id
    @GetMapping("muzix/{id}")
    public ResponseEntity<?> getTrack(@PathVariable int id) {
        ResponseEntity responseEntity;
        try {
            responseEntity =  new ResponseEntity<Muzix>(muzixService.getTrack(id), HttpStatus.OK);
        } catch (MuzixNotFoundException e) {
            responseEntity = new ResponseEntity<String>(e.getMessage(),HttpStatus.CONFLICT);
        }
        return responseEntity;
    }
    //to update
    @PutMapping("muzix")
    public ResponseEntity<?> updateMuzix(@RequestBody Muzix muzix){
      return new ResponseEntity<Muzix>(muzixService.updateTrackComment(muzix),HttpStatus.OK);
    }

    @GetMapping("muzix/{trackName}")
    public ResponseEntity<?> getTrackByName(@PathVariable String trackName){
        ResponseEntity responseEntity;
        try{
            responseEntity = new ResponseEntity<Muzix>(muzixService.getTrackByName(trackName),HttpStatus.OK);
        }catch (MuzixNotFoundException e){
            responseEntity = new ResponseEntity<String>(e.getMessage(),HttpStatus.CONFLICT);
        }
        return responseEntity;
    }
}
