package com.RManagement.dto;

import java.util.List;
import java.util.Map;

import lombok.Data;
@Data
public class MonthlyCountDto {

	private Map<String, Long> countedEvents;
	private Map<String, Long> countCategorys;
	private Map<String, Long> countVisitors;
	private List<UserVisitorDto> collect;
	
}
