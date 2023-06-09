package com.example.kevinochoa.CIS4301.NashvillePolicing.PoliceOfficer;

public class PoliceOfficer {

    private Long stopId;
    private String officerId;
    private Integer precinctId;
    private Integer reportingArea;
    private Integer zoneCode;

    public PoliceOfficer() {
    }

    public PoliceOfficer(Long stopId,String officerId, Integer precinctId, Integer reportingArea, Integer zoneCode) {
        this.officerId = officerId;
        this.precinctId = precinctId;
        this.reportingArea = reportingArea;
        this.zoneCode = zoneCode;
        this.stopId = stopId;
    }

    public String getOfficerId() {
        return officerId;
    }

    public void setOfficerId(String officerId) {
        this.officerId = officerId;
    }

    public Integer getPrecinctId() {
        return precinctId;
    }

    public void setPrecinctId(Integer precinctId) {
        this.precinctId = precinctId;
    }

    public Integer getReportingArea() {
        return reportingArea;
    }

    public void setReportingArea(Integer reportingArea) {
        this.reportingArea = reportingArea;
    }

    public Integer getZoneCode() {
        return zoneCode;
    }

    public void setZoneCode(Integer zoneCode) {
        this.zoneCode = zoneCode;
    }

    public Long getStopId() {
        return stopId;
    }

    public void setStopId(Long stopId) {
        this.stopId = stopId;
    }

    @Override
    public String toString() {
        return  "officerId='" + officerId + '\'' +
                ", precinctId=" + precinctId +
                ", reportingArea=" + reportingArea +
                ", zoneCode=" + zoneCode +
                ',';
    }
}
