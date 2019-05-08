package com.RManagement.controller;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.RManagement.dto.EventDataDto;
import com.RManagement.dto.EventDetail;
import com.RManagement.dto.EventDto;
import com.RManagement.dto.HostDataDto;
import com.RManagement.dto.HostDto;
import com.RManagement.dto.Message;
import com.RManagement.dto.MonthlyCountDto;
import com.RManagement.dto.ReceptionDto;
import com.RManagement.dto.UsersDto;
import com.RManagement.dto.VisitorCountDto;
import com.RManagement.dto.VisitorDto;
import com.RManagement.dto.VisitorsDataDto;
import com.RManagement.service.EventService;
import com.RManagement.service.HostService;
import com.RManagement.service.ReceptionService;
import com.RManagement.service.UserService;
import com.RManagement.service.VisitorService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping("/go")
public class UserController<JSONObject> {

	@Autowired
	private UserService userService;

	@Autowired
	private ReceptionService receptionService;

	@Autowired
	private EventService eventService;

	@Autowired
	private HostService hostService;

	@Autowired
	private VisitorService visitorService;


	@PostMapping("/adminRegister")
	public Message adminReg(@RequestBody UsersDto usersDTO) {
	userService.saveUserDetails(usersDTO);
	Message obj=new Message();
	obj.setResponse("success");
	obj.setMessage("admin registered");

		return obj;

	}

	@PostMapping("/reception")
	public Message receptionReg(@RequestBody ReceptionDto receptionDTO) {
		receptionService.saveReceptionDetails(receptionDTO);
		Message obj=new Message();
		obj.setResponse("success");
		obj.setMessage("receptionist registered");

			return obj;

	}

	@PostMapping("/events")
	public Message eventReg(@RequestBody EventDto eventDto) {
		eventService.saveEvent(eventDto);
		Message obj=new Message();
		obj.setResponse("success");
		obj.setMessage("event registered");
			return obj;

	}

	@PostMapping("/host")
	public Message hostReg(@RequestBody HostDto hostDto) {
		hostService.saveHost(hostDto);
		Message obj=new Message();
		obj.setResponse("success");
		obj.setMessage("host registered");

			return obj;
	}

@PostMapping("/visitors")
	public Message visitorReg(@RequestBody VisitorDto visitorDto) {
		visitorService.saveHost(visitorDto);
		Message obj=new Message();
		obj.setResponse("success");
		obj.setMessage("visitor registered");

			return obj;

	}

	@GetMapping("/monthlyCategory/{start}/{end}")
	public MonthlyCountDto getAllCategory(@PathVariable String start, @PathVariable String end) {
		log.info("start"+start +end);
		MonthlyCountDto getCategory = visitorService.monthlycategory(start, end);
		return getCategory;

	}
	
	@GetMapping("/listAllVisitors")
	public VisitorsDataDto getAllData() {
		VisitorsDataDto getAllVisitors = visitorService.getAll();
		return getAllVisitors;
		
	}
	
	@GetMapping("/listAllEvents")
	public EventDataDto getAllEvents() {
		EventDataDto getAllEventsList=eventService.getAllEventsList();
		return getAllEventsList;
	}
	
	@GetMapping("/listAllHost")
	public HostDataDto getAllHost() {
		HostDataDto getAllHostList=hostService.getAllHostList();
		return getAllHostList;
	}
	
	@GetMapping("/count/{start}/{end}")
	public VisitorCountDto getVisitorCount(@PathVariable String start, @PathVariable String end) {
		VisitorCountDto getCountOf=visitorService.getCountVisitors(start,end);
		return getCountOf;
	}

		

}
