package com.mobiliya.expensemanager.service.impl;

import java.util.Date;
import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.mobiliya.expensemanager.dao.ExpenseDao;
import com.mobiliya.expensemanager.dto.ExpenseDto;
import com.mobiliya.expensemanager.service.ExpenseService;
@Service
public class ExpenseServiceImpl implements ExpenseService {
	
	@Inject
	ExpenseDao expenseDao;

	@Override
	public List<ExpenseDto> getExpenses(String categoryName) {
		
		
		return expenseDao.getListOfExpenses(categoryName);
	}

	@Override
	public ExpenseDto addExpense(ExpenseDto dto) {
	
		return expenseDao.addExpense(dto);
		
	}

	@Override
	public List<ExpenseDto> getExpenseAfterDate(Date date) {
		
		return expenseDao.getExpensesAfterDate(date);
	}

}
