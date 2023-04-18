package com.example.kevinochoa.CIS4301.NashvillePolicing.Subject;

import com.example.kevinochoa.CIS4301.NashvillePolicing.Subject.Subject;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SubjectService {

    public List<Subject> getSubjects() {
        return List.of(
                new Subject()
        );
    }

}
