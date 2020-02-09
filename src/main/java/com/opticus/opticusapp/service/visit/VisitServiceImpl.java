package com.opticus.opticusapp.service.visit;

import com.opticus.opticusapp.dao.visit.VisitDAO;
import com.opticus.opticusapp.entity.visit.Visit;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service

public class VisitServiceImpl implements VisitService {

    //inject visit DAO
    @Autowired
    private VisitDAO visitDAO;

    @Override
    @Transactional
    public List<Visit> getVisits() {
        return visitDAO.getVisits();
    }

    @Override
    @Transactional
    public void saveVisit(Visit visit) {
        visitDAO.saveVisit(visit);
    }

    @Override
    @Transactional
    public Visit getVisit(int id) {
        return visitDAO.getVisit(id);
    }

    @Override
    @Transactional
    public void deleteVisit(int id) {
        visitDAO.deleteVisit(id);
    }
}
