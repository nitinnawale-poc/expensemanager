package com.mobiliya.expensemanager.dto;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * The Class ExpenseDto.
 *
 * @author Nitin
 */
@JsonInclude(Include.NON_NULL)
public class ExpenseDto {
	
	/** The expense title. */
	@JsonProperty("expenseTitle")
	private String expenseTitle;
	
	/** The category. */
	@JsonProperty("category")
	private CategoryDto category;
	
	/** The amount. */
	@JsonProperty("amount")
	private double amount;
	
	/** The date. */
	@JsonProperty("date")
	private Date date;

	/**
	 * Instantiates a new expense dto.
	 */
	public ExpenseDto() {}
	
	/**
	 * Instantiates a new expense dto.
	 *
	 * @param expenseTitle the expense title
	 * @param category the category
	 * @param amount the amount
	 * @param date the date
	 */
	public ExpenseDto(String expenseTitle, CategoryDto category, double amount, Date date) {
		this.expenseTitle = expenseTitle;
		this.category = category;
		this.amount = amount;
		this.date = date;
	}

	/**
	 * Gets the expense title.
	 *
	 * @return the expense title
	 */
	public String getExpenseTitle() {
		return expenseTitle;
	}

	/**
	 * Sets the expense title.
	 *
	 * @param expenseTitle the new expense title
	 */
	public void setExpenseTitle(String expenseTitle) {
		this.expenseTitle = expenseTitle;
	}

	/**
	 * Gets the category.
	 *
	 * @return the category
	 */
	public CategoryDto getCategory() {
		return category;
	}

	/**
	 * Sets the category.
	 *
	 * @param category the new category
	 */
	public void setCategory(CategoryDto category) {
		this.category = category;
	}

	/**
	 * Gets the amount.
	 *
	 * @return the amount
	 */
	public double getAmount() {
		return amount;
	}

	/**
	 * Sets the amount.
	 *
	 * @param amount the new amount
	 */
	public void setAmount(double amount) {
		this.amount = amount;
	}

	/**
	 * Gets the date.
	 *
	 * @return the date
	 */
	public Date getDate() {
		return date;
	}

	/**
	 * Sets the date.
	 *
	 * @param date the new date
	 */
	public void setDate(Date date) {
		this.date = date;
	}
}

