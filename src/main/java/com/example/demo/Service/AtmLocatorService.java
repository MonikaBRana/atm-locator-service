package com.example.demo.Service;

import com.example.demo.Controller.AtmLocatorController;
import com.example.demo.Pojo.AtmLocationDetails;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Service
public class AtmLocatorService {
    private static final Logger LOGGER = LoggerFactory.getLogger(AtmLocatorService.class);

    @Autowired
    private AtmLocatorClient atmLocatorClient;

    public List<AtmLocationDetails> getAllAtmDetails(){
        LOGGER.info("Getting list of all the atms ");
        return atmLocatorClient.loadAllAtmDetails();
    }

    public List<AtmLocationDetails> getAtmDetailsByCity(String city){
        LOGGER.info("Getting the list of all the atms for the city {}",city);
        List<AtmLocationDetails> atmLocationDetailsList =  atmLocatorClient.loadAllAtmDetails();
        return atmLocationDetailsList.stream().filter(atmDtls -> Objects.equals(atmDtls.getAddress().getCity(),city)).collect(Collectors.toList());
    }


}
