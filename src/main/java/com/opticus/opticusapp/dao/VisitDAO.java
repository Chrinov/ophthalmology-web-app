package com.opticus.opticusapp.dao;

import com.opticus.opticusapp.entity.Visit;

import java.util.List;

public interface VisitDAO {

    List<Visit> getVisits();

    void saveVisit(Visit visit);

//  void updateVisit(Visit visit);

    Visit getVisit(int id);

    void deleteVisit(int id);

}
