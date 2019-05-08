package com.RManagement.repository;



import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.RManagement.dto.UserVisitorDto;
import com.RManagement.dto.VisitorDto;
import com.RManagement.model.VisitorsModel;

@Repository
public interface VisitorRepo extends JpaRepository<VisitorsModel, Integer>{

public List<VisitorsModel> findByPlanStartBetween(Date start,Date end);


//public List<VisitorsModel> findByPlanStart();



}
