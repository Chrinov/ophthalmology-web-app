package com.opticus.opticusapp.entity.user;

import javax.persistence.*;

@MappedSuperclass
abstract public class SpecialistType {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "specialist_type_id")
    private int id;


    public SpecialistType() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }


}
