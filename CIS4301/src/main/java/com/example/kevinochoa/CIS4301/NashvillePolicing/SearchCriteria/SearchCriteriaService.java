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
        if (searchCriteria.getSetting().getStopDate() != null) {
            stringBuilder.append("AND se.stopDate = to_date('");
            stringBuilder.append(searchCriteria.getSetting().getStopDate());
            stringBuilder.append("', 'MM/DD/YYYY')");
        }
        if (searchCriteria.getSetting().getStopTime() != null) {
            stringBuilder.append("AND se.stopTime = '");
            stringBuilder.append(searchCriteria.getSetting().getStopTime());
            stringBuilder.append("'");
        }

        if (searchCriteria.getSetting().getAddress() != null) {
            stringBuilder.append(" AND se.address = '");
            stringBuilder.append(searchCriteria.getSetting().getAddress());
            stringBuilder.append("'");
        }
        if (searchCriteria.getPoliceOfficer().getPrecinctId() != null) {
            stringBuilder.append(" AND po.precinctId = '");
            stringBuilder.append(searchCriteria.getPoliceOfficer().getPrecinctId());
            stringBuilder.append("'");
        }
        if (searchCriteria.getPoliceOfficer().getZoneCode() != null){
            stringBuilder.append(" AND po.zoneCode = '");
            stringBuilder.append(searchCriteria.getPoliceOfficer().getZoneCode());
            stringBuilder.append("'");
        }
        if (searchCriteria.getPoliceOfficer().getReportingArea() != null){
            stringBuilder.append(" AND po.reportingArea = '");
            stringBuilder.append(searchCriteria.getPoliceOfficer().getReportingArea());
            stringBuilder.append("'");
        }
        if (searchCriteria.getPoliceOfficer().getOfficerId() != null ){
            stringBuilder.append(" AND po.officerid = '");
            stringBuilder.append(searchCriteria.getPoliceOfficer().getOfficerId());
            stringBuilder.append("' ");
        }

        //subject information
        if (searchCriteria.getSubject().getAge() != null){
            stringBuilder.append(" AND su.age = '");
            stringBuilder.append(searchCriteria.getSubject().getAge());
            stringBuilder.append("'");
        }
        if (searchCriteria.getSubject().getRace() != null){
            stringBuilder.append(" AND su.race = '");
            stringBuilder.append(searchCriteria.getSubject().getRace());
            stringBuilder.append("'");
        }
        if (searchCriteria.getSubject().getSex() != null) {
            stringBuilder.append(" AND su.sex = '");
            stringBuilder.append(searchCriteria.getSubject().getSex());
            stringBuilder.append("'");
        }
        return searchCriteriaJdbcDAO.getAllInstances(stringBuilder.toString());
    }
}
