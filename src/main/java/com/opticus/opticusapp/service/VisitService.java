package com.opticus.opticusapp.service;

import com.opticus.opticusapp.entity.Visit;

import java.util.List;

public interface VisitService {

    List<Visit> getVisits();

    void saveVisit(Visit visit);

    Visit getVisit(int id);

    void deleteVisit(int id);


}
