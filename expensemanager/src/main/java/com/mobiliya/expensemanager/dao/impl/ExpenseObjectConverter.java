package com.mobiliya.expensemanager.dao.impl;


import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.mobiliya.expensemanager.dao.Converter;
import com.mobiliya.expensemanager.dto.ExpenseDto;
import com.mobiliya.expensemanager.entities.Expense;


@Service
public class ExpenseObjectConverter implements Converter<ExpenseDto, Expense> {

	@Inject
	CategoryObjectConverter categoryConverter;
	
	@Override
	public Expense convertDtoToEntity(ExpenseDto dto) {
		Expense expense=new Expense();
		expense.setExpenseTitle(dto.getExpenseTitle());
		expense.setCategory(categoryConverter.convertDtoToEntity(dto.getCategory()));
		expense.setAmount(dto.getAmount());
		expense.setDate(dto.getDate());
		return expense;
	}

	@Override
	public ExpenseDto convertEntityToDto(Expense entity) {
		ExpenseDto dto=new ExpenseDto();
		dto.setExpenseTitle(entity.getExpenseTitle());
		dto.setCategory(categoryConverter.convertEntityToDto(entity.getCategory()));
		dto.setAmount(entity.getAmount());
		dto.setDate(entity.getDate());
		return dto;
	}

}
