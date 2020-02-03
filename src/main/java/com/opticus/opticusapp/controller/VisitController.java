package com.opticus.opticusapp.controller;

import com.opticus.opticusapp.entity.Visit;
import com.opticus.opticusapp.helpers.VisitNotFoundException;
import com.opticus.opticusapp.service.VisitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:5000", maxAge = 3600)
@RestController
@RequestMapping("/api")
public class VisitController {

    @Autowired
    private VisitService visitService;

    
    @GetMapping("/visits")
    public List<Visit> getVisits() {
        return visitService.getVisits();
    }

    
    @GetMapping("/visits/{visitId}")
    public Visit getVisit(@PathVariable int visitId) {

        Visit visit = visitService.getVisit(visitId);
        checkIfVisitExists(visit);

        return visit;

    }

    
    @PutMapping("/visits")
    public Visit saveVisit(@RequestBody Visit visit) {
        visitService.saveVisit(visit);

        return visit;
    }


    
    @PostMapping("/visits")
    public Visit addVisit(@RequestBody Visit visit) {
        visit.setId(0);
        visitService.saveVisit(visit);

        return visit;
    }

    
    @DeleteMapping("/visits/{visitId}")
    public String deleteNote(@PathVariable int visitId) {
        Visit visit = visitService.getVisit(visitId);

        checkIfVisitExists(visit);

        visitService.deleteVisit(visitId);

        return "Deleted Visit with Id: " + visitId;
    }


    private void checkIfVisitExists(Visit visit) {
        if (visit == null)
            throw new VisitNotFoundException("Visit not found!");
    }

}
