
package com.mobiliya.expensemanager.entities;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

/**
 * The Class Expense.
 */
@Entity
public class Expense {

/** The expense id. */
@Id()
@Column(name = "expenseid")
@GeneratedValue(strategy = GenerationType.IDENTITY)
private int expenseId;

/** The expense title. */
private String expenseTitle;

/** The category. */
@ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
@JoinColumn(name = "category", nullable = false)
private Category category;

/** The amount. */
private double amount;

/** The date. */
private Date date;

/**
 * Instantiates a new expense.
 */
public Expense() {
}

/**
 * Instantiates a new expense.
 *
 * @param expenseTitle the expense title
 * @param category     the category
 * @param amount       the amount
 * @param date         the date
 */
public Expense(String expenseTitle, Category category, double amount, Date date) {
this.expenseTitle = expenseTitle;
this.category = category;
this.amount = amount;
this.date = date;
}

public int getExpenseId() {
return expenseId;
}

public void setExpenseId(int expenseId) {
this.expenseId = expenseId;
}

public String getExpenseTitle() {
return expenseTitle;
}

public void setExpenseTitle(String expenseTitle) {
this.expenseTitle = expenseTitle;
}

public Category getCategory() {
return category;
}

public void setCategory(Category category) {
this.category = category;
}

public double getAmount() {
return amount;
}

public void setAmount(double amount) {
this.amount = amount;
}

public Date getDate() {
return date;
}

public void setDate(Date date) {
this.date = date;
}

}
