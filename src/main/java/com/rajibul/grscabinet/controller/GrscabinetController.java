package com.rajibul.grscabinet.controller;

import com.rajibul.grscabinet.model.GrscabinetModel;
import com.rajibul.grscabinet.service.GrscabinetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/complains")
public class GrscabinetController {

    @Autowired
    private GrscabinetService grscabinetService;




    @GetMapping("/getall")
    public ResponseEntity<List<GrscabinetModel>> getAllGrsComplain() {
        List<GrscabinetModel> grsComplainList = grscabinetService.getAllGrsComplain();
        return new ResponseEntity<>(grsComplainList, HttpStatus.OK);

    }

    @GetMapping("/{id}")
    public ResponseEntity<GrscabinetModel> getGrsComplainById(@PathVariable int id) {
        GrscabinetModel singleGrsComplain = grscabinetService.getGrsComplainByID(id);
        return new ResponseEntity<>(singleGrsComplain, HttpStatus.OK);


    }

    @PostMapping
    public ResponseEntity<GrscabinetModel> createComplain(@RequestBody GrscabinetModel grscabinetDataObj) {
        grscabinetService.addGrsComplain(grscabinetDataObj);
        return new ResponseEntity<>(grscabinetDataObj, HttpStatus.OK);
    }


    @PutMapping("/update/{id}")
    public ResponseEntity<GrscabinetModel> updateComplain(@PathVariable int id, @RequestBody GrscabinetModel complainDetails) {
        GrscabinetModel existingComplain = grscabinetService.getGrsComplainByID(id);

        if (existingComplain != null) {
            existingComplain.setSubject(complainDetails.getSubject());
            existingComplain.setDetails(complainDetails.getDetails());
            existingComplain.setName(complainDetails.getName());
            existingComplain.setPhone(complainDetails.getPhone());

            grscabinetService.updateGrsComplain(existingComplain);

            return ResponseEntity.ok(existingComplain);
        } else {
            return ResponseEntity.notFound().build();
        }
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteComplain(@PathVariable int id) {
        grscabinetService.deleteGrsComplain(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }



}
