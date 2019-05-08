package com.RManagement.serviceImpl;

import java.util.Arrays;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.RManagement.dto.UsersDto;

import com.RManagement.model.User;
import com.RManagement.repository.UserRepo;
import com.RManagement.service.UserService;

import lombok.extern.slf4j.Slf4j;

@Slf4j

@Service(value = "userService")
public class UserServiceImpl implements UserDetailsService, UserService {
	@Autowired
	private UserRepo userRepo;

	@Autowired
	private BCryptPasswordEncoder encoder;

	@Override
	@Transactional
	public void saveUserDetails(UsersDto usersDTO) {
	
		User user = new User();
		BeanUtils.copyProperties(usersDTO, user);// source,destination
		user.setPassword(encoder.encode(user.getPassword()));
		user.setRole_id(1);
		user.setRole("admin");
		log.info("in save user details..."+user);
		userRepo.save(user);

	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User user = userRepo.findByUsername(username);
		log.info(username);
		log.info("User Is ------->" + user);
		if (user == null) {
			throw new UsernameNotFoundException("Invalid username or password.");
		}
		return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(),
			
				getAuthority(user.getRole(),user.getRole_id()));
	}

	private List<SimpleGrantedAuthority> getAuthority(String role,Integer roleId) {
		log.info("roless........."+role);
		log.info("roleId..."+roleId);
		return Arrays.asList(new SimpleGrantedAuthority(role));
	}

}
