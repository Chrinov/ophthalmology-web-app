package com.opticus.opticusapp.entity.user;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.opticus.opticusapp.entity.clinic.Clinic;
import com.opticus.opticusapp.entity.review.PatientSpecialistReview;
import com.opticus.opticusapp.entity.visit.Visit;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;

import javax.persistence.*;
import java.time.LocalDateTime;

import java.time.temporal.ChronoUnit;
import java.util.*;


@Entity
@Table(name = "specialist")
public class Specialist extends User {

    @Enumerated(EnumType.STRING)
    private SpecialistType specialistType;

    @Enumerated(EnumType.STRING)
    private OptometristType optometristType;



    @Column(name = "hire_date")
    private LocalDateTime hireDate;

    @Column(name = "description")
    private String description;

    @Column(name = "title")
    private String title;


    @JsonManagedReference("specialist-review")
    @OneToMany(mappedBy = "specialist", cascade = CascadeType.ALL)
    private List<PatientSpecialistReview> patientSpecialistReviews = new ArrayList<>();

   // @JsonManagedReference("specialist-visit")
    @JsonBackReference
    @OneToMany(mappedBy = "specialist", cascade = {CascadeType.ALL})
    private List<Visit> visits = new ArrayList<>();

    @JsonBackReference
    @ManyToMany(cascade = {CascadeType.ALL})
    @JoinTable(
        name= "specialist_clinic",
        joinColumns = { @JoinColumn(name = "user_id")},
        inverseJoinColumns = { @JoinColumn(name = "clinic_id")}
    )
    Set<Clinic> clinics = new HashSet<>();




    public Specialist() {
    }


    public Specialist(String firstName, String lastName, LocalDateTime birthdate, String email, boolean signUpConfirmed, LocalDateTime hireDate, String description, String title) {
        super(firstName, lastName, birthdate, email, signUpConfirmed);
        this.hireDate = hireDate;
        this.description = description;
        this.title = title;
    }

    public void addClinic(Clinic clinic) {
        clinics.add(clinic);
        clinic.addSpecialist(this);

    }

    public List<Visit> getVisits() {
        return visits;
    }

    public void setVisits(List<Visit> visits) {
        this.visits = visits;
    }

    public SpecialistType getSpecialistType() {
        return specialistType;
    }

    public void setSpecialistType(SpecialistType specialistType) {
        this.specialistType = specialistType;
    }

    public OptometristType getOptometristType() {
        return optometristType;
    }

    public void setOptometristType(OptometristType optometristType) {
        this.optometristType = optometristType;
    }

    public void removeClinic(Clinic clinic) {
        clinics.remove(clinic);
        this.clinics.remove(clinic);

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

    public LocalDateTime getHireDate() {
        return hireDate;
    }

    public void setHireDate(LocalDateTime hireDate) {
        this.hireDate = hireDate;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setPatientSpecialistReviews(List<PatientSpecialistReview> patientSpecialistReviews) {
        this.patientSpecialistReviews = patientSpecialistReviews;
    }

    public Set<Clinic> getClinics() {
        return clinics;
    }

    public void setClinics(Set<Clinic> clinics) {
        this.clinics = clinics;
    }
}
