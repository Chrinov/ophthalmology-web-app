package com.opticus.opticusapp.entity.examination;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.opticus.opticusapp.entity.visit.Visit;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;

@Entity
public class Examination {

    @EmbeddedId
    private ExaminationId examinationId;

    @Column(name = "price")
    private double price;

    @JsonBackReference
    @ManyToOne
    private Visit visit;

    public Examination(ExaminationId examinationId, double price) {
        this.examinationId = examinationId;
        this.price = price;
    }

    public ExaminationId getExaminationId() {
        return examinationId;
    }

    public void setExaminationId(ExaminationId examinationId) {
        this.examinationId = examinationId;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Visit getVisit() {
        return visit;
    }

    public void setVisit(Visit visit) {
        this.visit = visit;
    }
}
