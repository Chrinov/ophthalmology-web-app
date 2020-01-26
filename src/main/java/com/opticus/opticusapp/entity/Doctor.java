package com.opticus.opticusapp.entity;


import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIdentityReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "doctor")
public class Doctor extends Person {


    //TODO create Specialisation <name> ENTITY 1-(1..*)
    @Column(name = "specialisation")
    private String specialisation;

    @Column(name = "hire_date")
    private LocalDateTime hireDate;

    @Column(name = "fire_date")
    private LocalDateTime fireDate;

    //TODO create Rating entity
    @Column(name = "rating")
    private double rating;

    @Column(name = "description")
    private String description;

    @Column(name = "title")
    private String title;
    @JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
    @JsonIdentityReference(alwaysAsId = true)
    @OneToMany(mappedBy = "doctor", cascade = {CascadeType.PERSIST, CascadeType.DETACH, CascadeType.MERGE, CascadeType.REFRESH})
    private List<Visit> visits;

    public Doctor() {
    }


    public Doctor(String firstName, String lastName, String PESEL, LocalDateTime birthdate, String sex, String email,
                  String specialisation, LocalDateTime hireDate, LocalDateTime fireDate, double rating, String description, String title) {
        super(firstName, lastName, PESEL, birthdate, sex, email);
        this.specialisation = specialisation;
        this.hireDate = hireDate;
        this.fireDate = fireDate;
        this.rating = rating;
        this.description = description;
        this.title = title;
    }


    /**
     * Returns value of specialisation
     *
     * @return
     */
    public String getSpecialisation() {
        return specialisation;
    }

    /**
     * Sets new value of specialisation
     *
     * @param
     */
    public void setSpecialisation(String specialisation) {
        this.specialisation = specialisation;
    }

    /**
     * Returns value of hireDate
     *
     * @return
     */
    public LocalDateTime getHireDate() {
        return hireDate;
    }

    /**
     * Sets new value of hireDate
     *
     * @param
     */
    public void setHireDate(LocalDateTime hireDate) {
        this.hireDate = hireDate;
    }

    /**
     * Returns value of fireDate
     *
     * @return
     */
    public LocalDateTime getFireDate() {
        return fireDate;
    }

    /**
     * Sets new value of fireDate
     *
     * @param
     */
    public void setFireDate(LocalDateTime fireDate) {
        this.fireDate = fireDate;
    }

    /**
     * Returns value of rating
     *
     * @return
     */
    public double getRating() {
        return rating;
    }

    /**
     * Sets new value of rating
     *
     * @param
     */
    public void setRating(double rating) {
        this.rating = rating;
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


    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<Visit> getVisits() {
        return visits;
    }

    public void setVisits(List<Visit> visits) {
        this.visits = visits;
    }
}
