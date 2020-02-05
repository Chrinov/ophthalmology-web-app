package com.opticus.opticusapp.service;

import com.opticus.opticusapp.entity.Specialist;

import java.util.List;

public interface DoctorService {

    List<Specialist> getDoctors();

    void saveDoctor(Specialist specialist);

    Specialist getDoctor(int id);

    void deleteDoctor(int id);

}
