package com.RManagement.service;

import com.RManagement.dto.EventDataDto;
import com.RManagement.dto.EventDto;

public interface EventService {

	void saveEvent(EventDto eventDto);

	EventDataDto getAllEventsList();



}
