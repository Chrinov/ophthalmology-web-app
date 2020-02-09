package com.opticus.opticusapp.dao.examination;

import com.opticus.opticusapp.entity.examination.MedicalExamination;

import java.util.List;

public interface MedicalExaminationDAO {

    List<MedicalExamination> getMedicalExaminations();

    MedicalExamination getMedicalExamination(int id);

}
