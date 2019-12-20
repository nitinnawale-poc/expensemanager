package com.mobiliya.expensemanager.dao;

/**
 * The Interface Converter.
 *
 * @author Nitin
 * @param <T> DTO
 * @param <K> Entity
 */
public interface Converter<T, K> {

/**
 * Convert dto to entity.
 *
 * @param dto the dto
 * @return the k
 */
public K convertDtoToEntity(final T dto);

/**
 * Convert entity to dto.
 *
 * @param entity the entity
 * @return the t
 */
public T convertEntityToDto(final K entity);
}
