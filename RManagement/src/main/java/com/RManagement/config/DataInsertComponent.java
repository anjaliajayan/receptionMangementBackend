package com.RManagement.config;

import java.util.ArrayList;

import javax.annotation.PostConstruct;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.RManagement.model.CategoryModel;
import com.RManagement.model.RoleModel;
import com.RManagement.repository.CategoryRepository;
import com.RManagement.repository.RoleRepository;

import lombok.extern.slf4j.Slf4j;


@Slf4j
@Component
public class DataInsertComponent {
	@Autowired
	private RoleRepository roleRepo;
	@Autowired
	private CategoryRepository categoryRepo;
	@PostConstruct
	public void checkDataInRoleTable() {
		ArrayList<RoleModel> list = new ArrayList<>();
	
		if(roleRepo.findAll().isEmpty()){
			
			list.add(new RoleModel(1, "ADMIN"));
			list.add(new RoleModel(2, "RECEPTIONIST"));
			list.add(new RoleModel(3, "HOST"));
			list.add(new RoleModel(4, "VISITOR"));
			log.info("-------list"+list);
			roleRepo.saveAll(list);
		}
		/*
		 * fixed table for roles
		 */
	}
		
	
		@PostConstruct
		public void checkDataInCategoryTable() {
			ArrayList<CategoryModel> list = new ArrayList<>();
			if(categoryRepo.findAll().isEmpty()){
				list.add(new CategoryModel(1,"MEETSTAFF"));
				list.add(new CategoryModel(2,"EVENTS"));
				list.add(new CategoryModel(3,"COURIER"));
				categoryRepo.saveAll(list);
				
				
			}
			/*
			 * fixed table for category
			 */
		
		
		}
}
