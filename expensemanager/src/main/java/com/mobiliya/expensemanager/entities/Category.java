
package com.mobiliya.expensemanager.entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

/**
 * The Class Category.
 */
@Entity
public class Category {

/** The category id. */
@Id
@Column(name = "categoryid")
@GeneratedValue(strategy = GenerationType.IDENTITY)
private int categoryId;

/** The category name. */
private String categoryName;

/** The list of expenses. */
@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
private List<Expense> listOfExpenses = new ArrayList<Expense>();

/**
 * Instantiates a new category.
 */
public Category() {
}

/**
 * Instantiates a new category.
 *
 * @param categoryName the category name
 */
public Category(String categoryName) {
this.categoryName = categoryName;
}

public int getCategoryId() {
return categoryId;
}

public void setCategoryId(int categoryId) {
this.categoryId = categoryId;
}

public String getCategoryName() {
return categoryName;
}

public void setCategoryName(String categoryName) {
this.categoryName = categoryName;
}

public List<Expense> getListOfExpenses() {
return listOfExpenses;
}

public void setListOfExpenses(List<Expense> listOfExpenses) {
this.listOfExpenses = listOfExpenses;
}

}
