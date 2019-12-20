package com.mobiliya.expensemanager.repositories;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.mobiliya.expensemanager.entities.Expense;

/**
 * The Interface ExpenseRepository.
 */
@Repository
public interface ExpenseRepository extends JpaRepository<Expense, Integer> {

/**
 * Find by category category name.
 *
 * @param name the name
 * @return the list
 */
public List<Expense> findByCategory_CategoryName(String name);

/**
 * Find expenses after date specified.
 *
 * @param date the date
 * @return the list
 */
@Query("SELECT e FROM Expense e WHERE e.date>= :date")
public List<Expense> findExpensesAfterDateSpecified(@Param("date") Date date);

/**
 * Find sum of all expenses.
 *
 * @return the double
 */
@Query("SELECT SUM(e.amount) from Expense e")
public Double findSumOfAllExpenses();
}
