package com.RManagement.dto;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale.Category;

import lombok.Data;

@Data
public class UserVisitorDto {

	private String visitorName;
	private Date planStart;
    private String host; 
    private String category;
    private String events;
 

	
	
	
}
