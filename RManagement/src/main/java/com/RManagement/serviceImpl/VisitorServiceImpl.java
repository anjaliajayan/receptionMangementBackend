package com.RManagement.serviceImpl;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import com.RManagement.dto.MonthlyCountDto;
import com.RManagement.dto.UserVisitorDto;
import com.RManagement.dto.VisitorCountDto;
import com.RManagement.dto.VisitorDto;
import com.RManagement.dto.VisitorsDataDto;
import com.RManagement.model.User;
import com.RManagement.model.VisitorsModel;
import com.RManagement.repository.UserRepo;
import com.RManagement.repository.VisitorRepo;
import com.RManagement.service.VisitorService;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class VisitorServiceImpl implements VisitorService {

	@Autowired
	private VisitorRepo visitorRepo;

	@Autowired
	private UserRepo userRepo;
	@Autowired
	private BCryptPasswordEncoder encoder;

	@Override
	public void saveHost(VisitorDto visitorDto) {
		User user = new User();
		VisitorsModel visitorModel = new VisitorsModel();

		BeanUtils.copyProperties(visitorDto, user);// source,destination
		user.setPassword(encoder.encode(user.getPassword()));
		user.setRole_id(4);
		user.setRole("visitor");
		userRepo.save(user);

		BeanUtils.copyProperties(visitorDto, visitorModel);// source,destination
		visitorModel.setUser(user);

		visitorModel.setPlanStart(new Date());// set current date and time

		visitorRepo.save(visitorModel);

	}

	@Override
	public MonthlyCountDto monthlycategory(String start, String end) {

		UserVisitorDto userVisitorDto = new UserVisitorDto();
		MonthlyCountDto monthlyCountDto = new MonthlyCountDto();

		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		List<VisitorsModel> categoryList = null;
		List<UserVisitorDto> collect = null;
		try {
			Date startDate = formatter.parse(start);
			Date endDate = formatter.parse(end);
			categoryList = visitorRepo.findByPlanStartBetween(startDate, endDate);
			log.info("categoryyyy..."+categoryList.size());
			collect = categoryList.stream().map(this::vistorConverter).collect(Collectors.toList());
			BeanUtils.copyProperties(categoryList, userVisitorDto);// source,destination

		} catch (ParseException e) {

			e.printStackTrace();
		}
		/*
		 * Group by the name + Count
		 */

		Map<String, Long> countedEvents = collect.stream()
				.collect(Collectors.groupingBy(UserVisitorDto::getEvents, Collectors.counting()));
		Map<String, Long> countCategorys = collect.stream()
				.collect(Collectors.groupingBy(UserVisitorDto::getCategory, Collectors.counting()));
		Map<String, Long> countVisitors = collect.stream()
				.collect(Collectors.groupingBy(UserVisitorDto::getVisitorName, Collectors.counting()));
		/*
		 * created a new MonthlyCountDto and set values and retrun it
		 * 
		 */
		monthlyCountDto.setCollect(collect);
		monthlyCountDto.setCountCategorys(countCategorys);
		monthlyCountDto.setCountedEvents(countedEvents);
		monthlyCountDto.setCountVisitors(countVisitors);
		return monthlyCountDto;

	}

	UserVisitorDto vistorConverter(VisitorsModel model) {
		log.info("model ----UserVisitorDto-------->" + model);

		UserVisitorDto userVisitorDto = new UserVisitorDto();
		userVisitorDto.setCategory(model.getCategory());
		userVisitorDto.setVisitorName(model.getVisitorName());
		userVisitorDto.setEvents(model.getEvents());
		userVisitorDto.setHost(model.getHost());
		userVisitorDto.setPlanStart(model.getPlanStart());
		log.info("userVisitorDto ------------>" + userVisitorDto);
		return userVisitorDto;

	}

	@Override
	public VisitorsDataDto getAll() {
		VisitorsDataDto visitorsDataDto=new VisitorsDataDto();
		List<VisitorsModel> visitorsList = null;
		visitorsList=visitorRepo.findAll();
		visitorsDataDto.setResponse("success");
		visitorsDataDto.setVisitorsList(visitorsList);
		
		log.info("visitorsDataDto...."+visitorsDataDto);
		return visitorsDataDto;
	}

	@Override
	public VisitorCountDto getCountVisitors(String start, String end) {

		VisitorCountDto vCountDto = new VisitorCountDto();
		List<VisitorsModel> categoryList = null;
		List<UserVisitorDto> collect = null;
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		try {
		Date startDate = formatter.parse(start);
		Date endDate = formatter.parse(end);
		categoryList = visitorRepo.findByPlanStartBetween(startDate, endDate);
		log.info("categoryyyy..."+categoryList.size());
		collect = categoryList.stream().map(this::vistorConverter).collect(Collectors.toList());
		}
		catch (ParseException e) {

			e.printStackTrace();
		}
		Map<String, Long> countVisit = collect.stream()
				.collect(Collectors.groupingBy(UserVisitorDto::getVisitorName, Collectors.counting()));
		
		vCountDto.setCountVisit(countVisit);
		return vCountDto;
	
	}


	  
}
