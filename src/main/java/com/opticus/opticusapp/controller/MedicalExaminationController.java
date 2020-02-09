package com.opticus.opticusapp.controller;


import com.opticus.opticusapp.entity.examination.MedicalExamination;
import com.opticus.opticusapp.service.examination.MedicalExaminationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@CrossOrigin(origins = {"http://localhost:3000", "http://localhost:3000/api/visits"}, maxAge = 3600)
@RestController
@RequestMapping("/api")
public class MedicalExaminationController {

    @Autowired
    private MedicalExaminationService medicalExaminationService;

    
    @GetMapping("/examinations")
    public List<MedicalExamination> getVisits() {
        return medicalExaminationService.getMedicalExaminations();
    }


}
