package com.mobiliya.expensemanager.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;


/**
 * The Class CategoryDto.
 *
 * @author Nitin
 */
@JsonInclude(Include.NON_NULL)
public class CategoryDto {
	
	/** The category name. */
	@JsonProperty("categoryName")
	private String categoryName;
	
	/**
	 * Instantiates a new category dto.
	 */
	public CategoryDto() {}
	
	/**
	 * Instantiates a new category dto.
	 *
	 * @param categoryName the category name
	 */
	public CategoryDto(String categoryName) {
		this.categoryName=categoryName;
	}

	/**
	 * Gets the category name.
	 *
	 * @return the category name
	 */
	public String getCategoryName() {
		return categoryName;
	}

	/**
	 * Sets the category name.
	 *
	 * @param categoryName the new category name
	 */
	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}
	
	
}
