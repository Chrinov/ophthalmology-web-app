package com.opticus.opticusapp.dao.specialist;

import com.opticus.opticusapp.entity.user.Specialist;

import java.util.List;

public interface SpecialistDAO {

    List<Specialist> getDoctors();

    void saveDoctor(Specialist specialist);

    //void updateDoctor(specialist doctor);

    Specialist getDoctor(int id);

    void deleteDoctor(int id);

}
