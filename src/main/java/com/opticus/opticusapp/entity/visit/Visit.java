package com.opticus.opticusapp.entity.visit;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.opticus.opticusapp.entity.examination.Examination;
import com.opticus.opticusapp.entity.medicine.AdministeredMedicine;
import com.opticus.opticusapp.entity.user.Specialist;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;


enum VisitStatus{
    PLANNED, COMPLETED, CANCELLED
}

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public class Visit {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "visit_id")
    private int id;

    @Column(name = "date")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm", iso = DateTimeFormat.ISO.DATE_TIME)
    private LocalDateTime date;

    @Column(name = "time")
    private LocalTime time;

    @Column(name = "description")
    private String description;


    @Column(name = "price")
    private double price;

    @Column(name = "total_price")
    private double totalPrice;

    @Enumerated(EnumType.STRING)
    @Column(name = "status")
    private VisitStatus status;


    //TODO Clinic

    @OneToMany(mappedBy = "visit", cascade = {CascadeType.PERSIST, CascadeType.DETACH, CascadeType.MERGE, CascadeType.REFRESH})
    private List<VisitAppointment> visitAppointments = new ArrayList<>();

    @JsonBackReference
    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.DETACH, CascadeType.MERGE, CascadeType.REFRESH})
    private Specialist specialist;

    @JsonBackReference
    @OneToMany(mappedBy = "visit", cascade = {CascadeType.PERSIST, CascadeType.DETACH, CascadeType.MERGE, CascadeType.REFRESH})
    private List<Examination> examinations = new ArrayList<>();


    @JsonBackReference
    @OneToMany(mappedBy = "visit", cascade = {CascadeType.PERSIST, CascadeType.DETACH, CascadeType.MERGE, CascadeType.REFRESH})
    private List<AdministeredMedicine> administeredMedicines = new ArrayList<>();


    @PostLoad
    private void postLoad() {
        this.totalPrice = getExaminations().stream().mapToDouble(e -> e.getPrice()).sum();
    }

    public Visit() {
    }



    public List<AdministeredMedicine> administeredMedicine() {
        return administeredMedicines;
    }

    public void addAdministeredMedicine(AdministeredMedicine administeredMedicine) {
        administeredMedicines.add(administeredMedicine);
        administeredMedicine.setVisit(this);

    }

    public void removeAdministeredMedicine(AdministeredMedicine administeredMedicine) {
        administeredMedicine.setVisit(null);
        this.administeredMedicines.remove(administeredMedicine);

    }

    public List<VisitAppointment> getvisitAppointment() {
        return visitAppointments;
    }

    public void addVisitAppointment(VisitAppointment visitAppointment) {
        visitAppointments.add(visitAppointment);
        visitAppointment.setVisit(this);

    }

    public void removeVisitAppointment(VisitAppointment visitAppointment) {
        visitAppointment.setVisit(null);
        this.visitAppointments.remove(visitAppointment);

    }

    public List<Examination> getExaminations() {
        return examinations;
    }

    public void setExaminations(List<Examination> examinations) {
        this.examinations = examinations;
    }

    public Specialist getSpecialist() {
        return specialist;
    }

    public void setSpecialist(Specialist specialist) {
        this.specialist = specialist;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }

    public LocalTime getTime() {
        return time;
    }

    public void setTime(LocalTime time) {
        this.time = time;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public VisitStatus getStatus() {
        return status;
    }

    public void setStatus(VisitStatus status) {
        this.status = status;
    }
}
