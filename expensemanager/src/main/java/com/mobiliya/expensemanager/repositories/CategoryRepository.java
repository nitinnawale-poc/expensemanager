package com.mobiliya.expensemanager.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mobiliya.expensemanager.entities.Category;
import com.mobiliya.expensemanager.entities.Expense;
@Repository
public interface CategoryRepository extends JpaRepository<Category, Integer> {

	//List<Expense> 
}
