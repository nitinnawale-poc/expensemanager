package com.mobiliya.expensemanager.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonInclude(Include.NON_NULL)
public class CategoryDto {
	@JsonProperty("categoryName")
	private String categoryName;
	
	public CategoryDto() {}
	
	public CategoryDto(String categoryName) {
		this.categoryName=categoryName;
	}

	public String getCategoryName() {
		return categoryName;
	}

	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}
	
	
}
