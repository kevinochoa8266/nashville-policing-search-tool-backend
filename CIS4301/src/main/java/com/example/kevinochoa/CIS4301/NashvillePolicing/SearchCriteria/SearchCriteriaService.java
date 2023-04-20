package com.example.kevinochoa.CIS4301.NashvillePolicing.SearchCriteria;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SearchCriteriaService {

    private final SearchCriteriaJdbcDAO searchCriteriaJdbcDAO;

    public SearchCriteriaService(SearchCriteriaJdbcDAO searchCriteriaJdbcDAO) {
        this.searchCriteriaJdbcDAO = searchCriteriaJdbcDAO;
    }

    public List<SearchCriteria> getCases(SearchCriteria searchCriteria) {
        // construct the WHERE clause for the SQL statement.
        StringBuilder stringBuilder = new StringBuilder();
        return searchCriteriaJdbcDAO.getAllInstances(stringBuilder.toString());
    }
}
