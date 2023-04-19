package com.example.kevinochoa.CIS4301.NashvillePolicing.Outcome;

import com.example.kevinochoa.CIS4301.Dao.DAO;
import com.example.kevinochoa.CIS4301.NashvillePolicing.Subject.Subject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class OutcomeJdbcDAO implements DAO<Outcome> {

    private static final Logger log = LoggerFactory.getLogger(OutcomeJdbcDAO.class);
    private JdbcTemplate jdbcTemplate;

    RowMapper<Outcome> rowMapper = (rs, rowNum) -> {
        Outcome outcome = new Outcome();
        outcome.setStopId(rs.getLong("stopid"));
        outcome.setArrest(rs.getBoolean("arrest"));
        outcome.setCitation(rs.getBoolean("citation"));
        outcome.setWarningIssued(rs.getBoolean("warningIssued"));
        return outcome;
    };

    public OutcomeJdbcDAO(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<Outcome> list() {
        String sql = "SELECT * FROM Outcome";
        jdbcTemplate.setFetchSize(15000);
        return jdbcTemplate.query(sql, rowMapper);
    }

    @Override
    public void create(Outcome outcome) {

    }

    @Override
    public Optional<Outcome> get(Long id) {
        return Optional.empty();
    }

    @Override
    public void update(Outcome outcome, Long id) {

    }

    @Override
    public void delete(Long id) {

    }
}
