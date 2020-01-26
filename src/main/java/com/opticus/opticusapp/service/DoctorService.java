package com.opticus.opticusapp.service;

import com.opticus.opticusapp.entity.Doctor;

import java.util.List;

public interface DoctorService {

    List<Doctor> getDoctors();

    void saveDoctor(Doctor doctor);

    Doctor getDoctor(int id);

    void deleteDoctor(int id);

}
