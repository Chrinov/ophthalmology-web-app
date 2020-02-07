package com.opticus.opticusapp.entity.user;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.opticus.opticusapp.entity.review.PatientSpecialistReview;
import com.opticus.opticusapp.entity.user.User;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "specialist")
public class Specialist extends User {


    @Column(name = "hire_date")
    private LocalDateTime hireDate;

    @Column(name = "description")
    private String description;

    @Column(name = "title")
    private String title;

    @JsonBackReference
    @OneToMany(mappedBy = "specialist", cascade = CascadeType.ALL)
    private List<PatientSpecialistReview> patientSpecialistReviews = new ArrayList<>();

    @ManyToMany(cascade = {CascadeType.ALL})
    @JoinTable(
        name= "specialist_clinic",
        joinColumns = { @JoinColumn(name = "user_id")},
        inverseJoinColumns = { @JoinColumn(name = "clinic_id")}
    )
    Set<Clinic> clinics = new HashSet<>();
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
