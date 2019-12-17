package com.mobiliya.expensemanager.dao;

import java.util.List;

import com.mobiliya.expensemanager.dto.CategoryDto;
import com.mobiliya.expensemanager.dto.ExpenseDto;


/**
 * The Interface CategoryDao.
 *
 * @author Nitin
 */
public interface CategoryDao {
    
    /**
     * Gets the list of category.
     *
     * @param categoryName the category name
     * @return the list of category
     */
    List<ExpenseDto> getListOfCategory(String categoryName);
	
	/**
	 * Adds the category.
	 *
	 * @param dto the dto
	 * @return the category dto
	 */
	CategoryDto addCategory(ExpenseDto dto);
}
