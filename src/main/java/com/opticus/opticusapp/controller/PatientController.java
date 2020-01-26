package com.opticus.opticusapp.controller;

import com.opticus.opticusapp.entity.Patient;
import com.opticus.opticusapp.helpers.PatientNotFoundException;
import com.opticus.opticusapp.service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class PatientController {

    @Autowired
    private PatientService patientService;

    @CrossOrigin
    @GetMapping("/patients")
    public List<Patient> getPatients() {
        return patientService.getPatients();
    }

    @CrossOrigin
    @GetMapping("/patients/{patientId}")
    public Patient getPatient(@PathVariable int patientId) {

        Patient patient = patientService.getPatient(patientId);
        checkIfPatientExists(patient);

        return patient;

    }

    @CrossOrigin
    @PutMapping("/patients")
    public Patient savePatient(@RequestBody Patient patient) {
        patientService.savePatient(patient);

        return patient;
    }


    @CrossOrigin
    @PostMapping("/patients")
    public Patient addPatient(@RequestBody Patient patient) {
        patient.setId(0);
        patientService.savePatient(patient);

        return patient;
    }

    @CrossOrigin
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
