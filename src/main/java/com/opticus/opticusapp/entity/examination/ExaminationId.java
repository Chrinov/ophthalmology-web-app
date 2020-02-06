package com.opticus.opticusapp.entity.examination;

import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
public class ExaminationId implements Serializable {
    private String name;

    public ExaminationId(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
