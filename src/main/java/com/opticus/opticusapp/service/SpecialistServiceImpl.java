package com.opticus.opticusapp.service;

import com.opticus.opticusapp.dao.specialist.SpecialistDAO;
import com.opticus.opticusapp.entity.user.Specialist;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service

public class SpecialistServiceImpl implements SpecialistService {

    //inject specialist DAO
    @Autowired
    private SpecialistDAO specialistDAO;

    @Override
    @Transactional
    public List<Specialist> getSpecialists() {
        return specialistDAO.getSpecialists();
    }

    @Override
    @Transactional
    public void saveSpecialist(Specialist specialist) {
        specialistDAO.saveSpecialist(specialist);
    }

    @Override
    @Transactional
    public Specialist getSpecialist(int id) {
        return specialistDAO.getSpecialist(id);
    }

    @Override
    @Transactional
    public void deleteSpecialist(int id) {
        specialistDAO.deleteSpecialist(id);
    }
}
