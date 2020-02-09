package com.opticus.opticusapp.dao.clinic;

import com.opticus.opticusapp.entity.clinic.Clinic;

import java.util.List;

public interface ClinicDAO {
    List<Clinic> getClinics();

    Clinic getClinic(int id);
}
