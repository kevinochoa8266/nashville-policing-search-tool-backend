package com.example.kevinochoa.CIS4301.NashvillePolicing.SearchCriteria;

import com.example.kevinochoa.CIS4301.NashvillePolicing.Outcome.Outcome;
import com.example.kevinochoa.CIS4301.NashvillePolicing.PoliceOfficer.PoliceOfficer;
import com.example.kevinochoa.CIS4301.NashvillePolicing.Setting.Setting;
import com.example.kevinochoa.CIS4301.NashvillePolicing.Subject.Subject;

public class SearchCriteria {

    private Subject subject;
    private Outcome outcome;
    private Setting setting;
    private PoliceOfficer policeOfficer;

    public SearchCriteria() {
    }

    public SearchCriteria(Subject subject, Outcome outcome, Setting setting, PoliceOfficer policeOfficer) {
        this.subject = subject;
        this.outcome = outcome;
        this.setting = setting;
        this.policeOfficer = policeOfficer;
    }

    public Subject getSubject() {
        return subject;
    }

    public void setSubject(Subject subject) {
        this.subject = subject;
    }

    public Outcome getOutcome() {
        return outcome;
    }

    public void setOutcome(Outcome outcome) {
        this.outcome = outcome;
    }

    public Setting getSetting() {
        return setting;
    }

    public void setSetting(Setting setting) {
        this.setting = setting;
    }

    public PoliceOfficer getPoliceOfficer() {
        return policeOfficer;
    }

    public void setPoliceOfficer(PoliceOfficer policeOfficer) {
        this.policeOfficer = policeOfficer;
    }

    /*
    * 1. Date
    * 2. Time
    * 3. Location
    * 4. OfficerID
    * 5. PrecinctID
    * 6. Reporting Area
    * 7. Zone
    * 8. Age
    * 9. Race
    * 10. Sex*/
    @Override
    public String toString() {
        return "{" +
                setting +
                policeOfficer +
                subject +
                '}';
    }
}
