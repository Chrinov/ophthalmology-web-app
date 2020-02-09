package com.opticus.opticusapp.dao.clinic;

import com.opticus.opticusapp.entity.clinic.Clinic;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.List;

@Repository
public class ClinicDAOImpl implements ClinicDAO {
    private EntityManager entityManager;


    @Autowired
    public ClinicDAOImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }


    @Override
    public List<Clinic> getClinics() {
        Session currentSession = entityManager.unwrap(Session.class);

        Query<Clinic> theQuery =
                currentSession.createQuery("from Clinic ", Clinic.class);

        List<Clinic> clinics = theQuery.getResultList();

        return clinics;
    }
}
