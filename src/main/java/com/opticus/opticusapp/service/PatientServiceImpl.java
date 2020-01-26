package com.opticus.opticusapp.service;

import com.opticus.opticusapp.dao.PatientDAO;
import com.opticus.opticusapp.entity.Patient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service

public class PatientServiceImpl implements PatientService {

    //inject patient DAO
    @Autowired
    private PatientDAO patientDAO;

    @Override
    @Transactional
    public List<Patient> getPatients() {
        return patientDAO.getPatients();
    }

    @Override
    @Transactional
    public void savePatient(Patient patient) {
        patientDAO.savePatient(patient);
    }

    @Override
    @Transactional
    public Patient getPatient(int id) {
        return patientDAO.getPatient(id);
    }

    @Override
    @Transactional
    public void deletePatient(int id) {
        patientDAO.deletePatient(id);
    }
}
