package com.example.kevinochoa.CIS4301.NashvillePolicing.SearchCriteria;

import com.example.kevinochoa.CIS4301.Dao.DAO;
import com.example.kevinochoa.CIS4301.NashvillePolicing.Outcome.Outcome;
import com.example.kevinochoa.CIS4301.NashvillePolicing.PoliceOfficer.PoliceOfficer;
import com.example.kevinochoa.CIS4301.NashvillePolicing.Setting.Setting;
import com.example.kevinochoa.CIS4301.NashvillePolicing.Subject.Subject;
import com.example.kevinochoa.CIS4301.NashvillePolicing.SubjectSearch.SubjectSearch;
import com.example.kevinochoa.CIS4301.NashvillePolicing.Violation.Violation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class SearchCriteriaJdbcDAO implements DAO<SearchCriteria> {

    private static final Logger log = LoggerFactory.getLogger(SearchCriteriaJdbcDAO.class);
    private JdbcTemplate jdbcTemplate;

    RowMapper<SearchCriteria> rowMapper = (rs, rowNum) -> {
        Setting setting = new Setting();
        setting.setStopId(rs.getLong("stopId"));
        setting.setStopDate(rs.getString("stopDate"));
        setting.setStopTime(rs.getString("stopTime"));
        setting.setAddress(rs.getString("address"));

        PoliceOfficer policeOfficer = new PoliceOfficer();
        policeOfficer.setStopId(rs.getLong("stopId"));
        policeOfficer.setOfficerId(rs.getString("officerId"));
        policeOfficer.setPrecinctId(rs.getInt("precinctId"));
        policeOfficer.setReportingArea(rs.getInt("reportingArea"));
        policeOfficer.setZoneCode(rs.getInt("zoneCode"));

        Subject subject = new Subject();
        subject.setStopId(rs.getLong("stopId"));
        subject.setAge(rs.getInt("age"));
        subject.setRace(rs.getString("race"));
        subject.setSex(rs.getString("sex"));

        Violation violation = new Violation();
        violation.setStopId(rs.getLong("stopId"));
        //violation.setOfficerId(rs.getString("officerId"));
        violation.setViolationType(rs.getString("violationType"));
        violation.setReason(rs.getString("reason"));

        SubjectSearch subjectSearch = new SubjectSearch();
        subjectSearch.setOfficerId(rs.getString("officerId"));
        subjectSearch.setSearchConducted(rs.getBoolean("searchConducted"));
        subjectSearch.setSearchBasis(rs.getString("searchBasis"));
        subjectSearch.setFriskPerformed(rs.getBoolean("friskPerformed"));
        subjectSearch.setSearchVehicle(rs.getBoolean("searchVehicle"));
        subjectSearch.setSearchPerson(rs.getBoolean("searchPerson"));
        subjectSearch.setStopId(rs.getLong("stopId"));
        subjectSearch.setWeaponsFound(rs.getBoolean("weaponsFound"));
        subjectSearch.setDrugsFound(rs.getBoolean("drugsFound"));
        subjectSearch.setContrabandFound(rs.getBoolean("contrabandFound"));

        Outcome outcome = new Outcome();
        outcome.setStopId(rs.getLong("stopId"));
        outcome.setCitation(rs.getBoolean("citation"));
        outcome.setWarningIssued(rs.getBoolean("warningIssued"));
        outcome.setArrest(rs.getBoolean("arrest"));

        SearchCriteria searchCriteria = new SearchCriteria();
        searchCriteria.setSetting(setting);
        searchCriteria.setPoliceOfficer(policeOfficer);
        searchCriteria.setSubject(subject);
        searchCriteria.setViolation(violation);
        searchCriteria.setSubjectSearch(subjectSearch);
        searchCriteria.setOutcome(outcome);
        return searchCriteria;
    };


    public SearchCriteriaJdbcDAO(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<SearchCriteria> getAllInstances(String whereClause) {
        String selectFrom = """
                SELECT se.stopId, se.stopDate, se.stopTime, se.address, po.officerId,
                po.precinctId, po.reportingArea, po.zoneCode, su.age, su.race, su.sex, v.reason,
                v.violationType, sus.searchConducted, sus.searchBasis, sus.friskPerformed,
                sus.searchVehicle, sus.searchPerson, sus.weaponsFound, sus.drugsFound,
                sus.contrabandFound, o.citation, o.warningIssued, o.arrest FROM setting se,
                policeOfficer po, subject su, subjectSearch sus, violation v, outcome o WHERE
                se.stopId = po.stopId AND po.stopId = su.stopId AND su.stopId = sus.stopId AND
                sus.stopId = v.stopId AND v.stopId = o.stopId
                """;
        String searchQuery = selectFrom + whereClause + " FETCH FIRST 10 ROWS ONLY";
        jdbcTemplate.setFetchSize(15000);
        return jdbcTemplate.query(searchQuery, rowMapper);
    }

    @Override
    public List<SearchCriteria> list(Long id) {
        return null;
    }

    @Override
    public void create(SearchCriteria searchCriteria) {
    }

    @Override
    public Optional<SearchCriteria> get(Long id) {
        return Optional.empty();
    }

    @Override
    public void update(SearchCriteria searchCriteria, Long id) {
    }

    @Override
    public void delete(Long id) {
    }
}
