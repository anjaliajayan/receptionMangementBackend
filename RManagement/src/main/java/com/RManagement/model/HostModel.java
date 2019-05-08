package com.RManagement.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

import lombok.Data;
@Data
@Entity
@Table(name="host")
public class HostModel {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer hostId;
	private String hostName;
	private String empId;
	private String designation;
	private String department;
	private String mobileNo;
	
	 @JsonProperty(access = Access.WRITE_ONLY)
	 @OneToOne(fetch = FetchType.LAZY,  cascade = CascadeType.ALL)
	@JoinColumn(name = "user_id", nullable = false)
     private User user;



}
