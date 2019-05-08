package com.RManagement.model;


import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.Data;
@Data
@Entity
@Table(name="reception")
public class ReceptionModel {
	
	@Id
	@GeneratedValue(strategy =GenerationType.AUTO)
	@Column(name="rec_id")
	private Integer rec_id;
	private String receptionist;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "user_id", nullable = false)
	 private User user;
	   
}
