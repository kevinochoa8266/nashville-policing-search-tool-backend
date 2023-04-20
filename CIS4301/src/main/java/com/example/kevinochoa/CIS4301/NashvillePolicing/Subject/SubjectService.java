package com.example.kevinochoa.CIS4301.NashvillePolicing.Subject;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SubjectService {

    private final SubjectJdbcDAO subjectJdbcDAO;

    public SubjectService(SubjectJdbcDAO subjectJdbcDAO) {
        this.subjectJdbcDAO = subjectJdbcDAO;
    }

    public int getTotalSubjects() {
        return subjectJdbcDAO.getTupleCount();
    }

    public List<Subject> getSubjectsByID(Long id) {
        return subjectJdbcDAO.list(id);
    }
}
