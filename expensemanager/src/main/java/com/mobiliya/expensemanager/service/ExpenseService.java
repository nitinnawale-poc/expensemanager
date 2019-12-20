package com.mobiliya.expensemanager.service;

import java.util.Date;
import java.util.List;

import com.mobiliya.expensemanager.dto.ExpenseDto;

/**
 * The Interface ExpenseService.
 */
public interface ExpenseService {

/**
 * Gets the expenses.
 *
 * @param categoryName the category name
 * @return the expenses
 */
public List<ExpenseDto> getExpenses(String categoryName);

/**
 * Adds the expense.
 *
 * @param dto the dto
 * @return the expense dto
 */
public ExpenseDto addExpense(ExpenseDto dto);

/**
 * Gets the expense after date.
 *
 * @param date the date
 * @return the expense after date
 */
public List<ExpenseDto> getExpenseAfterDate(Date date);

/**
 * Gets the sum of all expenses.
 *
 * @return the sum of all expenses
 */
public Double getSumOfAllExpenses();

}
