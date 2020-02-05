package com.opticus.opticusapp.dao.specialist;

import com.opticus.opticusapp.entity.Specialist;

import java.util.List;

public interface SpecialistDAO {

    List<Specialist> getDoctors();

    void saveDoctor(Specialist specialist);

    //void updateDoctor(Specialist doctor);

    Specialist getDoctor(int id);

    void deleteDoctor(int id);

}
