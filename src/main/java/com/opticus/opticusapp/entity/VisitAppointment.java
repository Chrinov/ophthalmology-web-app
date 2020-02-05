package com.opticus.opticusapp.entity;

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


    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id")
    private Patient patient;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "visit_id")
    private Visit visit;


    public void deleteVisitAppointment() {
        patient.removeVisitAppointment(this);
        patient = null;

        visit.removeVisitAppointment();
        visit = null;
    }

}
