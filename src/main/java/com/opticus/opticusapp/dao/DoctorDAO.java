package com.opticus.opticusapp.dao;

import com.opticus.opticusapp.entity.Doctor;

import java.util.List;

public interface DoctorDAO {

    List<Doctor> getDoctors();

    void saveDoctor(Doctor doctor);

    //void updateDoctor(Doctor doctor);

    Doctor getDoctor(int id);

    void deleteDoctor(int id);

}
