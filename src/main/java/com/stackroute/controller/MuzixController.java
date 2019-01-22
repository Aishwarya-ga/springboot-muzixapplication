package com.stackroute.controller;

import com.stackroute.domain.Muzix;
import com.stackroute.service.MuzixService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping(value="api/muzix")
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
        muzixService.saveMuzix(muzix);
        responseEntity = new ResponseEntity<String>("Succesfully inserted", HttpStatus.CREATED);
        return responseEntity;
    }
    //to delete
    @DeleteMapping("muzix/{id}")
    public ResponseEntity<?> deleteMuzix(@PathVariable int id){
        muzixService.deleteById(id);
        ResponseEntity responseEntity = new ResponseEntity<List<Muzix>>(muzixService.getAllMuzix(),HttpStatus.OK);
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
    public ResponseEntity<?> getTrack(@PathVariable int id){
        return new ResponseEntity<Muzix>(muzixService.getTrack(id),HttpStatus.OK);
    }
    //to update
    @PutMapping("muzix")
    public ResponseEntity<?> updateMuzix(@RequestBody Muzix muzix){
      return new ResponseEntity<Muzix>(muzixService.updateTrackComment(muzix),HttpStatus.OK);
    }
}
