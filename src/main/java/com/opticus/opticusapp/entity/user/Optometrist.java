package com.opticus.opticusapp.entity.user;

import javax.persistence.*;

@Entity
@Table(name = "optometrist")
public class Optometrist extends SpecialistType{





    private OptometristType optometristType;

    public Optometrist(OptometristType optometristType) {
        this.optometristType = optometristType;
    }

    public OptometristType getOptometristType() {
        return optometristType;
    }

    public void setOptometristType(OptometristType optometristType) {
        this.optometristType = optometristType;
    }

    public Optometrist() {
    }
}
