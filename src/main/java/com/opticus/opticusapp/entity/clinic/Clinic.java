package com.opticus.opticusapp.entity.clinic;

import com.fasterxml.jackson.annotation.*;
import com.opticus.opticusapp.entity.review.PatientSpecialistReview;
import com.opticus.opticusapp.entity.user.Specialist;
import com.opticus.opticusapp.entity.visit.Visit;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


@Entity
@Table(name="clinic")
public class Clinic {
  
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "clinic_id")
  private int id;
  
  @Column(name = "address")
  private String address;
  
  @ManyToMany(mappedBy = "clinics")
//  @JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
//  @JsonIdentityReference(alwaysAsId = true)
  private Set<Specialist> specialists = new HashSet<>();

//  @JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
//  @JsonIdentityReference(alwaysAsId = true)
  @OneToMany(mappedBy = "clinic", cascade = {CascadeType.ALL})
  private List<Visit> visits = new ArrayList<>();

  public Clinic(String address) {
    this.address = address;
  }

  public Clinic() {
  }


  public void addSpecialist(Specialist specialist) {
    specialists.add(specialist);
    specialist.addClinic(this);

  }

  public void removeSpecialist(Specialist specialist) {
    specialists.remove(specialist);
    this.specialists.remove(specialist);

  }

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public String getAddress() {
    return address;
  }

  public void setAddress(String address) {
    this.address = address;
  }

  public Set<Specialist> getSpecialists() {
    return specialists;
  }

  public void setSpecialists(Set<Specialist> specialists) {
    this.specialists = specialists;
  }
}
