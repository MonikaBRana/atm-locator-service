package com.example.demo.Pojo;

import java.util.List;

public class AtmLocationDetails {

    private Address address;
    private int distance;
    private List<OpeningHours> openingHours;
    private String functionality;
    private String type;

    public AtmLocationDetails(){

    }
    public AtmLocationDetails(Address address, int distance, List<OpeningHours> openingHours, String functionality, String type) {
        this.address = address;
        this.distance = distance;
        this.openingHours = openingHours;
        this.functionality = functionality;
        this.type = type;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public int getDistance() {
        return distance;
    }

    public void setDistance(int distance) {
        this.distance = distance;
    }

    public List<OpeningHours> getOpeningHours() {
        return openingHours;
    }

    public void setOpeningHours(List<OpeningHours> openingHours) {
        this.openingHours = openingHours;
    }

    public String getFunctionality() {
        return functionality;
    }

    public void setFunctionality(String functionality) {
        this.functionality = functionality;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
