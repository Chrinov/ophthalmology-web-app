package com.opticus.opticusapp.dao.examination;

import com.opticus.opticusapp.entity.examination.MedicalExamination;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.List;

@Repository
public class MedicalExaminationDAOImpl implements MedicalExaminationDAO {


    private EntityManager entityManager;


    @Autowired
    public MedicalExaminationDAOImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }


    @Override
    public List<MedicalExamination> getMedicalExaminations() {
        Session currentSession = entityManager.unwrap(Session.class);

        Query<MedicalExamination> theQuery =
                currentSession.createQuery("from MedicalExamination ", MedicalExamination.class);

        List<MedicalExamination> medicalExaminations = theQuery.getResultList();

        return medicalExaminations;
    }

    @Override
    public MedicalExamination getMedicalExamination(int id) {
        Session currentSession = entityManager.unwrap(Session.class);

        MedicalExamination medicalExamination = currentSession.get(MedicalExamination.class, id);

        return medicalExamination;
    }
}
