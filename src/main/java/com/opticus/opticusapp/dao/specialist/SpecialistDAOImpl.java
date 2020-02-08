package com.opticus.opticusapp.dao.specialist;

import com.opticus.opticusapp.entity.user.Specialist;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.List;

@Repository
public class SpecialistDAOImpl implements SpecialistDAO {


    private EntityManager entityManager;


    @Autowired
    public SpecialistDAOImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }


    @Override
    public List<Specialist> getSpecialists() {
        Session currentSession = entityManager.unwrap(Session.class);

        Query<Specialist> theQuery = currentSession.createQuery("from Specialist order by lastName", Specialist.class);

        List<Specialist> specialists = theQuery.getResultList();

        return specialists;
    }


    @Override
    public void saveSpecialist(Specialist specialist) {

        Session currentSession = entityManager.unwrap(Session.class);

        currentSession.saveOrUpdate(specialist);

    }

    @Override
    public Specialist getSpecialist(int id) {
        Session currentSession = entityManager.unwrap(Session.class);

        Specialist specialist = currentSession.get(Specialist.class, id);

        return specialist;
    }

    @Override
    public void deleteSpecialist(int id) {
        Session currentSession = entityManager.unwrap(Session.class);

        Specialist specialist = currentSession.get(Specialist.class, id);

        Query theQuery = currentSession.createQuery("delete from Specialist where id=:specialistId");
        theQuery.setParameter("specialistId", id);

        theQuery.executeUpdate();

    }


}
