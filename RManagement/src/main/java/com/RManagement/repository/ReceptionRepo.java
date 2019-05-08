package com.RManagement.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.RManagement.model.ReceptionModel;


@Repository
public interface ReceptionRepo extends JpaRepository<ReceptionModel, Integer> {
	
}
