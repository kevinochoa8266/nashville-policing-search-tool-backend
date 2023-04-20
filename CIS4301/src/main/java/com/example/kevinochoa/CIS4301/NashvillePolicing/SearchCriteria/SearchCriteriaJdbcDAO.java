package com.example.kevinochoa.CIS4301.NashvillePolicing.SearchCriteria;

import com.example.kevinochoa.CIS4301.Dao.DAO;
import com.example.kevinochoa.CIS4301.NashvillePolicing.PoliceOfficer.PoliceOfficer;
import com.example.kevinochoa.CIS4301.NashvillePolicing.Setting.Setting;
import com.example.kevinochoa.CIS4301.NashvillePolicing.Subject.Subject;
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
        SearchCriteria searchCriteria = new SearchCriteria();
        searchCriteria.setSetting(setting);
        searchCriteria.setPoliceOfficer(policeOfficer);
        searchCriteria.setSubject(subject);
        return searchCriteria;
    };

    public SearchCriteriaJdbcDAO(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<SearchCriteria> list(Long id) {
        String sql = "SELECT se.*, p.*, s.* FROM setting se, policeOfficer p, subject s" +
                     "WHERE s.stopid = se.stopid AND p.stopid = se.stopid " +
                     "FETCH first 5 rows only";
        jdbcTemplate.setFetchSize(15000);
        return jdbcTemplate.query(sql, rowMapper);
    }

    public List<SearchCriteria> getAllInstances(String whereClause) {
        String sql = "SELECT se.*, p.*, s.* FROM setting se, policeOfficer p, subject s" +
                "WHERE s.stopid = se.stopid AND p.stopid = se.stopid " +
                "FETCH first 5 rows only";
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
