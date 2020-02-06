package com.opticus.opticusapp.service;

import com.opticus.opticusapp.dao.specialist.SpecialistDAO;
import com.opticus.opticusapp.entity.user.Specialist;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service

public class DoctorServiceImpl implements DoctorService {

    //inject doctor DAO
    @Autowired
    private SpecialistDAO specialistDAO;

    @Override
    @Transactional
    public List<Specialist> getDoctors() {
        return specialistDAO.getDoctors();
    }

    @Override
    @Transactional
    public void saveDoctor(Specialist specialist) {
        specialistDAO.saveDoctor(specialist);
    }

    @Override
    @Transactional
    public Specialist getDoctor(int id) {
        return specialistDAO.getDoctor(id);
    }

    @Override
    @Transactional
    public void deleteDoctor(int id) {
        specialistDAO.deleteDoctor(id);
    }
}
