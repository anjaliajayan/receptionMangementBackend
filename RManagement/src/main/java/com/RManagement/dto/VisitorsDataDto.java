package com.RManagement.dto;

import java.util.List;

import com.RManagement.model.VisitorsModel;

import lombok.Data;
@Data
public class VisitorsDataDto {
	private String response;
	private List<VisitorsModel> visitorsList;
	


}
