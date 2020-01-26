package com.opticus.opticusapp.dao;


import com.opticus.opticusapp.entity.Patient;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.List;

@Repository
public class PatientDAOImpl implements PatientDAO {


    private EntityManager entityManager;


    @Autowired
    public PatientDAOImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }


    @Override
    public List<Patient> getPatients() {
        Session currentSession = entityManager.unwrap(Session.class);

        Query<Patient> theQuery =
                currentSession.createQuery("from Patient order by lastName",
                        Patient.class);

        List<Patient> patients = theQuery.getResultList();

        return patients;
    }


    @Override
    public void savePatient(Patient note) {

        Session currentSession = entityManager.unwrap(Session.class);

        currentSession.saveOrUpdate(note);

    }

    @Override
    public Patient getPatient(int id) {
        Session currentSession = entityManager.unwrap(Session.class);

        Patient note = currentSession.get(Patient.class, id);

        return note;
    }

    @Override
    public void deletePatient(int id) {
        Session currentSession = entityManager.unwrap(Session.class);


        Query theQuery =
                currentSession.createQuery("delete from Patient where id=:patientId");
        theQuery.setParameter("patientId", id);

        theQuery.executeUpdate();

    }


}
