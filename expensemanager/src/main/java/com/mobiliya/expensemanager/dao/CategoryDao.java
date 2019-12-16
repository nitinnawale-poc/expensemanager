package com.mobiliya.expensemanager.dao;

import java.util.List;

import com.mobiliya.expensemanager.dto.CategoryDto;
import com.mobiliya.expensemanager.dto.ExpenseDto;

public interface CategoryDao {
    List<ExpenseDto> getListOfCategory(String categoryName);
	
	CategoryDto addCategory(ExpenseDto dto);
}
