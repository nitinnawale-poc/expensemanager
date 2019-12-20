package com.mobiliya.expensemanager.dao.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mobiliya.expensemanager.dao.Converter;
import com.mobiliya.expensemanager.dto.ExpenseDto;
import com.mobiliya.expensemanager.entities.Expense;

/**
 * The Class ExpenseObjectConverter.
 *
 * @author Nitin
 */
@Service
public class ExpenseObjectConverter implements Converter<ExpenseDto, Expense> {

/** The category converter. */
@Autowired
private CategoryObjectConverter categoryConverter;

/**
 * Convert dto to entity.
 *
 * @param dto the dto
 * @return the expense
 */
@Override
public Expense convertDtoToEntity(ExpenseDto dto) {
Expense expense = new Expense();
expense.setExpenseTitle(dto.getExpenseTitle());
expense.setCategory(categoryConverter.convertDtoToEntity(dto.getCategory()));
expense.setAmount(dto.getAmount());
expense.setDate(dto.getDate());
return expense;
}

/**
 * Convert entity to dto.
 *
 * @param entity the entity
 * @return the expense dto
 */
@Override
public ExpenseDto convertEntityToDto(Expense entity) {
ExpenseDto dto = new ExpenseDto();
dto.setExpenseTitle(entity.getExpenseTitle());
dto.setCategory(categoryConverter.convertEntityToDto(entity.getCategory()));
dto.setAmount(entity.getAmount());
dto.setDate(entity.getDate());
return dto;
}

}
