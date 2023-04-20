package com.example.kevinochoa.CIS4301.NashvillePolicing.SearchCriteria;

import com.example.kevinochoa.CIS4301.NashvillePolicing.Outcome.Outcome;
import com.example.kevinochoa.CIS4301.NashvillePolicing.PoliceOfficer.PoliceOfficer;
import com.example.kevinochoa.CIS4301.NashvillePolicing.Setting.Setting;
import com.example.kevinochoa.CIS4301.NashvillePolicing.Subject.Subject;
import com.example.kevinochoa.CIS4301.NashvillePolicing.SubjectSearch.SubjectSearch;
import com.example.kevinochoa.CIS4301.NashvillePolicing.Violation.Violation;

public class SearchCriteria {

    private Subject subject;
    private Outcome outcome;
    private Setting setting;
    private PoliceOfficer policeOfficer;
    private Violation violation;
    private SubjectSearch subjectSearch;

    public SearchCriteria() {
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

    public Violation getViolation() {
        return violation;
    }

    public void setViolation(Violation violation) {
        this.violation = violation;
    }

    public SubjectSearch getSubjectSearch() {
        return subjectSearch;
    }

    public void setSubjectSearch(SubjectSearch subjectSearch) {
        this.subjectSearch = subjectSearch;
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
                violation +
                subjectSearch +
                outcome +
                '}';
    }
}
