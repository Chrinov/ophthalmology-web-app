package com.opticus.opticusapp.dao.specialist;

import com.opticus.opticusapp.entity.user.Specialist;

import java.util.List;

public interface SpecialistDAO {

    List<Specialist> getSpecialists();

    void saveSpecialist(Specialist specialist);

    //void updateSpecialist(specialist specialist);

    Specialist getSpecialist(int id);

    void deleteSpecialist(int id);

}
