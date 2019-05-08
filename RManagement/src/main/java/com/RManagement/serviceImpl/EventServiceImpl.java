package com.RManagement.serviceImpl;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.RManagement.dto.EventDataDto;
import com.RManagement.dto.EventDto;
import com.RManagement.dto.VisitorsDataDto;
import com.RManagement.model.EventModel;
import com.RManagement.model.VisitorsModel;
import com.RManagement.repository.EventRepo;
import com.RManagement.service.EventService;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class EventServiceImpl implements EventService {

	@Autowired
	private EventRepo eventRepo;

	@Override
	public void saveEvent(EventDto eventDto) {

		EventModel eventModel = new EventModel();
		BeanUtils.copyProperties(eventDto, eventModel);// source,destination
		log.info("-------------------->" + eventModel);
//		eventModel.setPlanStart(new Date());
		eventRepo.save(eventModel);

	}

	@Override
	public EventDataDto getAllEventsList() {

		EventDataDto eventDataDto=new EventDataDto();
		List<EventModel> eventsList = null;
		eventsList=eventRepo.findAll();
		eventDataDto.setResponse("success");
		eventDataDto.setEventsList(eventsList);
		
		log.info("eventDataDto...."+eventDataDto);
		return eventDataDto;
	}

}
