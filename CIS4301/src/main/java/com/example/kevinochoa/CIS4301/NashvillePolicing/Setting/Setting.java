package com.example.kevinochoa.CIS4301.NashvillePolicing.Setting;

import java.sql.Time;
import java.util.Date;

public class Setting {

    private Long stopId;
    private String stopDate;
    private String stopTime;
    private String address;
    private Integer longitude;
    private Integer latitude;

    public Setting() {
    }

    public Setting(Long stopId, String stopDate, String stopTime, String address, Integer longitude, Integer latitude) {
        this.stopId = stopId;
        this.stopDate = stopDate;
        this.stopTime = stopTime;
        this.address = address;
        this.longitude = longitude;
        this.latitude = latitude;
    }

    public Long getStopId() {
        return stopId;
    }

    public void setStopId(Long stopId) {
        this.stopId = stopId;
    }

    public String getStopDate() {
        return stopDate;
    }

    public void setStopDate(String stopDate) {
        this.stopDate = stopDate;
    }

    public String getStopTime() {
        return stopTime;
    }

    public void setStopTime(String stopTime) {
        this.stopTime = stopTime;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Integer getLongitude() {
        return longitude;
    }

    public void setLongitude(Integer longitude) {
        this.longitude = longitude;
    }

    public Integer getLatitude() {
        return latitude;
    }

    public void setLatitude(Integer latitude) {
        this.latitude = latitude;
    }

    @Override
    public String toString() {
        return  "stopId=" + stopId +
                ", stopDate=" + stopDate +
                ", stopTime=" + stopTime +
                ", address='" + address + '\'' +
                ',';
    }
}
