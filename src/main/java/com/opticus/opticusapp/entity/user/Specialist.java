package com.opticus.opticusapp.entity.user;


import com.opticus.opticusapp.entity.Visit;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "doctor")
public class Specialist extends User {


    @Column(name = "hire_date")
    private LocalDateTime hireDate;

    @Column(name = "description")
    private String description;

    @Column(name = "title")
    private String title;


    @OneToMany(mappedBy = "doctor", cascade = CascadeType.ALL)
    private List<PatientSpecialistReview> patientSpecialistReviews = new ArrayList<>();


    @OneToMany(mappedBy = "doctor", cascade = {CascadeType.PERSIST, CascadeType.DETACH, CascadeType.MERGE, CascadeType.REFRESH})
    private List<Visit> visits;

    public Specialist() {
    }


    public double getSpecialistRating() {

        return patientSpecialistReviews.stream().mapToDouble(review -> review.getRating()).sum() / patientSpecialistReviews.size();

    }

    public LocalDateTime getSeniority() {
        LocalDateTime seniority = LocalDateTime.now().minus(hireDate.getYear(), ChronoUnit.YEARS);

        return seniority;
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
