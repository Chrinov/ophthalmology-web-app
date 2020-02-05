package com.opticus.opticusapp.dao.patient;

import com.opticus.opticusapp.entity.Patient;

import java.util.List;

public interface PatientDAO {

    List<Patient> getPatients();

    void savePatient(Patient patient);


    Patient getPatient(int id);

    void deletePatient(int id);

}
