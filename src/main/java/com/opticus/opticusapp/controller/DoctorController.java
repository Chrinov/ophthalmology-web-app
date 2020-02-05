package com.opticus.opticusapp.controller;


import com.opticus.opticusapp.entity.Specialist;
import com.opticus.opticusapp.helpers.DoctorNotFoundException;
import com.opticus.opticusapp.service.DoctorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:5000", maxAge = 3600)
@RestController
@RequestMapping("/api")
public class DoctorController {

    @Autowired
    private DoctorService doctorService;

    
    @GetMapping("/doctors")
    public List<Specialist> getDoctors() {
        return doctorService.getDoctors();
    }

    
    @GetMapping("/doctors/{doctorId}")
    public Specialist getDoctor(@PathVariable int doctorId) {

        Specialist specialist = doctorService.getDoctor(doctorId);
        checkIfDoctorExists(specialist);

        return specialist;

    }

    
    @PutMapping("/doctors")
    public Specialist saveDoctor(@RequestBody Specialist specialist) {
        doctorService.saveDoctor(specialist);

        return specialist;
    }


    
    @PostMapping("/doctors")
    public Specialist addDoctor(@RequestBody Specialist specialist) {
        specialist.setId(0);
        doctorService.saveDoctor(specialist);

        return specialist;
    }

    
    @DeleteMapping("/doctors/{doctorId}")
    public String deleteNote(@PathVariable int doctorId) {
        Specialist specialist = doctorService.getDoctor(doctorId);

        checkIfDoctorExists(specialist);

        doctorService.deleteDoctor(doctorId);

        return "Deleted Specialist with Id: " + doctorId;
    }


    private void checkIfDoctorExists(Specialist specialist) {
        if (specialist == null)
            throw new DoctorNotFoundException("Specialist not found!");
    }

}
