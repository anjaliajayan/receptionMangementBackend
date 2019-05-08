package com.RManagement.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.RManagement.model.RoleModel;
import com.RManagement.model.User;

@Repository
public interface RoleRepository extends JpaRepository<RoleModel, Integer> {
	
}
