package com.opticus.opticusapp.entity.medicine;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.opticus.opticusapp.entity.visit.Visit;

import javax.persistence.*;

@Entity
@Table(name = "administered_medicine")
public class AdministeredMedicine {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "administered_medicine_id")
    private int id;

    @Column(name = "dosage")
    private String dosage;

    @Column(name = "form")
    private String form;


    @ManyToOne
    @JsonManagedReference
    private Medicine medicine;

    @ManyToOne
    @JsonManagedReference
    private Visit visit;

    public AdministeredMedicine(String dosage, String form) {
        this.dosage = dosage;
        this.form = form;
    }

    public void deleteAdministeredMedicine() {
        medicine.removeAdministeredMedicine(this);
        medicine = null;

        visit.removeAdministeredMedicine(this);
        visit = null;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDosage() {
        return dosage;
    }

    public void setDosage(String dosage) {
        this.dosage = dosage;
    }

    public String getForm() {
        return form;
    }

    public void setForm(String form) {
        this.form = form;
    }

    public Medicine getMedicine() {
        return medicine;
    }

    public void setMedicine(Medicine medicine) {
        this.medicine = medicine;
        this.medicine.addAdministeredMedicine(this);
    }

    public Visit getVisit() {
        return visit;
    }

    public void setVisit(Visit visit) {
        this.visit = visit;
        this.visit.addAdministeredMedicine(this);
    }
}
