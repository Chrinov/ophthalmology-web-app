package com.opticus.opticusapp.dao;


import com.opticus.opticusapp.entity.Visit;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.List;

@Repository
public class VisitDAOImpl implements VisitDAO {


    private EntityManager entityManager;


    @Autowired
    public VisitDAOImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }


    @Override
    public List<Visit> getVisits() {
        Session currentSession = entityManager.unwrap(Session.class);

        Query<Visit> theQuery =
                currentSession.createQuery("from Visit order by date",
                        Visit.class);

        List<Visit> visits = theQuery.getResultList();

        return visits;
    }


    @Override
    public void saveVisit(Visit visit) {

        Session currentSession = entityManager.unwrap(Session.class);

        currentSession.saveOrUpdate(visit);

    }

    @Override
    public Visit getVisit(int id) {
        Session currentSession = entityManager.unwrap(Session.class);

        Visit visit = currentSession.get(Visit.class, id);

        return visit;
    }

    @Override
    public void deleteVisit(int id) {
        Session currentSession = entityManager.unwrap(Session.class);


        Query theQuery =
                currentSession.createQuery("delete from Visit where id=:visitId");
        theQuery.setParameter("visitId", id);

        theQuery.executeUpdate();

    }


}
