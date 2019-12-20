package com.mobiliya.expensemanager.controller;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.mobiliya.expensemanager.dao.impl.ExpenseObjectConverter;
import com.mobiliya.expensemanager.dto.CategoryDto;
import com.mobiliya.expensemanager.dto.ExpenseDto;
import com.mobiliya.expensemanager.repositories.ExpenseRepository;
import com.mobiliya.expensemanager.service.ExpenseService;
import com.mobiliya.expensemanager.service.impl.ExpenseServiceImpl;


/**
 * The Class ExpenseControllerTest.
 *
 * @author Nitin
 */
//@RunWith(MockitoJUnitRunner.class)
public class ExpenseControllerTest {

	/** The expense test repository. */
	@Mock
	ExpenseRepository expenseTestRepository;

	/** The expense controller. */
	@InjectMocks
	ExpenseController expenseController;
	
	
	/** The expense service. */
	ExpenseService expenseService;
	
	/** The expense object converter. */
	@InjectMocks
	ExpenseObjectConverter expenseObjectConverter;
	
	/**
	 * Inits the mocks.
	 */
	@Before
	public void initMocks() {
		MockitoAnnotations.initMocks(this);
		expenseService = Mockito.mock(ExpenseServiceImpl.class);
		expenseController.service = expenseService;
	}

	/**
	 * Adds the expense.
	 */
	@Test
	public void addExpense() {
		ExpenseDto s2 = this.getExpenseDTO();
		//ResponseEntity<ExpenseDto> re = this.getExpenseDTOResponse();
		//when(expenseController.addingExpense(s2)).thenReturn(re);
		when(expenseService.addExpense(s2)).thenReturn(s2);
		
		assertEquals(s2, expenseController.addExpense(s2).getBody());
	}

	/**
	 * Gets the expense DTO response.
	 *
	 * @return the expense DTO response
	 */
	private ResponseEntity<Double> getExpenseDTOResponse() {
		return new ResponseEntity<Double>(new Double(4000), HttpStatus.OK);
	}
	
	/**
	 * Gets the sum of all expenses.
	 *
	 * @return the sum of all expenses
	 */
	@Test
	public void getSumOfAllExpenses() {
		when(expenseService.getSumOfAllExpenses()).thenReturn((double) 4000);
		
		assertEquals(getExpenseDTOResponse().getBody(), expenseController.getSumOfAllExpenses().getBody());
	}

	/**
	 * Gets the expense DTO.
	 *
	 * @return the expense DTO
	 */
	private ExpenseDto getExpenseDTO() {
		Date d1 = null;
		DateFormat df = new SimpleDateFormat("yyyy-mm-dd");
		try {
			d1 = df.parse("2019-11-12");
		} catch (ParseException e) {
			e.printStackTrace();
		}
		ExpenseDto s2 = new ExpenseDto();
		s2.setExpenseTitle("Lunch");
		s2.setDate(d1);
		s2.setAmount(10000);
		s2.setCategory(new CategoryDto("Food"));
		return s2;
	}
	
}     
