package com.mobiliya.expensemanager.dao.impl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.mobiliya.expensemanager.dao.ExpenseDao;
import com.mobiliya.expensemanager.dto.ExpenseDto;
import com.mobiliya.expensemanager.entities.Expense;
import com.mobiliya.expensemanager.exception.DataRetrievalException;
import com.mobiliya.expensemanager.repositories.CategoryRepository;
import com.mobiliya.expensemanager.repositories.ExpenseRepository;

@Service
public class ExpenseDaoImpl implements ExpenseDao {

	@Inject
	CategoryRepository categoryRepository;
	
	@Inject
	ExpenseRepository expenseRepository;
	
	@Inject
	ExpenseObjectConverter expenseConverter;
	
	@Inject
	CategoryObjectConverter categoryConverter;
	
	@Override
	public List<ExpenseDto> getListOfExpenses(String categoryName) {
		List<Expense> entityList=Collections.emptyList();
		try {
			if(StringUtils.isEmpty(categoryName)) {
				entityList=expenseRepository.findAll();
			}else {
				entityList=expenseRepository.findByCategory_CategoryName(categoryName);
			}
		} catch (Exception e) {
			throw new DataRetrievalException("Data Retrieval Error", e);
			
		}
		return createExpenseDtoList(entityList);
	}
	
	public List<ExpenseDto> createExpenseDtoList(List<Expense> entityList){
		 List<ExpenseDto> expenses= new ArrayList<ExpenseDto>();
	        entityList.forEach(e->expenses.add(expenseConverter.convertEntityToDto(e)));
	        return expenses;
	}

	@Override
	public ExpenseDto addExpense(ExpenseDto dto) {
		ExpenseDto expenseDto;
		 try {
			 expenseDto=expenseConverter.convertEntityToDto(expenseRepository.save(expenseConverter.convertDtoToEntity(dto)));
		} catch (Exception e) {
			throw new DataRetrievalException("Data Retrieval Error", e);
		}
		return expenseDto;
		
	}

	@Override
	public List<ExpenseDto> getExpensesAfterDate(Date date) {
		List<Expense> entityList=Collections.emptyList();
		try {
			if(date!=null) {
				entityList=expenseRepository.findExpensesAfterDateSpecified(date);
			}
		} catch (Exception e) {
			throw new DataRetrievalException("Data Retrieval Error", e);
			
		}
		return createExpenseDtoList(entityList);
	}

}
