package com.RManagement.repository;

import java.util.Date;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.RManagement.model.EventModel;



@Repository
public interface EventRepo extends JpaRepository<EventModel, Integer>{

	



	

}
