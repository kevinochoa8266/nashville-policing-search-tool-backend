package com.example.kevinochoa.CIS4301.NashvillePolicing.PoliceOfficer;

import com.example.kevinochoa.CIS4301.Dao.DAO;
import com.example.kevinochoa.CIS4301.NashvillePolicing.Subject.Subject;
import com.example.kevinochoa.CIS4301.NashvillePolicing.Subject.SubjectJdbcDAO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class PoliceOfficerJdbcDAO implements DAO<PoliceOfficer> {

    private static final Logger log = LoggerFactory.getLogger(PoliceOfficerJdbcDAO.class);
    private JdbcTemplate jdbcTemplate;

    RowMapper<PoliceOfficer> rowMapper = (rs, rowNum) -> {
        PoliceOfficer policeOfficer = new PoliceOfficer();
        policeOfficer.setOfficerId(rs.getString("officerid"));
        policeOfficer.setPrecinctId(rs.getInt("precinctid"));
        policeOfficer.setReportingArea(rs.getInt("reportingArea"));
        policeOfficer.setZoneCode(rs.getInt("zoneCode"));
        return policeOfficer;
    };

    public PoliceOfficerJdbcDAO(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<PoliceOfficer> list() {
        String sql = "SELECT * FROM PoliceOfficer";
        jdbcTemplate.setFetchSize(15000);
        return jdbcTemplate.query(sql, rowMapper);
    }

    @Override
    public void create(PoliceOfficer policeOfficer) {

    }

    @Override
    public Optional<PoliceOfficer> get(Long id) {
        return Optional.empty();
    }

    @Override
    public void update(PoliceOfficer policeOfficer, Long id) {

    }

    @Override
    public void delete(Long id) {

    }
}
