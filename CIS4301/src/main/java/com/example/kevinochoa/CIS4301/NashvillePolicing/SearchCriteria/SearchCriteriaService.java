package com.example.kevinochoa.CIS4301.NashvillePolicing.SearchCriteria;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
public class SearchCriteriaService {

    private final SearchCriteriaJdbcDAO searchCriteriaJdbcDAO;

    public SearchCriteriaService(SearchCriteriaJdbcDAO searchCriteriaJdbcDAO) {
        this.searchCriteriaJdbcDAO = searchCriteriaJdbcDAO;
    }

    public List<SearchCriteria> getCases(SearchCriteria searchCriteria) {
        // construct the WHERE clause for the SQL statement.
        StringBuilder stringBuilder = new StringBuilder();
//        if (searchCriteria.getSetting().getStopDate() != null
//            || !Objects.equals(searchCriteria.getSetting().getStopDate().toString(), "")) {
//            stringBuilder.append("stopdate = '");
//            stringBuilder.append(searchCriteria.getSetting().getStopDate().toString());
//            stringBuilder.append("'");
//        }
        if (searchCriteria.getPoliceOfficer().getOfficerId() != null
                || !Objects.equals(searchCriteria.getPoliceOfficer().getOfficerId(), "")) {
            stringBuilder.append(" AND po.officerid = '");
            stringBuilder.append(searchCriteria.getPoliceOfficer().getOfficerId());
            stringBuilder.append("' ");
        }
        if (searchCriteria.getPoliceOfficer().getReportingArea() != null
                || !Objects.equals(searchCriteria.getPoliceOfficer().getReportingArea().toString(), "")) {
            stringBuilder.append(" AND po.reportingArea = '");
            stringBuilder.append(searchCriteria.getPoliceOfficer().getReportingArea());
            stringBuilder.append("'");
        }
        return searchCriteriaJdbcDAO.getAllInstances(stringBuilder.toString());
    }
}
