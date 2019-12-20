package com.mobiliya.expensemanager.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mobiliya.expensemanager.dao.ExpenseDao;
import com.mobiliya.expensemanager.dto.ExpenseDto;
import com.mobiliya.expensemanager.service.ExpenseService;

/**
 * The Class ExpenseServiceImpl.
 *
 * @author Nitin
 */
@Service
public class ExpenseServiceImpl implements ExpenseService {

/** The expense dao. */
@Autowired
private ExpenseDao expenseDao;

/**
 * Gets the expenses.
 *
 * @param categoryName the category name
 * @return the expenses
 */
@Override
public List<ExpenseDto> getExpenses(String categoryName) {

return expenseDao.getListOfExpenses(categoryName);
}

/**
 * Adds the expense.
 *
 * @param dto the dto
 * @return the expense dto
 */
@Override
public ExpenseDto addExpense(ExpenseDto dto) {

return expenseDao.addExpense(dto);

}

/**
 * Gets the expense after date.
 *
 * @param date the date
 * @return the expense after date
 */
@Override
public List<ExpenseDto> getExpenseAfterDate(Date date) {

return expenseDao.getExpensesAfterDate(date);
}

/**
 * Gets the sum of all expenses.
 *
 * @return the sum of all expenses
 */
@Override
public Double getSumOfAllExpenses() {
return expenseDao.getSumOfAllExpenses();
}

}
