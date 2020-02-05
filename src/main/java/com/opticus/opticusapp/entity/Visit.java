package com.opticus.opticusapp.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = )
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
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

    @OneToMany(mappedBy = "visit", cascade = {CascadeType.PERSIST, CascadeType.DETACH, CascadeType.MERGE, CascadeType.REFRESH})
    private List<VisitAppointment> visitAppointments = new ArrayList<>();


    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.DETACH, CascadeType.MERGE, CascadeType.REFRESH})
    @JoinColumn(name = "doctor_id")
    private Specialist specialist;





    public Visit() {
    }



}
