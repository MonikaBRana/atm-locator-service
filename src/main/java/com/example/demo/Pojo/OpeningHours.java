package com.example.demo.Pojo;

import java.util.List;

public class OpeningHours {
    private int dayOfWeek;
    private List<Hours> hours;

    public OpeningHours() {
    }

    public OpeningHours(int dayOfWeek, List<Hours> hours) {
        this.dayOfWeek = dayOfWeek;
        this.hours = hours;
    }

    public int getDayOfWeek() {
        return dayOfWeek;
    }

    public void setDayOfWeek(int dayOfWeek) {
        this.dayOfWeek = dayOfWeek;
    }

    public List<Hours> getHours() {
        return hours;
    }

    public void setHours(List<Hours> hours) {
        this.hours = hours;
    }
}
