package com.opticus.opticusapp.entity;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIdentityReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "patient")
public class Patient extends Person {


    @Column(name = "register_date")
    private LocalDateTime registerDate;

    @Column(name = "phone_number")
    private String phoneNumber;

    @Column(name = "kuz")
    private String kuz;

    @Column(name = "blood_type")
    private String bloodType;

    @JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
    @JsonIdentityReference(alwaysAsId = true)
    @OneToMany(mappedBy = "patient", cascade = {CascadeType.PERSIST, CascadeType.DETACH, CascadeType.MERGE, CascadeType.REFRESH})
    private List<Visit> visits;

    public Patient() {
    }

    public Patient(String firstName, String lastName, String PESEL, LocalDateTime birthdate, String sex, String email,
                   LocalDateTime registerDate, String phoneNumber, String kuz, String bloodType) {
        super(firstName, lastName, PESEL, birthdate, sex, email);
        this.registerDate = registerDate;
        this.phoneNumber = phoneNumber;
        this.kuz = kuz;
        this.bloodType = bloodType;
    }


    /**
     * Returns value of registerDate
     *
     * @return
     */
    public LocalDateTime getRegisterDate() {
        return registerDate;
    }

    /**
     * Sets new value of registerDate
     *
     * @param
     */
    public void setRegisterDate(LocalDateTime registerDate) {
        this.registerDate = registerDate;
    }

    /**
     * Returns value of phoneNumber
     *
     * @return
     */
    public String getPhoneNumber() {
        return phoneNumber;
    }

    /**
     * Sets new value of phoneNumber
     *
     * @param
     */
    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    /**
     * Returns value of kuz
     *
     * @return
     */
    public String getKuz() {
        return kuz;
    }

    /**
     * Sets new value of kuz
     *
     * @param
     */
    public void setKuz(String kuz) {
        this.kuz = kuz;
    }

    /**
     * Returns value of bloodType
     *
     * @return
     */
    public String getBloodType() {
        return bloodType;
    }

    /**
     * Sets new value of bloodType
     *
     * @param
     */
    public void setBloodType(String bloodType) {
        this.bloodType = bloodType;
    }

    /**
     * Returns value of visits
     *
     * @return
     */
    public List<Visit> getVisits() {
        return visits;
    }

    /**
     * Sets new value of visits
     *
     * @param
     */
    public void setVisits(List<Visit> visits) {
        this.visits = visits;
    }

}
