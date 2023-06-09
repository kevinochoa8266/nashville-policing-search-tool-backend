package com.example.kevinochoa.CIS4301.NashvillePolicing.SearchCriteria;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/v1/SearchCriteria")
public class SearchCriteriaController {

    @Autowired
    public SearchCriteriaService searchCriteriaService;


    @CrossOrigin(origins = "http://localhost:3000")
    @PostMapping("/find")
    public ResponseEntity<?> findCase(@RequestBody SearchCriteria searchCriteria) {
        List<SearchCriteria> searchCriteriaList = searchCriteriaService.getCases(searchCriteria);
        if (searchCriteriaList.size() == 0) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Could not get the subject");
        }
        return ResponseEntity.status(HttpStatus.OK).body(searchCriteriaList);
    }
}
