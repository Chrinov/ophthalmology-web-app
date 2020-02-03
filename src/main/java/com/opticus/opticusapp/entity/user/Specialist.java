package com.opticus.opticusapp.entity.user;


import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIdentityReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import com.opticus.opticusapp.entity.Visit;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "doctor")
public class Specialist extends User {


    //TODO create Specialisation <name> ENTITY 1-(1..*)
    @Column(name = "specialisation")
    private String specialisation;

    @Column(name = "hire_date")
    private LocalDateTime hireDate;

    @Column(name = "description")
    private String description;

    @Column(name = "title")
    private String title;


    @OneToMany(mappedBy = "doctor", cascade = CascadeType.ALL)
    private List<PatientSpecialistReview> patientSpecialistReviews = new ArrayList<>();


    @JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "user_id")
    @JsonIdentityReference(alwaysAsId = true)
    @OneToMany(mappedBy = "doctor", cascade = {CascadeType.PERSIST, CascadeType.DETACH, CascadeType.MERGE, CascadeType.REFRESH})
    private List<Visit> visits;

    public Specialist() {
    }


    public List<PatientSpecialistReview> getPatientSpecialistReviews() {
        return patientSpecialistReviews;
    }

    public void addPatientSpecialistReview(PatientSpecialistReview patientSpecialistReview) {
        patientSpecialistReviews.add(patientSpecialistReview);
        patientSpecialistReview.setSpecialist(this);

    }

    public void removePatientSpecialistReview(PatientSpecialistReview patientSpecialistReview) {
        patientSpecialistReview.setSpecialist(null);
        this.patientSpecialistReviews.remove(patientSpecialistReview);

    }


}
