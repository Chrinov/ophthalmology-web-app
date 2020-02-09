package com.opticus.opticusapp.entity.visit;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIdentityReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import com.opticus.opticusapp.entity.clinic.Clinic;
import com.opticus.opticusapp.entity.examination.MedicalExamination;
import com.opticus.opticusapp.entity.medicine.AdministeredMedicine;
import com.opticus.opticusapp.entity.user.Patient;
import com.opticus.opticusapp.entity.user.Specialist;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;


enum VisitType {
    OPTOMETRICAL, OPHTHALMOLOGICAL

}



@Entity
@Table(name = "visit")
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
    private double price = 50;


    @Column(name = "total_price")
    private Double totalPrice;

    @Enumerated(EnumType.STRING)
    @Column(name = "status")
    private VisitStatus status;

    @Enumerated(EnumType.STRING)
    @Column(name = "visit_type")
    private VisitType visitType;



    @JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
    @JsonIdentityReference(alwaysAsId = true)
    @ManyToOne(cascade = {CascadeType.ALL})
    private Clinic clinic;

    //   @JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
    // @JsonIdentityReference(alwaysAsId = true)
    //  @JsonBackReference("patient-visit")
    @ManyToOne(cascade = {CascadeType.ALL})
    private Patient patient;

    // @JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
    // @JsonIdentityReference(alwaysAsId = true)
    //@JsonBackReference("specialist-visit")
    @ManyToOne(cascade = {CascadeType.ALL})
    private Specialist specialist;

    //  @JsonBackReference
//    @OneToMany(mappedBy = "visit", cascade = {CascadeType.PERSIST, CascadeType.DETACH, CascadeType.MERGE, CascadeType.REFRESH})
//    private List<Examination> examinations = new ArrayList<>();

    //  @JsonBackReference
    @ElementCollection(fetch = FetchType.LAZY)
    @CollectionTable(name = "medical_examinations", joinColumns = @JoinColumn(name = "visit_id"))
    @AttributeOverrides({
            @AttributeOverride(name = "name", column = @Column(name = "examination_name")),
            @AttributeOverride(name = "price", column = @Column(name = "examination_price"))
    })
    private List<MedicalExamination> medicalExaminations;


    //   @JsonBackReference
    //   @JsonIgnore
    @JsonManagedReference("medicine-visit")
    @OneToMany(mappedBy = "visit", fetch = FetchType.EAGER, cascade = {CascadeType.ALL}, orphanRemoval = true)
    private List<AdministeredMedicine> administeredMedicines = new ArrayList<>();


    public Visit() {
    }

    public Visit(LocalDateTime date, LocalTime time, String description, double price, Double totalPrice, VisitStatus status, VisitType visitType, Clinic clinic, Patient patient, Specialist specialist) {
        this.date = date;
        this.time = time;
        this.description = description;
        this.price = price;
        this.totalPrice = totalPrice;
        this.status = status;
        this.visitType = visitType;
        this.clinic = clinic;
        this.patient = patient;
        this.specialist = specialist;
    }


    //    @PostUpdate
//    private void postLoad() {
//        this.totalPrice = this.price + getExaminations().stream().mapToDouble(e -> e.getPrice()).sum();
//    }

//    public Double totalPrice() {
//        return this.totalPrice = this.price + getExaminations().stream().mapToDouble(e -> e.getPrice()).sum();
//    }

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

//    public List<VisitAppointment> getvisitAppointment() {
//        return visitAppointments;
//    }
//
//    public void addVisitAppointment(VisitAppointment visitAppointment) {
//        visitAppointments.add(visitAppointment);
//        visitAppointment.setVisit(this);
//
//    }
//
//    public void removeVisitAppointment(VisitAppointment visitAppointment) {
//        visitAppointment.setVisit(null);
//        this.visitAppointments.remove(visitAppointment);
//
//    }


//    public VisitAppointment getVisits() {
//        return visitAppointments;
//    }
//
//    public void setVisits(VisitAppointment visitAppointments) {
//        this.visitAppointments = visitAppointments;
//    }


    public Clinic getClinic() {
        return clinic;
    }

    public void setClinic(Clinic clinic) {
        this.clinic = clinic;
    }

    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }

    public List<MedicalExamination> getMedicalExaminations() {
        return medicalExaminations;
    }

    public void setMedicalExaminations(List<MedicalExamination> medicalExaminations) {
        this.medicalExaminations = medicalExaminations;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public VisitType getVisitType() {
        return visitType;
    }

    public void setVisitType(VisitType visitType) {
        this.visitType = visitType;
    }

    public Double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(Double totalPrice) {
        this.totalPrice = totalPrice;
    }

//    public List<Examination> getExaminations() {
//        return examinations;
//    }
//
//    public void setExaminations(List<Examination> examinations) {
//        this.examinations = examinations;
//    }

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
