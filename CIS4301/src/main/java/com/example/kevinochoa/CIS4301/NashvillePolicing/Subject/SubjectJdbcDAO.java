package com.example.kevinochoa.CIS4301.NashvillePolicing.Subject;

import com.example.kevinochoa.CIS4301.Dao.DAO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class SubjectJdbcDAO implements DAO<Subject> {

    private static final Logger log = LoggerFactory.getLogger(SubjectJdbcDAO.class);
    private JdbcTemplate jdbcTemplate;

    RowMapper<Subject> rowMapper = (rs, rowNum) -> {
        Subject subject = new Subject();
        subject.setStopId(rs.getLong("stopid"));
        subject.setRace(rs.getString("race"));
        subject.setAge(rs.getInt("age"));
        subject.setSex(rs.getString("sex"));
        return subject;
    };

    public SubjectJdbcDAO(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<Subject> list(Long id) {
        String sql = "SELECT * FROM subject WHERE stopid = ?";
        jdbcTemplate.setFetchSize(15000);
        return jdbcTemplate.query(sql, rowMapper, id);
    }

    public int getTupleCount() {
        String sql = "SELECT COUNT (*) FROM subject";
        int tuplesCount;
        try {
            tuplesCount =  jdbcTemplate.queryForObject(sql, Integer.class);
            return tuplesCount;
        }
        catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }

    @Override
    public void create(Subject subject) {

    }

    @Override
    public Optional<Subject> get(Long id) {
        return Optional.empty();
    }

    @Override
    public void update(Subject subject, Long id) {

    }

    @Override
    public void delete(Long id) {

    }
}
