package com.mobiliya.expensemanager.dto;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonInclude(Include.NON_NULL)
public class ExpenseDto {
	@JsonProperty("expenseTitle")
	private String expenseTitle;
	
	@JsonProperty("category")
	private CategoryDto category;
	
	@JsonProperty("amount")
	private double amount;
	
	@JsonProperty("date")
	private Date date;

	public ExpenseDto() {}
	
	public ExpenseDto(String expenseTitle, CategoryDto category, double amount, Date date) {
		this.expenseTitle = expenseTitle;
		this.category = category;
		this.amount = amount;
		this.date = date;
	}

	public String getExpenseTitle() {
		return expenseTitle;
	}

	public void setExpenseTitle(String expenseTitle) {
		this.expenseTitle = expenseTitle;
	}

	public CategoryDto getCategory() {
		return category;
	}

	public void setCategory(CategoryDto category) {
		this.category = category;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}
}

