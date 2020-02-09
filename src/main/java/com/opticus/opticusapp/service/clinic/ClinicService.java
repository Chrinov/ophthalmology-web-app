package com.opticus.opticusapp.service.clinic;


import com.opticus.opticusapp.entity.clinic.Clinic;

import java.util.List;

public interface ClinicService {

    List<Clinic> getClinics();
    Clinic getClinic(int id);

}
