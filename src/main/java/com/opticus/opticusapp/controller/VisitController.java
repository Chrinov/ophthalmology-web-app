package com.opticus.opticusapp.controller;

import com.opticus.opticusapp.entity.clinic.Clinic;
import com.opticus.opticusapp.entity.examination.MedicalExamination;
import com.opticus.opticusapp.entity.user.Patient;
import com.opticus.opticusapp.entity.user.Specialist;
import com.opticus.opticusapp.entity.visit.Visit;
import com.opticus.opticusapp.entity.visit.VisitStatus;
import com.opticus.opticusapp.helpers.VisitNotFoundException;
import com.opticus.opticusapp.service.clinic.ClinicService;
import com.opticus.opticusapp.service.patient.PatientService;
import com.opticus.opticusapp.service.specialist.SpecialistService;
import com.opticus.opticusapp.service.visit.VisitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = {"http://localhost:3000"}, maxAge = 3600)
@RestController
@RequestMapping("/api")
public class VisitController {

    @Autowired
    private VisitService visitService;

    @Autowired
    private PatientService patientService;

    @Autowired
    private SpecialistService specialistService;

    @Autowired
    private ClinicService clinicService;

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

    
    @PutMapping("/visits/{visitId}")
    public Visit saveVisit(@PathVariable int visitId, @RequestBody Visit visit) {
        Visit tmpVisit = visitService.getVisit(visitId);
        checkIfVisitExists(tmpVisit);

        VisitStatus status = visit.getStatus();

        tmpVisit.setStatus(status);

        visitService.saveVisit(tmpVisit);

        return visit;
    }


    @PostMapping("/visits")
    public Visit addVisit(@RequestBody Visit visit) {
       // visit.setId(0);


     //   System.out.println(patientService.getPatient(visit.getPatient().getId()));

        Patient patient = patientService.getPatient(visit.getPatient().getId());
        visit.setPatient(patient);

        Specialist specialist = specialistService.getSpecialist(visit.getSpecialist().getId());
        visit.setSpecialist(specialist);


        Clinic clinic = clinicService.getClinic(visit.getClinic().getId());
        visit.setClinic(clinic);

        double totalPrice = visit.getPrice() + visit.getMedicalExaminations().stream().mapToDouble(e -> e.getPrice()).sum();

        visit.setTotalPrice(totalPrice);

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
