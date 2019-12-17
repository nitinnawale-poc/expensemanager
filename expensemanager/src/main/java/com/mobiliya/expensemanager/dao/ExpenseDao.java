package com.mobiliya.expensemanager.dao;

import java.util.Date;
import java.util.List;

import com.mobiliya.expensemanager.dto.ExpenseDto;


/**
 * The Interface ExpenseDao.
 *
 * @author Nitin
 */
public interface ExpenseDao {

	
	/**
	 * Gets the list of expenses.
	 *
	 * @param categoryName the category name
	 * @return the list of expenses
	 */
	List<ExpenseDto> getListOfExpenses(String categoryName);
	
	/**
	 * Adds the expense.
	 *
	 * @param dto the dto
	 * @return the expense dto
	 */
	ExpenseDto addExpense(ExpenseDto dto);
	
	/**
	 * Gets the expenses after date.
	 *
	 * @param date the date
	 * @return the expenses after date
	 */
	List<ExpenseDto> getExpensesAfterDate(Date date);
	
	/**
	 * Gets the sum of all expenses.
	 *
	 * @return the sum of all expenses
	 */
	Double getSumOfAllExpenses();
}
