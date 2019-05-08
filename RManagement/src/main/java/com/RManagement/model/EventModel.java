package com.RManagement.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.Data;

@Data
@Entity
@Table(name = "event")
public class EventModel {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer event_id;
	private String eventName;
//	@Column(name = "PlanStartDateTime")
//	private Date planStart;
	@Column(name = "bookingDate")
//	private Date date;

	@Temporal(TemporalType.DATE)
	private Date date;
	private String roomNo;
}
