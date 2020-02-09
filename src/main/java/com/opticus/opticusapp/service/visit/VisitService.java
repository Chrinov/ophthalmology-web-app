package com.opticus.opticusapp.service.visit;

import com.opticus.opticusapp.entity.visit.Visit;

import java.util.List;

public interface VisitService {

    List<Visit> getVisits();

    void saveVisit(Visit visit);

    Visit getVisit(int id);

    void deleteVisit(int id);


}
