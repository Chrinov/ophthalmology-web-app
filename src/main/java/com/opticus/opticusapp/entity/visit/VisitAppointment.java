package com.opticus.opticusapp.entity.visit;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.opticus.opticusapp.entity.user.Patient;

import javax.persistence.*;

@Entity
@Table(name = "visit_appointment")
public class VisitAppointment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "visit_appointment_id")
    private int id;

    @Column(name = "reason")
    private String reason;

    @JsonBackReference
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id")
    private Patient patient;

    @JsonBackReference
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "visit_id")
    private Visit visit;


    public VisitAppointment(String reason, Patient patient, Visit visit) {
        this.reason = reason;
        this.patient = patient;
        this.visit = visit;
    }

    public VisitAppointment() {

    }


    public void deleteVisitAppointment() {
        patient.removeVisitAppointment(this);
        patient = null;

        visit.removeVisitAppointment(this);
        visit = null;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
        this.patient.addVisitAppointment(this);
    }

    public Visit getVisit() {
        return visit;
    }

    public void setVisit(Visit visit) {
        this.visit = visit;
        this.visit.addVisitAppointment(this);

    }
}
