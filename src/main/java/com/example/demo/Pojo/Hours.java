package com.example.demo.Pojo;

public class Hours {
    private String hourFrom;
    private String hourTo;

    public Hours() {
    }

    public Hours(String hourFrom, String hourTo) {
        this.hourFrom = hourFrom;
        this.hourTo = hourTo;
    }

    public String getHourFrom() {
        return hourFrom;
    }

    public void setHourFrom(String hourFrom) {
        this.hourFrom = hourFrom;
    }

    public String getHourTo() {
        return hourTo;
    }

    public void setHourTo(String hourTo) {
        this.hourTo = hourTo;
    }
}
