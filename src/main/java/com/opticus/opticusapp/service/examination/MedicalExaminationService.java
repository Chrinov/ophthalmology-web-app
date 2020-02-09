package com.opticus.opticusapp.service.examination;




import com.opticus.opticusapp.entity.examination.MedicalExamination;

import java.util.List;

public interface MedicalExaminationService {

    List<MedicalExamination> getMedicalExaminations();
    MedicalExamination getMedicalExamination(int id);

}
