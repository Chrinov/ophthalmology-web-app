package com.opticus.opticusapp.controller;

import com.opticus.opticusapp.entity.clinic.Clinic;
import com.opticus.opticusapp.entity.user.Patient;
import com.opticus.opticusapp.entity.visit.Visit;
import com.opticus.opticusapp.helpers.VisitNotFoundException;
import com.opticus.opticusapp.service.clinic.ClinicService;
import com.opticus.opticusapp.service.patient.PatientService;
import com.opticus.opticusapp.service.visit.VisitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = {"http://localhost:3000", "http://localhost:3000/api/visits"}, maxAge = 3600)
@RestController
@RequestMapping("/api")
public class ClinicController {

    @Autowired
    private ClinicService clinicService;

    
    @GetMapping("/clinics")
    public List<Clinic> getVisits() {
        return clinicService.getClinics();
    }


}
