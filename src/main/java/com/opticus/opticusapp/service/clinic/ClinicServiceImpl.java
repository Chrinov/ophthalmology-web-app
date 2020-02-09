package com.opticus.opticusapp.service.clinic;

import com.opticus.opticusapp.dao.clinic.ClinicDAO;
import com.opticus.opticusapp.entity.clinic.Clinic;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ClinicServiceImpl implements ClinicService {

    //inject clinic DAO
    @Autowired
    private ClinicDAO clinicDAO;

    @Override
    @Transactional
    public List<Clinic> getClinics() {
        return clinicDAO.getClinics();
    }

}
