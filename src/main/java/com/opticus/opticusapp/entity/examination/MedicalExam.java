package com.opticus.opticusapp.entity.examination;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class MedicalExam {

    @Column(name = "medical_exam_name")
    private String name;

    @Column(name = "price")
    private double price;

    public MedicalExam(String name) {
        this.name = name;
    }

    public MedicalExam() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
