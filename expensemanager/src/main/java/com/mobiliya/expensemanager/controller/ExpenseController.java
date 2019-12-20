package com.mobiliya.expensemanager.controller;

import java.util.Date;
import java.util.List;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.mobiliya.expensemanager.dto.ExpenseDto;
import com.mobiliya.expensemanager.service.ExpenseService;
import com.mobiliya.expensemanager.service.impl.MessageExecutorService;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

/**
 * The Class ExpenseController.
 *
 * @author Nitin
 */
@RestController
@RequestMapping("/expensemanager")
public class ExpenseController {

/** The logger. */
private Logger logger = LoggerFactory.getLogger(ExpenseController.class);

/** The service. */
@Autowired
public ExpenseService service;

@Autowired
public MessageExecutorService messageService;

/**
 * Gets the expenses by category name.
 *
 * @param categoryName the category name
 * @return the expenses by category name
 */
@ApiOperation(value = "View a list of available Expenses By Category Name", 
response = ExpenseDto.class)
@ApiResponses(value = { @ApiResponse(code = 200, message = "Successfully retrieved list"),
@ApiResponse(code = 401, message = "You are not authorized to view the resource"),
@ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
@ApiResponse(code = 404, message = "The resource you were trying to reach is not found") })
@GetMapping(path = "/expenses/{categoryName}", produces = MediaType.APPLICATION_JSON_VALUE)
public ResponseEntity<List<ExpenseDto>> getExpensesByCategoryName(
@PathVariable(name = "categoryName") String categoryName) {
logger.info("Calling List Of Expenses for  :" + categoryName);
return new ResponseEntity<List<ExpenseDto>>(service.getExpenses(categoryName), HttpStatus.OK);
}

/**
 * Adding expense.
 *
 * @param dto the dto
 * @return the response entity
 */
@ApiOperation(value = "Add an expense")
@PostMapping("/addexpense")
public ResponseEntity<ExpenseDto> addExpense(
@ApiParam(value = "Employee object store in database table",
required = true) @Valid @RequestBody ExpenseDto dto) {
logger.info("Adding Expense");
return new ResponseEntity<ExpenseDto>(service.addExpense(dto), HttpStatus.OK);
}

/**
 * Gets the all expenses.
 *
 * @return the all expenses
 */
@ApiOperation(value = "View a list of available Expenses", response = ExpenseDto.class)
@ApiResponses(value = { @ApiResponse(code = 200, message = "Successfully retrieved list"),
@ApiResponse(code = 401, message = "You are not authorized to view the resource"),
@ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
@ApiResponse(code = 404, message = "The resource you were trying to reach is not found") })
@GetMapping(path = "/expenses", produces = MediaType.APPLICATION_JSON_VALUE)
public ResponseEntity<List<ExpenseDto>> getAllExpenses() {
logger.info("Viewing All the expenses");
return new ResponseEntity<List<ExpenseDto>>(service.getExpenses(null), HttpStatus.OK);
}

/**
 * Gets the expense after date.
 *
 * @param date the date
 * @return the expense after date
 */
@ApiOperation(value = "View a list of Expenses After Specified Date including the date",
response = ExpenseDto.class)
@ApiResponses(value = { @ApiResponse(code = 200, message = "Successfully retrieved list"),
@ApiResponse(code = 401, message = "You are not authorized to view the resource"),
@ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
@ApiResponse(code = 404, message = "The resource you were trying to reach is not found") })
@GetMapping(path = "/expenseAfterDate", produces = MediaType.APPLICATION_JSON_VALUE)
public ResponseEntity<List<ExpenseDto>> getExpenseAfterDate(
@RequestParam("from") @DateTimeFormat(pattern = "yyyy-MM-dd") Date date) {
logger.info("Fetching expense after the Date : " + date + " including itself");
return new ResponseEntity<List<ExpenseDto>>(service.getExpenseAfterDate(date), HttpStatus.OK);
}

/**
 * Gets the sum of all expenses.
 *
 * @return the sum of all expenses
 */
@ApiOperation(value = "Get Sum of All Expenses", response = Double.class)
@ApiResponses(value = { @ApiResponse(code = 200, message = "Successfully retrieved list"),
@ApiResponse(code = 401, message = "You are not authorized to view the resource"),
@ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
@ApiResponse(code = 404, message = "The resource you were trying to reach is not found") })
@GetMapping(path = "/sumofexpenses", produces = MediaType.APPLICATION_JSON_VALUE)
public ResponseEntity<Double> getSumOfAllExpenses() {
logger.info("Get Sum of All Expenses");
logger.info("Result: " + service.getSumOfAllExpenses());
return new ResponseEntity<Double>(service.getSumOfAllExpenses(), HttpStatus.OK);
}

@ApiOperation(value = "Start Print Message Service", response = String.class)
@ApiResponses(value = { @ApiResponse(code = 200, message = "Started Message Service Successfully"),
@ApiResponse(code = 401, message = "You are not authorized to view the resource"),
@ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
@ApiResponse(code = 404, message = "The resource you were trying to reach is not found") })
@GetMapping(path = "/printmessage", produces = MediaType.APPLICATION_JSON_VALUE)
public ResponseEntity<String> printMessage() {
logger.info("Printing message using thread executor service");
return new ResponseEntity<String>(messageService.printMessageOnConsole(), HttpStatus.OK);
}

}
