package com.RManagement.serviceImpl;



import javax.transaction.Transactional;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import com.RManagement.dto.ReceptionDto;
import com.RManagement.model.ReceptionModel;
import com.RManagement.model.User;
import com.RManagement.repository.ReceptionRepo;
import com.RManagement.repository.UserRepo;
import com.RManagement.service.ReceptionService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class ReceptionServiceImpl implements ReceptionService {

	@Autowired
	private ReceptionRepo receptionRepo;
	@Autowired
	private UserRepo userRepo;
	@Autowired
	private BCryptPasswordEncoder encoder;

	@Override
	@Transactional
	public void saveReceptionDetails(ReceptionDto receptionDTO) {
		User user = new User();
		ReceptionModel receptionModel = new ReceptionModel();

		BeanUtils.copyProperties(receptionDTO, user);// source,destination
		user.setPassword(encoder.encode(user.getPassword()));
		user.setRole_id(2);
		user.setRole("receptionist");
		userRepo.save(user);
		BeanUtils.copyProperties(receptionDTO, receptionModel);// source,destination
		
		receptionModel.setUser(user);
		log.info("-------------------->" + receptionModel);
		receptionRepo.save(receptionModel);

	}


}																					
