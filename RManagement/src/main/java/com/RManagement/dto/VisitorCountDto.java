package com.RManagement.dto;

import java.util.Map;

import lombok.Data;

@Data
public class VisitorCountDto {
	
	private Map<String, Long> countVisit;
}
