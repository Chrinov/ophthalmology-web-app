//package com.opticus.opticusapp.entity.examination;
//
//import com.opticus.opticusapp.entity.visit.Visit;
//
//import javax.persistence.*;
//
//@Entity
//public class Examination {
//
//    @EmbeddedId
//    private ExaminationId examinationId;
//
//    @Column(name = "price")
//    private double price;
//
//    // @JsonBackReference
//    @ManyToOne(cascade = CascadeType.ALL)
//    @JoinColumn(name = "visit_id")
//    private Visit visit;
//
//    public Examination(ExaminationId examinationId, double price, Visit visit) {
//        this.examinationId = examinationId;
//        setPrice(price);
//        setVisit(visit);
//
//    }
//
//    public Examination() {
//    }
//
//    public ExaminationId getExaminationId() {
//        return examinationId;
//    }
//
//    public void setExaminationId(ExaminationId examinationId) {
//        this.examinationId = examinationId;
//    }
//
//    public double getPrice() {
//        return price;
//    }
//
//    public void setPrice(double price) {
//        this.price = price;
//    }
//
//    public Visit getVisit() {
//        return visit;
//    }
//
//    public void setVisit(Visit visit) {
//        this.visit = visit;
//        this.visit.setTotalPrice(this.visit.getPrice() + this.visit.getTotalPrice() + this.price);
//    }
//}
