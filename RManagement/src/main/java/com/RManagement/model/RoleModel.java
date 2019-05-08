package com.RManagement.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.Data;


@Data
@Entity
@Table(name = "role")
public class RoleModel {
	@Id
	private Integer role_id;
	private String roleName;

	public RoleModel(Integer role_id, String roleName) {
		super();
		this.role_id = role_id;
		this.roleName = roleName;
	}

	public RoleModel() {

	}

}
