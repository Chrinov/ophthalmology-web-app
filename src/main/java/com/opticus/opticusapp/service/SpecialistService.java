package com.opticus.opticusapp.service;

import com.opticus.opticusapp.entity.user.Specialist;

import java.util.List;

public interface SpecialistService {

    List<Specialist> getSpecialists();

    void saveSpecialist(Specialist specialist);

    Specialist getSpecialist(int id);

    void deleteSpecialist(int id);

}
