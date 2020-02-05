package com.opticus.opticusapp.controller;

import com.opticus.opticusapp.entity.Patient;
import com.opticus.opticusapp.helpers.PatientNotFoundException;
import com.opticus.opticusapp.service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:5000", maxAge = 3600)
@RestController
@RequestMapping("/api")
public class PatientController {

    @Autowired
    private PatientService patientService;

    
    @GetMapping("/patients")
    public List<Patient> getPatients() {
        return patientService.getPatients();
    }

    
    @GetMapping("/patients/{patientId}")
    public Patient getPatient(@PathVariable int patientId) {

        Patient patient = patientService.getPatient(patientId);
        checkIfPatientExists(patient);

        return patient;

    }

    
    @PutMapping("/patients")
    public Patient savePatient(@RequestBody Patient patient) {
        patientService.savePatient(patient);

        return patient;
    }


    
    @PostMapping("/patients")
    public Patient addPatient(@RequestBody Patient patient) {
        patient.setId(0);
        patientService.savePatient(patient);

        return patient;
    }

    
    @DeleteMapping("/patients/{patientId}")
    public String deleteNote(@PathVariable int patientId) {
        Patient patient = patientService.getPatient(patientId);

        checkIfPatientExists(patient);

        patientService.deletePatient(patientId);

        return "Deleted Patient with Id: " + patientId;
    }


    private void checkIfPatientExists(Patient patient) {
        if (patient == null)
            throw new PatientNotFoundException("Patient not found!");
    }

}
