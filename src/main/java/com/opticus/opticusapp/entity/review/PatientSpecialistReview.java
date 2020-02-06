package com.opticus.opticusapp.entity.review;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.opticus.opticusapp.entity.user.Patient;
import org.hibernate.validator.constraints.Range;
import com.opticus.opticusapp.entity.user.Specialist;
import javax.persistence.*;

@Entity
@Table(name = "patient_specialist_review")
public class PatientSpecialistReview {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "patient_specialist_review_id")
    private int id;

    @JsonBackReference
    @ManyToOne(cascade = CascadeType.ALL)
    private Patient patient;

    @JsonBackReference
    @ManyToOne(cascade = CascadeType.ALL)
    private Specialist specialist;

    @Column(name = "rating", precision = 1)
    @Range(min = 0, max = 5)
    private double rating;


    @Column(name = "comment")
    private String comment;

    public PatientSpecialistReview(Patient patient, Specialist specialist, @Range(min = 0, max = 5) double rating, String comment) {
        this.patient = patient;
        this.specialist = specialist;
        this.rating = rating;
        this.comment = comment;
    }

    public PatientSpecialistReview() {

    }

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
        this.patient.addPatientSpecialistReview(this);
    }

    public Specialist getSpecialist() {
        return specialist;
    }

    public void setSpecialist(Specialist specialist) {
        this.specialist = specialist;
        this.specialist.addPatientSpecialistReview(this);
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
