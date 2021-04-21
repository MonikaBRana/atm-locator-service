package com.example.demo.Controller;

import com.example.demo.Pojo.AtmLocationDetails;
import com.example.demo.Service.AtmLocatorService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class AtmLocatorController {
    private static final Logger LOGGER = LoggerFactory.getLogger(AtmLocatorController.class);
    @Autowired
    AtmLocatorService atmLocatorService;

    @GetMapping("/getAllAtmDetails")
    public ResponseEntity<List<AtmLocationDetails>> getAllAtmDetails(){
        try{
            List<AtmLocationDetails> atmLocationDetailsList = atmLocatorService.getAllAtmDetails();
            return new ResponseEntity<>(atmLocationDetailsList, HttpStatus.OK);
        }catch(Exception ex){
            LOGGER.error("Exception encountered while getting all atm details",ex);
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/getAtmDetailsByCity/{city}")
    public ResponseEntity<List<AtmLocationDetails>> getAtmDetailsByCity(@PathVariable String city){
        try{
            List<AtmLocationDetails> atmLocationDetailsList = atmLocatorService.getAtmDetailsByCity(city);
            return new ResponseEntity<>(atmLocationDetailsList, HttpStatus.OK);
        }catch(Exception ex){
            LOGGER.error("Exception encountered while getting all atm details for the city - {}",city,ex);
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }
}
