package com.example.kevinochoa.CIS4301.NashvillePolicing.Setting;

import jakarta.persistence.*;

import java.sql.Time;
import java.util.Date;

@Entity
@Table
public class Setting {

    @Id
    @Column(name = "stopid")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long stopId;
    private Integer precinctId;
    private Date stopDate;
    private Time stopTime;
    private String address;
    private Integer longitude;
    private Integer latitude;

    public Setting() {
    }

    public Setting(Long stopId, Integer precinctId, Date stopDate, Time stopTime, String address, Integer longitude, Integer latitude) {
        this.stopId = stopId;
        this.precinctId = precinctId;
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

    public Date getStopDate() {
        return stopDate;
    }

    public void setStopDate(Date stopDate) {
        this.stopDate = stopDate;
    }

    public Time getStopTime() {
        return stopTime;
    }

    public void setStopTime(Time stopTime) {
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

    public Integer getPrecinctId() {
        return precinctId;
    }

    public void setPrecinctId(Integer precinctId) {
        this.precinctId = precinctId;
    }

    @Override
    public String toString() {
        return "Setting{" +
                "stopId=" + stopId +
                ", precinctId=" + precinctId +
                ", stopDate=" + stopDate +
                ", stopTime=" + stopTime +
                ", address='" + address + '\'' +
                ", longitude=" + longitude +
                ", latitude=" + latitude +
                '}';
    }
}
