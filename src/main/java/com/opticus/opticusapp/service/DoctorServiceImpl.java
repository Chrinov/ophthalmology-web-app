package com.opticus.opticusapp.service;

import com.opticus.opticusapp.dao.DoctorDAO;
import com.opticus.opticusapp.entity.Doctor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service

public class DoctorServiceImpl implements DoctorService {

    //inject doctor DAO
    @Autowired
    private DoctorDAO doctorDAO;

    @Override
    @Transactional
    public List<Doctor> getDoctors() {
        return doctorDAO.getDoctors();
    }

    @Override
    @Transactional
    public void saveDoctor(Doctor doctor) {
        doctorDAO.saveDoctor(doctor);
    }

    @Override
    @Transactional
    public Doctor getDoctor(int id) {
        return doctorDAO.getDoctor(id);
    }

    @Override
    @Transactional
    public void deleteDoctor(int id) {
        doctorDAO.deleteDoctor(id);
    }
}
