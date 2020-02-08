package com.opticus.opticusapp.controller;


import com.opticus.opticusapp.entity.user.Specialist;
import com.opticus.opticusapp.helpers.SpecialistNotFoundException;
import com.opticus.opticusapp.service.SpecialistService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:5000", maxAge = 3600)
@RestController
@RequestMapping("/api")
public class SpecialistController {

    @Autowired
    private SpecialistService specialistService;

    
    @GetMapping("/specialists")
    public List<Specialist> getSpecialists() {
        return specialistService.getSpecialists();
    }

    
    @GetMapping("/specialists/{specialistId}")
    public Specialist getSpecialist(@PathVariable int specialistId) {

        Specialist specialist = specialistService.getSpecialist(specialistId);
        checkIfSpecialistExists(specialist);

        return specialist;

    }

    
    @PutMapping("/specialists")
    public Specialist saveSpecialist(@RequestBody Specialist specialist) {
        specialistService.saveSpecialist(specialist);

        return specialist;
    }


    
    @PostMapping("/specialists")
    public Specialist addSpecialist(@RequestBody Specialist specialist) {
        specialist.setId(0);
        specialistService.saveSpecialist(specialist);

        return specialist;
    }

    
    @DeleteMapping("/specialists/{specialistId}")
    public String deleteNote(@PathVariable int specialistId) {
        Specialist specialist = specialistService.getSpecialist(specialistId);

        checkIfSpecialistExists(specialist);

        specialistService.deleteSpecialist(specialistId);

        return "Deleted specialist with Id: " + specialistId;
    }


    private void checkIfSpecialistExists(Specialist specialist) {
        if (specialist == null)
            throw new SpecialistNotFoundException("specialist not found!");
    }

}
