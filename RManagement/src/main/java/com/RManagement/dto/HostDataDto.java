package com.RManagement.dto;

import java.util.List;

import com.RManagement.model.HostModel;

import lombok.Data;


@Data
public class HostDataDto {
	private String response;
	private List<HostModel> hostList;
}
