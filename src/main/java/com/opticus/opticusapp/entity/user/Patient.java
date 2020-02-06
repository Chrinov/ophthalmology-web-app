package com.opticus.opticusapp.entity.user;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.opticus.opticusapp.entity.review.PatientSpecialistReview;
import com.opticus.opticusapp.entity.visit.VisitAppointment;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "patient")
public class Patient extends User {


    @Column(name = "register_date")
    private LocalDateTime registerDate;

    @ElementCollection
    @Column(name = "phone_number")
    private List<String> phoneNumber;


    @Column(name = "birth_date")
    private LocalDateTime birthDate;

    @Column(name = "gender")
    private String gender;

    @JsonBackReference
    @OneToMany(mappedBy = "patient", cascade = CascadeType.ALL)
    private List<PatientSpecialistReview> patientSpecialistReviews = new ArrayList<>();

    @JsonBackReference
    @OneToMany(mappedBy = "patient", cascade = {CascadeType.PERSIST, CascadeType.DETACH, CascadeType.MERGE, CascadeType.REFRESH})
    private List<VisitAppointment> visitAppointments = new ArrayList<>();



    public Patient() {
    }

    public Patient(String firstName, String lastName, LocalDateTime birthdate, String email, boolean signUpConfirmed, LocalDateTime registerDate, List<String> phoneNumber, LocalDateTime birthDate, String gender) {
        super(firstName, lastName, birthdate, email, signUpConfirmed);
        this.registerDate = registerDate;
        this.phoneNumber = phoneNumber;
        this.birthDate = birthDate;
        this.gender = gender;
    }

    public List<VisitAppointment> getvisitAppointment() {
        return visitAppointments;
    }

    public void addVisitAppointment(VisitAppointment visitAppointment) {
        visitAppointments.add(visitAppointment);
        visitAppointment.setPatient(this);

    }

    public void removeVisitAppointment(VisitAppointment visitAppointment) {
        visitAppointment.setPatient(null);
        this.visitAppointments.remove(visitAppointment);

    }


    public List<PatientSpecialistReview> getPatientSpecialistReviews() {
        return patientSpecialistReviews;
    }

    public void addPatientSpecialistReview(PatientSpecialistReview patientSpecialistReview) {
        patientSpecialistReviews.add(patientSpecialistReview);
        patientSpecialistReview.setPatient(this);

    }

    public void removePatientSpecialistReview(PatientSpecialistReview patientSpecialistReview) {
        patientSpecialistReview.setPatient(null);
        this.patientSpecialistReviews.remove(patientSpecialistReview);

    }

    public LocalDateTime getRegisterDate() {
        return registerDate;
    }

    public void setRegisterDate(LocalDateTime registerDate) {
        this.registerDate = registerDate;
    }

    public List<String> getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(List<String> phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public LocalDateTime getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDateTime birthDate) {
        this.birthDate = birthDate;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }
}
