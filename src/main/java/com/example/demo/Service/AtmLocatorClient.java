package com.example.demo.Service;

import com.example.demo.Pojo.AtmLocationDetails;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@Component
public class AtmLocatorClient {

    private static final Logger LOGGER = LoggerFactory.getLogger(AtmLocatorClient.class);

    @Autowired
    RestTemplate restTemplate;

    @Value("${AtmLocatorApi.url}")
    private String atmDetailsProviderUrl;

    public List<AtmLocationDetails> loadAllAtmDetails(){
        String response = restTemplate.getForObject(
                        atmDetailsProviderUrl,
                        String.class);
        String tokenizer[] = response.split("\n");
        ObjectMapper mapper = new ObjectMapper();
        List<AtmLocationDetails> atmLocationDetails = new ArrayList<>();
        try {
            atmLocationDetails = mapper.readValue(tokenizer[1], new TypeReference<List<AtmLocationDetails>>(){});
        } catch (JsonProcessingException ex) {
            LOGGER.error("Exception encountered while parsing string into Json",ex);
        }
        return atmLocationDetails;
    }
}
