package com.opticus.opticusapp.service.examination;

import com.opticus.opticusapp.dao.examination.MedicalExaminationDAO;
import com.opticus.opticusapp.entity.examination.MedicalExamination;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class MedicalExaminationServiceImpl implements MedicalExaminationService {

    //inject medicalExamination DAO
    @Autowired
    private MedicalExaminationDAO medicalExaminationDAO;

    @Override
    @Transactional
    public List<MedicalExamination> getMedicalExaminations() {
        return medicalExaminationDAO.getMedicalExaminations();
    }

    @Override
    public MedicalExamination getMedicalExamination(int id) {
        return medicalExaminationDAO.getMedicalExamination(id);
    }

}
