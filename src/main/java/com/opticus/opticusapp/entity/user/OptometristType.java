package com.opticus.opticusapp.entity.user;

import javax.persistence.*;

@MappedSuperclass
abstract public class OptometristType {



    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "optometrist_type_id")
    private int id;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

}
