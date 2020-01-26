package com.opticus.opticusapp.service;

import com.opticus.opticusapp.entity.Patient;

import java.util.List;

public interface PatientService {

    List<Patient> getPatients();

    void savePatient(Patient patient);

    Patient getPatient(int id);

    void deletePatient(int id);


}
