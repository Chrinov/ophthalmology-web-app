package com.opticus.opticusapp.controller;


import com.opticus.opticusapp.entity.Doctor;
import com.opticus.opticusapp.helpers.DoctorNotFoundException;
import com.opticus.opticusapp.service.DoctorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class DoctorController {

    @Autowired
    private DoctorService doctorService;

    @CrossOrigin
    @GetMapping("/doctors")
    public List<Doctor> getDoctors() {
        return doctorService.getDoctors();
    }

    @CrossOrigin
    @GetMapping("/doctors/{doctorId}")
    public Doctor getDoctor(@PathVariable int doctorId) {

        Doctor doctor = doctorService.getDoctor(doctorId);
        checkIfDoctorExists(doctor);

        return doctor;

    }

    @CrossOrigin
    @PutMapping("/doctors")
    public Doctor saveDoctor(@RequestBody Doctor doctor) {
        doctorService.saveDoctor(doctor);

        return doctor;
    }


    @CrossOrigin
    @PostMapping("/doctors")
    public Doctor addDoctor(@RequestBody Doctor doctor) {
        doctor.setId(0);
        doctorService.saveDoctor(doctor);

        return doctor;
    }

    @CrossOrigin
    @DeleteMapping("/doctors/{doctorId}")
    public String deleteNote(@PathVariable int doctorId) {
        Doctor doctor = doctorService.getDoctor(doctorId);

        checkIfDoctorExists(doctor);

        doctorService.deleteDoctor(doctorId);

        return "Deleted Doctor with Id: " + doctorId;
    }


    private void checkIfDoctorExists(Doctor doctor) {
        if (doctor == null)
            throw new DoctorNotFoundException("Doctor not found!");
    }

}
