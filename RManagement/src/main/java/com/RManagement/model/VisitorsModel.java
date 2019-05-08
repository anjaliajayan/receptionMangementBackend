package com.RManagement.model;

import java.util.Date;
import javax.persistence.CascadeType;
import javax.persistence.Column;
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
@Table(name="visitors")
public class VisitorsModel {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer visitorId;
	private String visitorName;
	@Column(name = "PlanStartDateTime")
	private Date planStart;
	private String mobileNo;
//	private Integer categoryId;
//	private Integer eventId;
//    private Integer hostId;
    private String category;
    private String events;
    private String host;
    
    
    @JsonProperty(access = Access.WRITE_ONLY)
    @OneToOne(fetch = FetchType.LAZY,  cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id", nullable = false)
     private User user;
}
