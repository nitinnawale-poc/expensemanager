package com.mobiliya.expensemanager.controller;

import java.util.Date;
import java.util.List;

import javax.inject.Inject;
import javax.validation.Valid;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.mobiliya.expensemanager.dto.ExpenseDto;
import com.mobiliya.expensemanager.service.ExpenseService;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping("/expensemanager")
public class ExpenseController {

	@Inject
	ExpenseService service;

	@ApiOperation(value = "View a list of available Expenses By Category Name", response = ExpenseDto.class)
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Successfully retrieved list"),
			@ApiResponse(code = 401, message = "You are not authorized to view the resource"),
			@ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
			@ApiResponse(code = 404, message = "The resource you were trying to reach is not found") })
	@GetMapping(path = "/expenses/{categoryName}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<ExpenseDto>> getExpensesByCategoryName(
			@PathVariable(name = "categoryName") String categoryName) {
		return new ResponseEntity<List<ExpenseDto>>(service.getExpenses(categoryName), HttpStatus.OK);
	}


    @ApiOperation(value = "Add an expense")
    @PostMapping("/addexpense")
	public ResponseEntity<ExpenseDto> addingExpense(@ApiParam(value = "Employee object store in database table", required = true) @Valid  @RequestBody ExpenseDto dto) {
		return new ResponseEntity<ExpenseDto>(service.addExpense(dto), HttpStatus.OK);
	}

	@ApiOperation(value = "View a list of available Expenses", response = ExpenseDto.class)
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Successfully retrieved list"),
			@ApiResponse(code = 401, message = "You are not authorized to view the resource"),
			@ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
			@ApiResponse(code = 404, message = "The resource you were trying to reach is not found") })
	@GetMapping(path = "/expenses", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<ExpenseDto>> getAllExpenses() {
		return new ResponseEntity<List<ExpenseDto>>(service.getExpenses(null), HttpStatus.OK);
	}
	
	@ApiOperation(value = "View a list of Expenses After Specified Date including the date", response = ExpenseDto.class)
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Successfully retrieved list"),
			@ApiResponse(code = 401, message = "You are not authorized to view the resource"),
			@ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
			@ApiResponse(code = 404, message = "The resource you were trying to reach is not found") })
	@GetMapping(path = "/expenseAfterDate", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<ExpenseDto>> getExpenseAfterDate(@RequestParam("from") @DateTimeFormat(pattern="yyyy-MM-dd") Date date) {
		return new ResponseEntity<List<ExpenseDto>>(service.getExpenseAfterDate(date), HttpStatus.OK);
	}

}     
