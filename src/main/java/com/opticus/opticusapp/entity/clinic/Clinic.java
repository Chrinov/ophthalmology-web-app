package com.opticus.opticusapp.entity.clinic;

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
  private Set<Specialist> specialists = new HashSet<>();
  
  
  
  
}
