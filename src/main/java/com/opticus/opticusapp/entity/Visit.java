package com.opticus.opticusapp.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.opticus.opticusapp.entity.user.Patient;
import com.opticus.opticusapp.entity.user.Specialist;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDateTime;


@Entity
@Table(name = "visit")
public class Visit {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "visit_id")
    private int id;

    @Column(name = "date")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm", iso = DateTimeFormat.ISO.DATE_TIME)
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm")
    private LocalDateTime date;

    @Column(name = "description")
    private String description;

    //TODO Clinic

    @Column(name = "clinic")
    private String clinic;

    @Column(name = "visit_type")
    private String visitType;

    @Column(name = "reason")
    private String reason;

    @Column(name = "is_planned")
    private boolean isPlanned;

    //  @JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
    //  @JsonIdentityReference(alwaysAsId = true)
    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.DETACH, CascadeType.MERGE, CascadeType.REFRESH})
    @JoinColumn(name = "doctor_id")
    private Specialist specialist;

    //  @JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
    // @JsonIdentityReference(alwaysAsId = true)
    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.DETACH, CascadeType.MERGE, CascadeType.REFRESH})
    @JoinColumn(name = "patient_id")
    private Patient patient;


    public Visit() {
    }

    public Visit(LocalDateTime date, String description, String visitType, String reason, boolean isPlanned, String clinic, Patient patient, Specialist specialist) {
        this.date = date;
        this.description = description;
        this.visitType = visitType;
        this.reason = reason;
        this.isPlanned = isPlanned;
        this.clinic = clinic;
        this.patient = patient;
        this.specialist = specialist;
    }

    /**
     * Returns value of id
     *
     * @return
     */
    public int getId() {
        return id;
    }

    /**
     * Sets new value of id
     *
     * @param
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Returns value of date
     *
     * @return
     */
    public LocalDateTime getDate() {
        return date;
    }

    /**
     * Sets new value of date
     *
     * @param
     */
    public void setDate(LocalDateTime date) {
        this.date = date;
    }

    /**
     * Returns value of description
     *
     * @return
     */
    public String getDescription() {
        return description;
    }

    /**
     * Sets new value of description
     *
     * @param
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * Returns value of visitType
     *
     * @return
     */
    public String getVisitType() {
        return visitType;
    }

    /**
     * Sets new value of visitType
     *
     * @param
     */
    public void setVisitType(String visitType) {
        this.visitType = visitType;
    }

    /**
     * Returns value of reason
     *
     * @return
     */
    public String getReason() {
        return reason;
    }

    /**
     * Sets new value of reason
     *
     * @param
     */
    public void setReason(String reason) {
        this.reason = reason;
    }

    /**
     * Returns value of isPlanned
     *
     * @return
     */
    public boolean isIsPlanned() {
        return isPlanned;
    }

    /**
     * Sets new value of isPlanned
     *
     * @param
     */
    public void setIsPlanned(boolean isPlanned) {
        this.isPlanned = isPlanned;
    }

    public String getClinic() {
        return clinic;
    }

    public void setClinic(String clinic) {
        this.clinic = clinic;
    }

    public boolean isPlanned() {
        return isPlanned;
    }

    public void setPlanned(boolean planned) {
        isPlanned = planned;
    }

    public Specialist getSpecialist() {
        return specialist;
    }

    public void setSpecialist(Specialist specialist) {
        this.specialist = specialist;
    }

    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }

    /**
     * Create string representation of Visit for printing
     *
     * @return
     */
    @Override
    public String toString() {
        return "Visit [id=" + id + ", date=" + date + ", description=" + description + ", visitType=" + visitType + ", reason=" + reason + ", isPlanned=" + isPlanned + "]";
    }
}
