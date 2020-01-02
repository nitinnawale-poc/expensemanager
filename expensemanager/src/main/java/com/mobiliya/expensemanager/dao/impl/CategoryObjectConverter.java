package com.mobiliya.expensemanager.dao.impl;

import org.springframework.stereotype.Service;

import com.mobiliya.expensemanager.dao.Converter;
import com.mobiliya.expensemanager.dto.CategoryDto;
import com.mobiliya.expensemanager.entities.Category;

/**
 * The Class CategoryObjectConverter.
 *
 * @author Nitin
 */
@Service
public class CategoryObjectConverter implements Converter<CategoryDto, Category> {

    /**
     * Convert dto to entity.
     *
     * @param dto the dto
     * @return the category
     */
    @Override
    public Category convertDtoToEntity(CategoryDto dto) {
        return new Category(dto.getCategoryName());
    }

    /**
     * Convert entity to dto.
     *
     * @param entity the entity
     * @return the category dto
     */
    @Override
    public CategoryDto convertEntityToDto(Category entity) {
        return new CategoryDto(entity.getCategoryName());
    }

}
