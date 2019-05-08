package com.RManagement.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.Data;
@Data
@Entity
@Table(name="category")
public class CategoryModel {
	
	@Id
	private Integer categoryId;
	private String categoryName;
	public CategoryModel(Integer categoryId, String categoryName) {
		super();
		this.categoryId = categoryId;
		this.categoryName = categoryName;
	}
	
	public CategoryModel() {
	
	}
}
