package com.example.kevinochoa.CIS4301.NashvillePolicing.Violation;


public class Violation {

    private Long stopId;
    private String officerId;
    private String violationType;
    private String reason;

    public Violation() {
    }

    public Violation(Long stopId, String officerId, String violationType, String reason) {
        this.stopId = stopId;
        this.officerId = officerId;
        this.violationType = violationType;
        this.reason = reason;
    }

    public Long getStopId() {
        return stopId;
    }

    public void setStopId(Long stopId) {
        this.stopId = stopId;
    }

    public String getOfficerId() {
        return officerId;
    }

    public void setOfficerId(String officerId) {
        this.officerId = officerId;
    }

    public String getViolationType() {
        return violationType;
    }

    public void setViolationType(String violationType) {
        this.violationType = violationType;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    @Override
    public String toString() {
        return  ", reason='" + reason + '\'' +
                ", violationType='" + violationType + '\'' +
                ',';
    }
}
