package com.RManagement.serviceImpl;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.RManagement.dto.HostDataDto;
import com.RManagement.dto.HostDto;
import com.RManagement.model.HostModel;
import com.RManagement.model.User;
import com.RManagement.model.VisitorsModel;
import com.RManagement.repository.HostRepo;
import com.RManagement.repository.UserRepo;
import com.RManagement.service.HostService;

import lombok.extern.slf4j.Slf4j;
@Slf4j
@Service
public class HostServiceImpl implements HostService{
	
	@Autowired
	private HostRepo hostRepo;
	
	@Autowired
	private UserRepo userRepo;
	
	@Autowired
	private BCryptPasswordEncoder encoder;
	
	@Override
	public void saveHost(HostDto hostDto) {
		User user = new User();
		HostModel hostModel = new HostModel();
		
		BeanUtils.copyProperties(hostDto, user);
		user.setPassword(encoder.encode(user.getPassword()));
		
		user.setRole_id(3);
		user.setRole("host");
		userRepo.save(user);
		
		BeanUtils.copyProperties(hostDto, hostModel);
		hostModel.setUser(user);
		log.info("----hostmodel-->"+hostModel);
		hostRepo.save(hostModel);
		
	}

	@Override
	public HostDataDto getAllHostList() {
		HostDataDto hostDataDto=new HostDataDto()  ;
		List<HostModel> hostList = null;
		hostList=hostRepo.findAll();
		hostDataDto.setResponse("success");
		hostDataDto.setHostList(hostList);
		
		return hostDataDto;
		
		
	
	}

}
