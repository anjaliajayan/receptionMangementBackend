package com.RManagement.dto;

import java.util.Date;



import lombok.Data;
@Data
public class VisitorDto {
	private Integer visitorId;
	private String visitorName;
	private String username;
	private String password;
	private Date planStart;
	private String mobileNo;
//	private Integer categoryId;
//	private Integer eventId;
//    private Integer hostId;
    private String category;
    private String events;
    private String host;
}
