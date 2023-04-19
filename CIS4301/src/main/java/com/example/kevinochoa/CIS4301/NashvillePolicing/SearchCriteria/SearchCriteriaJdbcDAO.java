package com.example.kevinochoa.CIS4301.NashvillePolicing.SearchCriteria;

import com.example.kevinochoa.CIS4301.Dao.DAO;
import com.example.kevinochoa.CIS4301.NashvillePolicing.Outcome.Outcome;
import com.example.kevinochoa.CIS4301.NashvillePolicing.Outcome.OutcomeJdbcDAO;
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
        Subject subject = new Subject();
        subject.setStopId(rs.getLong("stopid"));
        subject.setRace(rs.getString("race"));
        subject.setAge(rs.getInt("age"));
        subject.setSex(rs.getString("sex"));
        Outcome outcome = new Outcome();
        outcome.setStopId(rs.getLong("stopid"));
        outcome.setArrest(rs.getBoolean("arrest"));
        outcome.setCitation(rs.getBoolean("citation"));
        outcome.setWarningIssued(rs.getBoolean("warningIssued"));
        SearchCriteria searchCriteria = new SearchCriteria();
        searchCriteria.setSubject(subject);
        searchCriteria.setOutcome(outcome);
        return searchCriteria;
    };

    public SearchCriteriaJdbcDAO(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<SearchCriteria> list() {
        String sql = "SELECT s.*, o.* FROM subject s JOIN Outcome o ON s.stopid = o.stopid";
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
