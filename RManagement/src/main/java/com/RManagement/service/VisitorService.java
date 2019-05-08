package com.RManagement.service;

import com.RManagement.dto.MonthlyCountDto;
import com.RManagement.dto.VisitorCountDto;
import com.RManagement.dto.VisitorDto;
import com.RManagement.dto.VisitorsDataDto;



public interface VisitorService {

	void saveHost(VisitorDto visitorDto);

	public MonthlyCountDto monthlycategory(String start, String end);

	VisitorsDataDto getAll();

	public	VisitorCountDto getCountVisitors(String start, String end);










}
