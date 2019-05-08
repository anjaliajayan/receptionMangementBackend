package com.RManagement.service;

import com.RManagement.dto.HostDataDto;
import com.RManagement.dto.HostDto;

public interface HostService {

	void saveHost(HostDto hostDto);

	HostDataDto getAllHostList();

}
