package com.opticus.opticusapp.entity.medicine;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.opticus.opticusapp.entity.review.PatientSpecialistReview;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "medicine")
public class Medicine {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "medicine_id")
    private int id;

    @Column(name = "name")
    private String name;


    @JsonBackReference
    @OneToMany(mappedBy = "medicine", cascade = CascadeType.ALL)
    private List<AdministeredMedicine> administeredMedicines = new ArrayList<>();

    public List<AdministeredMedicine> getAdministeredMedicines() {
        return administeredMedicines;
    }

    public void addAdministeredMedicine(AdministeredMedicine administeredMedicine) {
        administeredMedicines.add(administeredMedicine);
        administeredMedicine.setMedicine(this);

    }

    public void removeAdministeredMedicine(AdministeredMedicine administeredMedicine) {
        administeredMedicine.setMedicine(null);
        this.administeredMedicines.remove(administeredMedicine);

    }

    public Medicine(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAdministeredMedicines(List<AdministeredMedicine> administeredMedicines) {
        this.administeredMedicines = administeredMedicines;
    }
}
