package com.mobiliya.expensemanager.dao.impl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.mobiliya.expensemanager.dao.ExpenseDao;
import com.mobiliya.expensemanager.dto.ExpenseDto;
import com.mobiliya.expensemanager.entities.Expense;
import com.mobiliya.expensemanager.exception.DataRetrievalException;
import com.mobiliya.expensemanager.repositories.CategoryRepository;
import com.mobiliya.expensemanager.repositories.ExpenseRepository;

/**
 * The Class ExpenseDaoImpl.
 *
 * @author Nitin
 */
@Service
public class ExpenseDaoImpl implements ExpenseDao {

	/** The logger. */
	Logger logger = LoggerFactory.getLogger(ExpenseDaoImpl.class);

	/** The category repository. */
	@Inject
	CategoryRepository categoryRepository;

	/** The expense repository. */
	@Inject
	ExpenseRepository expenseRepository;

	/** The expense converter. */
	@Inject
	ExpenseObjectConverter expenseConverter;

	/** The category converter. */
	@Inject
	CategoryObjectConverter categoryConverter;

	/**
	 * Gets the list of expenses.
	 *
	 * @param categoryName the category name
	 * @return the list of expenses
	 */
	@Override
	public List<ExpenseDto> getListOfExpenses(String categoryName) {
		logger.info("getting Expenses for the Category Name : " + categoryName);
		List<Expense> entityList = Collections.emptyList();
		try {
			if (StringUtils.isEmpty(categoryName)) {
				entityList = expenseRepository.findAll();
			} else {
				entityList = expenseRepository.findByCategory_CategoryName(categoryName);
			}
		} catch (Exception e) {
			logger.error("Error while Fetching Data : " + e.getMessage());
			throw new DataRetrievalException("Data Retrieval Error", e);

		}
		return createExpenseDtoList(entityList);
	}

	/**
	 * Creates the expense dto list.
	 *
	 * @param entityList the entity list
	 * @return the list
	 */
	public List<ExpenseDto> createExpenseDtoList(List<Expense> entityList) {
		List<ExpenseDto> expenses = new ArrayList<ExpenseDto>();
		entityList.forEach(e -> expenses.add(expenseConverter.convertEntityToDto(e)));
		return expenses;
	}

	/**
	 * Adds the expense.
	 *
	 * @param dto the dto
	 * @return the expense dto
	 */
	@Override
	public ExpenseDto addExpense(ExpenseDto dto) {
		logger.info("Adding Expense in the Repository");
		ExpenseDto expenseDto;
		try {
			expenseDto = expenseConverter
					.convertEntityToDto(expenseRepository.save(expenseConverter.convertDtoToEntity(dto)));
		} catch (Exception e) {
			logger.error("Error while Adding Data : " + e.getMessage());
			throw new DataRetrievalException("Data Retrieval Error", e);
		}
		return expenseDto;

	}

	/**
	 * Gets the expenses after date.
	 *
	 * @param date the date
	 * @return the expenses after date
	 */
	@Override
	public List<ExpenseDto> getExpensesAfterDate(Date date) {
		logger.info("Fetching Expense from the repository on date : " + date);
		List<Expense> entityList = Collections.emptyList();
		try {
			if (date != null) {
				entityList = expenseRepository.findExpensesAfterDateSpecified(date);
			}
		} catch (Exception e) {
			logger.error("Error while Adding Data : " + e.getMessage());
			throw new DataRetrievalException("Data Retrieval Error", e);

		}
		return createExpenseDtoList(entityList);
	}

	/**
	 * Gets the sum of all expenses.
	 *
	 * @return the sum of all expenses
	 */
	@Override
	public Double getSumOfAllExpenses() {
		Double sum = null;
		try {
			sum = expenseRepository.findSumOfAllExpenses();
		} catch (Exception e) {
			logger.error("Error while Adding Data : " + e.getMessage());
			throw new DataRetrievalException("Data Retrieval Error", e);
		}

		return sum;
	}

}
