package com.mobiliya.expensemanager.dao;

import java.util.Date;
import java.util.List;

import com.mobiliya.expensemanager.dto.ExpenseDto;

public interface ExpenseDao {

	
	List<ExpenseDto> getListOfExpenses(String categoryName);
	
	ExpenseDto addExpense(ExpenseDto dto);
	
	List<ExpenseDto> getExpensesAfterDate(Date date);
}
