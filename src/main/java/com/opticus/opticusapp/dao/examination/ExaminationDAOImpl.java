//package com.opticus.opticusapp.dao.examination;
//
//import com.opticus.opticusapp.entity.examination.Examination;
//import org.hibernate.Session;
//import org.hibernate.query.Query;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Repository;
//
//import javax.persistence.EntityManager;
//import java.util.List;
//
//@Repository
//public class ExaminationDAOImpl implements ExaminationDAO {
//
//
//
//    private EntityManager entityManager;
//
//
//    @Autowired
//    public ExaminationDAOImpl(EntityManager entityManager) {
//        this.entityManager = entityManager;
//    }
//
//
//    @Override
//    public List<Examination> getExaminations() {
//        Session currentSession = entityManager.unwrap(Session.class);
//
//        Query<Examination> theQuery =
//                currentSession.createQuery("from Examination",
//                        Examination.class);
//
//        List<Examination> examinations = theQuery.getResultList();
//
//        return examinations;
//    }
//
//
//    @Override
//    public void saveExamination(Examination examination) {
//
//        Session currentSession = entityManager.unwrap(Session.class);
//
//        currentSession.saveOrUpdate(examination);
//
//    }
//
//    @Override
//    public Examination getExamination(int id) {
//        Session currentSession = entityManager.unwrap(Session.class);
//
//        Examination examination = currentSession.get(Examination.class, id);
//
//        return examination;
//    }
//
//    @Override
//    public void deleteExamination(int id) {
//        Session currentSession = entityManager.unwrap(Session.class);
//
//
//        Query theQuery =
//                currentSession.createQuery("delete from Examination where id=:examinationId");
//        theQuery.setParameter("examinationId", id);
//
//        theQuery.executeUpdate();
//
//    }
//}
