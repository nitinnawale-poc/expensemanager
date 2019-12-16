package com.mobiliya.expensemanager.service;

import java.util.Date;
import java.util.List;

import com.mobiliya.expensemanager.dto.ExpenseDto;

public interface ExpenseService {
	
	List<ExpenseDto> getExpenses(String categoryName);
	
	ExpenseDto addExpense(ExpenseDto dto);
	
	List<ExpenseDto> getExpenseAfterDate(Date date);

}
