package com.RManagement.dto;

import java.util.List;

import com.RManagement.model.EventModel;

import lombok.Data;


@Data
public class EventDataDto {
	private String response;
	private List<EventModel> eventsList;
}
