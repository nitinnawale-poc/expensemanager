package com.mobiliya.expensemanager.repositories;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.mobiliya.expensemanager.entities.Expense;
@Repository
public interface ExpenseRepository extends JpaRepository<Expense, Integer> {

	List<Expense> findByCategory_CategoryName(String name);
	
	@Query("SELECT e FROM Expense e WHERE e.date>= :date")
	List<Expense> findExpensesAfterDateSpecified(@Param("date") Date date);
}
