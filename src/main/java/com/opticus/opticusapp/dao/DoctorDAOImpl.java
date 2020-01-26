package com.opticus.opticusapp.dao;

import com.opticus.opticusapp.entity.Doctor;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.List;

@Repository
public class DoctorDAOImpl implements DoctorDAO {


    private EntityManager entityManager;


    @Autowired
    public DoctorDAOImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }


    @Override
    public List<Doctor> getDoctors() {
        Session currentSession = entityManager.unwrap(Session.class);

        Query<Doctor> theQuery = currentSession.createQuery("from Doctor order by lastName", Doctor.class);

        List<Doctor> doctors = theQuery.getResultList();

        return doctors;
    }


    @Override
    public void saveDoctor(Doctor doctor) {

        Session currentSession = entityManager.unwrap(Session.class);

        currentSession.saveOrUpdate(doctor);

    }

    @Override
    public Doctor getDoctor(int id) {
        Session currentSession = entityManager.unwrap(Session.class);

        Doctor doctor = currentSession.get(Doctor.class, id);

        return doctor;
    }

    @Override
    public void deleteDoctor(int id) {
        Session currentSession = entityManager.unwrap(Session.class);

        Doctor doctor = currentSession.get(Doctor.class, id);

        Query theQuery = currentSession.createQuery("delete from Doctor where id=:doctorId");
        theQuery.setParameter("doctorId", id);

        theQuery.executeUpdate();

    }


}
