package com.example.kevinochoa.CIS4301.NashvillePolicing.SearchCriteria;

import com.example.kevinochoa.CIS4301.NashvillePolicing.Subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/v1/Subjects")
public class SearchCriteriaController {

    @Autowired
    public SearchCriteriaService searchCriteriaService;

    /*@GetMapping("/totalTuples")
    public ResponseEntity<?> getTotalTuples() {
        int totalCount = searchCriteriaService.getTotalSubjects();
        if (totalCount != 0) {
            return ResponseEntity.status(HttpStatus.OK).body(totalCount);
        }
        System.out.println("Couldn't retrieve the number of tuples in the database");
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Couldn't retrieve the number of tuples in the database");
    }*/

    @PostMapping("/find")
    public ResponseEntity<?> findCase(@RequestBody SearchCriteria searchCriteria) {
        List<SearchCriteria> searchCriteriaList = searchCriteriaService.getCases(searchCriteria);
        if (searchCriteriaList.size() == 0) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Could not get the subject");
        }
        return ResponseEntity.status(HttpStatus.OK).body(searchCriteriaList);
    }
}
