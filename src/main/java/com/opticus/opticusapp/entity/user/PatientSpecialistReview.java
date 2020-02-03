package com.opticus.opticusapp.entity.user;

import org.hibernate.validator.constraints.Range;

import javax.persistence.*;

@Entity
@Table(name = "patient_specialist_review")
public class PatientSpecialistReview {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "patient_specialist_review_id")
    private int id;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id")
    private Patient patient;


    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id")
    private Specialist specialist;

    @Column(name = "rating", precision = 1)
    @Range(min = 0, max = 5)
    private double rating;


    @Column(name = "comment")
    private String comment;


    public void deletePatientSpecialistReview() {
        patient.removePatientSpecialistReview(this);
        specialist.removePatientSpecialistReview(this);
        patient = null;
        specialist = null;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }

    public Specialist getSpecialist() {
        return specialist;
    }

    public void setSpecialist(Specialist specialist) {
        this.specialist = specialist;
    }

    public double getRating() {
        return rating;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }
}
