package com.mobiliya.expensemanager.dao.impl;

import org.springframework.stereotype.Service;

import com.mobiliya.expensemanager.dao.Converter;
import com.mobiliya.expensemanager.dto.CategoryDto;
import com.mobiliya.expensemanager.entities.Category;
@Service
public class CategoryObjectConverter implements Converter<CategoryDto, Category> {

	@Override
	public Category convertDtoToEntity(CategoryDto dto) {
		return new Category(dto.getCategoryName());
	}

	@Override
	public CategoryDto convertEntityToDto(Category entity) {
		return new CategoryDto(entity.getCategoryName());
	}

}
