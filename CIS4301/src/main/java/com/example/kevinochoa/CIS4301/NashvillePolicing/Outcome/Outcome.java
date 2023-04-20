package com.example.kevinochoa.CIS4301.NashvillePolicing.Outcome;


public class Outcome {

    private Long stopId;
    private Boolean arrest;
    private Boolean citation;
    private Boolean warningIssued;

    public Outcome() {
    }

    public Outcome(Long stopId, Boolean arrest, Boolean citation, Boolean warningIssued) {
        this.stopId = stopId;
        this.arrest = arrest;
        this.citation = citation;
        this.warningIssued = warningIssued;
    }

    public Long getStopId() {
        return stopId;
    }

    public void setStopId(Long stopId) {
        this.stopId = stopId;
    }

    public Boolean getArrest() {
        return arrest;
    }

    public void setArrest(Boolean arrest) {
        this.arrest = arrest;
    }

    public Boolean getCitation() {
        return citation;
    }

    public void setCitation(Boolean citation) {
        this.citation = citation;
    }

    public Boolean getWarningIssued() {
        return warningIssued;
    }

    public void setWarningIssued(Boolean warningIssued) {
        this.warningIssued = warningIssued;
    }

    @Override
    public String toString() {
        return  "arrest=" + arrest +
                ", citation=" + citation +
                ", warningIssued=" + warningIssued;
    }
}
