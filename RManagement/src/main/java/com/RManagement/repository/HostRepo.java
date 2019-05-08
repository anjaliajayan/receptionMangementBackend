package com.RManagement.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.RManagement.model.HostModel;

@Repository
public interface HostRepo extends JpaRepository<HostModel, Integer>{
	

}
