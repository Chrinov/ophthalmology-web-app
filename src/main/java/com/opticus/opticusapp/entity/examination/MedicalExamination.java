package com.opticus.opticusapp.entity.examination;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class MedicalExamination {

    @Column(name = "medical_exam_name")
    private String name;

    @Column(name = "price")
    private double price;

    public MedicalExamination(String name) {
        this.name = name;
    }

    public MedicalExamination() {
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
