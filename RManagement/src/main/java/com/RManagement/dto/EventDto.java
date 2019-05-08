package com.RManagement.dto;


import java.util.Date;

import lombok.Data;

@Data
public class EventDto {

    private Integer event_id;
	private String eventName;
	private Date date;
	private String roomNo;
}
