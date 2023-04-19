package com.example.kevinochoa.CIS4301.NashvillePolicing.SearchCriteria;

import com.example.kevinochoa.CIS4301.NashvillePolicing.Outcome.Outcome;
import com.example.kevinochoa.CIS4301.NashvillePolicing.Subject.Subject;

public class SearchCriteria {

    private Subject subject;
    private Outcome outcome;

    public SearchCriteria() {
    }

    public SearchCriteria(Subject subject, Outcome outcome) {
        this.subject = subject;
        this.outcome = outcome;
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

    @Override
    public String toString() {
        return "SearchCriteria{" +
                subject +
                outcome +
                '}';
    }
}
