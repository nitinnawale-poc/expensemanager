package com.mobiliya.expensemanager.dao;

public interface Converter<T,K> {
 
	K convertDtoToEntity(final T dto);
	
	T convertEntityToDto(final K entity);
}
