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
        setting.setStopDate(rs.getDate("stopDate"));
        setting.setStopTime(rs.getTime("stopTime"));
        setting.setAddress(rs.getString("address"));

        PoliceOfficer policeOfficer = new PoliceOfficer();
        policeOfficer.setOfficerId(rs.getString("officerid"));
        policeOfficer.setPrecinctId(rs.getInt("precinctid"));
        policeOfficer.setReportingArea(rs.getInt("reportingArea"));
        policeOfficer.setZoneCode(rs.getInt("zoneCode"));

        Subject subject = new Subject();
        subject.setAge(rs.getInt("age"));
        subject.setRace(rs.getString("race"));
        subject.setSex(rs.getString("sex"));

        Violation violation = new Violation();
        violation.setStopId(rs.getLong("stopid"));
        violation.setOfficerId(rs.getString("officerid"));
        violation.setViolationType(rs.getString("violationtype"));
        violation.setReason(rs.getString("reason"));

        SubjectSearch subjectSearch = new SubjectSearch();
        subjectSearch.setOfficerId(rs.getString("officerid"));
        subjectSearch.setSearchConducted(rs.getBoolean("searchconducted"));
        subjectSearch.setSearchBasis(rs.getString("searchbasis"));
        subjectSearch.setFriskPerformed(rs.getBoolean("friskperformed"));
        subjectSearch.setSearchVehicle(rs.getBoolean("searchvehicle"));
        subjectSearch.setSearchPerson(rs.getBoolean("searchperson"));
        subjectSearch.setStopId(rs.getLong("stopid"));
        subjectSearch.setWeaponsFound(rs.getBoolean("weapons"));
        subjectSearch.setDrugsFound(rs.getBoolean("drugsfound"));
        subjectSearch.setContrabandFound(rs.getBoolean("contrabandfound"));

        Outcome outcome = new Outcome();
        outcome.setStopId(rs.getLong("stopid"));
        outcome.setCitation(rs.getBoolean("citation"));
        outcome.setWarningIssued(rs.getBoolean("warningissued"));
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

    @Override
    public List<SearchCriteria> list(Long id) {
        return null;
    }

    public List<SearchCriteria> getAllInstances(String whereClause) {
        String sql = """
                SELECT se.stopId, se.stopDate, se.stopTime, se.address, po.officerId,
                po.precinctId, po.reportingArea, po.zoneCode, su.age, su.race, su.sex, v.reason,
                v.violationType, sus.searchConducted, sus.searchBasis, sus.friskPerformed,
                sus.searchVehicle, sus.searchPerson, sus.weaponsFound, sus.drugsFound,
                sus.contrabandFound, o.citation, o.warningIssued, o.arrest FROM setting se,
                policeOfficer po, subject su, subjectSearch sus, violation v, outcome o WHERE
                se.stopId = po.stopId AND po.stopId = su.stopId AND su.stopId = sus.stopId AND
                sus.stopId = v.stopId AND v.stopId = o.stopId AND po.officerId = 'a983204b21'
                AND po.reportingArea = '9035';
                """;
        jdbcTemplate.setFetchSize(15000);
        return jdbcTemplate.query(sql, rowMapper);
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
