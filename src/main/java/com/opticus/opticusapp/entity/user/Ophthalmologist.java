package com.opticus.opticusapp.entity.user;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "ophthalmologist")
public class Ophthalmologist extends SpecialistType{

    public Ophthalmologist() {
    }

}
